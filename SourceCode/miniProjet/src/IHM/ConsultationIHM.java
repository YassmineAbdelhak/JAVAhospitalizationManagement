
package IHM;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

public class ConsultationIHM extends JFrame {

  
    public ConsultationIHM() {
        initComponents();
        loadTbale();
    }

    private javax.swing.JButton ajouter;
    private JButton effacerTout;
    private JButton modifier;
    private JButton supprimer;
    private JCheckBox cnam;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JTable constTab;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea consultation;
    private JTextField numero;
    private JTextField titreConsultation;
    private JTextField heure;
    private JTextField dateAjrd;
    private JTextField user;
    private JTextField titre;
    private JTextField prenom;
    private JTextField nom;
    private JTextField etat;
    private JTextField date;
    private JTextField honorraire;
    private JButton cliche;
   
   
                             
    private void initComponents() {

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();
        numero = new JTextField();
        titre = new JTextField();
        prenom = new JTextField();
        nom = new JTextField();
        etat = new JTextField();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jPanel3 = new JPanel();
        jLabel14 = new JLabel();
        jScrollPane1 = new JScrollPane();
        constTab = new JTable();
        jLabel13 = new JLabel();
        ajouter = new JButton();
        jPanel4 = new JPanel();
        date = new JTextField();
        honorraire = new JTextField();
        cnam = new JCheckBox();
        cliche = new JButton("choisir file");
        titreConsultation = new JTextField();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jScrollPane2 = new JScrollPane();
        consultation = new JTextArea();
        jLabel15 = new JLabel();
        effacerTout = new JButton();
        modifier = new JButton();
        supprimer = new JButton();
        heure = new JTextField();
        dateAjrd = new JTextField();
        user = new JTextField();
        jLabel16 = new JLabel();
        jLabel17 = new JLabel();
        jLabel18 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fiche Consultation");

        jPanel1.setBackground(new Color(255, 255, 255));

        jPanel2.setBackground(new Color(255, 255, 255));

        jLabel1.setFont(new Font("Tahoma", 0, 16)); 
        jLabel1.setForeground(new Color(102, 102, 102));
        jLabel1.setText("Gestion Des patients");

        numero.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    int nip=Integer.parseInt(numero.getText());
                    try {
                       Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava","root","");
                       PreparedStatement ps= con1.prepareStatement("SELECT `nom`, `prenom`,`civilite`, `sit_fam` FROM `patient` where nip=?;");
                       ps.setInt(1, nip);
                       ResultSet Rs = ps.executeQuery();
                       if(Rs.next()){
                            nom.setText(Rs.getString("nom"));
                            prenom.setText(Rs.getString("prenom"));
                            titre.setText(Rs.getString("civilite"));
                            etat.setText(Rs.getString("sit_fam"));
                            loadTbaleSpe();
                            //JOptionPane.showMessageDialog(mainPanel, "Utilisateur existe");
                       }else{
                           JOptionPane.showMessageDialog(jPanel1, "Utilisateur n'existe pas");
                       }
                     } catch (Exception e2) {
                        e2.printStackTrace();
                   }
                }
            }
        });
        nom.setEditable(false);
        prenom.setEditable(false);
        titre.setEditable(false);
        etat.setEditable(false);
        
        titre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel2.setText("NIP");

        jLabel3.setText("Civilité");

        jLabel4.setText("Prénom");

        jLabel5.setText("Nom");
        jLabel7.setText("Sit. Familiale");
        numero.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
            }
            public void focusGained(FocusEvent e) {
                if(numero.getText().equals("NIP...")){
                    numero.setText("");
                    } 
            }
            public void focusLost(FocusEvent e) {
                if(numero.getText().equals("")){
                    numero.setText("NIP...");
                }
            }
        });
        date.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
            }
            public void focusGained(FocusEvent e) {
                if(date.getText().equals("Date...")){
                    date.setText("");
                    } 
            }
            public void focusLost(FocusEvent e) {
                if(date.getText().equals("")){
                    date.setText("Date...");
                }
            }
        });
        honorraire.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
            }
            public void focusGained(FocusEvent e) {
                if(honorraire.getText().equals("Honorraire...")){
                    honorraire.setText("");
                    } 
            }
            public void focusLost(FocusEvent e) {
                if(honorraire.getText().equals("")){
                    honorraire.setText("Honorraire...");
                }
            }
        });
        titreConsultation.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
            }
            public void focusGained(FocusEvent e) {
                if(titreConsultation.getText().equals("Donner Titre au Consultation...")){
                    titreConsultation.setText("");
                    } 
            }
            public void focusLost(FocusEvent e) {
                if(titreConsultation.getText().equals("")){
                    titreConsultation.setText("Ecrire Titre Consultation...");
                }
            }
        });
        consultation.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
            }
            public void focusGained(FocusEvent e) {
                if(consultation.getText().equals("Ecrire Contenu Consultation...")){
                    consultation.setText("");
                    } 
            }
            public void focusLost(FocusEvent e) {
                if(consultation.getText().equals("")){
                    consultation.setText("Ecrire Contenu Consultation...");
                }
            }
        });
        
        constTab.addMouseListener(new MouseListener() {
            

            @Override
            public void mouseClicked(MouseEvent e) {
                //SELECT nom, prenom, civilite, sit_fam, dateCons, honoraire, cnam, cliché, consTxt, id_patient FROM `consultation`, `patient` WHERE patient.nip=consultation.id_patient and id_consultation=?; 
                int ligne = constTab.getSelectedRow();
                int id = (int) constTab.getModel().getValueAt(ligne,0);
                //JOptionPane.showMessageDialog(jPanel1,"LIGNE==> "+ligne+" ID=>"+id);
                try {
                    Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava","root","");
                    PreparedStatement ps= con1.prepareStatement("SELECT nom, prenom, civilite, sit_fam, dateCons, honoraire, cnam, cliché, titre, consTxt, id_patient FROM `consultation`, `patient` WHERE patient.nip=consultation.id_patient and id_consultation=?;");
                    ps.setInt(1, id);
                    ResultSet Rs = ps.executeQuery();
                    if(Rs.next()){
                        numero.setText(Rs.getString("id_patient"));
                        nom.setText(Rs.getString("nom"));
                        prenom.setText(Rs.getString("prenom"));
                        titre.setText(Rs.getString("civilite"));
                        etat.setText(Rs.getString("sit_fam"));
                        date.setText(Rs.getString("dateCons"));
                        honorraire.setText(Rs.getString("honoraire"));
                        String cn= Rs.getString("cliché");
                        if( cn.equals("OUI")){
                                cnam.setSelected(true);
                        }else{
                                cnam.setSelected(false);
                        }
                        titreConsultation.setText(Rs.getString("titre"));
                        consultation.setText(Rs.getString("consTxt"));
                        
                    }
           } catch (Exception e1) {
                e1.printStackTrace();
           }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //System.err.println("mousePressed"); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //System.err.println("mousereleased");//To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //System.err.println("mouseEntered"); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //System.err.println("mouseExited"); //To change body of generated methods, choose Tools | Templates.
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numero, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titre, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(prenom, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nom, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel6)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                //.addComponent(age, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etat, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(numero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(titre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(prenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    //.addComponent(age, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(etat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 20,GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );

        jLabel14.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setForeground(new Color(102, 102, 102));
        jLabel14.setText("Liste des Consultations");

        constTab.setCursor(new java.awt.Cursor(Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(constTab);

        jLabel13.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setForeground(new Color(102, 102, 102));
        jLabel13.setText("Nouvelle Consultation");

        ajouter.setBackground(new Color(0, 61, 58));
        ajouter.setForeground(new Color(255, 255, 255));
        ajouter.setText("Ajouter");
        ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		Connection c = null;
                try {
                    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root","");
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultationIHM.class.getName()).log(Level.SEVERE, null, ex);
                }
		// Définition et exécution de la requête d'insertion
		if (c != null) {
			try {
			c.setAutoCommit(false);
                        int idp = Integer.parseInt(numero.getText());
                        String dt = date.getText();
                        String hr= honorraire.getText();
                        String cn="NON";
                        if(cnam.isSelected()){
                            cn="OUI";
                        }else{
                            cn="NON";
                        }
                        String cl=cliche.getText();
                        String tr=titreConsultation.getText();
                        String cnst= consultation.getText();
			PreparedStatement s = c.prepareStatement("INSERT INTO `consultation`(`id_patient`, `dateCons`, `honoraire`, `cnam`, `cliché`, `titre`, `consTxt`) VALUES (?,?,?,?,?,?,?);");
			//s.setInt(1, a.getId());
			s.setInt(1, idp);
			s.setString(2, dt);
                        s.setString(3, hr);
                        s.setString(4, cn);
			s.setString(5, cl);
			s.setString(6, tr);
                        s.setString(7, cnst);			
			int res = s.executeUpdate();
			if (res != 0) { // Activer le commit uniquement si la requête s'est exécuté sans problème
                            c.commit();
                            JOptionPane.showMessageDialog(jPanel1, "Consultation Ajouté!");
                            loadTbaleSpe();
                            numero.setText("NIP...");
                            nom.setText("");
                            prenom.setText("");
                            etat.setText("");
                            titre.setText("");
                            date.setText("Date...");
                            honorraire.setText("Honorraire...");
                            cnam.setSelected(false);
                            cliche.setText("Choisir Fichier");
                            titreConsultation.setText("Ecrire Titre Consultation...");
                            consultation.setText("Ecrire Contenu Consultation...");
                            loadTbale();
                        }else{
                            JOptionPane.showMessageDialog(jPanel1, "Consultation ne peut pas Etre ajouté!");
                        }
			} catch (SQLException e1) { 
                            e1.printStackTrace(); 
                            System.out.println("problem au niveau SQL");
                        }
			catch (Exception e1) { 
                            e1.printStackTrace();
                            System.out.println("problem");
                        }
		}
            }
        } );

        jPanel4.setBackground(new Color(255, 255, 255));

        cliche.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                File f = chooser.getSelectedFile();
                String filename = f.getAbsolutePath();
                cliche.setText(filename);
            }
        });


        jLabel8.setText("Date");

        jLabel9.setText("Honorraires");

        jLabel10.setText("CNAM");

        jLabel11.setText("Cliché");

        jLabel12.setText("Titre");

        consultation.setColumns(20);
        consultation.setRows(5);
        jScrollPane2.setViewportView(consultation);

        jLabel15.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jLabel15.setForeground(new Color(102, 102, 102));

       GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(titreConsultation)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(date, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(honorraire, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cnam)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cliche, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 577, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(date, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(honorraire, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cnam)
                    .addComponent(cliche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(titreConsultation,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel15)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))))
        );

        effacerTout.setBackground(new Color(0, 61, 58));
        effacerTout.setForeground(new Color(255, 255, 255));
        effacerTout.setText("Effacer tout");
        effacerTout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		Connection c = null;
                try {
                    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root","");
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultationIHM.class.getName()).log(Level.SEVERE, null, ex);
                }
		// Définition et exécution de la requête d'insertion
		if (c != null) {
			try {
			c.setAutoCommit(false);
                        //int ligne = constTab.getSelectedRow();
                        int idp = (int) constTab.getModel().getValueAt(0,1);
			PreparedStatement s = c.prepareStatement("delete from consultation where id_patient=?;");	
                        s.setInt(1, idp);
			int res = s.executeUpdate();
			if (res != 0) { // Activer le commit uniquement si la requête s'est exécuté sans problème
                            c.commit();
                            JOptionPane.showMessageDialog(jPanel1, "Tous les Consultation de l'utilisateur ont été Supprimer avec succées!");
                            loadTbaleSpe();
                            numero.setText("NIP...");
                            nom.setText("");
                            prenom.setText("");
                            etat.setText("");
                            titre.setText("");
                            date.setText("Date...");
                            honorraire.setText("Honorraire...");
                            cnam.setSelected(false);
                            cliche.setText("Choisir Fichier");
                            titreConsultation.setText("Ecrire Titre Consultation...");
                            consultation.setText("Ecrire Contenu Consultation...");
                            loadTbale();
                        }else{
                            JOptionPane.showMessageDialog(jPanel1, "Les Consultations de l'utilisateur ne peut pas Etre Supprimer!");
                        }
			} catch (SQLException e1) { 
                            e1.printStackTrace(); 
                            System.out.println("problem au niveau SQL");
                        }
			catch (Exception e1) { 
                            e1.printStackTrace();
                            System.out.println("problem");
                        }
		}
            }
        } );

        modifier.setBackground(new Color(0, 61, 58));
        modifier.setForeground(new Color(255, 255, 255));
        modifier.setText("Modifier Consultation");
        modifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		Connection c = null;
                try {
                    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root","");
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultationIHM.class.getName()).log(Level.SEVERE, null, ex);
                }
		// Définition et exécution de la requête d'insertion
		if (c != null) {
			try {
			c.setAutoCommit(false);
                        int ligne = constTab.getSelectedRow();
                        int idp = (int) constTab.getModel().getValueAt(ligne,0);
                        //int idp = Integer.parseInt(numero.getText());
                        String dt = date.getText();
                        String hr= honorraire.getText();
                        String cn="NON";
                        if(cnam.isSelected()){
                            cn="OUI";
                        }else{
                            cn="NON";
                        }
                        String cl=cliche.getText();
                        String tr=titreConsultation.getText();
                        String cnst= consultation.getText();
			PreparedStatement s = c.prepareStatement("update consultation set dateCons=?"
                                + ",honoraire=?,cnam=?,cliché=?,titre=?,consTxt=? where id_consultation=?;");
			//s.setInt(1, a.getId());
			
			s.setString(1, dt);
                        s.setString(2, hr);
                        s.setString(3, cn);
			s.setString(4, cl);
			s.setString(5, tr);
                        s.setString(6, cnst);	
                        s.setInt(7, idp);
			int res = s.executeUpdate();
			if (res != 0) { // Activer le commit uniquement si la requête s'est exécuté sans problème
                            c.commit();
                            JOptionPane.showMessageDialog(jPanel1, "Consultation Modifier!");
                            loadTbaleSpe();
                            numero.setText("NIP...");
                            nom.setText("");
                            prenom.setText("");
                            etat.setText("");
                            titre.setText("");
                            date.setText("Date...");
                            honorraire.setText("Honorraire...");
                            cnam.setSelected(false);
                            cliche.setText("Choisir Fichier");
                            titreConsultation.setText("Ecrire Titre Consultation...");
                            consultation.setText("Ecrire Contenu Consultation...");
                        }else{
                            JOptionPane.showMessageDialog(jPanel1, "Consultation ne peut pas Etre Modifier!");
                        }
			} catch (SQLException e1) { 
                            e1.printStackTrace(); 
                            System.out.println("problem au niveau SQL");
                        }
			catch (Exception e1) { 
                            e1.printStackTrace();
                            System.out.println("problem");
                        }
		}
            }
        } );


        supprimer.setBackground(new Color(0, 61, 58));
        supprimer.setForeground(new Color(255, 255, 255));
        supprimer.setText("Retirer Consultation");
        supprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		Connection c = null;
                try {
                    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root","");
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultationIHM.class.getName()).log(Level.SEVERE, null, ex);
                }
		// Définition et exécution de la requête d'insertion
		if (c != null) {
			try {
			c.setAutoCommit(false);
                        int ligne = constTab.getSelectedRow();
                        int idp = (int) constTab.getModel().getValueAt(ligne,0);
			PreparedStatement s = c.prepareStatement("delete from consultation where id_consultation=?;");	
                        s.setInt(1, idp);
			int res = s.executeUpdate();
			if (res != 0) { // Activer le commit uniquement si la requête s'est exécuté sans problème
                            c.commit();
                            JOptionPane.showMessageDialog(jPanel1, "Consultation Supprimer!");
                            loadTbaleSpe();
                            numero.setText("NIP...");
                            nom.setText("");
                            prenom.setText("");
                            etat.setText("");
                            titre.setText("");
                            date.setText("Date...");
                            honorraire.setText("Honorraire...");
                            cnam.setSelected(false);
                            cliche.setText("Choisir Fichier");
                            titreConsultation.setText("Ecrire Titre Consultation...");
                            consultation.setText("Ecrire Contenu Consultation...");
                            loadTbale();
                        }else{
                            JOptionPane.showMessageDialog(jPanel1, "Consultation ne peut pas Etre Supprimer!");
                        }
			} catch (SQLException e1) { 
                            e1.printStackTrace(); 
                            System.out.println("problem au niveau SQL");
                        }
			catch (Exception e1) { 
                            e1.printStackTrace();
                            System.out.println("problem");
                        }
		}
            }
        } );
        

        //heure.setText("jTextField11");
        heure.setBorder(null);
        dateAjrd.setBorder(null);

        //dateAjrd.setText("jTextField12");

        //dateAjrd.setText("jTextField13");

        jLabel16.setText("Heure");
        jLabel16.setForeground(new Color(255, 255, 255));

        jLabel17.setText("Date");
        jLabel17.setForeground(new Color(255, 255, 255));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(210, 210, 210)
                                .addComponent(ajouter)
                                .addGap(18, 18, 18)
                                .addComponent(modifier)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(supprimer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(effacerTout, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(106, 106, 106)
                        .addComponent(jLabel16)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(heure, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateAjrd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel18)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateAjrd, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(ajouter)
                        .addComponent(modifier)))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(supprimer)
                            .addComponent(dateAjrd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(dateAjrd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(heure, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(effacerTout)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel3,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 903, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }                      

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
       
    }                                           

   
    public static void main(String args[]) {
       
       EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultationIHM().setVisible(true);
            }
        });
    }
    public void loadTbale() {
           try {
               Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava","root","");
               PreparedStatement ps= con1.prepareStatement("SELECT id_consultation, id_patient, dateCons FROM `consultation`;");
               ResultSet Rs = ps.executeQuery();
               constTab.setModel(DbUtils.resultSetToTableModel(Rs));
           } catch (Exception e) {
                e.printStackTrace();
           }
    }
    public void loadTbaleSpe() {
           try {
               Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava","root","");
               int id=Integer.parseInt(numero.getText());
               PreparedStatement ps= con1.prepareStatement("SELECT id_consultation, id_patient, dateCons FROM `consultation`where id_patient=?;");
               ps.setInt(1, id);
               ResultSet Rs = ps.executeQuery();
               constTab.setModel(DbUtils.resultSetToTableModel(Rs));
           } catch (Exception e) {
                e.printStackTrace();
           }
    }
                    
}
