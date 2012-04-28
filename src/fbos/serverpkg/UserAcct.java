/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fbos.serverpkg;

import fbos.UserAcctInterface;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.lang.Object;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author User
 */
public class UserAcct extends java.rmi.server.UnicastRemoteObject implements UserAcctInterface
{
    int      thisRMIPort;
    String   thisRMIAddress;
    Registry registry;    // rmi registry for lookup the remote objects.
    ArrayList<String> myUpdates = new ArrayList<String>();
    ArrayList<UserAcctInterface> myFriends = new ArrayList<UserAcctInterface>();
    ArrayList<UserAcctInterface> myRequests = new ArrayList<UserAcctInterface>();
    Map<String, Object> profileInfo = new HashMap<String, Object>();
    
    public UserAcct(String userName, String password, String profession, String livingCity, 
                       String company, String college, int gradYear) throws RemoteException
    {
        
        profileInfo.put("userName", userName);
        profileInfo.put("password", password);
        profileInfo.put("profession", profession);
        profileInfo.put("livingCity", livingCity);
        profileInfo.put("company", company);
        profileInfo.put("college", college);
        profileInfo.put("gradYear", gradYear);
        try{
            // get the address of this host.
            thisRMIAddress= (InetAddress.getLocalHost()).toString();
        }
        catch(Exception e){
            throw new RemoteException("can't get inet address.");
        }
        
        thisRMIPort=3232;  // this port(registry�fs port)
        System.out.println("this address="+thisRMIAddress+",port="+thisRMIPort);
        try{
            // create the registry and bind the name and object.
            registry = LocateRegistry.getRegistry( thisRMIPort );
            registry.rebind(userName+"-"+password, this);
        }
        catch(RemoteException e){
            throw e;
        }
    }
        
    @Override
    public synchronized Map viewProfile() throws RemoteException
    {
        return profileInfo;
    } 
    
    @Override
    public synchronized int updateProfile(String userName, String password, String profession, String livingCity, 
                       String company, String college, int gradYear) throws RemoteException
    {
        if(!(password.equals("NOPASS") || profileInfo.get("password").equals("NOPASS")) ) {
            try{
            // create the registry and bind the name and object.
                String oldUser = (String)profileInfo.get("userName");
                String oldPass = (String)profileInfo.get("password");
                registry.unbind(oldUser+"-"+oldPass);
                profileInfo.put("userName", userName);
                profileInfo.put("password", password);
                profileInfo.put("profession", profession);
                profileInfo.put("livingCity", livingCity);
                profileInfo.put("company", company);
                profileInfo.put("college", college);
                profileInfo.put("gradYear", gradYear);
                registry.rebind(userName+"-"+password, this);
                registry.unbind(userName+"-NOPASS");
                UserAcct newUser2 = new UserAcct(userName, "NOPASS", profession, livingCity, company, college, gradYear);
                return 1;
            }
            catch(Exception e) {
                System.err.println(e.getStackTrace());
                return 0;
            }
            
        }
        return 0;
    }
    
    @Override
    public synchronized int postUpdate(String content) throws RemoteException
    {
        myUpdates.add(content);
        return 1;
    }
    
    @Override
    public synchronized ArrayList<String> getUpdates() throws RemoteException
    {
        return myUpdates;
    }
    
}
