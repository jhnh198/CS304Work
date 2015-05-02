/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week8;

/**
 *
 * @author jhewi_000
 */
public class MultiplyTester {
    public static void main(String[] args){
        SpecializedList m1 = new SpecializedList();
        SpecializedList m2 = new SpecializedList();
        
        
        m1.addFront((byte)4);
        m1.addFront((byte)2);
        m1.addFront((byte)0);
        m1.addFront((byte)1);
        
        
        m2.addFront((byte)4);
        m2.addFront((byte)2);
        m2.addFront((byte)0);
        m2.addFront((byte)1);
                       
        System.out.println(LargeInt.multiplyLists(m1, m2));
    }
}
