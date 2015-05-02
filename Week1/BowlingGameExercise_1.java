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
 * 1/9/15
 * 
 * @author jhewi_000
 * Exercise Portion of Week One Bowling Game.
 * 
 * used code from driver, swapped out for a scanner input and toString update 
 * per frame instead of array
 * 
 * strikes work, spares work, score works, gb works
 * need to make the lastFrame method pass strikes / spares / gb properly;
 * minor logic error. does not affect the program score, compilation or runtime
 * 
 * the logic could be less bloated and messy, 
 *  -- need to implement methods into the logic to simplify
 */
 
public class BowlingGameExercise_1 {
    public static void main(String[] args){
        
        BowlingGame_1 John = new BowlingGame_1("John");
       
        Scanner sc = new Scanner(System.in);
        int[][] bowlingScores = new int[11][2];
             
        int frameScore = 0; //used to add frame score, mostly for clarity in the rest of the program
        
        for(int frame = 1; frame < bowlingScores.length; frame++){
            //Step one, get user input for one frame.
            //Validate strike, spare, gutterball or normal shot
            John.shotPrompt();
            bowlingScores[frame][0] = sc.nextInt();
            
            //gutter ball check
            John.setGutterBalls(bowlingScores[frame][0]);
            //strike check
            John.setStrikes(bowlingScores[frame][0]);
            
            //check if we need another shot. true if first shot != 10
            if(!John.shot(bowlingScores[frame][0]) && frame != 10)
            {
               John.shotPrompt();
               bowlingScores[frame][1] = sc.nextInt();
               //check again for gutter ball, but only if we shoot again
               John.setGutterBalls(bowlingScores[frame][1]);
               
               //spare check
               John.setSpares(bowlingScores[frame][0], bowlingScores[frame][1]);
            }
            else if(frame == 10){
               //last frame
               John.shotPrompt();
               bowlingScores[frame][1] = sc.nextInt();
               
               //check for special shots and increment them
               John.setGutterBalls(bowlingScores[frame][1]);
               John.setStrikes(bowlingScores[frame][1]);
               John.setSpares(bowlingScores[frame][0], bowlingScores[frame][1]);
               
               // will return bonus of the last frame, or 0 if no spare / strike in last frame
               // the last score does not change the normal flow of the game score logic
               John.setScore(lastFrame(bowlingScores[frame][0], bowlingScores[frame][1], John, sc));
            }
            
            //sum frame for score
            frameScore = bowlingScores[frame][0] + bowlingScores[frame][1];
                      
            //Step two, figure out bonus scores. We check prior frames to add a current bonus
            try{
               if(frame >= 1 && John.shot(bowlingScores[frame - 1][0])) 
               {  //strike bonus
                  if(bowlingScores[frame][0] != 10){                
                  John.setScore(frameScore);
                  }
                  
                  if(bowlingScores[frame - 2][0] == 10 && bowlingScores[frame - 1][0] == 10){
                  John.setScore(bowlingScores[frame][0] + bowlingScores[frame-1][0]);
                  }
               }
               else if(frame != 0 && John.shot(bowlingScores[frame - 1][0] + bowlingScores[frame - 1][1]))
               { //spare bonus
                  John.setScore(bowlingScores[frame][0]);
               }
            } catch(ArrayIndexOutOfBoundsException e){
               System.out.println("No bonus yet");
            }
            
            John.setScore(frameScore); //add score from normal shot
            John.setFrame();
            System.out.println(John + "\n " );   //calls to string of the bowling game class
        }
          
   } //end class
    
    public static int lastFrame(int pin1, int pin2, BowlingGame_1 bg, Scanner sc){
        int pin3 = 0;
        int lastFrameScore = 0;        
        
        int frameScore = pin1 + pin2;
        
        if(frameScore >= 10){
         
               bg.shotPrompt();
               pin3 = sc.nextInt();
               bg.setGutterBalls(pin3);
               bg.setSpares(pin1, pin2);
               lastFrameScore += pin3;
               return lastFrameScore;
            }
        else if (frameScore == 20){
               bg.shotPrompt();
               pin3 = sc.nextInt();
               bg.setStrikes(pin3);
               bg.setGutterBalls(pin3);
               lastFrameScore = 2*(pin3);
               return lastFrameScore;
            }
        else return 0;
            
    
    }   
}