/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fbos;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RemoteRef;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface FBOSServantInterface extends Remote
{
	public abstract UserAcctInterface createAccount(String userName, String password, String profession, String livingCity, 
                       String company, String college, int gradYear) throws RemoteException;
        public abstract UserAcctInterface loginAccount(String userName, String password) throws RemoteException;
        public abstract ArrayList<UserAcctInterface> searchForFriends(String college, String company) throws RemoteException;
        public abstract int inviteFriend(String userName) throws RemoteException;
}