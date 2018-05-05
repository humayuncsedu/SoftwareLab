/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
public class PracticePage extends javax.swing.JFrame {

    String userName,IP;
    int ar[]=new int[50]; //place to keep score of 50 questions
    private int counter,max;
    private String topic;
    ArrayList<String> ob_ans; //to store answers
    ArrayList<String> ob; //to store all questions
    /**
     * Creates new form PracticePage
     */
    public PracticePage() 
    {
        Arrays.fill(ar, 0);
        ob_ans=new ArrayList<String>();
        ob=new ArrayList<String>();
        counter=0;
        initComponents();
    }
    public PracticePage(String examTopic,String userNem,String ip)
    {
        IP=ip;
        userName=userNem;
        Arrays.fill(ar, 0);
        ob_ans=new ArrayList<String>();
        ob=new ArrayList<String>();
        counter=0;
        //
                try {
            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("bk3.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
                //
        initComponents();

        //setting all the fields that will hold question and options invisble. will become visible when start pressed

        jButton3.setVisible(false); // next and previous
        jButton2.setVisible(false); // buttons are not displayed until start pressed
        jButton4.setVisible(false); // submit button
        jLabel7.setVisible(false); // score
        
        jLabel3.setVisible(false);
        jRadioButton1.setVisible(false);
        jRadioButton2.setVisible(false);
        jRadioButton3.setVisible(false);
        jRadioButton4.setVisible(false);
        jLabel4.setVisible(false);
        jRadioButton5.setVisible(false);
        jRadioButton6.setVisible(false);
        jRadioButton7.setVisible(false);
        jRadioButton8.setVisible(false);
        jLabel5.setVisible(false);
        jRadioButton9.setVisible(false);
        jRadioButton10.setVisible(false);
        jRadioButton11.setVisible(false);
        jRadioButton12.setVisible(false);
        jLabel6.setVisible(false);
        jRadioButton13.setVisible(false);
        jRadioButton14.setVisible(false);
        jRadioButton15.setVisible(false);
        jRadioButton16.setVisible(false);
        
        
        //
        topic=examTopic;
        jLabel2.setText(topic);
    }
    void checkAnswers(int page)
    {
        String str=null,ans=null;
        if(buttonGroup1.getSelection()!=null)
        {
            str=buttonGroup1.getSelection().getActionCommand();
            ans=ob_ans.get((page-1)*4+0);
            if(str.equals(ans)) ar[(page-1)*4+0]=1;
        }
        if(buttonGroup2.getSelection()!=null)
        {
            str=buttonGroup2.getSelection().getActionCommand();
            ans=ob_ans.get((page-1)*4+1);
            if(str.equals(ans)) ar[(page-1)*4+1]=1;
        }
        if(buttonGroup3.getSelection()!=null)
        {
            str=buttonGroup3.getSelection().getActionCommand();
            ans=ob_ans.get((page-1)*4+2);
            if(str.equals(ans)) ar[(page-1)*4+2]=1;
        }
        if(buttonGroup4.getSelection()!=null)
        {
            str=buttonGroup4.getSelection().getActionCommand();
            ans=ob_ans.get((page-1)*4+3);
            if(str.equals(ans)) ar[(page-1)*4+3]=1;
        } 
        
    }
    void showContent(int PageNumber)
    {
        
        jButton3.setVisible(true); 
        jButton2.setVisible(true);
        
        //clearing the selections from the other pages
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        buttonGroup3.clearSelection();
        buttonGroup4.clearSelection();
        // setting the old marks of this page to 0 so that the new selections can be counted 
        ar[(PageNumber-1)*4 +0] =0;
        ar[(PageNumber-1)*4 +1] =0;
        ar[(PageNumber-1)*4 +2] =0;
        ar[(PageNumber-1)*4 +3] =0;
        
        
        
        String line="";
        for(int i=0;i<4;i++)
        {
            if( (((PageNumber-1)*4)+i)>(ob.size()-1) ) break;
            line=ob.get(  ((PageNumber-1)*4)+i  );
            System.out.println(line);
            String parts[]=line.split("[.]");
            if(i%4==0)
            {
                jLabel3.setText(parts[0]);
                jRadioButton1.setText(parts[1]);
                jRadioButton2.setText(parts[2]);
                jRadioButton3.setText(parts[3]);
                jRadioButton4.setText(parts[4]);
                jRadioButton1.setActionCommand(parts[1]);
                jRadioButton2.setActionCommand(parts[2]);
                jRadioButton3.setActionCommand(parts[3]);
                jRadioButton4.setActionCommand(parts[4]);
                jLabel3.setVisible(true);
                jRadioButton1.setVisible(true);
                jRadioButton2.setVisible(true);
                jRadioButton3.setVisible(true);
                jRadioButton4.setVisible(true);
            }
            else if(i%4==1)
            {
                jLabel4.setText(parts[0]);
                jRadioButton5.setText(parts[1]);
                jRadioButton6.setText(parts[2]);
                jRadioButton7.setText(parts[3]);
                jRadioButton8.setText(parts[4]);
                jRadioButton5.setActionCommand(parts[1]);
                jRadioButton6.setActionCommand(parts[2]);
                jRadioButton7.setActionCommand(parts[3]);
                jRadioButton8.setActionCommand(parts[4]);
                jLabel4.setVisible(true);
                jRadioButton5.setVisible(true);
                jRadioButton6.setVisible(true);
                jRadioButton7.setVisible(true);
                jRadioButton8.setVisible(true);
            }
            else if(i%4==2)
            {
                jLabel5.setText(parts[0]);
                jRadioButton9.setText(parts[1]);
                jRadioButton10.setText(parts[2]);
                jRadioButton11.setText(parts[3]);
                jRadioButton12.setText(parts[4]);
                jRadioButton9.setActionCommand(parts[1]);
                jRadioButton10.setActionCommand(parts[2]);
                jRadioButton11.setActionCommand(parts[3]);
                jRadioButton12.setActionCommand(parts[4]);
                jLabel5.setVisible(true);
                jRadioButton9.setVisible(true);
                jRadioButton10.setVisible(true);
                jRadioButton11.setVisible(true);
                jRadioButton12.setVisible(true);
            }
            else if(i%4==3)
            {
                jLabel6.setText(parts[0]);
                jRadioButton13.setText(parts[1]);
                jRadioButton14.setText(parts[2]);
                jRadioButton15.setText(parts[3]);
                jRadioButton16.setText(parts[4]);
                jRadioButton13.setActionCommand(parts[1]);
                jRadioButton14.setActionCommand(parts[2]);
                jRadioButton15.setActionCommand(parts[3]);
                jRadioButton16.setActionCommand(parts[4]);
                jLabel6.setVisible(true);
                jRadioButton13.setVisible(true);
                jRadioButton14.setVisible(true);
                jRadioButton15.setVisible(true);
                jRadioButton16.setVisible(true);
            }
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
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jRadioButton15 = new javax.swing.JRadioButton();
        jRadioButton16 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setSize(new java.awt.Dimension(750, 500));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Welcome to the practice session on");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("jLabel2");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("jLabel3");

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("jLabel4");

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton5.setText("jRadioButton5");

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton6.setText("jRadioButton6");

        buttonGroup2.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton7.setText("jRadioButton7");

        buttonGroup2.add(jRadioButton8);
        jRadioButton8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton8.setText("jRadioButton8");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("jLabel5");

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

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("jLabel6");

        buttonGroup4.add(jRadioButton13);
        jRadioButton13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton13.setText("jRadioButton13");

        buttonGroup4.add(jRadioButton14);
        jRadioButton14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton14.setText("jRadioButton14");

        buttonGroup4.add(jRadioButton15);
        jRadioButton15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton15.setText("jRadioButton15");

        buttonGroup4.add(jRadioButton16);
        jRadioButton16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton16.setText("jRadioButton16");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Previous");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("SUBMIT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(195, 195, 195))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton9)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton10)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton11)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton12))
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton8))
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton13)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton14)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton15)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton8))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton9)
                    .addComponent(jRadioButton10)
                    .addComponent(jRadioButton11)
                    .addComponent(jRadioButton12))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton13)
                    .addComponent(jRadioButton14)
                    .addComponent(jRadioButton15)
                    .addComponent(jRadioButton16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //need to add a timer when start pressed
        jButton1.setVisible(false);
           
        //going to copy all questions from the text file into arraylist first
        try
        {
            String line = "";
            
            //copying questions
            File question = new File(topic+".txt");
            BufferedReader b = new BufferedReader(new FileReader(question));
            while (true) 
            {   
                line = b.readLine();
                if(line==null) 
                {
                    break;
                }
                ob.add(line);

            }
            
            //copying answers
            File answer = new File(topic+"-ans.txt");
            BufferedReader c = new BufferedReader(new FileReader(answer));
            while (true) 
            {   
                line = c.readLine();
                if(line==null) 
                {
                    break;
                }
                ob_ans.add(line);

            }
            
            //finding how many pages are going to be needed to display all the questions; 4 question per page        
            double testIfMaxNeedsPlusOne = (double)ob.size() / 4;  //for 5-7 questions need 2 page
            int z=ob.size()/4;
            if( (testIfMaxNeedsPlusOne-z) >0 ) max=z+1;
            else max=z; 
            counter=0;
                
            jButton3.setVisible(true); // next and previous shown
            jButton2.setVisible(true); // after pressing start
            jButton2.doClick();

            }
            catch (FileNotFoundException ex) 
            {
                Logger.getLogger(PracticePage.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(PracticePage.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
        
          
       /* 
        try 
        {
            File question = new File(topic+".txt");
            BufferedReader b = new BufferedReader(new FileReader(question));
         
            int i=0;
            String line = "";
            System.out.println("Reading file using Buffered Reader");
            while (true) 
            {   
                i++;
                line = b.readLine();
                if(line==null) 
                {
                    //throw new LoginNotFound();
                    break;
                }
                String parts[]=line.split("[.]");
                System.out.println(parts[0]+" "+parts[1]);
                if(i%4==1)
                {
                    jLabel3.setText(parts[0]);
                    jRadioButton1.setText(parts[1]);
                    jRadioButton2.setText(parts[2]);
                    jRadioButton3.setText(parts[3]);
                    jRadioButton4.setText(parts[4]);
                    jLabel3.setVisible(true);
                    jRadioButton1.setVisible(true);
                    jRadioButton2.setVisible(true);
                    jRadioButton3.setVisible(true);
                    jRadioButton4.setVisible(true);
                }
                else if(i%4==2)
                {
                    jLabel4.setText(parts[0]);
                    jRadioButton5.setText(parts[1]);
                    jRadioButton6.setText(parts[2]);
                    jRadioButton7.setText(parts[3]);
                    jRadioButton8.setText(parts[4]);
                    jLabel4.setVisible(true);
                    jRadioButton5.setVisible(true);
                    jRadioButton6.setVisible(true);
                    jRadioButton7.setVisible(true);
                    jRadioButton8.setVisible(true);
                }
                else if(i%4==3)
                {
                    jLabel5.setText(parts[0]);
                    jRadioButton9.setText(parts[1]);
                    jRadioButton10.setText(parts[2]);
                    jRadioButton11.setText(parts[3]);
                    jRadioButton12.setText(parts[4]);
                    jLabel5.setVisible(true);
                    jRadioButton9.setVisible(true);
                    jRadioButton10.setVisible(true);
                    jRadioButton11.setVisible(true);
                    jRadioButton12.setVisible(true);
                }
                else if(i%4==0)
                {
                    jLabel6.setText(parts[0]);
                    jRadioButton13.setText(parts[1]);
                    jRadioButton14.setText(parts[2]);
                    jRadioButton15.setText(parts[3]);
                    jRadioButton16.setText(parts[4]);
                    jLabel6.setVisible(true);
                    jRadioButton13.setVisible(true);
                    jRadioButton14.setVisible(true);
                    jRadioButton15.setVisible(true);
                    jRadioButton16.setVisible(true);
                }
                //need to code for more than 4 questions,new page or same page?
                //if all question answered then check and make i=0
                
            }
        
        }
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(PracticePage.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(PracticePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // if previous pressed
        checkAnswers(counter);  //checking this page
        counter--;              // and then moving to the previous page and displaying them
        showContent(counter);
        
        if(counter==max)
        {
            jButton2.setVisible(false);
        }
        if(counter==1)
        {
            jButton3.setVisible(false);
            return;
        }
        
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // if next pressed
        if(counter>0) checkAnswers(counter);    //checking this page 
        counter++;                              // and then moving to the next page and displaying them
        if(counter==max)
        {
            jLabel3.setVisible(false);
            jRadioButton1.setVisible(false);
            jRadioButton2.setVisible(false);
            jRadioButton3.setVisible(false);
            jRadioButton4.setVisible(false);
            jLabel4.setVisible(false);
            jRadioButton5.setVisible(false);
            jRadioButton6.setVisible(false);
            jRadioButton7.setVisible(false);
            jRadioButton8.setVisible(false);
            jLabel5.setVisible(false);
            jRadioButton9.setVisible(false);
            jRadioButton10.setVisible(false);
            jRadioButton11.setVisible(false);
            jRadioButton12.setVisible(false);
            jLabel6.setVisible(false);
            jRadioButton13.setVisible(false);
            jRadioButton14.setVisible(false);
            jRadioButton15.setVisible(false);
            jRadioButton16.setVisible(false);
        }
        showContent(counter);
        if(counter==1)
        {
            jButton3.setVisible(false);
        }
        if(counter==max)
        {
            jButton2.setVisible(false);
            jButton4.setVisible(true);
            return;
        }
        

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // if submit pressed
        checkAnswers(counter);
        int marks=0;
        for(int i=0;i<50;i++)
        {
            marks+=ar[i];
        }
        //jLabel7.setText("You have scored: "+marks+" out of "+ob.size());
        //jLabel7.setVisible(true);
        
        ShowMarks temp=new ShowMarks(marks,ob.size(),userName,IP); //could also send string i.e jTextField2.getText();
        temp.setLocationRelativeTo(null);
        temp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(PracticePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PracticePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PracticePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PracticePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PracticePage().setVisible(true);
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
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
