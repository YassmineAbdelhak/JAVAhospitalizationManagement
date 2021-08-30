
package IHM;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import IHM.MenuBar;
import IHM.menuBarDoc;


public class ConnexionIHM extends JFrame {

    public ConnexionIHM() {
        initComponents();
    }
    
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel Connexion;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTextField User;
    private JPasswordField pwd;

                             
    private void initComponents() {

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jLabel2 = new JLabel();
        jLabel1 = new JLabel();
        Connexion = new JLabel();
        User = new JTextField();
        pwd = new JPasswordField();
        jLabel5 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Connexion");

        jPanel2.setBackground(new Color(255, 255, 255));

        jLabel2.setFont(new Font("Segoe UI", 0, 24)); 
        jLabel2.setForeground(new Color(70, 70, 70));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("Cabinet Medical");
        jLabel2.setAlignmentX(6.0F);

        jLabel1.setForeground(new Color(70, 70, 70));
        jLabel1.setText("Mot de passe oublié?");

        Connexion.setHorizontalAlignment(SwingConstants.CENTER);
        Connexion.setIcon(new ImageIcon(getClass().getResource("/Images/Groupe 6.png"))); // NOI18N

        User.setForeground(new Color(102, 102, 102));
        User.setHorizontalAlignment(JTextField.CENTER);
        User.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
            }
            public void focusGained(FocusEvent e) {
                if(User.getText().equals("Utilisateur...")){
                    User.setText("");
                    } 
            }
            public void focusLost(FocusEvent e) {
                if(User.getText().equals("")){
                    User.setText("Utilisateur...");
                }
            }
        });
        
        User.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        pwd.setForeground(new Color(102, 102, 102));
        pwd.setHorizontalAlignment(JTextField.CENTER);
        pwd.addFocusListener(new FocusListener() {
            public void actionPerformed(ActionEvent evt) {
            }
            public void focusGained(FocusEvent e) {
                if(pwd.getText().equals("Mot de Passe...")){
                    pwd.setText("");
                    } 
            }
            public void focusLost(FocusEvent e) {
                if(pwd.getText().equals("")){
                    pwd.setText("Mot de Passe...");
                }
            }
        });
        pwd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        
         Connexion.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (User.getText().equals("secretaire") && (pwd.getText().equals("secretaire"))){
                    MenuBar m= new MenuBar();
                    m.setVisible(true);
                    setVisible(false);
                }
                else if (User.getText().equals("medecin") && (pwd.getText().equals("medecin"))){
                    menuBarDoc n= new menuBarDoc();
                    n.setVisible(true);
                    setVisible(false);
                    
                }
                
            }
 
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(144, 144, 144))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(Connexion, GroupLayout.Alignment.LEADING,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(User,GroupLayout.PREFERRED_SIZE, 219,GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(106, Short.MAX_VALUE)
                    .addComponent(pwd,GroupLayout.PREFERRED_SIZE, 219,GroupLayout.PREFERRED_SIZE)
                    .addGap(75, 75, 75)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel2,GroupLayout.PREFERRED_SIZE, 43,GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(User,GroupLayout.PREFERRED_SIZE, 35,GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(Connexion,GroupLayout.PREFERRED_SIZE, 91,GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(237, Short.MAX_VALUE)
                    .addComponent(pwd,GroupLayout.PREFERRED_SIZE, 35,GroupLayout.PREFERRED_SIZE)
                    .addGap(191, 191, 191)))
        );

        jLabel5.setIcon(new ImageIcon(getClass().getResource("/Images/undraw_medicine_b1ol.png"))); 

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5,GroupLayout.PREFERRED_SIZE, 404, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }                       

    private void jTextField6ActionPerformed(ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jTextField7ActionPerformed(ActionEvent evt) {                                            
        
    }                                           

   
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConnexionIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnexionIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnexionIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnexionIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
       EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnexionIHM().setVisible(true);
            }
        });
    }
                  
 
                      
}
