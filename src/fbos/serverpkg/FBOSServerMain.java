/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fbos.serverpkg;

/**
 *
 * @author User
 */
public class FBOSServerMain 
{
    public static void main(String args[])
    {
        FBOSServer myFB = new FBOSServer();
        myFB.addUser("DUser", "DPass", "DProf", "DCity", "DComp", "DCol", 2012);
        myFB.closeCon();
    }
}
