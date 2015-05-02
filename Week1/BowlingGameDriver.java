/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week1;
/**
 * John Hewitt
 * 
 * 1/8/15
 * 
 * @author jhewi_000
 * Lab Portion of Week One Bowling Game. 
 * Takes test array and outputs string
 * 
 * strikes work, spares work, score works mostly
 * 
 * the logic could be less bloated and messy
 * incomplete ... no gutter balls, or frame increment, 
 * last frame does not add to score
 * 
 */
public class BowlingGameDriver {
    public static void main(String[] args){
        BowlingGame John = new BowlingGame("John");
       
         int[][] bowlingScores = new int[][]{ //test values
             {1, 3},    //4
             {4, 5},    //9
             {7, 3},    //10 + 10 spare
             {10,0},    //10 + 4 + 0 strike
             {4, 0},    //4
             {1, 2},    //3
             {3, 5},    //8
             {7, 3},    //10 + 5 spare
             {5, 2},    //7
             {3, 7},    // 10 + 6 spare
             {6, 0}     // 6 bonus frame, if [9][1] spare or strike
             };         // 106 total
                 
         int frameScore = 0;
         for(int frame = 0; frame < bowlingScores.length - 1; frame++){
             
            //add frame, can be transferred to get input as well
            frameScore = bowlingScores[frame][0] + bowlingScores[frame][1];
            John.setScore(bowlingScores[frame][0] + bowlingScores[frame][1]); 
            
            //System.out.println(score); debugger printout
            if(John.shot(bowlingScores[frame][0])){
                John.setStrikes(true); //strikes++
                
                John.setScore(bowlingScores[frame + 1][0] + bowlingScores[frame + 1][1]);
            }
            else if(John.shot(bowlingScores[frame][0]) && bowlingScores[frame + 1][0] == 10)try {
                //strikes++
                John.setStrikes(true);
                
                John.setScore(bowlingScores[frame + 1][0] + bowlingScores[frame + 2][1]);
                
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Last Frame, bonus shot");
                }
            else if(John.shot(frameScore))
            {   //spare++
                John.setSpares(true);
                
                John.setScore(bowlingScores[frame + 1][0]);
            }            
      }
         
      //should add last frame if a spare or strike   
      if (bowlingScores[9][0] + bowlingScores[9][1] % 10 == 0){
          John.setScore(bowlingScores[10][0]);
      }
      System.out.println(John);   //calls to string of the bowling game class
   }   
}

 
