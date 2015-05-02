/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week1;

import java.util.Scanner;

/**
 * John Hewitt
 * 
 * 1/8/15
 * 
 * @author jhewi_000
 * Exercise Portion of Week One Bowling Game.
 * 
 * used code from driver, swapped out for a scanner input and toString update 
 * per frame
 * 
 * strikes work, spares work, score works mostly
 * 
 * the logic could be less bloated and messy
 * incomplete ... no gutter balls, or frame increment, 
 * last frame does not add to score
 * 
 */
public class BowlingGameExercise {
    public static void main(String[] args){
        BowlingGame John = new BowlingGame("John");
       
        Scanner sc = new Scanner(System.in);
         int[][] bowlingScores = new int[11][2];
             
         int frameScore = 0;
         for(int frame = 0; frame < bowlingScores.length - 1; frame++){
            System.out.print("Frame " + John.getFrame() + ": ");
            bowlingScores[frame][0] = sc.nextInt();
           
            try {
                if(!John.shot(bowlingScores[frame][0])) //if next shot is not strike, 
                    bowlingScores[frame][1] = sc.nextInt();

                frameScore = bowlingScores[frame][0] + bowlingScores[frame][1];
                  //were checking the last time for strikes and then adding the score
                if(John.shot(bowlingScores[frame - 1][0])) {

                        John.setStrikes(true); //strikes++

                        John.setScore(bowlingScores[frame][0] + bowlingScores[frame][1]);
                    }
                else if(John.shot(bowlingScores[frame][0]) && bowlingScores[frame + 1][0] == 10){
                    //strikes++
                    John.setStrikes(true);

                    John.setScore(bowlingScores[frame + 1][0] + bowlingScores[frame + 2][1]);
                }

                else if(John.shot(frameScore)){   //spare++
                    John.setSpares(true);

                    John.setScore(bowlingScores[frame + 1][0]);
                }
            
            }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("First Frame");
                    }
            John.setScore(frameScore); //add score from normal shot
            John.setFrame();
            System.out.println(John);   //calls to string of the bowling game class
      }
      
      //should add last frame if a spare or strike   
      if (bowlingScores[9][0] + bowlingScores[9][1] % 10 == 0){
          John.setScore(bowlingScores[10][0]);
      }
      
   }   
}

 
