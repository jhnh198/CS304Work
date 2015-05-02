/*
 * John Hewitt
2/15/15
Lab 4 Recursion. Problem a and b
Answer to problem b: The algorithm is inefficient since it has to call the method recursively over 180,000 times.
A simpler way would be to derive a closed formula that takes n and returns the number of paths. Although the code
or formula may be much more difficult to work with and derive.
 */
package Week5;

/**
 *
 * @author jhewi_000
 */
public class LabFourRecursion {
    public static void main(String[] args){
        System.out.print(numPaths(1, 1, 4));
    }
    
    public static int numPaths(int row, int col, int n){
        if(row == n || col == n){
            return 1;
        }
        else 
            return (numPaths(row + 1, col, n) + numPaths(row, col + 1, n));
    }
}
