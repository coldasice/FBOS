/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fbos.clientpkg;
import fbos.FBOSI;
import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;
/**
 *
 * @author User
 */
public class FBOSClient 
{
    public static void main(String args[]) 
    {
       FBOSI FBOSServer;
       Registry registry;
       String serverAddress="172.24.8.40";//args[0];
       String serverPort="3232";//args[1];
       String text="useless";//args[2];
       System.out.println("sending "+text+" to "+serverAddress+":"+serverPort);
       try{
           // get the �gregistry�h
           registry=LocateRegistry.getRegistry(serverAddress,(new Integer(serverPort)).intValue());
           // look up the remote object
           FBOSServer=(FBOSI)(registry.lookup("FBOSServer"));
           
           
           // call the remote method
           System.out.println(FBOSServer.addUser("DUser", "DPass", "DProf", "DCity", "DComp", "DCol", 2012));
           //System.out.println("myRet: "+myRet);
       }
       catch(RemoteException e){
           e.printStackTrace();
       }
       catch(NotBoundException e){
           e.printStackTrace();
       }
    }
}
