/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fbos;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author User
 */
public interface FBOSI extends Remote
{
	public abstract int addUser(String userName, String password, String profession, String livingCity, 
                       String company, String college, int gradYear) throws RemoteException;
}