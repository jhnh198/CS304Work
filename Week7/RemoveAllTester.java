/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week7;

/**
 *
 * @author jhewi_000
 */
public class RemoveAllTester {
    public static void main(String[] args){
        RefUnsortedList r1 = new RefUnsortedList();
        r1.add("lol");
        r1.add("merp");
        r1.add("merp");
        r1.add("lol");
        
        System.out.println(r1);
        System.out.println(r1.removeAll("lol"));
        System.out.println(r1);
    }
}
