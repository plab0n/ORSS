/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RU;

/**
 *
 * @author rahma
 */
import client.ui.ClientFrame;
import client.ui.MainPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import org.json.JSONObject;
public class OnlineResFrame extends javax.swing.JFrame {

    /**
     * Creates new form OnlineResFrame
     */
    public OnlineResFrame() {
        try {
            initComponents();
            setResizable(false);
            
            Socket s = new Socket(login.ip, 10001);
            OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            out.println("Kichu Pathabo Na");
            os.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String row = br.readLine();
            System.out.println("DataPaisi");
            
            System.out.println(row);
            String data = "";
            for(int ch=0; ch<row.length(); ch++){
                if(row.charAt(ch)==' ' || row.charAt(ch)=='[' || row.charAt(ch)==']'){
                    continue;
                }
                if(row.charAt(ch)==',' && ch+1<row.length() && row.charAt(ch+2)=='{')
                    continue;
                data += row.charAt(ch);
            }
            System.out.println(data);
            List<String> myList = new ArrayList<String>(Arrays.asList(data.split("}")));
            
            System.out.println(myList);
            // int ar[]=new int[6];
            // int ar1[]=new int[6];
            String name[]=new String[6];
            // name[0]="Machine Learning";
           
            int a=150,b=120,c=200,d=150;
            int x=a;
            JButton[] jb = new JButton[100];
            int cnt = 0;
            for(String val : myList){
                val += "}";
                System.out.println(val);
                JSONObject obj = new JSONObject(val);
          
                jb[cnt] = new JButton(obj.getString("title"));
                jb[cnt].setBounds(a, b, c,d);
                jb[cnt].setFont(new Font("Times New Roman", Font.BOLD, 18));
                jb[cnt].addActionListener(new MyListener(obj));
                jPanel4.add(jb[cnt]);
                ++cnt;
                if(cnt%3==0){
                    b += d;
                    a = x;
                }
                else{
                    a += c;
                }
             
                
            }

//        JButton jb=new JButton("Machine Learning");
//        jb.setBounds(150, 120, 200, 150);
//        jb.setBackground(Color.gray);
//        jb.setForeground(Color.BLACK);
//        jb.setFont(new Font("Times New Roman", Font.BOLD, 18));
//        jPanel4.add(jb);
//        JButton jb1=new JButton("Online Judge");
//        jb1.setBounds(400,120,200,150);
//       // jb1.setBounds(100, 120, 200, 150);
//        jb1.setBackground(Color.gray);
//        jb1.setForeground(Color.BLACK);
//        jb1.setFont(new Font("Times New Roman", Font.BOLD, 18));
//        jPanel4.add(jb1);
//        JButton jb2=new JButton("GitHub");
//        jb2.setBounds(650,120,200,150);
//       // jb1.setBounds(100, 120, 200, 150);
//        jb2.setBackground(Color.gray);
//        jb2.setForeground(Color.BLACK);
//        jb2.setFont(new Font("Times New Roman", Font.BOLD, 18));
//        jPanel4.add(jb2);
//        JButton jb3=new JButton("Stack OverFlow");
//        jb3.setBounds(150,320,200,150);
//       // jb1.setBounds(100, 120, 200, 150);
//        jb3.setBackground(Color.gray);
//        jb3.setForeground(Color.BLACK);
//        jb3.setFont(new Font("Times New Roman", Font.BOLD, 18));
//        jPanel4.add(jb3);
//        JButton jb4=new JButton("Quora");
//        jb4.setBounds(400,320,200,150);
//       // jb1.setBounds(100, 120, 200, 150);
//        jb4.setBackground(Color.gray);
//        jb4.setForeground(Color.BLACK);
//        jb4.setFont(new Font("Times New Roman", Font.BOLD, 18));
//        jPanel4.add(jb4);
//        JButton jb5=new JButton("Blah");
//        jb5.setBounds(650,320,200,150);
//       // jb1.setBounds(100, 120, 200, 150);
//        jb5.setBackground(Color.gray);
//        jb5.setForeground(Color.BLACK);
//        jb5.setFont(new Font("Times New Roman", Font.BOLD, 18));
//        jPanel4.add(jb5);
//                
        } catch (IOException ex) {
            Logger.getLogger(OnlineResFrame.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        RUSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        RUProfile = new javax.swing.JLabel();
        RUOR = new javax.swing.JLabel();
        RUAL = new javax.swing.JLabel();
        RUPH = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        RUProfile1 = new javax.swing.JLabel();
        RUOR1 = new javax.swing.JLabel();
        RUAL1 = new javax.swing.JLabel();
        RUPH1 = new javax.swing.JLabel();
        menu = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Os = new javax.swing.JComboBox();
        CPU = new javax.swing.JLabel();
        cpu = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        ram = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        GraCard = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        RUSearch.setBackground(new java.awt.Color(0, 102, 51));
        RUSearch.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RUSearch.setForeground(new java.awt.Color(255, 255, 255));
        RUSearch.setText("Search");
        RUSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RUSearchMouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(153, 0, 153));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("Online Resource Sharing System");

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        RUProfile.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RUProfile.setForeground(new java.awt.Color(255, 255, 255));
        RUProfile.setText("Profile");
        RUProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RUProfileMouseClicked(evt);
            }
        });

        RUOR.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RUOR.setForeground(new java.awt.Color(255, 255, 255));
        RUOR.setText("Online Resources");
        RUOR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RUORMouseClicked(evt);
            }
        });

        RUAL.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RUAL.setForeground(new java.awt.Color(255, 255, 255));
        RUAL.setText("Activity Log");
        RUAL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RUALMouseClicked(evt);
            }
        });

        RUPH.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RUPH.setForeground(new java.awt.Color(255, 255, 255));
        RUPH.setText("Payment History");
        RUPH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RUPHMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RUPH)
                    .addComponent(RUAL)
                    .addComponent(RUOR)
                    .addComponent(RUProfile))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(RUProfile)
                .addGap(26, 26, 26)
                .addComponent(RUOR)
                .addGap(28, 28, 28)
                .addComponent(RUAL)
                .addGap(33, 33, 33)
                .addComponent(RUPH)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RUSearch)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RUSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        RUProfile1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RUProfile1.setForeground(new java.awt.Color(255, 255, 255));
        RUProfile1.setText("Profile");
        RUProfile1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RUProfile1MouseClicked(evt);
            }
        });

        RUOR1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RUOR1.setForeground(new java.awt.Color(255, 255, 255));
        RUOR1.setText("Online Resources");
        RUOR1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RUOR1MouseClicked(evt);
            }
        });

        RUAL1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RUAL1.setForeground(new java.awt.Color(255, 255, 255));
        RUAL1.setText("Activity Log");
        RUAL1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RUAL1MouseClicked(evt);
            }
        });

        RUPH1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RUPH1.setForeground(new java.awt.Color(255, 255, 255));
        RUPH1.setText("Payment History");
        RUPH1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RUPH1MouseClicked(evt);
            }
        });

        menu.setBackground(new java.awt.Color(0, 102, 51));
        menu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        menu.setForeground(new java.awt.Color(255, 255, 255));
        menu.setText("Return To Menu");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RUPH1)
                            .addComponent(RUAL1)
                            .addComponent(RUOR1)
                            .addComponent(RUProfile1)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(menu)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(RUProfile1)
                .addGap(26, 26, 26)
                .addComponent(RUOR1)
                .addGap(28, 28, 28)
                .addComponent(RUAL1)
                .addGap(33, 33, 33)
                .addComponent(RUPH1)
                .addGap(87, 87, 87)
                .addComponent(menu)
                .addContainerGap(229, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setBackground(new java.awt.Color(0, 153, 51));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("OS: ");

        Os.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Windows", "Linux", "Mac Os" }));
        Os.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OsMouseClicked(evt);
            }
        });
        Os.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OsActionPerformed(evt);
            }
        });

        CPU.setBackground(new java.awt.Color(0, 102, 51));
        CPU.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        CPU.setForeground(new java.awt.Color(255, 255, 255));
        CPU.setText("CPU: ");

        cpu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Intel Core i3", "Intel Core i5", "Intel Core i7" }));
        cpu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpuActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("RAM: ");

        ram.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "512MB", "2GB", "4GB", "1TB", " " }));
        ram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ramActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Graphics Card:");

        GraCard.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Intel", "NVIDIA", "AMD", "GigaByte", " " }));
        GraCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraCardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Os, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(CPU)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GraCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Os, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CPU)
                    .addComponent(cpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(ram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(GraCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void RUSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RUSearchMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_RUSearchMouseClicked

    private void RUProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RUProfileMouseClicked
        // TODO add your handling code here:
        ProfileFrame pf=new ProfileFrame();
        pf.setVisible(true);
        pf.setLocationRelativeTo(null);
        pf.pack();
        this.dispose();
    }//GEN-LAST:event_RUProfileMouseClicked

    private void RUORMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RUORMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_RUORMouseClicked

    private void RUALMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RUALMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_RUALMouseClicked

    private void RUPHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RUPHMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_RUPHMouseClicked

    private void RUProfile1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RUProfile1MouseClicked
        // TODO add your handling code here:
        ProfileFrame pf=new ProfileFrame();
        pf.setVisible(true);
        pf.setLocationRelativeTo(null);
        pf.pack();
        this.dispose();
    }//GEN-LAST:event_RUProfile1MouseClicked

    private void RUOR1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RUOR1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_RUOR1MouseClicked

    private void RUAL1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RUAL1MouseClicked
        // TODO add your handling code here:
        ActivityFrame af=new ActivityFrame();
        af.setVisible(true);
        af.setLocationRelativeTo(null);
        af.pack();
        this.dispose();
    }//GEN-LAST:event_RUAL1MouseClicked

    private void RUPH1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RUPH1MouseClicked
        // TODO add your handling code here:
        PaymentFrame pf=new PaymentFrame();
        pf.setVisible(true);
        pf.setLocationRelativeTo(null);
        pf.pack();
        this.dispose();
        
    }//GEN-LAST:event_RUPH1MouseClicked

    private void OsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OsMouseClicked
        // TODO add your handling code here:
        String os=Os.getSelectedItem().toString();
        System.out.print(os);
    }//GEN-LAST:event_OsMouseClicked

    private void OsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OsActionPerformed
        // TODO add your handling code here:
        String os=Os.getSelectedItem().toString();
        
    }//GEN-LAST:event_OsActionPerformed

    private void cpuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpuActionPerformed
        // TODO add your handling code here:
        String cp=cpu.getSelectedItem().toString();
    }//GEN-LAST:event_cpuActionPerformed

    private void ramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ramActionPerformed
        // TODO add your handling code here:
        String rm=ram.getSelectedItem().toString();
    }//GEN-LAST:event_ramActionPerformed

    private void GraCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraCardActionPerformed
        // TODO add your handling code here:
        String gc=GraCard.getSelectedItem().toString();
    }//GEN-LAST:event_GraCardActionPerformed

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        // TODO add your handling code here:
        RUinterface in=new RUinterface();
        in.setVisible(true);
        in.setLocationRelativeTo(null);
        in.pack();
        this.dispose();
    }//GEN-LAST:event_menuActionPerformed

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
            java.util.logging.Logger.getLogger(OnlineResFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OnlineResFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OnlineResFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OnlineResFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OnlineResFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CPU;
    private javax.swing.JComboBox GraCard;
    private javax.swing.JComboBox Os;
    private javax.swing.JLabel RUAL;
    private javax.swing.JLabel RUAL1;
    private javax.swing.JLabel RUOR;
    private javax.swing.JLabel RUOR1;
    private javax.swing.JLabel RUPH;
    private javax.swing.JLabel RUPH1;
    private javax.swing.JLabel RUProfile;
    private javax.swing.JLabel RUProfile1;
    private javax.swing.JButton RUSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cpu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton menu;
    private javax.swing.JComboBox ram;
    // End of variables declaration//GEN-END:variables
}


class MyListener implements ActionListener {
      JSONObject obj = new JSONObject();
      MyListener(JSONObject o) {
         this.obj = o;
         System.out.println("ON ActionListener");
      }
      public void actionPerformed(ActionEvent e) {
                String user = "RU";
                System.out.println("On ActionEvent");
                //new MainPanel("192.168.16.108",9939, this, data, user)
                ClientFrame.load(this.obj, user, login.ip);
         }

       }











