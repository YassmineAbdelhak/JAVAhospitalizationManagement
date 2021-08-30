package IHM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Insert_Patient extends JFrame {

    public Insert_Patient() {
        initComponents();
        loadTbale();
        
    }        
    private void initComponents() {

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel7 = new JPanel();
        entetePanel = new JPanel();
        creerFichier_label = new JLabel();
        exit_label = new JLabel();
        jTabbedPane1 = new JTabbedPane();
        mainPanel = new JPanel();
        add_btn = new JLabel();
        annuler_btn = new JLabel();
        civilite_cb = new JComboBox<>();
        bigpanel_gauche = new JPanel();
        nip_txt = new JTextField();
        numIm_txt = new JTextField();
        homme_rd = new JRadioButton();
        femme_rd = new JRadioButton();
        grpSang_cb = new JComboBox<>();
        profile_pic = new JLabel();
        civilite_cb2 = new JComboBox<>();
        sexe_cb = new JComboBox<>();
        grandePanelDroite = new JPanel();
        adressepardr_label = new JLabel();
        doc_cb1 = new JComboBox<>();
        nom_txt = new JTextField();
        email_txt = new JTextField();
        prenom_txt = new JTextField();
        dateNaiss_txt = new JTextField();
        profession_txt = new JTextField();
        sitFam_cb = new JComboBox<>();
        ville_txt = new JTextField();
        codePostale_txt = new JTextField();
        adresse_txt = new JTextField();
        nbrEnf_txt = new JTextField();
        telPort_txt = new JTextField();
        telProf_txt = new JTextField();
        telDom_txt = new JTextField();
        //annuler_btn = new JLabel();
        ajouter_btn = new JLabel();
        rechpanelLay1 = new JPanel();
        rechercherBigpanel = new JPanel();
        rechercherpanel = new JPanel();
        rechPat_txt = new JTextField();
        rechercher_btn = new JLabel();
        rechPanelLayout = new JPanel();
        jScrollPane1 = new JScrollPane();
        patient_table = new JTable();
        modifiergrandpanel = new JPanel();
        ajtbtn_label = new JLabel();
        anulbtn_label = new JLabel();
        civilite_cb3 = new JComboBox<>();
        msexeg_cb=new JComboBox<>(); 
        modifiergrandGauchePanel = new JPanel();
        mnip_txt = new JTextField();
        mnumIm_txt = new JTextField();
        mhomme_rd = new JRadioButton();
        mfemme_rd = new JRadioButton();
        mgrpSang_cb = new JComboBox<>();
        mprofile_pic = new JLabel();
        mcivilite_cb = new JComboBox<>();
        modifiergrandDroitePanel = new JPanel();
        modifierAdresseparLabel = new JLabel();
        mdoc_cb = new JComboBox<>();
        mnom_txt = new JTextField();
        memail_txt = new JTextField();
        mprenom_txt = new JTextField();
        mdateNaiss = new JTextField();
        mprofession_txt = new JTextField();
        msitFam_cb = new JComboBox<>();
        mville_txt = new JTextField();
        mcodePostale_txt = new JTextField();
        madresse_txt = new JTextField();
        mnbrEnf_txt = new JTextField();
        mtelPort_txt = new JTextField();
        mtelProf_txt = new JTextField();
        mtelDom_txt = new JTextField();
        msupp_btn = new JLabel();
        modifier_btn = new JLabel();
        
        
        
        setTitle("Fichier Patient");
        setBackground(new Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new Color(255, 255, 255));
        entetePanel.setBackground(new Color(0, 97, 88));

        creerFichier_label.setFont(new Font("Tahoma", 1, 16)); 
        creerFichier_label.setForeground(new Color(255, 255, 255));
        creerFichier_label.setText("Créer Fichier Patient");

        exit_label.setFont(new Font("Tahoma", 1, 16)); 
        exit_label.setForeground(new Color(255, 255, 255));
        exit_label.setText("X");
        exit_label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            dispose();
            }
        });
        //panel qui contient tittre de frame et X de fermeture
        //GroupLayout entetePanelLayout = new GroupLayout(entetePanel);
        entetePanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 13, 13));
        entetePanel.add(creerFichier_label);
        entetePanel.add(exit_label);

        jTabbedPane1.setBackground(new Color(255, 255, 255));

        mainPanel.setBackground(new Color(255, 255, 255));

        add_btn.setIcon(new ImageIcon(getClass().getResource("/images/ajouter_btn.png"))); 

        annuler_btn.setIcon(new ImageIcon(getClass().getResource("/images/annuler_btn.png"))); 

        //civilite_cb.setModel(new DefaultComboBoxModel<>(new String[] { "Civilité", "Item 2", "Item 3", "Item 4" }));

        bigpanel_gauche.setBackground(new Color(255, 255, 255));

        nip_txt.setFont(new Font("Tahoma", 0, 23)); 
        nip_txt.setForeground(new Color(112, 112, 112));
        nip_txt.setText("NIP...");
        nip_txt.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
            }
            public void focusGained(FocusEvent e) {
                if(nip_txt.getText().equals("NIP...")){
                    nip_txt.setText("");
                    } 
            }
            public void focusLost(FocusEvent e) {
                if(nip_txt.getText().equals("")){
                    nip_txt.setText("NIP...");
                }
            }
        });
        mnip_txt.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
            }
            public void focusGained(FocusEvent e) {
                if(mnip_txt.getText().equals("NIP...")){
                    mnip_txt.setText("");
                    } 
            }
            public void focusLost(FocusEvent e) {
                if(mnip_txt.getText().equals("")){
                    mnip_txt.setText("NIP...");
                }
            }
        });
        

        numIm_txt.setFont(new Font("Tahoma", 0, 23)); 
        numIm_txt.setForeground(new Color(112, 112, 112));
        numIm_txt.setText("Num Immatricule...");
        numIm_txt.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
                numIm_txtActionPerformed(evt);
            }
            public void focusGained(FocusEvent e) {
                if(numIm_txt.getText().equals("Num Immatricule...")){
                    numIm_txt.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(numIm_txt.getText().equals("")){
                    numIm_txt.setText("Num Immatricule...");
                }
            }
        });

        grpSang_cb.setFont(new Font("Tahoma", 0, 23)); 
        grpSang_cb.setForeground(new Color(112, 112, 112));
        grpSang_cb.setModel(new DefaultComboBoxModel<>(new String[] { "Groupe Sanguin...", "A+", "A-", "B+", "B-", "O-", "O+", "AB" }));
        grpSang_cb.setName("Groupe Sanguin"); 
        grpSang_cb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                grpSang_cbActionPerformed(evt);
            }
        });

        profile_pic.setIcon(new ImageIcon(getClass().getResource("/images/profilePic.png")));
        profile_pic.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                File f = chooser.getSelectedFile();
                String filename = f.getAbsolutePath();
                profile_pic.setText(filename);
                Image getAbsolutePath= null;
                ImageIcon icon = new ImageIcon(filename);
                Image image = icon.getImage().getScaledInstance(profile_pic.getWidth(), profile_pic.getHeight(),Image.SCALE_SMOOTH);
                profile_pic.setIcon(icon);
            }
        });
       
        sexe_cb.setFont(new Font("Tahoma", 0, 23)); 
        sexe_cb.setForeground(new Color(112, 112, 112));
        sexe_cb.setModel(new DefaultComboBoxModel<>(new String[] { "Sexe...", "Homme", "Femme"}));
        sexe_cb.setName("Sexe"); 
        /**sexe_cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });**/

        civilite_cb2.setFont(new Font("Tahoma", 0, 23)); 
        civilite_cb2.setForeground(new Color(112, 112, 112));
        civilite_cb2.setModel(new DefaultComboBoxModel<>(new String[] { "Civilité...", "M.", "Mlle.", "Mr." }));

        GroupLayout bigpanel_gaucheLayout = new GroupLayout(bigpanel_gauche);
        bigpanel_gauche.setLayout(bigpanel_gaucheLayout);
        bigpanel_gaucheLayout.setHorizontalGroup(
            bigpanel_gaucheLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bigpanel_gaucheLayout.createSequentialGroup()
                .addGroup(bigpanel_gaucheLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(profile_pic)
                    .addComponent(nip_txt, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                    .addComponent(numIm_txt, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexe_cb, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                    .addComponent(grpSang_cb, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                    .addComponent(civilite_cb2, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        bigpanel_gaucheLayout.setVerticalGroup(
            bigpanel_gaucheLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bigpanel_gaucheLayout.createSequentialGroup()
                .addComponent(profile_pic)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nip_txt, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numIm_txt, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sexe_cb, GroupLayout.PREFERRED_SIZE,44, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grpSang_cb, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(civilite_cb2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        sexe_cb.getAccessibleContext().setAccessibleName("sexe");
        grpSang_cb.getAccessibleContext().setAccessibleName("grp_sangCombo");

        grandePanelDroite.setBackground(new Color(255, 255, 255));

        adressepardr_label.setFont(new Font("Tahoma", 0, 23)); 
        adressepardr_label.setForeground(new Color(112, 112, 112));
        adressepardr_label.setText("Adressé par Docteur:");

        doc_cb1.setFont(new Font("Tahoma", 0, 23)); 
        doc_cb1.setForeground(new Color(112, 112, 112));
        doc_cb1.setModel(new DefaultComboBoxModel<>(new String[] { "Docteur...", "Kaouther Belaalia", "maha ben amor", "wiem chebaane", "ashref gadour" }));
        doc_cb1.setBorder(null);

        nom_txt.setFont(new Font("Tahoma", 0, 23)); 
        nom_txt.setForeground(new Color(112, 112, 112));
        nom_txt.setText("Nom...");
        nom_txt.setCaretColor(new Color(112, 112, 112));
        nom_txt.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
                nom_txtActionPerformed(evt);
            } 
            public void focusGained(FocusEvent e) {
                if(nom_txt.getText().equals("Nom...")){
                    nom_txt.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(nom_txt.getText().equals("")){
                    nom_txt.setText("Nom...");
                }
            }
        });

        email_txt.setFont(new Font("Tahoma", 0, 23)); 
        email_txt.setForeground(new Color(112, 112, 112));
        email_txt.setText("Email...");
        email_txt.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
                email_txtActionPerformed(evt);
            }
            public void focusGained(FocusEvent e) {
                if(email_txt.getText().equals("Email...")){
                    email_txt.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(email_txt.getText().equals("")){
                    email_txt.setText("Email...");
                }
            }
        });

        prenom_txt.setFont(new Font("Tahoma", 0, 23)); 
        prenom_txt.setForeground(new Color(112, 112, 112));
        prenom_txt.setText("Prénom...");
        prenom_txt.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
                prenom_txtActionPerformed(evt);
            }
            public void focusGained(FocusEvent e) {
                if(prenom_txt.getText().equals("Prénom...")){
                    prenom_txt.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(nom_txt.getText().equals("")){
                    nom_txt.setText("Prénom...");
                }
            }
        });

        dateNaiss_txt.setFont(new Font("Tahoma", 0, 23)); 
        dateNaiss_txt.setForeground(new Color(112, 112, 112));
        dateNaiss_txt.setText("Date de Naissance...");
        dateNaiss_txt.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
                dateNaiss_txtActionPerformed(evt);
            }
            @Override
            public void focusGained(FocusEvent e) {
                if(dateNaiss_txt.getText().equals("Date de Naissance...")){
                    dateNaiss_txt.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(dateNaiss_txt.getText().equals("")){
                    dateNaiss_txt.setText("Date de Naissance...");
                }
            }
        });

        profession_txt.setFont(new Font("Tahoma", 0, 23)); 
        profession_txt.setForeground(new Color(112, 112, 112));
        profession_txt.setText("Profession...");
        profession_txt.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
                profession_txtActionPerformed(evt);
            }
            public void focusGained(FocusEvent e) {
                if(profession_txt.getText().equals("Profession...")){
                    profession_txt.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(profession_txt.getText().equals("")){
                    profession_txt.setText("Profession...");
                }
            }
        });

        sitFam_cb.setFont(new Font("Tahoma", 0, 23)); 
        sitFam_cb.setForeground(new Color(112, 112, 112));
        sitFam_cb.setModel(new DefaultComboBoxModel<>(new String[] { "Situations Familiale...", "Marié ", "Divorcé ", "Célibataire " }));

        ville_txt.setFont(new Font("Tahoma", 0, 23)); 
        ville_txt.setForeground(new Color(112, 112, 112));
        ville_txt.setText("Ville...");
        ville_txt.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
                ville_txtActionPerformed(evt);
            }
            public void focusGained(FocusEvent e) {
                if(ville_txt.getText().equals("Ville...")){
                    ville_txt.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(ville_txt.getText().equals("")){
                    ville_txt.setText("Ville...");
                }
            }
        });

        codePostale_txt.setFont(new Font("Tahoma", 0, 23)); 
        codePostale_txt.setForeground(new Color(112, 112, 112));
        codePostale_txt.setText("Code Postale...");
        codePostale_txt.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
                codePostale_txtActionPerformed(evt);
            }
            public void focusGained(FocusEvent e) {
                if(codePostale_txt.getText().equals("Code Postale...")){
                    codePostale_txt.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(codePostale_txt.getText().equals("")){
                    codePostale_txt.setText("Code Postale...");
                }
            }
        });

        adresse_txt.setFont(new Font("Tahoma", 0, 23)); 
        adresse_txt.setForeground(new Color(112, 112, 112));
        adresse_txt.setText("Adresse...");
        adresse_txt.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
                adresse_txtActionPerformed(evt);
            }
            public void focusGained(FocusEvent e) {
                if(adresse_txt.getText().equals("Adresse...")){
                    adresse_txt.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(adresse_txt.getText().equals("")){
                    adresse_txt.setText("Adresse...");
                }
            }
        });

        nbrEnf_txt.setFont(new Font("Tahoma", 0, 23)); 
        nbrEnf_txt.setForeground(new Color(112, 112, 112));
        nbrEnf_txt.setText("Nombre Enfant...");
        nbrEnf_txt.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
                nbrEnf_txtActionPerformed(evt);
            }
            public void focusGained(FocusEvent e) {
                if(nbrEnf_txt.getText().equals("Nombre Enfant...")){
                    nbrEnf_txt.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(nbrEnf_txt.getText().equals("")){
                    nbrEnf_txt.setText("Nombre Enfant...");
                }
            }
        });

        telPort_txt.setFont(new Font("Tahoma", 0, 23)); 
        telPort_txt.setForeground(new Color(112, 112, 112));
        telPort_txt.setText("Téléphone Portable...");
        telPort_txt.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
                telPort_txtActionPerformed(evt);
            }
            public void focusGained(FocusEvent e) {
                if(telPort_txt.getText().equals("Téléphone Portable...")){
                    telPort_txt.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(telPort_txt.getText().equals("")){
                    telPort_txt.setText("Téléphone Portable...");
                }
            }
        });

        telProf_txt.setFont(new Font("Tahoma", 0, 23)); 
        telProf_txt.setForeground(new Color(112, 112, 112));
        telProf_txt.setText("Téléphone Professionelle...");
        telProf_txt.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
                telProf_txtActionPerformed(evt);
            }
            public void focusGained(FocusEvent e) {
                if(telProf_txt.getText().equals("Téléphone Professionelle...")){
                    telProf_txt.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(telProf_txt.getText().equals("")){
                    telProf_txt.setText("Téléphone Professionelle...");
                }
            }
        });

        telDom_txt.setFont(new Font("Tahoma", 0, 23)); 
        telDom_txt.setForeground(new Color(112, 112, 112));
        telDom_txt.setText("Téléphone Domicille...");
        telDom_txt.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
                telDom_txtActionPerformed(evt);
            }
            public void focusGained(FocusEvent e) {
                if(telDom_txt.getText().equals("Téléphone Domicille...")){
                    telDom_txt.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(telDom_txt.getText().equals("")){
                    telDom_txt.setText("Téléphone Domicille...");
                }
            }
        });

        annuler_btn.setIcon(new ImageIcon(getClass().getResource("/images/annuler_btn.png"))); 
        annuler_btn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
        
        modifier_btn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            // Connexion à la BD
		//Connection c = Connexion.getConnection();
                
		Connection c = null;
                try {
                    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root","");
                } catch (SQLException ex) {
                    Logger.getLogger(Insert_Patient.class.getName()).log(Level.SEVERE, null, ex);
                }
		// Définition et exécution de la requête d'insertion
		if (c != null) {
			try {
			c.setAutoCommit(false);
			int nip=Integer.parseInt(mnip_txt.getText());
                        String num_imm=mnumIm_txt.getText();
			String sexe= String.valueOf(msexeg_cb.getSelectedItem());
                        String nom= mnom_txt.getText();
                        String prenom= mprenom_txt.getText();
                        String date= mdateNaiss.getText();
                        String email= memail_txt.getText();
                        String adresse= madresse_txt.getText();
                        String adressePar= String.valueOf(mdoc_cb.getSelectedItem());
                        int codePostale= Integer.parseInt(mcodePostale_txt.getText());
                        String ville= mville_txt.getText();
                        String civilite= String.valueOf(mcivilite_cb.getSelectedItem());
                        String grpSng= String.valueOf(mgrpSang_cb.getSelectedItem());
                        String sit_fam= String.valueOf(msitFam_cb.getSelectedItem());
                        String profession= mprofession_txt.getText();
                        int nbr_enf= Integer.parseInt(mnbrEnf_txt.getText());
                        int tel_dom= Integer.parseInt(mtelDom_txt.getText()); 
                        int tel_prof= Integer.parseInt(mtelProf_txt.getText());
                        int tel_port= Integer.parseInt(mtelPort_txt.getText());
                        PreparedStatement s = c.prepareStatement("UPDATE `patient` SET `num_imm`=?,"
                                + "`sexe`=?,`nom`=?,`prenom`=?,`dateNai`=?,`email`=?,`adresse`=?"
                                + ",`adressé_par`=?,`code_postale`=?,`ville`=?,`civilite`=?"
                                + ",`grp_sng`=?,`sit_fam`=?,`nb_enf`=?,`profession`=?,`tel_dom`=?,"
                                + "`tel_prof`=?,`tel_portable`=? WHERE `nip`=?;");
			s.setString(1, num_imm);
                        s.setString(2, sexe);
                        s.setString(3, nom);
			s.setString(4, prenom);
                        s.setString(5, date);
			s.setString(6, email);
			s.setString(7, adresse);
			s.setString(8, adressePar);
                        s.setInt(9, codePostale);
                        s.setString(10, ville);
			s.setString(11, civilite);
                        s.setString(12, grpSng);     
                        s.setString(13, sit_fam);
                        s.setInt(14, nbr_enf);
                        s.setString(15, profession);
			s.setInt(16, tel_dom);
			s.setInt(17, tel_prof);
                        s.setInt(18, tel_port);
                        s.setInt(19, nip);
			int res = s.executeUpdate();
			if (res != 0) { // Activer le commit uniquement si la requête s'est exécuté sans problème
                            c.commit();
                            JOptionPane.showMessageDialog(mainPanel,"Patient modifié avec succés");
                            mnip_txt.setText("NIP...");
                            mnumIm_txt.setText("Num Immatricule...");
			    msexeg_cb.setSelectedIndex(0);
                            mnom_txt.setText("Nom...");
                            mprenom_txt.setText("Prénom...");
                            mdateNaiss.setText("Date de Naissance...");
                            memail_txt.setText("Email...");
                            madresse_txt.setText("Adresse...");
                            mdoc_cb.setSelectedIndex(0);
                            mcodePostale_txt.setText("Code Postale...");
                            mville_txt.setText("Ville...");
                            mcivilite_cb.setSelectedIndex(0);
                            mgrpSang_cb.setSelectedIndex(0);
                            msitFam_cb.setSelectedIndex(0);
                            mprofession_txt.setText("Profession...");
                            mnbrEnf_txt.setText("Nombre Enfant...");
                            mtelDom_txt.setText("Téléphone Domicille..."); 
                            mtelProf_txt.setText("Téléphone Professionelle...");
                            mtelPort_txt.setText("Téléphone Portable...");
                            loadTbale();
			}else{
                            JOptionPane.showMessageDialog(mainPanel,"Problème au niveau de modification du Patient!");
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
        });
        
        msupp_btn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
		Connection c = null;
                try {
                    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root","");
                } catch (SQLException ex) {
                    Logger.getLogger(Insert_Patient.class.getName()).log(Level.SEVERE, null, ex);
                }
		// Définition et exécution de la requête d'insertion
		if (c != null) {
			try {
			c.setAutoCommit(false);
			int nip=Integer.parseInt(mnip_txt.getText());
                        PreparedStatement s = c.prepareStatement("delete from patient where nip=?;");
			s.setInt(1, nip);
			int res = s.executeUpdate();
			if (res != 0) { // Activer le commit uniquement si la requête s'est exécuté sans problème
                            c.commit();
                            JOptionPane.showMessageDialog(mainPanel,"Patient Retirer avec succés");
                            mnip_txt.setText("NIP...");
                            mnumIm_txt.setText("Num Immatricule...");
			    msexeg_cb.setSelectedIndex(0);
                            mnom_txt.setText("Nom...");
                            mprenom_txt.setText("Prénom...");
                            mdateNaiss.setText("Date de Naissance...");
                            memail_txt.setText("Email...");
                            madresse_txt.setText("Adresse...");
                            mdoc_cb.setSelectedIndex(0);
                            mcodePostale_txt.setText("Code Postale...");
                            mville_txt.setText("Ville...");
                            mcivilite_cb.setSelectedIndex(0);
                            mgrpSang_cb.setSelectedIndex(0);
                            msitFam_cb.setSelectedIndex(0);
                            mprofession_txt.setText("Profession...");
                            mnbrEnf_txt.setText("Nombre Enfant...");
                            mtelDom_txt.setText("Téléphone Domicille..."); 
                            mtelProf_txt.setText("Téléphone Professionelle...");
                            mtelPort_txt.setText("Téléphone Portable...");
                            loadTbale();
			}else{
                            JOptionPane.showMessageDialog(mainPanel,"Problème au niveau de modification du Patient!");
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
        });
        
        ajouter_btn.setIcon(new ImageIcon(getClass().getResource("/images/ajouter_btn.png"))); 
        ajouter_btn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            // Connexion à la BD
		//Connection c = Connexion.getConnection();
                
		Connection c = null;
                try {
                    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root","");
                } catch (SQLException ex) {
                    Logger.getLogger(Insert_Patient.class.getName()).log(Level.SEVERE, null, ex);
                }
		// Définition et exécution de la requête d'insertion
		if (c != null) {
			try {
			c.setAutoCommit(false);
			int nip=Integer.parseInt(nip_txt.getText());
                        String num_imm=numIm_txt.getText();
			String sexe= String.valueOf(sexe_cb.getSelectedItem());
                        String nom= nom_txt.getText();
                        String prenom= prenom_txt.getText();
                        String photo= profile_pic.getText();
                        String date= dateNaiss_txt.getText();
                        String email= email_txt.getText();
                        String adresse= adresse_txt.getText();
                        String adressePar= String.valueOf(doc_cb1.getSelectedItem());
                        int codePostale= Integer.parseInt(codePostale_txt.getText());
                        String ville= ville_txt.getText();
                        String civilite= String.valueOf(civilite_cb2.getSelectedItem());
                        String grpSng= String.valueOf(grpSang_cb.getSelectedItem());
                        String sit_fam= String.valueOf(sitFam_cb.getSelectedItem());
                        String profession= profession_txt.getText();
                        int nbr_enf= Integer.parseInt(nbrEnf_txt.getText());
                        int tel_dom= Integer.parseInt(telDom_txt.getText()); 
                        int tel_prof= Integer.parseInt(telProf_txt.getText());
                        int tel_port= Integer.parseInt(telPort_txt.getText());
                        PreparedStatement ps = c.prepareStatement("SELECT * FROM `patient` WHERE `nip`=?;");		
			ps.setInt(1, nip);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
                            JOptionPane.showMessageDialog(ajouter_btn,"numéro NIP existe déja");
                        
                        }
                        else{
                        PreparedStatement s = c.prepareStatement("insert into patient(`nip`, `num_imm`, `sexe`, `nom`, `prenom`, `photo`, `dateNai`, `email`, `adresse`, `adressé_par`, `code_postale`, `ville`, `civilite`, `grp_sng`, `sit_fam`, `nb_enf`, `profession`, `tel_dom`, `tel_prof`, `tel_portable`)  values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
                        s.setInt(1, nip);
			s.setString(2, num_imm);
                        s.setString(3, sexe);
                        s.setString(4, nom);
			s.setString(5, prenom);
			s.setString(6, photo);
                        s.setString(7, date);
			s.setString(8, email);
			s.setString(9, adresse);
			s.setString(10, adressePar);
                        s.setInt(11, codePostale);
                        s.setString(12, ville);
			s.setString(13, civilite);
                        s.setString(14, grpSng);     
                        s.setString(15, sit_fam);
                        s.setInt(16, nbr_enf);
                        s.setString(17, profession);
			s.setInt(18, tel_dom);
			s.setInt(19, tel_prof);
                        s.setInt(20, tel_port);			
			int res = s.executeUpdate();
			if (res != 0) { // Activer le commit uniquement si la requête s'est exécuté sans problème
                            c.commit();
                            JOptionPane.showMessageDialog(mainPanel,"Patient ajouté avec succés");
                            nip_txt.setText("NIP...");
                            numIm_txt.setText("Num Immatricule...");
			    sexe_cb.setSelectedIndex(0);
                            profile_pic.setIcon(new ImageIcon(getClass().getResource("/images/profilePic.png")));
                            nom_txt.setText("Nom...");
                            prenom_txt.setText("Prénom...");
                            dateNaiss_txt.setText("Date de Naissance...");
                            email_txt.setText("Email...");
                            adresse_txt.setText("Adresse...");
                            doc_cb1.setSelectedIndex(0);
                            codePostale_txt.setText("Code Postale...");
                            ville_txt.setText("Ville...");
                            civilite_cb2.setSelectedIndex(0);
                            grpSang_cb.setSelectedIndex(0);
                            sitFam_cb.setSelectedIndex(0);
                            profession_txt.setText("Profession...");
                            nbrEnf_txt.setText("Nombre Enfant...");
                            telDom_txt.setText("Téléphone Domicille..."); 
                            telProf_txt.setText("Téléphone Professionelle...");
                            telPort_txt.setText("Téléphone Portable...");
                            loadTbale();
			}else{
                            JOptionPane.showMessageDialog(mainPanel,"Problème au niveau d'insertion du Patient!");
                        }
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
        });
        
               
        //ajouter les textFields et boutons ay grandpanelDroite
        GroupLayout grandePanelDroiteLayout = new GroupLayout(grandePanelDroite);
        grandePanelDroite.setLayout(grandePanelDroiteLayout);
        grandePanelDroiteLayout.setHorizontalGroup(
            grandePanelDroiteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(grandePanelDroiteLayout.createSequentialGroup()
                .addComponent(adressepardr_label)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doc_cb1, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(grandePanelDroiteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(grandePanelDroiteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(grandePanelDroiteLayout.createSequentialGroup()
                        .addComponent(nom_txt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prenom_txt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
                    .addGroup(grandePanelDroiteLayout.createSequentialGroup()
                        .addComponent(email_txt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateNaiss_txt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
                    .addGroup(grandePanelDroiteLayout.createSequentialGroup()
                        .addGroup(grandePanelDroiteLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(grandePanelDroiteLayout.createSequentialGroup()
                                .addComponent(codePostale_txt, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ville_txt, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
                            .addComponent(profession_txt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(grandePanelDroiteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(sitFam_cb, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                            .addComponent(adresse_txt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(grandePanelDroiteLayout.createSequentialGroup()
                        .addComponent(nbrEnf_txt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telPort_txt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
                    .addGroup(grandePanelDroiteLayout.createSequentialGroup()
                        .addComponent(telProf_txt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telDom_txt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
                    .addGroup(grandePanelDroiteLayout.createSequentialGroup()
                        .addComponent(annuler_btn)
                        .addGap(18, 18, 18)
                        .addComponent(ajouter_btn)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        grandePanelDroiteLayout.setVerticalGroup(
            grandePanelDroiteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(grandePanelDroiteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(grandePanelDroiteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(doc_cb1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                    .addComponent(adressepardr_label))
                .addGap(18, 18, 18)
                .addGroup(grandePanelDroiteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nom_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addComponent(prenom_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(grandePanelDroiteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(email_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateNaiss_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(grandePanelDroiteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(profession_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sitFam_cb, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(grandePanelDroiteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ville_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addComponent(codePostale_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addComponent(adresse_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(grandePanelDroiteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(telPort_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addComponent(nbrEnf_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(grandePanelDroiteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(telProf_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addComponent(telDom_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(grandePanelDroiteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(ajouter_btn)
                    .addComponent(annuler_btn))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        adressepardr_label.getAccessibleContext().setAccessibleName("adressé_par_lbl");
        //ajouter bouton au grand panel droite
        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(civilite_cb, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(annuler_btn)
                .addGap(50, 50, 50)
                .addComponent(add_btn)
                .addGap(58, 58, 58))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(bigpanel_gauche, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(grandePanelDroite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(bigpanel_gauche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(grandePanelDroite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(civilite_cb, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_btn)
                    .addComponent(annuler_btn))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        annuler_btn.getAccessibleContext().setAccessibleName("annuler_btn");

        jTabbedPane1.addTab("Ajouter Patient", mainPanel);

        rechercherBigpanel.setBackground(new Color(255,255,255));
        rechPat_txt.setFont(new Font("Tahoma", 0, 23)); 
        rechPat_txt.setForeground(new Color(112, 112, 112));
        rechPat_txt.setText("Rechercher Patient...");
        rechPat_txt.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e) {
                if(rechPat_txt.getText().equals("Rechercher Patient...")){
                    rechPat_txt.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(rechPat_txt.getText().equals("")){
                    rechPat_txt.setText("Rechercher Patient...");
                }
            }
        });

        rechercher_btn.setIcon(new ImageIcon(getClass().getResource("/images/rechercher_btn.png"))); 
        rechercher_btn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            // Connexion à la BD
		//Connection c = Connexion.getConnection();
                int nip=Integer.parseInt(rechPat_txt.getText());
                loadTbaleR();
            }
        });

        GroupLayout rechercherpanelLayout = new GroupLayout(rechercherpanel);
        rechercherpanel.setLayout(rechercherpanelLayout);
        rechercherpanelLayout.setHorizontalGroup(
            rechercherpanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(rechercherpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rechPat_txt, GroupLayout.PREFERRED_SIZE, 603, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rechercher_btn, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );
        rechercherpanelLayout.setVerticalGroup(
            rechercherpanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(rechercherpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rechercherpanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(rechPat_txt, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                    .addComponent(rechercher_btn))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        jScrollPane1.setViewportView(patient_table);
        patient_table.getAccessibleContext().setAccessibleName("Patient_List");
        patient_table.getAccessibleContext().setAccessibleDescription("");

        GroupLayout rechPanelLayoutLayout = new GroupLayout(rechPanelLayout);
        rechPanelLayout.setLayout(rechPanelLayoutLayout);
        rechPanelLayoutLayout.setHorizontalGroup(
            rechPanelLayoutLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING)
        );
        rechPanelLayoutLayout.setVerticalGroup(
            rechPanelLayoutLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(rechPanelLayoutLayout.createSequentialGroup()
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 507, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
        );

        GroupLayout rechercherBigpanelLayout = new GroupLayout(rechercherBigpanel);
        rechercherBigpanel.setLayout(rechercherBigpanelLayout);
        rechercherBigpanelLayout.setHorizontalGroup(
            rechercherBigpanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(rechercherBigpanelLayout.createSequentialGroup()
                .addComponent(rechercherpanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
            .addComponent(rechPanelLayout, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        rechercherBigpanelLayout.setVerticalGroup(
            rechercherBigpanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(rechercherBigpanelLayout.createSequentialGroup()
                .addComponent(rechercherpanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rechPanelLayout, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        GroupLayout rechpanelLay1Layout = new GroupLayout(rechpanelLay1);
        rechpanelLay1.setLayout(rechpanelLay1Layout);
        rechpanelLay1Layout.setHorizontalGroup(
            rechpanelLay1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(rechercherBigpanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        rechpanelLay1Layout.setVerticalGroup(
            rechpanelLay1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(rechpanelLay1Layout.createSequentialGroup()
                .addComponent(rechercherBigpanel, GroupLayout.PREFERRED_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
        );

        rechercherBigpanel.getAccessibleContext().setAccessibleName("RechercherJpanel");

        jTabbedPane1.addTab("Liste des Patients", rechpanelLay1);

        modifiergrandpanel.setBackground(new Color(255, 255, 255));

        ajtbtn_label.setIcon(new ImageIcon(getClass().getResource("/images/ajouter_btn.png"))); 

        anulbtn_label.setIcon(new ImageIcon(getClass().getResource("/images/annuler_btn.png"))); 


        modifiergrandGauchePanel.setBackground(new Color(255, 255, 255));

        mnip_txt.setFont(new Font("Tahoma", 0, 23)); 
        mnip_txt.setForeground(new Color(112, 112, 112));
        mnip_txt.setText("NIP...");
        mnip_txt.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    int nip=Integer.parseInt(mnip_txt.getText());
                    try {
                       Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava","root","");
                       PreparedStatement ps= con1.prepareStatement("SELECT `num_imm`, `sexe`, `nom`, `prenom`, `photo`, `dateNai`, `email`, `adresse`, `adressé_par`, `code_postale`, `ville`, `civilite`, `grp_sng`, `sit_fam`, `nb_enf`, `profession`, `tel_dom`, `tel_prof`, `tel_portable` FROM `patient` where nip=?;");
                       ps.setInt(1, nip);
                       ResultSet Rs = ps.executeQuery();
                       if(Rs.next()){
                            mnumIm_txt.setText(Rs.getString("num_imm"));
			    msexeg_cb.setSelectedItem(Rs.getString("sexe"));
                            mnom_txt.setText(Rs.getString("nom"));
                            mprenom_txt.setText(Rs.getString("prenom"));
                            mdateNaiss.setText(Rs.getString("dateNai"));
                            memail_txt.setText(Rs.getString("email"));
                            madresse_txt.setText(Rs.getString("adresse"));
                            mdoc_cb.setSelectedItem(Rs.getString("adressé_par"));
                            mcodePostale_txt.setText(Rs.getString("code_postale"));
                            mville_txt.setText(Rs.getString("ville"));
                            mcivilite_cb.setSelectedItem(Rs.getString("civilite"));
                            mgrpSang_cb.setSelectedItem(Rs.getString("grp_sng"));
                            msitFam_cb.setSelectedItem(Rs.getString("sit_fam"));
                            mprofession_txt.setText(Rs.getString("profession"));
                            mnbrEnf_txt.setText(Rs.getString("nb_enf"));
                            mtelDom_txt.setText(Rs.getString("tel_dom")); 
                            mtelProf_txt.setText(Rs.getString("tel_prof"));
                            mtelPort_txt.setText(Rs.getString("tel_portable"));
                            //JOptionPane.showMessageDialog(mainPanel, "Utilisateur existe");
                       }else{
                           JOptionPane.showMessageDialog(mainPanel, "Utilisateur n'existe pas");
                       }
                     } catch (Exception e2) {
                        e2.printStackTrace();
                   }
                }
            }
        });

        mnumIm_txt.setFont(new Font("Tahoma", 0, 23)); 
        mnumIm_txt.setForeground(new Color(112, 112, 112));
        mnumIm_txt.setText("Num Immatricule...");
        mnumIm_txt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mnumIm_txtActionPerformed(evt);
            }
        });

        mgrpSang_cb.setFont(new Font("Tahoma", 0, 23)); 
        mgrpSang_cb.setForeground(new Color(112, 112, 112));
        mgrpSang_cb.setModel(new DefaultComboBoxModel<>(new String[] { "Groupe Sanguin...", "A+", "A-", "B+", "B-", "O-", "O+", "AB" }));
        mgrpSang_cb.setName("Groupe Sanguin"); 
        mgrpSang_cb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mgrpSang_cbActionPerformed(evt);
            }
        });
        msexeg_cb.setFont(new Font("Tahoma", 0, 23)); 
        msexeg_cb.setForeground(new Color(112, 112, 112));
        msexeg_cb.setModel(new DefaultComboBoxModel<>(new String[] { "Sexe...", "Homme", "Femme" }));
        msexeg_cb.setName("Sexe"); 
        /**msexeg_cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msexeg_cbActionPerformed(e); 
            }

            private void msexeg_cbActionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
            
        });**/

        mprofile_pic.setIcon(new ImageIcon(getClass().getResource("/images/profilePic.png"))); 

        mcivilite_cb.setFont(new Font("Tahoma", 0, 23)); 
        mcivilite_cb.setForeground(new Color(112, 112, 112));
        mcivilite_cb.setModel(new DefaultComboBoxModel<>(new String[] { "Civilité...", "M.", "Mlle.", "Mr." }));

        GroupLayout modifiergrandGauchePanelLayout = new GroupLayout(modifiergrandGauchePanel);
        modifiergrandGauchePanel.setLayout(modifiergrandGauchePanelLayout);
        modifiergrandGauchePanelLayout.setHorizontalGroup(
            modifiergrandGauchePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(modifiergrandGauchePanelLayout.createSequentialGroup()
                .addGroup(modifiergrandGauchePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(mprofile_pic)
                    .addComponent(mnip_txt, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                    .addComponent(mnumIm_txt, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                    .addComponent(msexeg_cb, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                    .addComponent(mgrpSang_cb, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                    .addComponent(mcivilite_cb, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        modifiergrandGauchePanelLayout.setVerticalGroup(
            modifiergrandGauchePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(modifiergrandGauchePanelLayout.createSequentialGroup()
                .addComponent(mprofile_pic)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mnip_txt, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mnumIm_txt, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msexeg_cb, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mgrpSang_cb, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mcivilite_cb, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        modifiergrandDroitePanel.setBackground(new Color(255, 255, 255));

        modifierAdresseparLabel.setFont(new Font("Tahoma", 0, 23)); 
        modifierAdresseparLabel.setForeground(new Color(112, 112, 112));
        modifierAdresseparLabel.setText("Adressé par Docteur:");

        mdoc_cb.setFont(new Font("Tahoma", 0, 23)); 
        mdoc_cb.setForeground(new Color(112, 112, 112));
        mdoc_cb.setModel(new DefaultComboBoxModel<>(new String[] { "Docteur...", "Kaouther Belaalia", "maha ben amor", "wiem chebaane", "ashref gadour" }));
        mdoc_cb.setBorder(null);

        mnom_txt.setFont(new Font("Tahoma", 0, 23)); 
        mnom_txt.setForeground(new Color(112, 112, 112));
        mnom_txt.setText("Nom...");
        mnom_txt.setCaretColor(new Color(112, 112, 112));
        mnom_txt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mnom_txtActionPerformed(evt);
            }
        });

        memail_txt.setFont(new Font("Tahoma", 0, 23)); 
        memail_txt.setForeground(new Color(112, 112, 112));
        memail_txt.setText("Email...");
        memail_txt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                memail_txtActionPerformed(evt);
            }
        });

        mprenom_txt.setFont(new Font("Tahoma", 0, 23)); 
        mprenom_txt.setForeground(new Color(112, 112, 112));
        mprenom_txt.setText("Prénom...");
        mprenom_txt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mprenom_txtActionPerformed(evt);
            }
        });

        mdateNaiss.setFont(new Font("Tahoma", 0, 23)); 
        mdateNaiss.setForeground(new Color(112, 112, 112));
        mdateNaiss.setText("Date de Naissance...");
        mdateNaiss.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mdateNaissActionPerformed(evt);
            }
        });

        mprofession_txt.setFont(new Font("Tahoma", 0, 23)); 
        mprofession_txt.setForeground(new Color(112, 112, 112));
        mprofession_txt.setText("Profession...");
        mprofession_txt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mprofession_txtActionPerformed(evt);
            }
        });

        msitFam_cb.setFont(new Font("Tahoma", 0, 23)); 
        msitFam_cb.setForeground(new Color(112, 112, 112));
        msitFam_cb.setModel(new DefaultComboBoxModel<>(new String[] { "Situations Familiale...", "Marié ", "Divorcé ", "Célibataire ", " " }));

        mville_txt.setFont(new Font("Tahoma", 0, 23)); 
        mville_txt.setForeground(new Color(112, 112, 112));
        mville_txt.setText("Ville...");
        mville_txt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mville_txtActionPerformed(evt);
            }
        });

        mcodePostale_txt.setFont(new Font("Tahoma", 0, 23)); 
        mcodePostale_txt.setForeground(new Color(112, 112, 112));
        mcodePostale_txt.setText("Code Postale...");
        mcodePostale_txt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mcodePostale_txtActionPerformed(evt);
            }
        });

        madresse_txt.setFont(new Font("Tahoma", 0, 23)); 
        madresse_txt.setForeground(new Color(112, 112, 112));
        madresse_txt.setText("Adresse...");
        madresse_txt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                madresse_txtActionPerformed(evt);
            }
        });

        mnbrEnf_txt.setFont(new Font("Tahoma", 0, 23)); 
        mnbrEnf_txt.setForeground(new Color(112, 112, 112));
        mnbrEnf_txt.setText("Nombre Enfant...");
        mnbrEnf_txt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mnbrEnf_txtActionPerformed(evt);
            }
        });

        mtelPort_txt.setFont(new Font("Tahoma", 0, 23)); 
        mtelPort_txt.setForeground(new Color(112, 112, 112));
        mtelPort_txt.setText("Téléphone Portable...");
        mtelPort_txt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mtelPort_txtActionPerformed(evt);
            }
        });

        mtelProf_txt.setFont(new Font("Tahoma", 0, 23)); 
        mtelProf_txt.setForeground(new Color(112, 112, 112));
        mtelProf_txt.setText("Téléphone Professionelle...");
        mtelProf_txt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mtelProf_txtActionPerformed(evt);
            }
        });

        mtelDom_txt.setFont(new Font("Tahoma", 0, 23)); 
        mtelDom_txt.setForeground(new Color(112, 112, 112));
        mtelDom_txt.setText("Téléphone Domicille...");
        mtelDom_txt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mtelDom_txtActionPerformed(evt);
            }
        });

        msupp_btn.setIcon(new ImageIcon(getClass().getResource("/images/supp_btn.png"))); 

        modifier_btn.setIcon(new ImageIcon(getClass().getResource("/images/modifier_btn.png"))); 

        GroupLayout modifiergrandDroitePanelLayout = new GroupLayout(modifiergrandDroitePanel);
        modifiergrandDroitePanel.setLayout(modifiergrandDroitePanelLayout);
        modifiergrandDroitePanelLayout.setHorizontalGroup(
            modifiergrandDroitePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(modifiergrandDroitePanelLayout.createSequentialGroup()
                .addComponent(modifierAdresseparLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mdoc_cb, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(modifiergrandDroitePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(modifiergrandDroitePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(modifiergrandDroitePanelLayout.createSequentialGroup()
                        .addComponent(mnom_txt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mprenom_txt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
                    .addGroup(modifiergrandDroitePanelLayout.createSequentialGroup()
                        .addComponent(memail_txt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mdateNaiss, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
                    .addGroup(modifiergrandDroitePanelLayout.createSequentialGroup()
                        .addGroup(modifiergrandDroitePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(modifiergrandDroitePanelLayout.createSequentialGroup()
                                .addComponent(mcodePostale_txt, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mville_txt, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
                            .addComponent(mprofession_txt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(modifiergrandDroitePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(msitFam_cb, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                            .addComponent(madresse_txt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(modifiergrandDroitePanelLayout.createSequentialGroup()
                        .addComponent(mnbrEnf_txt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mtelPort_txt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
                    .addGroup(modifiergrandDroitePanelLayout.createSequentialGroup()
                        .addComponent(mtelProf_txt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mtelDom_txt, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
                    .addGroup(modifiergrandDroitePanelLayout.createSequentialGroup()
                        .addComponent(msupp_btn)
                        .addGap(18, 18, 18)
                        .addComponent(modifier_btn)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        modifiergrandDroitePanelLayout.setVerticalGroup(
            modifiergrandDroitePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(modifiergrandDroitePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(modifiergrandDroitePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(mdoc_cb, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifierAdresseparLabel))
                .addGap(18, 18, 18)
                .addGroup(modifiergrandDroitePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(mnom_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addComponent(mprenom_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modifiergrandDroitePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(memail_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addComponent(mdateNaiss, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modifiergrandDroitePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(mprofession_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addComponent(msitFam_cb, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modifiergrandDroitePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(mville_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addComponent(mcodePostale_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addComponent(madresse_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modifiergrandDroitePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(mtelPort_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addComponent(mnbrEnf_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modifiergrandDroitePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(mtelProf_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addComponent(mtelDom_txt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modifiergrandDroitePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(modifier_btn)
                    .addComponent(msupp_btn))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        GroupLayout modifiergrandpanelLayout = new GroupLayout(modifiergrandpanel);
        modifiergrandpanel.setLayout(modifiergrandpanelLayout);
        modifiergrandpanelLayout.setHorizontalGroup(
            modifiergrandpanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(modifiergrandpanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(anulbtn_label)
                .addGap(50, 50, 50)
                .addComponent(ajtbtn_label)
                .addGap(58, 58, 58))
            .addGroup(modifiergrandpanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(modifiergrandGauchePanel, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modifiergrandDroitePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        modifiergrandpanelLayout.setVerticalGroup(
            modifiergrandpanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(modifiergrandpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(modifiergrandpanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(modifiergrandGauchePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifiergrandDroitePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(modifiergrandpanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    //.addComponent(civilite_cb3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                    .addComponent(ajtbtn_label)
                    .addComponent(anulbtn_label))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Modifier Patient", modifiergrandpanel);

        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(entetePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(entetePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 633, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void grpSang_cbActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void numIm_txtActionPerformed(ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void nip_txtActionPerformed(ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void telProf_txtActionPerformed(ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void telDom_txtActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void adresse_txtActionPerformed(ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void telPort_txtActionPerformed(ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void codePostale_txtActionPerformed(ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void nbrEnf_txtActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void prenom_txtActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void profession_txtActionPerformed(ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void email_txtActionPerformed(ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void ville_txtActionPerformed(ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void dateNaiss_txtActionPerformed(ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void nom_txtActionPerformed(ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void mnip_txtActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void mnumIm_txtActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void mgrpSang_cbActionPerformed(ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void mnom_txtActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void memail_txtActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void mprenom_txtActionPerformed(ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void mdateNaissActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void mprofession_txtActionPerformed(ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void mville_txtActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void mcodePostale_txtActionPerformed(ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void madresse_txtActionPerformed(ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void mnbrEnf_txtActionPerformed(ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void mtelPort_txtActionPerformed(ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void mtelProf_txtActionPerformed(ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void mtelDom_txtActionPerformed(ActionEvent evt) {                                            
        // TODO add your handling code here:
    }
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Insert_Patient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private JTextField adresse_txt;
    private DefaultTableModel model;
    private JTextField email_txt;
    private JLabel ajouter_btn;
    private JLabel annuler_btn;
    private JComboBox<String> civilite_cb;
    private JComboBox<String> civilite_cb2;
    private JComboBox<String> civilite_cb3;
    private JComboBox<String>  msexeg_cb;
    private JTextField codePostale_txt;
    private JTextField dateNaiss_txt;
    private JComboBox<String> doc_cb1;
    private JLabel exit_label;
    private JRadioButton femme_rd;
    private JComboBox<String> grpSang_cb;
    private JRadioButton homme_rd;
    private JLabel creerFichier_label;
    private JLabel ajtbtn_label;
    private JLabel anulbtn_label;
    private JLabel modifierAdresseparLabel;
    private JLabel adressepardr_label;
    private JLabel add_btn;
    private JPanel jPanel1;
    private JPanel bigpanel_gauche;
    private JPanel grandePanelDroite;
    private JPanel rechercherpanel;
    private JPanel rechPanelLayout;
    private JPanel modifiergrandpanel;
    private JPanel modifiergrandGauchePanel;
    private JPanel modifiergrandDroitePanel;
    private JPanel jPanel2;
    private JPanel mainPanel;
    private JPanel rechpanelLay1;
    private JPanel jPanel7;
    private JPanel entetePanel;
    private JPanel rechercherBigpanel;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;
    private JTextField madresse_txt;
    private JTextField memail_txt;
    private JLabel msupp_btn;
    private JComboBox<String> mcivilite_cb;
    private JComboBox<String> sexe_cb;
    private JTextField mcodePostale_txt;
    private JTextField mdateNaiss;
    private JComboBox<String> mdoc_cb;
    private JRadioButton mfemme_rd;
    private JComboBox<String> mgrpSang_cb;
    private JRadioButton mhomme_rd;
    private JTextField mnbrEnf_txt;
    private JTextField mnip_txt;
    private JTextField mnom_txt;
    private JTextField mnumIm_txt;
    private JLabel modifier_btn;
    private JTextField mprenom_txt;
    private JTextField mprofession_txt;
    private JLabel mprofile_pic;
    private JComboBox<String> msitFam_cb;
    private JTextField mtelDom_txt;
    private JTextField mtelPort_txt;
    private JTextField mtelProf_txt;
    private JTextField mville_txt;
    private JTextField nbrEnf_txt;
    private JTextField nip_txt;
    private JTextField nom_txt;
    private JTextField numIm_txt;
    private JTable patient_table;
    private JTextField prenom_txt;
    private JTextField profession_txt;
    private JLabel profile_pic;
    private JTextField rechPat_txt;
    private JLabel rechercher_btn;
    private JComboBox<String> sitFam_cb;
    private JTextField telDom_txt;
    private JTextField telPort_txt;
    private JTextField telProf_txt;
    private JTextField ville_txt;
    // End of variables declaration                   

    public void loadTbale() {
           try {
               Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava","root","");
               PreparedStatement ps= con1.prepareStatement("SELECT nip, num_imm, nom, prenom, adressé_par, tel_portable FROM `patient`;");
               ResultSet Rs = ps.executeQuery();
               patient_table.setModel(DbUtils.resultSetToTableModel(Rs));
           } catch (Exception e) {
                e.printStackTrace();
           }
    }
    public void loadTbaleR() {
           try {
               Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava","root","");
               int nip= Integer.parseInt(rechPat_txt.getText());
               PreparedStatement ps= con1.prepareStatement("SELECT nip, num_imm, nom, prenom, adressé_par, tel_portable FROM `patient` where nip=?;");
               ps.setInt(1, nip);
               ResultSet Rs = ps.executeQuery();
               if(Rs.next()){
                    patient_table.setModel(DbUtils.resultSetToTableModel(Rs));
               }else{
                   JOptionPane.showMessageDialog(mainPanel, "Utilisateur n'existe pas");
               }
           } catch (Exception e) {
                e.printStackTrace();
           }
    }
}
