package project1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client 
{
    ArrayList<String> ob_ans=new ArrayList<String>();   //to store answers
    ArrayList<String> ob=new ArrayList<String>();       //to store all questions
    String IP,subject;
    int numberOfElements;
    static int returningAgain=0;
    //static Socket s=null;
    Client(String ip,String xmTopic)
    {
        IP=ip;
        subject=xmTopic;
        
    }
    void connection() throws IOException
    {
        Socket s = null;
        DataInputStream din;
        DataOutputStream dout;
        //cheking for external server
        //if(returningAgain==0)
        //{
            //System.out.println("here"+returningAgain);
            System.out.println("going in" + IP);
            try 
            {
                s=new Socket(IP,4495);
            } 
            catch (IOException ex) 
            {
                //Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);

                // if external server not found then creating local server
                System.out.println("External server not found ." + IP);
                try 
                {
                    s=new Socket("localhost",4495);
                } 
                catch (IOException ex1) 
                {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex1);
                }
                //
            }
          //  returningAgain=1;
        //}
        din=new DataInputStream(s.getInputStream());
        dout=new DataOutputStream(s.getOutputStream());
        
        //send server which exam is going on
        dout.writeUTF(subject);
        dout.flush();
        
        //store how many questions going to come
        int i;
        String s1;
        s1=din.readUTF();
        dout.flush();
        numberOfElements=Integer.valueOf(s1);
        System.out.println("here in client" + numberOfElements);
        //store questions and answers recieved from the server

        for(i=0;i<numberOfElements;i++)
        {
            s1=din.readUTF();
            ob.add(s1);
            dout.flush();
            s1=din.readUTF();
            ob_ans.add(s1);
            dout.flush();
        }
        /*
        for(i=0;i<ob.size();i++)
        {
            System.out.println(ob.get(i));
        }
        */
        
        
        
        
        
        
    }
    
    //for testing purpose. only run LocalServer/Server(in other pc) and Client to check if all data passing accordingly
    /*
    public static void main(String args[]) throws IOException
    {
        Client c=new Client("34234","Java");
        c.connection();
    }
    */

}

