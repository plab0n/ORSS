/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RU;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JLabel;
import org.json.JSONObject;

/**
 *
 * @author rahma
 */
public class PaymentFrame extends javax.swing.JFrame {

    /**
     * Creates new form PaymentFrame
     */
    private String uname;
    public PaymentFrame() {
        try {
            initComponents();
            this.uname = login.uName;
            //this.uname = "petr";
            setResizable(false);
            Socket s = new Socket(login.ip, 10003);
            OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            JSONObject ob = new JSONObject();
            ob.put("name", uname);
            ob.put("who", "RU");
            ob.toString();
            out.println(ob);
            os.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String row = br.readLine();
            System.out.println("DataPaisi");
            System.out.println(row);
            String data = "";
            for(int ch=0; ch<row.length(); ch++){
                if(row.charAt(ch)=='[' || row.charAt(ch)==']'){
                    continue;
                }
                if(row.charAt(ch)==' '){
                    if(ch-1>=0 && row.charAt(ch-1)==',')
                        continue;
                }
                if(row.charAt(ch)==',' && ch+1<row.length() && row.charAt(ch+2)=='{')
                    continue;
                data += row.charAt(ch);
            }
            System.out.println(data);
            List<String> myList = new ArrayList<String>(Arrays.asList(data.split("}")));
            int a=25,b=60,c=500,d=20;
            for(String val : myList){
                val += "}";
                JSONObject ob2 = new JSONObject(val);
                JLabel lbl= new JLabel(ob2.getString("timeDate"));
                JLabel lbl2 = new JLabel("Transfered " + ob2.getString("amm") +"BDT to " + ob2.getString("pName") + "s account");
                lbl.setBounds(a, b, c, d);
                b += d;
                b += 5;
                lbl2.setBounds(a,b,c,d);
                lbl.setForeground(Color.red);
                lbl2.setForeground(Color.red);
                lbl.setFont(new Font("Times New Roman", Font.BOLD, 14));
                jPanel4.add(lbl);
                jPanel4.add(lbl2);
                b += d;
                b += 20;
                
            }
        } catch (IOException ex) {
            Logger.getLogger(PaymentFrame.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        RUSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        RUProfile = new javax.swing.JLabel();
        RUOR = new javax.swing.JLabel();
        RUAL = new javax.swing.JLabel();
        RUPH = new javax.swing.JLabel();
        menu = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RUSearch)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RUSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(23, Short.MAX_VALUE))
        );

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

        menu.setBackground(new java.awt.Color(0, 102, 51));
        menu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        menu.setForeground(new java.awt.Color(255, 255, 255));
        menu.setText("Return To Menu");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
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
                    .addComponent(RUProfile)
                    .addComponent(menu))
                .addContainerGap(44, Short.MAX_VALUE))
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
                .addGap(73, 73, 73)
                .addComponent(menu)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Payment History:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
        OnlineResFrame or=new OnlineResFrame();
        or.setVisible(true);
        or.setLocationRelativeTo(null);
        or.pack();
        this.dispose();
    }//GEN-LAST:event_RUORMouseClicked

    private void RUALMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RUALMouseClicked
        // TODO add your handling code here:
        ActivityFrame af=new ActivityFrame();
        af.setVisible(true);
        af.setLocationRelativeTo(null);
        af.pack();
        this.dispose();

    }//GEN-LAST:event_RUALMouseClicked

    private void RUPHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RUPHMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_RUPHMouseClicked

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
            java.util.logging.Logger.getLogger(PaymentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RUAL;
    private javax.swing.JLabel RUOR;
    private javax.swing.JLabel RUPH;
    private javax.swing.JLabel RUProfile;
    private javax.swing.JButton RUSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton menu;
    // End of variables declaration//GEN-END:variables
}
