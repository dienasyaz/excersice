
    Connection cnc = null;
    Statement st = null;
    ResultSet rs = null;
    
    public SPMP() throws SQLException {
        initComponents();
        setTitle("SISTEM PENDAFTARAN MAKLUMAT PENGGUNA");
        cnc = getsambungan();
        st = cnc.createStatement();
    }
    
    public Connection getsambungan(){
                                           
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cnc = DriverManager.getConnection("jdbc:mysql://localhost:  3306/spmp","root","");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return cnc;
    }
    //ni connection wajib ada yang mysql localhost tu ikut nama database kau
 


    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {                                       
        String sqlAdd = "INSERT INTO maklumat_pengguna(Nama_Pengguna, UserName, Password, Email, Tarikh_Akhir_Log_Masuk, Kategori_Pengguna) VALUES ('"+txtName.getText()+"','"+txtUser.getText()+"','"+txtPass.getText()+"','"+txtEmail.getText()+"','"+txtDate.getText()+"','"+txtKategori.getSelectedItem()+"')";

        try {
            int q = st.executeUpdate(sqlAdd);
            if(q>0){
                JOptionPane.showMessageDialog(null, "Data Telah Disimpan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Disimpan");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }                                      

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {                                        
        System.exit(0);
    }                                       

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        String sqlEdit = "UPDATE maklumat_pengguna SET Nama_Pengguna='"+txtName.getText()+"',UserName='"+txtUser.getText()+"',Password='"+txtPass.getText()+"',Email='"+txtEmail.getText()+"',Tarikh_Akhir_Log_Masuk='"+txtDate.getText()+"',Kategori_Pengguna='"+txtKategori.getSelectedItem()+"' WHERE Nama_Pengguna = '"+txtName.getText()+"'";

        try {
            int z = st.executeUpdate(sqlEdit);
            if(z>0){
                JOptionPane.showMessageDialog(null, "Data Telah Diubah");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Diubah");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }                                         

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        txtCari.setText("");
        txtName.setText("");
        txtUser.setText("");
        txtPass.setText("");
        txtEmail.setText("");
        txtDate.setText("");
        txtKategori.setSelectedIndex(0);
    }                                        

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:

        String sqlCari = "SELECT * FROM maklumat_pengguna WHERE Nama_Pengguna = '"+txtCari.getText()+"'";

        try {
            rs = st.executeQuery(sqlCari);
            rs.last();
            int a = rs.getRow();

            if(a>0){
                JOptionPane.showMessageDialog(null, "Data Telah Dijumpai");
                txtName.setText(rs.getString(2));
                txtUser.setText(rs.getString(3));
                txtPass.setText(rs.getString(4));
                txtEmail.setText(rs.getString(5));
                txtDate.setText(rs.getString(6));
                txtKategori.setSelectedItem(rs.getString(7));
            }
            else {
                JOptionPane.showMessageDialog(null, "Tiada Data Dijumpai");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }                                         

  

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        String sqlDelete = "DELETE FROM maklumat_pengguna WHERE Nama_Pengguna='"+txtName.getText()+"'";
        
        try {
            int d = st.executeUpdate(sqlDelete);
            if(d>0){
                JOptionPane.showMessageDialog(null, "Data Telah Dibuang");
            }
            else{
                JOptionPane.showMessageDialog(null, "Data Tidak Dibuang");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }                                         

   