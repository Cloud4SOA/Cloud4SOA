/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.management.*;
import java.lang.management.*;
import java.util.Set;

public class SimpleAgent {
   private MBeanServer mbs = null;

   public SimpleAgent() {

      // Get the platform MBeanServer


      // Unique identification of MBeans
     // Hello helloBean = new Hello();


      
   }

   // Utility method: so that the application continues to run
   private static void waitForEnterPressed() {
      try {
         System.out.println("Press  to continue...");
         System.in.read();
      } catch (Exception e) {
         e.printStackTrace();
      }
    }

   public static void main(String argv[]) {
      SimpleAgent agent = new SimpleAgent();
      System.out.println("SimpleAgent is running...");
      SimpleAgent.waitForEnterPressed();
   }
}