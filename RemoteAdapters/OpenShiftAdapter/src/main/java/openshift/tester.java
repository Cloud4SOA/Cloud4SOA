/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openshift;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jled
 */
public class tester {
    
 public static void main(String[] args) {

     Openshift_Aux open = new Openshift_Aux();
        try {
            
            //open.deleteApplication("c4sgit");
            System.out.println(open.getApplicationUrl("c4sgit"));
            System.out.println(open.getApplicationName("c4sgit"));
           
            //open.test("cloud4soaexpress1");
        } catch (Exception ex) {
            Logger.getLogger(tester.class.getName()).log(Level.SEVERE, null, ex);
        }
 
 }
}
