/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class ExamPage extends javax.swing.JFrame {

    String userName;
    Client c;
    int counter,noOfQues,max; //represents the page number of our questions
    String IP,subject;
    int ar[];
    
    
    /**
     * Creates new form ExamPage
     */
    void checkAnswers(int page)
    {
        String str=null,ans=null;
        if(buttonGroup1.getSelection()!=null)
        {
            str=buttonGroup1.getSelection().getActionCommand();
            ans=c.ob_ans.get((page-1)*4+0);
            if(str.equals(ans)) ar[(page-1)*4+0]=1;
        }
        if(buttonGroup2.getSelection()!=null)
        {
            str=buttonGroup2.getSelection().getActionCommand();
            ans=c.ob_ans.get((page-1)*4+1);
            if(str.equals(ans)) ar[(page-1)*4+1]=1;
        }
        if(buttonGroup3.getSelection()!=null)
        {
            str=buttonGroup3.getSelection().getActionCommand();
            ans=c.ob_ans.get((page-1)*4+2);
            if(str.equals(ans)) ar[(page-1)*4+2]=1;
        }
        if(buttonGroup4.getSelection()!=null)
        {
            str=buttonGroup4.getSelection().getActionCommand();
            ans=c.ob_ans.get((page-1)*4+3);
            if(str.equals(ans)) ar[(page-1)*4+3]=1;
        } 
        
    }
    void showContent(int PageNumber)
    {

        //clearing the selections from the other pages
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        buttonGroup3.clearSelection();
        buttonGroup4.clearSelection();

        
        String line="";
        for(int i=0;i<4;i++)
        {
            if( (((PageNumber-1)*4)+i)>(noOfQues-1) ) break;
            line=c.ob.get(  ((PageNumber-1)*4)+i  );
            System.out.println(line);
            String parts[]=line.split("[.]");
            if(i%4==0)
            {
                jLabel2.setText(parts[0]);
                jRadioButton1.setText(parts[1]);
                jRadioButton2.setText(parts[2]);
                jRadioButton3.setText(parts[3]);
                jRadioButton4.setText(parts[4]);
                jRadioButton1.setActionCommand(parts[1]);
                jRadioButton2.setActionCommand(parts[2]);
                jRadioButton3.setActionCommand(parts[3]);
                jRadioButton4.setActionCommand(parts[4]);
                jLabel2.setVisible(true);
                jRadioButton1.setVisible(true);
                jRadioButton2.setVisible(true);
                jRadioButton3.setVisible(true);
                jRadioButton4.setVisible(true);
            }
            else if(i%4==1)
            {
                jLabel3.setText(parts[0]);
                jRadioButton5.setText(parts[1]);
                jRadioButton6.setText(parts[2]);
                jRadioButton7.setText(parts[3]);
                jRadioButton8.setText(parts[4]);
                jRadioButton5.setActionCommand(parts[1]);
                jRadioButton6.setActionCommand(parts[2]);
                jRadioButton7.setActionCommand(parts[3]);
                jRadioButton8.setActionCommand(parts[4]);
                jLabel3.setVisible(true);
                jRadioButton5.setVisible(true);
                jRadioButton6.setVisible(true);
                jRadioButton7.setVisible(true);
                jRadioButton8.setVisible(true);
            }
            else if(i%4==2)
            {
                jLabel4.setText(parts[0]);
                jRadioButton9.setText(parts[1]);
                jRadioButton10.setText(parts[2]);
                jRadioButton11.setText(parts[3]);
                jRadioButton12.setText(parts[4]);
                jRadioButton9.setActionCommand(parts[1]);
                jRadioButton10.setActionCommand(parts[2]);
                jRadioButton11.setActionCommand(parts[3]);
                jRadioButton12.setActionCommand(parts[4]);
                jLabel4.setVisible(true);
                jRadioButton9.setVisible(true);
                jRadioButton10.setVisible(true);
                jRadioButton11.setVisible(true);
                jRadioButton12.setVisible(true);
            }
            else if(i%4==3)
            {
                jLabel5.setText(parts[0]);
                jRadioButton13.setText(parts[1]);
                jRadioButton14.setText(parts[2]);
                jRadioButton15.setText(parts[3]);
                jRadioButton16.setText(parts[4]);
                jRadioButton13.setActionCommand(parts[1]);
                jRadioButton14.setActionCommand(parts[2]);
                jRadioButton15.setActionCommand(parts[3]);
                jRadioButton16.setActionCommand(parts[4]);
                jLabel5.setVisible(true);
                jRadioButton13.setVisible(true);
                jRadioButton14.setVisible(true);
                jRadioButton15.setVisible(true);
                jRadioButton16.setVisible(true);
            }
        }
    }
    
    public ExamPage(String ip,String sub,String usrnem) 
    {
        userName=usrnem;
        IP=ip;
        subject=sub;
        System.out.println("SUBJECT FROM EXAMPAGE CONSTRUCTOR:" + subject);
        counter=0;
        ar=new int[50];
        Arrays.fill(ar, 0);
        //
                try {
            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("bk3.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
                //
        initComponents();
        jLabel6.setText(subject);
        jButton1.setVisible(false);
        jLabel2.setVisible(false);
        jRadioButton1.setVisible(false);
        jRadioButton2.setVisible(false);
        jRadioButton3.setVisible(false);
        jRadioButton4.setVisible(false);
        jLabel3.setVisible(false);
        jRadioButton5.setVisible(false);
        jRadioButton6.setVisible(false);
        jRadioButton7.setVisible(false);
        jRadioButton8.setVisible(false);
        jLabel4.setVisible(false);
        jRadioButton9.setVisible(false);
        jRadioButton10.setVisible(false);
        jRadioButton11.setVisible(false);
        jRadioButton12.setVisible(false);
        jLabel5.setVisible(false);
        jRadioButton13.setVisible(false);
        jRadioButton14.setVisible(false);
        jRadioButton15.setVisible(false);
        jRadioButton16.setVisible(false);
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
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jRadioButton15 = new javax.swing.JRadioButton();
        jRadioButton16 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Exam Page");
        setSize(new java.awt.Dimension(750, 500));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Welcome to the Exam Session on");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("jLabel2");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton1.setText("jRadioButton1");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton2.setText("jRadioButton2");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton3.setText("jRadioButton3");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton4.setText("jRadioButton4");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("jLabel3");

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton5.setText("jRadioButton5");

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton6.setText("jRadioButton6");

        buttonGroup2.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton7.setText("jRadioButton7");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton8);
        jRadioButton8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton8.setText("jRadioButton8");

        buttonGroup3.add(jRadioButton9);
        jRadioButton9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton9.setText("jRadioButton9");

        buttonGroup3.add(jRadioButton10);
        jRadioButton10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton10.setText("jRadioButton10");

        buttonGroup3.add(jRadioButton11);
        jRadioButton11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton11.setText("jRadioButton11");

        buttonGroup3.add(jRadioButton12);
        jRadioButton12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton12.setText("jRadioButton12");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("jLabel4");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup4.add(jRadioButton15);
        jRadioButton15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton15.setText("jRadioButton15");

        buttonGroup4.add(jRadioButton16);
        jRadioButton16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton16.setText("jRadioButton16");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("jLabel5");

        buttonGroup4.add(jRadioButton13);
        jRadioButton13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton13.setText("jRadioButton13");
        jRadioButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton13ActionPerformed(evt);
            }
        });

        buttonGroup4.add(jRadioButton14);
        jRadioButton14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton14.setText("jRadioButton14");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Start");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton4))
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton6)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton7)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton8))
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton9)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton10)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton11)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton12))
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton13)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton14)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton15)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton16))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(250, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton8))
                .addGap(26, 26, 26)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton9)
                    .addComponent(jRadioButton10)
                    .addComponent(jRadioButton11)
                    .addComponent(jRadioButton12))
                .addGap(28, 28, 28)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton13)
                    .addComponent(jRadioButton14)
                    .addComponent(jRadioButton15)
                    .addComponent(jRadioButton16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton13ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // When Start pressed
        jButton2.setVisible(false);
        c=new Client(IP,subject);
        System.out.println("coming this far");
        try {
            c.connection();
        } catch (IOException ex) {
            Logger.getLogger(ExamPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        noOfQues=c.numberOfElements;
        System.out.println(c.ob.size());
        double testIfMaxNeedsPlusOne = (double)noOfQues / 4;  //for 5-7 questions need 2 page
        int z=noOfQues/4;
        if( (testIfMaxNeedsPlusOne-z) >0 ) max=z+1;
        else max=z; 
        System.out.println(" MAX :" + max);
        jButton1.doClick();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // when submit pressed calculate current page and display next
        jButton1.setVisible(true);
        if(counter>0) checkAnswers(counter);
        counter++;
        if(counter==max+1)
        {
            int marks=0;
            for(int i=0;i<50;i++)
            {
                marks+=ar[i];
            }
            //jLabel7.setText("You have scored: "+marks+" out of "+ob.size());
            //jLabel7.setVisible(true);

            ShowMarks temp=new ShowMarks(marks,c.ob.size(),userName,IP); //could also send string i.e jTextField2.getText();
            temp.setLocationRelativeTo(null);
            temp.setVisible(true);
            this.dispose();
        }
        
        if(counter==max)
        {
            jLabel2.setVisible(false);
            jRadioButton1.setVisible(false);
            jRadioButton2.setVisible(false);
            jRadioButton3.setVisible(false);
            jRadioButton4.setVisible(false);
            jLabel3.setVisible(false);
            jRadioButton5.setVisible(false);
            jRadioButton6.setVisible(false);
            jRadioButton7.setVisible(false);
            jRadioButton8.setVisible(false);
            jLabel4.setVisible(false);
            jRadioButton9.setVisible(false);
            jRadioButton10.setVisible(false);
            jRadioButton11.setVisible(false);
            jRadioButton12.setVisible(false);
            jLabel5.setVisible(false);
            jRadioButton13.setVisible(false);
            jRadioButton14.setVisible(false);
            jRadioButton15.setVisible(false);
            jRadioButton16.setVisible(false);
        }
        showContent(counter);
        
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
            java.util.logging.Logger.getLogger(ExamPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExamPage("","","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    // End of variables declaration//GEN-END:variables
}
