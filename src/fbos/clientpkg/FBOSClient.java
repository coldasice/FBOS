/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fbos.clientpkg;
import fbos.FBOSServantInterface;
import fbos.UserAcctInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
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
       String serverAddress="172.24.8.22";//args[0];
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
           UserAcctInterface proxy1 = FBOSServer.createAccount("DUser1", "DPass", "DProf", "DCity", "DComp1", "DCol", 2012);
           UserAcctInterface proxy2 = FBOSServer.createAccount("DUser2", "DPass", "DProf", "DCity", "DComp1", "DCol", 2012);
           UserAcctInterface proxy3 = FBOSServer.createAccount("DUser3", "DPass", "DProf", "DCity", "DComp", "DCol", 2012);
           UserAcctInterface loggedIn = FBOSServer.loginAccount("DUser", "DPass");
           
           if(loggedIn == null) {
               System.out.println("Could not log in");
           }
           else {
               System.out.println("Logged in");
               System.out.println(loggedIn.viewProfile());
               int updateSuccess = loggedIn.updateProfile("NewUN", "NewPass", "DProf", "DCity", "DComp", "DCol", 2012);
               if(updateSuccess == 0) {
                   System.out.println("updated");
               }
           }
           
           ArrayList userObjList = FBOSServer.searchForFriends(null, null);
           for(int i = 0; i < userObjList.size(); i++) {
               UserAcctInterface currUser = (UserAcctInterface) userObjList.get(i);
               System.out.println(currUser.viewProfile());
           }
       }
       catch(Exception e){
           e.printStackTrace();
       }
       
    }
    
}
