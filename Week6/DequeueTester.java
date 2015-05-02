/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week6;

/**
 *
 * @author jhewi_000
 */
public class DequeueTester {
    
    public static void main(String[] args){
      Dequeue dq1 = new Dequeue();
      
      dq1.enqueue("1");
      dq1.enqueue("2");
      dq1.enqueue("3");
      dq1.enqueue("4");
      dq1.enqueue("5");
      dq1.enqueue("6");
      dq1.enqueue("7");
      dq1.enqueue("8");      
      
      System.out.println(dq1);
      System.out.print("\n");
      dq1.enDequeue("9");
      System.out.println(dq1);
      
      System.out.print("\n");
      System.out.println(dq1.deDequeue());
      System.out.print("\n");
      System.out.println(dq1);
      
      System.out.print("\n");
      System.out.println(dq1.deDequeue());
      System.out.print("\n");
      
      System.out.println(dq1);
    }
}
