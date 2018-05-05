package project1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static project1.LocalServer.subject;

//testing if networking works. works same as practice but uses localhost for all retrieval of questions and answers
class ClientSocketThread extends Thread {
    final Socket clientSocket;

    ClientSocketThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        DataInputStream din = null;
        DataOutputStream dout = null;
        try {
            din=new DataInputStream(clientSocket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClientSocketThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            dout=new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClientSocketThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            //recieving subject name
            subject=din.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(ClientSocketThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(subject);
        try {
            dout.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientSocketThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //finding and storing questions and answers for subject
        ArrayList<String> ob_ans=new ArrayList<String>();   //to store answers
        ArrayList<String> ob=new ArrayList<String>();       //to store all questions
        try
        {
            String line = "";
            
            //copying questions
            File question = new File(subject+".txt");
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
            File answer = new File(subject+"-ans.txt");
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
            
        }
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(PracticePage.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(PracticePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            //sned how many questions going to come
            dout.writeUTF( String.valueOf(ob.size()) );
        } catch (IOException ex) {
            Logger.getLogger(ClientSocketThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        //sending all the questions and answers to client on tht subject
        for(int i=0;i<ob.size();i++)
        {
            try {
                dout.writeUTF(ob.get(i));
            } catch (IOException ex) {
                Logger.getLogger(ClientSocketThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                dout.flush();
            } catch (IOException ex) {
                Logger.getLogger(ClientSocketThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                dout.writeUTF(ob_ans.get(i));
            } catch (IOException ex) {
                Logger.getLogger(ClientSocketThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                dout.flush();
            } catch (IOException ex) {
                Logger.getLogger(ClientSocketThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

public class LocalServer 
{
    static String subject;
    static ServerSocket ss;
    /*
    static void startServerSocketAgain() throws IOException
    {
        ss=new ServerSocket(4495);
    }
    */
    public static void main(String args[]) throws IOException
    {
        
        
        Socket s;
        
        ss = new ServerSocket(4495);
        //startServerSocketAgain();
        
        try {
    while (true) { 
        s=ss.accept();

        Thread t = new ClientSocketThread(s);
        t.start();
    }
} finally {
    ss.close();
}
        
        
        
        
        
        
    }
}



/*
package project1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocalServer 
{
    static String subject;
    static ServerSocket ss;
    
    //static void startServerSocketAgain() throws IOException
    //{
    //    ss=new ServerSocket(4495);
    //}
    //
    public static void main(String args[]) throws IOException
    {
        
        Socket s;
        DataInputStream din;
        DataOutputStream dout;
        ss = new ServerSocket(4495);
        //startServerSocketAgain();
        s=ss.accept();
        din=new DataInputStream(s.getInputStream());
        dout=new DataOutputStream(s.getOutputStream());
        
        //recieving subject name
        subject=din.readUTF();
        System.out.println(subject);
        dout.flush();
        
        //finding and storing questions and answers for subject
        ArrayList<String> ob_ans=new ArrayList<String>();   //to store answers
        ArrayList<String> ob=new ArrayList<String>();       //to store all questions
        try
        {
            String line = "";
            
            //copying questions
            File question = new File(subject+".txt");
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
            File answer = new File(subject+"-ans.txt");
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
            
        }
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(PracticePage.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(PracticePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //sned how many questions going to come
        dout.writeUTF( String.valueOf(ob.size()) );
        //sending all the questions and answers to client on tht subject
        for(int i=0;i<ob.size();i++)
        {
            dout.writeUTF(ob.get(i));
            dout.flush();
            dout.writeUTF(ob_ans.get(i));
            dout.flush();
        }
        
        
        
        
    }
}

*/