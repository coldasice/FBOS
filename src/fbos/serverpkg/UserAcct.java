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
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    ArrayList<UserAcctInterface> sentRequests = new ArrayList<UserAcctInterface>();
    Map<String, Object> profileInfo = new HashMap<String, Object>();
    UserAcctInterface mySisterAcct;
    int loggedIn = 0;
    
    public UserAcct(String userName, String password, String profession, String livingCity, 
                       String company, String college, int gradYear, UserAcctInterface sisterAcct) throws RemoteException
    {
        
        profileInfo.put("userName", userName);
        profileInfo.put("password", password);
        profileInfo.put("profession", profession);
        profileInfo.put("livingCity", livingCity);
        profileInfo.put("company", company);
        profileInfo.put("college", college);
        profileInfo.put("gradYear", gradYear);
        mySisterAcct = sisterAcct;
        try{
            // get the address of this host.
            thisRMIAddress= (InetAddress.getLocalHost()).toString();
        }
        catch(Exception e){
            throw new RemoteException("can't get inet address.");
        }
        
        thisRMIPort=4242;  // this port(registry�fs port)
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
            try {
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
                    registry.unbind(oldUser+"-NOPASS");
                    UserAcct newUser2 = new UserAcct(userName, "NOPASS", profession, livingCity, company, college, gradYear, this);
                    newUser2.myFriends = myFriends;
                    newUser2.myRequests = myRequests;
                    newUser2.myUpdates = myUpdates;
                    mySisterAcct = newUser2;
                    return 1;
            } catch (NotBoundException ex) {
                Logger.getLogger(UserAcct.class.getName()).log(Level.SEVERE, null, ex);
            } catch (AccessException ex) {
                Logger.getLogger(UserAcct.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        return 0;
    }
    
    @Override
    public synchronized int postUpdate(UserAcctInterface poster, String content, boolean isFirst) throws RemoteException
    {
        Map posterProfile = poster.viewProfile();
        if(posterProfile.get("password").equals("NOPASS")) {
            System.out.println("Must be logged in to post");
            return 0;
        }
        myUpdates.add(posterProfile.get("userName") + ": " + content);
        
        if(isFirst) {
            mySisterAcct.postUpdate(poster, content, false);
        }
        return 1;
    }
    
    @Override
    public synchronized ArrayList<String> getUpdates() throws RemoteException
    {
        return myUpdates;
    }
   
    
    @Override
    public synchronized int addReq(UserAcctInterface requester, boolean isFirst) throws RemoteException
    {
        myRequests.add(requester);
        if(isFirst) {
            mySisterAcct.addReq(requester, false);
        }
        return 1;
    }
    
    @Override
    public synchronized ArrayList<UserAcctInterface> getRequests() throws RemoteException
    {
        return myRequests;
    }
    
    @Override
    public synchronized int approveFriend(UserAcctInterface requester, boolean isFirst) throws RemoteException
    {
        if(profileInfo.get("password").equals("NOPASS")) {
            System.out.println("Must be logged in to post");
            return 0;
        }
        if(myRequests.contains(requester)) {
            myFriends.add(requester);
            String userName = (String) requester.viewProfile().get("userName");
            try {
                UserAcctInterface safeAcct = (UserAcctInterface)(registry.lookup(userName+"-NOPASS"));
                if(requester.approve(safeAcct, true) != 1) {
                    return 0;
                }
            } 
            catch (Exception ex) {
                Logger.getLogger(FBOSServant.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
            }
            myFriends.add(requester);
            return 1;
        }
        else {
            System.out.println("Did not request you");
            return 0;
        }
    }
    
    @Override
    public synchronized int sentReq(UserAcctInterface friend, boolean isFirst) throws RemoteException
    {
        sentRequests.add(friend);
        if(isFirst) {
            mySisterAcct.sentReq(friend, false);
        }
        return 1;
    }
    
    @Override 
    public synchronized int approve(UserAcctInterface friend, boolean isFirst) throws RemoteException
    {
        if(sentRequests.contains(friend)) {
            myFriends.add(friend);
            if(isFirst) {
                mySisterAcct.approve(friend, false);
            }
        }
        return 1;
    }
    
    @Override 
    public synchronized ArrayList<UserAcctInterface> getFriends() throws RemoteException
    {
        return myFriends;
    }
}
