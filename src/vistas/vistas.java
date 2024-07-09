/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class vistas extends javax.swing.JFrame {
    conexion con = new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel modelo;
    int id;

    public vistas() {
        initComponents();
        setLocationRelativeTo(null);
        Listar();
    }

 
    
    
    void Listar() {
        String sql = "select * from formulario";
        try {
            cn=con.getCon();
            st=cn.createStatement();
            rs=st.executeQuery(sql);
            Object[]registro=new Object [9];
            modelo=(DefaultTableModel)tabladatos.getModel();
            while (rs.next()) {
                registro[0]=rs.getInt("id");
                registro[1]=rs.getString("dni");
                registro[2]=rs.getString("nombre");
                registro[3]=rs.getString("apellidos");
                registro[4]=rs.getString("fecha_nacimiento");
                registro[5]=rs.getString("sexo");
                registro[6]=rs.getString("celular");
                registro[7]=rs.getString("email");
                registro[8]=rs.getString("direccion");
                modelo.addRow(registro);
            }   
            tabladatos.setModel(modelo);
            System.out.println("listado exitoso");
        } catch (Exception e) {
            System.out.println("error de listado" + e);
        }
    }
      void Agregar () {
        String dni=txt_dni_eriksonyallico.getText();
        String nombre= txt_nombre_eriksonyallico.getText();
        String apellidos=txt_apellidos_eriksonyallico.getText();
        String nacimiento=txt_fechanacimiento_eriksonyallico.getText();
        String sexo=txt_sexo_eriksonyallico.getText();
        String celular=txt_celular_eriksonyallico.getText();
        String correo=txt_correo_eriksonyallico.getText();
        String direccion=txt_direccion_eriksonyallico.getText();
        if(dni.equals("")||nombre.equals("")||apellidos.equals("")||nacimiento.equals("")||sexo.equals("")||celular.equals("")||correo.equals("")||direccion.equals("")){
            JOptionPane.showMessageDialog(null,"no se agrego......!!!");
        }else{
            String sql = "insert into formulario(dni,nombre,apellidos,fecha_nacimiento,sexo,celular,email,direccion)values('"+dni+"','"+nombre+"','"+apellidos+"','"+nacimiento+"','"+sexo+"','"+celular+"','"+correo+"','"+direccion+"')";
            try {
                cn=con.getCon();
                st=cn.createStatement();
                st.executeUpdate(sql);
                System.out.println("agregado exitoso");
                limpiartabla();
            } catch (Exception e) {
                System.out.println("error" + e);
            }
            }
        }
      
      
       void limpiartabla(){
         for(int i=0;i<=tabladatos.getRowCount();i++) {
             modelo.removeRow(i);
             i=i-1;
         }
     }
    
       
       
       
       
        void modificar () {
        String dni=txt_dni_eriksonyallico.getText();
        String nombre= txt_nombre_eriksonyallico.getText();
        String apellidos=txt_apellidos_eriksonyallico.getText();
        String nacimiento=txt_fechanacimiento_eriksonyallico.getText();
        String sexo=txt_sexo_eriksonyallico.getText();
        String celular=txt_celular_eriksonyallico.getText();
        String correo=txt_correo_eriksonyallico.getText();
        String direccion=txt_direccion_eriksonyallico.getText();
        String sql="update formulario set dni='"+dni+"', nombre='"+nombre+"', fecha_nacimiento='"+nacimiento+"', sexo='"+sexo+"', celular='"+celular+"', email='"+correo+"', direccion='"+direccion+"',  where id= "+id;
         if(dni.equals("")||nombre.equals("")||apellidos.equals("")||nacimiento.equals("")||sexo.equals("")||celular.equals("")||correo.equals("")||direccion.equals("")){
             JOptionPane.showMessageDialog(null,"debe ingresar datos");
         }else{
             try {
                 cn=con.getCon();
                 st=cn.createStatement();
                 st.executeUpdate(sql);
                 JOptionPane.showMessageDialog(null,"Usuario actualizado");
                 limpiartabla();
             } catch (Exception e) {
                 System.out.println("error al actualizar" + e);
             }
         }
     }
        
        
        void eliminar() {
         int filaseleccionado=tabladatos.getSelectedRow();
         if(filaseleccionado==-1) {
             JOptionPane.showMessageDialog(null,"Debe seleccionar fila");
         }else{
             String sql = "delete from formulario where id="+id;
             try {
                 cn=con.getCon();
                 st=cn.createStatement();
                 st.executeUpdate(sql);
                 JOptionPane.showMessageDialog(null,"Usuario eliminado con exito.....!!!!");
                 limpiartabla();
             } catch (Exception e) {
             }
         }
     }
        
        
          void nuevo(){
           txt_id_eriksonyallico.setText("");
           txt_dni_eriksonyallico.setText("");
           txt_nombre_eriksonyallico.setText("");
           txt_apellidos_eriksonyallico.setText("");
           txt_fechanacimiento_eriksonyallico.setText("");
           txt_sexo_eriksonyallico.setText("");
           txt_celular_eriksonyallico.setText("");
           txt_correo_eriksonyallico.setText("");
           txt_direccion_eriksonyallico.setText("");
     }
        
        
        
        
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_id_eriksonyallico = new javax.swing.JTextField();
        txt_nombre_eriksonyallico = new javax.swing.JTextField();
        txt_apellidos_eriksonyallico = new javax.swing.JTextField();
        txt_fechanacimiento_eriksonyallico = new javax.swing.JTextField();
        txt_sexo_eriksonyallico = new javax.swing.JTextField();
        txt_celular_eriksonyallico = new javax.swing.JTextField();
        txt_correo_eriksonyallico = new javax.swing.JTextField();
        txt_direccion_eriksonyallico = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabladatos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_agregar_eriksonyallico = new javax.swing.JButton();
        btn_modificar_eriksonyallico = new javax.swing.JButton();
        btn_eliminar_eriksonyallico = new javax.swing.JButton();
        btn_nuevo_eriksonyallico = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_dni_eriksonyallico = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("VALLE GRANDE");

        jLabel2.setText("ID");

        jLabel3.setText("Nombres");

        jLabel4.setText("Apellidos");

        jLabel5.setText("Fecha de nacimiento");

        jLabel6.setText("sexo");

        jLabel7.setText("Celular");

        jLabel8.setText("Correo electronico");

        jLabel9.setText("Direccion");

        txt_id_eriksonyallico.setEditable(false);

        txt_sexo_eriksonyallico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sexo_eriksonyallicoActionPerformed(evt);
            }
        });

        tabladatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "Nombre", "Apellidos", "Fecha Nacimiento", "Sexo", "Celular", "Correo", "Direccion"
            }
        ));
        tabladatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabladatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabladatos);

        btn_agregar_eriksonyallico.setText("AGREGAR");
        btn_agregar_eriksonyallico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar_eriksonyallicoActionPerformed(evt);
            }
        });

        btn_modificar_eriksonyallico.setText("MODIFICAR");
        btn_modificar_eriksonyallico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_eriksonyallicoActionPerformed(evt);
            }
        });

        btn_eliminar_eriksonyallico.setText("ELIMINAR");
        btn_eliminar_eriksonyallico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_eriksonyallicoActionPerformed(evt);
            }
        });

        btn_nuevo_eriksonyallico.setText("NUEVO");
        btn_nuevo_eriksonyallico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo_eriksonyallicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btn_agregar_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btn_modificar_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btn_eliminar_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_nuevo_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_eliminar_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_nuevo_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_agregar_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel10.setText("DNI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel10))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_apellidos_eriksonyallico)
                                    .addComponent(txt_nombre_eriksonyallico)
                                    .addComponent(txt_fechanacimiento_eriksonyallico)
                                    .addComponent(txt_id_eriksonyallico)
                                    .addComponent(txt_dni_eriksonyallico, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(74, 74, 74)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_celular_eriksonyallico, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                            .addComponent(txt_sexo_eriksonyallico)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_direccion_eriksonyallico, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                            .addComponent(txt_correo_eriksonyallico)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(214, 214, 214)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(txt_id_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sexo_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_celular_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txt_dni_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_correo_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txt_nombre_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txt_direccion_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_apellidos_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_fechanacimiento_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_sexo_eriksonyallicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sexo_eriksonyallicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sexo_eriksonyallicoActionPerformed

    private void btn_agregar_eriksonyallicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar_eriksonyallicoActionPerformed
        Agregar();
        Listar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agregar_eriksonyallicoActionPerformed

    private void tabladatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabladatosMouseClicked
 int fila=tabladatos.getSelectedRow();
       if(fila==-1) {
           JOptionPane.showMessageDialog(null,"no se selecionado......!!!");
       }else{
           id=Integer.parseInt((String)tabladatos.getValueAt(fila,0).toString());
           String dni=(String)tabladatos.getValueAt(fila,1);
           String nombre=(String)tabladatos.getValueAt(fila,2);
           String apellidos=(String)tabladatos.getValueAt(fila,3);
           String fechanacimiento=(String)tabladatos.getValueAt(fila,4);
           String sexo=(String)tabladatos.getValueAt(fila,5);
           String celular=(String)tabladatos.getValueAt(fila,6);
           String correo=(String)tabladatos.getValueAt(fila,7);
           String direccion=(String)tabladatos.getValueAt(fila,8);
           txt_id_eriksonyallico.setText(""+id);
           txt_dni_eriksonyallico.setText(dni);
           txt_nombre_eriksonyallico.setText(nombre);
           txt_apellidos_eriksonyallico.setText(apellidos);
           txt_fechanacimiento_eriksonyallico.setText(fechanacimiento);
           txt_sexo_eriksonyallico.setText(sexo);
           txt_celular_eriksonyallico.setText(celular);
           txt_correo_eriksonyallico.setText(correo);
           txt_direccion_eriksonyallico.setText(direccion);
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_tabladatosMouseClicked

    private void btn_modificar_eriksonyallicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_eriksonyallicoActionPerformed
         modificar();
         Listar();    
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modificar_eriksonyallicoActionPerformed

    private void btn_eliminar_eriksonyallicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_eriksonyallicoActionPerformed
        eliminar();
        Listar();
        nuevo();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminar_eriksonyallicoActionPerformed

    private void btn_nuevo_eriksonyallicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo_eriksonyallicoActionPerformed
        nuevo();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nuevo_eriksonyallicoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar_eriksonyallico;
    private javax.swing.JButton btn_eliminar_eriksonyallico;
    private javax.swing.JButton btn_modificar_eriksonyallico;
    private javax.swing.JButton btn_nuevo_eriksonyallico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabladatos;
    private javax.swing.JTextField txt_apellidos_eriksonyallico;
    private javax.swing.JTextField txt_celular_eriksonyallico;
    private javax.swing.JTextField txt_correo_eriksonyallico;
    private javax.swing.JTextField txt_direccion_eriksonyallico;
    private javax.swing.JTextField txt_dni_eriksonyallico;
    private javax.swing.JTextField txt_fechanacimiento_eriksonyallico;
    private javax.swing.JTextField txt_id_eriksonyallico;
    private javax.swing.JTextField txt_nombre_eriksonyallico;
    private javax.swing.JTextField txt_sexo_eriksonyallico;
    // End of variables declaration//GEN-END:variables
}
