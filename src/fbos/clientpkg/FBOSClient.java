/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fbos.clientpkg;
import fbos.FBOSServantInterface;
import fbos.UserAcctInterface;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;
import java.rmi.server.RemoteRef;
import java.rmi.server.RemoteStub;
import java.rmi.server.RemoteObject;
/**
 *
 * @author User
 */
public class FBOSClient 
{
    public static void main(String args[]) 
    {
       FBOSServantInterface FBOSServer;
       Registry registry;
       String serverAddress="192.168.1.69";//args[0];
       String serverPort="3232";//args[1];
       String text="useless";//args[2];
       System.out.println("sending "+text+" to "+serverAddress+":"+serverPort);
       try{
           // get the �gregistry�h
           registry=LocateRegistry.getRegistry(serverAddress,(new Integer(serverPort)).intValue());
           // look up the remote object
           FBOSServer=(FBOSServantInterface)(registry.lookup("FBOSServer"));
                      
           // create new account
           UserAcctInterface proxy = FBOSServer.createAccount("DUser", "DPass", "DProf", "DCity", "DComp", "DCol", 2012);
           UserAcctInterface loggedIn = FBOSServer.loginAccount("DUser", "DPass");
           
           if(loggedIn == null) {
               System.out.println("Could not log in");
           }
           else {
               System.out.println("Logged in");
               System.out.println(loggedIn.viewProfile());
           }
           
       }
       catch(Exception e){
           e.printStackTrace();
       }
       
    }
}
