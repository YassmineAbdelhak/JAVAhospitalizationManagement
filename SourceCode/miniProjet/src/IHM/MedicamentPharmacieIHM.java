
package IHM;

import DAO.Connexion;
import DAO.MedicamentDAO;
import DAO.OrdonnanceDAO;
import MODEL.Medicament;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicamentPharmacieIHM extends JFrame implements ActionListener,MouseListener,KeyListener {

   
    public MedicamentPharmacieIHM() {
        initComponents();
    }
                         
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JList<String> jList1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea jTextArea1;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextArea jTextField6;
    private JTextField jTextField7;
    private Label label1;
    private Label label2;
    private Panel panel2;
    private  DefaultListModel model;
    
    MedicamentDAO MedicamentDAO = new MedicamentDAO();
    ArrayList<Medicament> allMedicaments = new ArrayList<Medicament>();
    private DefaultListModel<String> medicamentModel = new DefaultListModel<String>();

                        
    private void initComponents() {

        panel2 = new Panel();
        jTextField5 = new JTextField();
        jScrollPane1 = new JScrollPane(jList1);
        jList1 = new JList<>();
        label1 = new Label();
        label2 = new Label();
        jTextField4 = new JTextField();
        jScrollPane2 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jTextField6 = new JTextArea();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jCheckBox1 = new JCheckBox();
        jCheckBox2 = new JCheckBox();
        jCheckBox3 = new JCheckBox();
        jTextField7 = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jButton7 = new JButton();
        jButton8 = new JButton();
        jButton9 = new JButton();
        model = new DefaultListModel();
         
        
        jScrollPane1.setViewportView(jList1);
        //jList1.setModel(model);
        jList1.setModel(medicamentModel);
        jList1.addMouseListener(this);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Medicaments de la pharmacie");
        setBackground(new java.awt.Color(255, 255, 255));

        jTextField5.setForeground(new Color(102, 102, 102));
        jTextField5.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
            }
            public void focusGained(FocusEvent e) {
                if(jTextField5.getText().equals("Recherche Rapide...")){
                    jTextField5.setText("");
                    } 
            }
            public void focusLost(FocusEvent e) {
                if(jTextField5.getText().equals("")){
                    jTextField5.setText("Recherche Rapide...");
                }
            }
        });
        jTextField5.addActionListener(this);
        jTextField5.addKeyListener(this);
       

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //jList1.setModel(new AbstractListModel<String>() {
           // String[] strings = { "Doliprane","Asprine","Abuféne","Voltaréne","Spasmocalme"};
            
            
            
           // public int getSize() { return strings.length; }
           // public String getElementAt(int i) { return strings[i]; }
      //  });
        
        
        jScrollPane1.setViewportView(jList1);

        label1.setText("Medicaments");

        label2.setText("Medicament choisi");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jButton1.setBackground(new Color(0, 61, 58));
        jButton1.setForeground(new Color(255, 255, 255));
        jButton1.setText("Saut de ligne");
        jButton1.addActionListener(this);

        jButton2.setBackground(new Color(0, 61, 58));
        jButton2.setForeground(new Color(255, 255, 255));
        jButton2.setText("Ajouter");
        jButton2.addActionListener(this);

        jButton3.setBackground(new Color(0, 61, 58));
        jButton3.setForeground(new Color(255, 255, 255));
        jButton3.setText("Creer ordonnance");
        jButton3.addActionListener(this);

        jButton4.setBackground(new Color(0, 61, 58));
        jButton4.setForeground(new Color(255, 255, 255));
        jButton4.setText("Tout effacer");
        jButton4.addActionListener(this);
       

        jButton5.setBackground(new Color(0, 61, 58));
        jButton5.setForeground(new Color(255, 255, 255));
        jButton5.setText("Annuler");
        jButton5.addActionListener(this);

        jButton6.setBackground(new Color(0, 61, 58));
        jButton6.setForeground(new Color(255, 255, 255));
        jButton6.setText("Ordo memorisee");

        jCheckBox1.setText("Ordonnance ALD");

        jCheckBox2.setText("Imprimer duplicata");

        jCheckBox3.setText("Imprimer triplicata");

        jLabel1.setText("Quantite");

        jLabel2.setText("Posologie");

        jButton7.setBackground(new Color(0, 61, 58));
        jButton7.setForeground(new Color(255, 255, 255));
        jButton7.setText("Ajouter Medicament");
        jButton7.addActionListener(this);

        jButton8.setBackground(new Color(0, 61, 58));
        jButton8.setForeground(new Color(255, 255, 255));
        jButton8.setText("Modifier Medicament");
        jButton8.addActionListener(this);
        
        jButton9.setBackground(new Color(0, 61, 58));
        jButton9.setForeground(new Color(255, 255, 255));
        jButton9.setText("Retirer Medicament");
        jButton9.addActionListener(this);
        updateList();
        
        javax.swing.GroupLayout panel2Layout = new GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton8,GroupLayout.PREFERRED_SIZE, 162,GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jButton9,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addComponent(jTextField5)
                            .addComponent(jTextField4,GroupLayout.PREFERRED_SIZE, 527,GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 106,GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 106,GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox3))
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4,GroupLayout.PREFERRED_SIZE, 111,GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5,GroupLayout.PREFERRED_SIZE, 116,GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jTextField6,GroupLayout.PREFERRED_SIZE, 424,GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField7,GroupLayout.PREFERRED_SIZE, 73,GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton6))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField5,GroupLayout.PREFERRED_SIZE, 29,GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label1,GroupLayout.PREFERRED_SIZE, 11,GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1,GroupLayout.PREFERRED_SIZE, 88,GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label2,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4,GroupLayout.PREFERRED_SIZE, 36,GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2,GroupLayout.PREFERRED_SIZE, 54,GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton2,GroupLayout.PREFERRED_SIZE, 27,GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1,GroupLayout.PREFERRED_SIZE, 34,GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 27,GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton6,GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3,GroupLayout.PREFERRED_SIZE, 32,GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4,GroupLayout.PREFERRED_SIZE, 32,GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5,GroupLayout.PREFERRED_SIZE, 32,GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTextField6,GroupLayout.PREFERRED_SIZE, 103,GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel2,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel2,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }      
    
    public void loadMedicaments()
    {
    	MedicamentDAO mDAO = new MedicamentDAO();
    	allMedicaments = mDAO.getAllMedicaments();
    	for (Medicament medicament : allMedicaments) {
    		medicamentModel.addElement(medicament.getNomMed());
		}
    }
    
     @Override
    public void actionPerformed(ActionEvent e) { 
        
        
        
       Object o = e.getSource();
       //System.out.print("aaa");
		
		if(o == jButton7)
		{
                    
			Connection cn = Connexion.getConnection();
            if (cn != null) {
            try {
          
            String req = "insert into medicament (`NomMed`,`IdMed`) values (?,?);";
            PreparedStatement ps = cn.prepareStatement(req);
            //System.out.println("aloo");
            
            ps.setString(1,jTextField4.getText());
            ps.setString(2,"id");
            
            int res = ps.executeUpdate();

            if(res != 0){
            System.out.println("Un nouveau medicament est ajoutÃ© !");
            medicamentModel.removeAllElements();
            updateList();
            }
            

        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
         }
		}
                
          
        if(o == jButton8)
		{
                    
			Connection cn = Connexion.getConnection();
            if (cn != null) {
            try {
          
            String req = "update medicament set IdMed=?, NomMed=? where NomMed=?;";
            PreparedStatement ps = cn.prepareStatement(req);
            
            System.out.println(" aloo!");
            ps.setString(1,"id");
            ps.setString(2,jTextField4.getText());
            ps.setString(3,jList1.getSelectedValue());
            
            System.out.print(jTextField4.getText());
            System.out.print(jList1.getSelectedValue());
            
            int res = ps.executeUpdate();

            if(res != 0){
            System.out.println("modification effectuée!");
            medicamentModel.removeAllElements();
            updateList();
            }
            

        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
         }
		}
        
         if(o == jButton9)
		{
                    
			Connection cn = Connexion.getConnection();
            if (cn != null) {
            try {
          
           String req = "delete from medicament where NomMed=?;";
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setString(1,jTextField4.getText());
            
            int res = ps.executeUpdate();

            if(res != 0){
            System.out.println(" medicament est supprimé ");
            medicamentModel.removeAllElements();
            updateList();
            jTextField4.setText("");
            }
            

        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
         }
		}
         
          if(o == jButton2)
		{
                    
			Connection cn = Connexion.getConnection();
            if (cn != null) {
            try {
          
             String req2 = "select `IdM` from medicament where NomMed = ?;";
            PreparedStatement ps2 = cn.prepareStatement(req2);
            
            ps2.setString(1,jTextField4.getText());
            ResultSet res2 = ps2.executeQuery();
             System.out.println(res2);
                
          String req = "insert into ordonnance (`Posologie`,`Qte`,`IdMed`) values (?,?,?);";
            PreparedStatement ps = cn.prepareStatement(req);
            
           System.out.println(jTextArea1.getText());
           System.out.println(Integer.parseInt(jTextField7.getText()));
            
            ps.setString(1,jTextArea1.getText());
           ps.setInt(2,Integer.parseInt(jTextField7.getText()));
            ps.setInt(3,1);
            
            int res = ps.executeUpdate();

            if(res != 0){
               //String var = "";
               String var =  " " + jTextField4.getText() + "   " +Integer.parseInt(jTextField7.getText()) + " boites(s)";
            jTextField6.setText(var);
            jTextField6.append("\n");
            System.out.println("Une nouvelle ligne ordonnance est ajoutée !");
            
            updateList();
            }
         

        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
         }
		}
          
           if(o == jButton4)
		{
                    
		jTextField6.setText("");
		}
            if(o == jButton1)
		{
                    
		System.out.println("\r\n");
		}
           
           
                
    }
    public void updateList(){
        
         Connection cn = Connexion.getConnection();
         if (cn != null) {
        try {
          
            String req = "select * from medicament;";
            PreparedStatement ps = cn.prepareStatement(req);
            ResultSet res = ps.executeQuery();
            //jList1.setModel(DbUtils.resultSetToTableModel(res));
            
            while(res.next()){
            String IdMed = res.getString("IdMed");
            String NomMed = res.getString("NomMed");
           
            System.out.println("id med est: " + IdMed + " & nom med est: " + NomMed );
            
            
            medicamentModel.addElement(NomMed);
            
            }
            

        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
         }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        if(e.getSource() == jList1)
		{
                    //System.out.println("aa");
			String selectedItem = jList1.getSelectedValue().toString();
			jTextField4.setText(selectedItem);
                        System.out.println(selectedItem);
		}
    }

    @Override
    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

                                       

    public static void main(String args[]) {
       
       EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MedicamentPharmacieIHM().setVisible(true);
            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
         
    }
    
    

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
           // System.out.println(jTextField5.getText());
        Connection connexion = Connexion.getConnection();
				
		if(connexion != null)
		{
			String query = "select * from medicament where NomMed = ?;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
						
				ps.setString(1, jTextField5.getText());
						
				ResultSet res = ps.executeQuery();				
				if (res.next()) {
					//m = new Medicament(res.getInt(1),res.getString(2));
                                        medicamentModel.removeAllElements();
                                        medicamentModel.addElement(jTextField5.getText());
				}else
				{
					System.out.println("Impossible de trouver le medicament!");
				}
						
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
                
                }}
        if (e.getKeyCode()==KeyEvent.VK_SPACE){
            medicamentModel.removeAllElements();
            updateList();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

                   
}
