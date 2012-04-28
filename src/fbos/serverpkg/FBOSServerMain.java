/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fbos.serverpkg;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
/**
 *
 * @author User
 */
public class FBOSServerMain 
{
    public static void main(String args[])
    {
        try{
            FBOSServant myFB = new FBOSServant();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        
    }
}
