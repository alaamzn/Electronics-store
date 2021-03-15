/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electronicsstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mezni
 */
public class GestionProduits extends javax.swing.JFrame {

    /**
     * Creates new form GestionProduits
     */
    public GestionProduits() {
        initComponents();
        
        txtnompr.requestFocus();
        
        connectDataBase();
        
        loadDataFromDataBase();
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel d;
    
    
    public void connectDataBase(){
        try {
	  Class.forName("com.mysql.jdbc.Driver");
	  con = DriverManager.getConnection("jdbc:mysql://localhost/electronicsstore", "", "");
        } catch (ClassNotFoundException | SQLException ex) {
	  Logger.getLogger(GestionProduits.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadDataFromDataBase(){
        try {
	  int a;
	  PreparedStatement pst = con.prepareStatement("select * from produit");
	  
	  ResultSet rs = pst.executeQuery();
	  
	  ResultSetMetaData rd = rs.getMetaData();
	  
	  a = rd.getColumnCount();
	  
	  d = (DefaultTableModel)jTable1.getModel();
	  
	  d.setRowCount(0);
	  
	  
	 
	  while(rs.next()){
	      Vector v = new Vector();
	      
	      for(int i = 0; i < a; i++){
		v.add(rs.getString("id"));
		v.add(rs.getString("nompr"));
		v.add(rs.getString("description"));
		v.add(rs.getString("type"));
		v.add(rs.getString("couleur"));
		v.add(rs.getString("codebar"));
		v.add(rs.getString("prixachat"));
		v.add(rs.getString("prixvente"));
		v.add(rs.getString("quantité"));
	      }
	      d.addRow(v);
	  }
	  
        } catch (SQLException ex) {
	  Logger.getLogger(GestionProduits.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtchercher = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnompr = new javax.swing.JTextField();
        txtprixachat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtdesc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtcodebar = new javax.swing.JTextField();
        txtprixvente = new javax.swing.JTextField();
        txttype = new javax.swing.JComboBox<>();
        txtcouleur = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtquantite = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Chercher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Modifier");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Supprimer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Ajouter");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText("Quitter");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Gestion des Produits");

        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setText("Reset");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nom :");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Couleur :");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Description :");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Prix Achat :");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Code à Barre :");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Type :");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Prix Vente :");

        txttype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Smart phone", "Phone", "Smart TV", "TV", "PC Portable", "PC Bureau", "Tablet", "Anticasse", "Radio" }));

        txtcouleur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Noir", "Gold", "Rouge", "Jaune", "Vert", "Bleu", "Maron" }));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Quantité :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtnompr, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtdesc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtcouleur, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txttype, javax.swing.GroupLayout.Alignment.LEADING, 0, 126, Short.MAX_VALUE)))))
                        .addGap(3, 3, 3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtprixachat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtprixvente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtcodebar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtquantite, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnompr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtdesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txttype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcouleur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtcodebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtprixachat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtprixvente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtquantite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDProduit", "NomPr", "Desc", "Type", "Couleur", "CodeBarre", "PrixAchat", "PrixVente", "Quantité"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(28, 28, 28)
                                .addComponent(jButton2)
                                .addGap(26, 26, 26)
                                .addComponent(jButton3)
                                .addGap(26, 26, 26)
                                .addComponent(jButton6))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtchercher, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(51, 51, 51))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtchercher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jButton6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)))
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        d = (DefaultTableModel)jTable1.getModel();
        int selectedRow = jTable1.getSelectedRow();
        
        txtnompr.setText(d.getValueAt(selectedRow, 1).toString());
        txtdesc.setText(d.getValueAt(selectedRow, 2).toString());
        txttype.setSelectedItem(d.getValueAt(selectedRow, 3).toString());
        txtcouleur.setSelectedItem(d.getValueAt(selectedRow, 4).toString());
        txtcodebar.setText(d.getValueAt(selectedRow, 5).toString());
        txtprixachat.setText(d.getValueAt(selectedRow, 6).toString());
        txtprixvente.setText(d.getValueAt(selectedRow, 7).toString());
        txtquantite.setText(d.getValueAt(selectedRow, 8).toString());
        
        jButton4.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String nompr = txtnompr.getText();
        String desc = txtdesc.getText();
        String type = txttype.getSelectedItem().toString();
        String couleur = txtcouleur.getSelectedItem().toString();
        String codebar = txtcodebar.getText();
        String prixachat = txtprixachat.getText();
        String prixvente = txtprixvente.getText();
        String quantite = txtquantite.getText();
        
        try {
	  pst = con.prepareStatement("insert into produit(nompr,description,type,couleur,codebar,prixachat,prixvente,quantité) values(?, ?, ?, ?, ?, ?, ?, ?)");
	  
	  pst.setString(1, nompr);
	  pst.setString(2, desc);
	  pst.setString(3, type);
	  pst.setString(4, couleur);
	  pst.setString(5, codebar);
	  pst.setString(6, prixachat);
	  pst.setString(7, prixvente);
	  pst.setString(8, quantite);
	  
	  pst.executeUpdate();
	  
	  JOptionPane.showMessageDialog(this, "Produit Ajouté !!!");
	  
	  txtnompr.setText("");
	  txtdesc.setText("");
	  txttype.setSelectedIndex(0);
	  txtcouleur.setSelectedIndex(0);
	  txtcodebar.setText("");
	  txtprixachat.setText("");
	  txtprixvente.setText("");
	  txtquantite.setText("");
	  
	  txtnompr.requestFocus();
	  
	  loadDataFromDataBase();
	  
	  
        } catch (SQLException ex) {
	  Logger.getLogger(GestionProduits.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
	  // TODO add your handling code here:
	  d = (DefaultTableModel)jTable1.getModel();
	  int selectedRow = jTable1.getSelectedRow();
	  
	  int id = Integer.parseInt(d.getValueAt(selectedRow, 0).toString());
	  
	  pst = con.prepareStatement("delete from produit where id=?");
	  
	  pst.setInt(1, id);
	  
	  pst.executeUpdate();
	  
	  JOptionPane.showMessageDialog(this, "Produit Supprimé !!!");
	  
	  txtnompr.setText("");
	  txtdesc.setText("");
	  txttype.setSelectedIndex(0);
	  txtcouleur.setSelectedIndex(0);
	  txtcodebar.setText("");
	  txtprixachat.setText("");
	  txtprixvente.setText("");
	  txtquantite.setText("");
	  
	  txtnompr.requestFocus();
	  txtchercher.setText("");
	  loadDataFromDataBase();
	  
	  jButton4.setEnabled(true);
	  
        } catch (SQLException ex) {
	  Logger.getLogger(GestionProduits.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
            txtchercher.setText("");
            txtnompr.setText("");
	  txtdesc.setText("");
	  txttype.setSelectedIndex(0);
	  txtcouleur.setSelectedIndex(0);
	  txtcodebar.setText("");
	  txtprixachat.setText("");
	  txtprixvente.setText("");
	  txtquantite.setText("");
	  
	  txtnompr.requestFocus();
	  
	  loadDataFromDataBase();
	  
	  jButton4.setEnabled(true);
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
	  // TODO add your handling code here:

	  d = (DefaultTableModel)jTable1.getModel();
	  int selectedRow = jTable1.getSelectedRow();
	  
	  int id = Integer.parseInt(d.getValueAt(selectedRow, 0).toString());
	  
	  String nompr = txtnompr.getText();
	  String desc = txtdesc.getText();
	  String type = txttype.getSelectedItem().toString();
	  String couleur = txtcouleur.getSelectedItem().toString();
	  String codebar = txtcodebar.getText();
	  String prixachat = txtprixachat.getText();
	  String prixvente = txtprixvente.getText();
	  String quantite = txtquantite.getText();
	  
	  
	  
	  pst = con.prepareStatement("update produit set nompr=?, description=?, type=?, couleur=?,codebar=?, prixachat=?, prixvente=?, quantité=? where id=?");
	  
	  pst.setInt(9, id);
	  
	  pst.setString(1, nompr);
	  pst.setString(2, desc);
	  pst.setString(3, type);
	  pst.setString(4, couleur);
	  pst.setString(5, codebar);
	  pst.setString(6, prixachat);
	  pst.setString(7, prixvente);
	  pst.setString(8, quantite);
	  
	  int executeUpdate = pst.executeUpdate();
	  
	  JOptionPane.showMessageDialog(this, "Produit Modifié !!!");
	  
	  txtnompr.setText("");
	  txtdesc.setText("");
	  txttype.setSelectedIndex(0);
	  txtcouleur.setSelectedIndex(0);
	  txtcodebar.setText("");
	  txtprixachat.setText("");
	  txtprixvente.setText("");
	  txtquantite.setText("");
	  
	  txtnompr.requestFocus();
	  
	  loadDataFromDataBase();
	  
	  jButton4.setEnabled(true);
        } catch (SQLException ex) {
	  Logger.getLogger(GestionProduits.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
	  // TODO add your handling code here:
	  String motCle = txtchercher.getText();
	  pst = con.prepareStatement("select * from produit where codebar =?");
	  
	  pst.setString(1, motCle);
	  
	  rs = pst.executeQuery();
	  
	  d = (DefaultTableModel)jTable1.getModel();
	  
	  int rowCount = d.getRowCount();
	  int columnCount = d.getColumnCount();
	  
	  if(rs == null){
	      JOptionPane.showMessageDialog(this, "Produit non trouvé !!!");
	      
	      txtchercher.setText("");
	      txtchercher.requestFocus();
	      
	      loadDataFromDataBase();
	  } else {
	      for(int i = rowCount-1; i >= 0; i--){
		d.removeRow(i);
	      }
	      
	      while(rs.next()){
		Vector v = new Vector();
		for(int i = 0; i < columnCount; i++){
		    v.add(rs.getString("id"));
		    v.add(rs.getString("nompr"));
		    v.add(rs.getString("description"));
		    v.add(rs.getString("type"));
		    v.add(rs.getString("couleur"));
		    v.add(rs.getString("codebar"));
		    v.add(rs.getString("prixachat"));
		    v.add(rs.getString("prixvente"));
		    v.add(rs.getString("quantité"));
		}
		d.addRow(v);
	      }
	  }
	  
	  
        } catch (SQLException ex) {
	  Logger.getLogger(GestionProduits.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
	  java.util.logging.Logger.getLogger(GestionProduits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
	  java.util.logging.Logger.getLogger(GestionProduits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
	  java.util.logging.Logger.getLogger(GestionProduits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	  java.util.logging.Logger.getLogger(GestionProduits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
	  public void run() {
	      new GestionProduits().setVisible(true);
	  }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtchercher;
    private javax.swing.JTextField txtcodebar;
    private javax.swing.JComboBox<String> txtcouleur;
    private javax.swing.JTextField txtdesc;
    private javax.swing.JTextField txtnompr;
    private javax.swing.JTextField txtprixachat;
    private javax.swing.JTextField txtprixvente;
    private javax.swing.JTextField txtquantite;
    private javax.swing.JComboBox<String> txttype;
    // End of variables declaration//GEN-END:variables
}
