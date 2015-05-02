/*
* John Hewitt
 * 
 * 1/8/15
 * 
 * @author jhewi_000
 * Lab Portion of Week One Bowling Game
 * Bowling Game for CS 304; need to check is a shot is spare, strike or gutter
 *   then add score. 
 
Scoring
Normal shot is + pins to score
strike : 10 + (next two scores) to score
spare : 10 for frame + (next shot) to score
gutter : score is +0 and next frame
shot checks if pins are ten, if so, the caller handls the behavior.
but this class should
 */
package Week1;

import java.util.Scanner;

/**
 *
 * @author jhewi_000
 */
public class BowlingGame {
    private String bowlerName;
    private int score;
    private double frame;
    private byte strikes;
    private byte spares;
    private byte gutterBalls;
    private Scanner sc = new Scanner(System.in);
    
    public BowlingGame(String name){
        bowlerName = name;
        spares = 0;
        strikes = 0;
        gutterBalls = 0;
        frame = 0;
    }
    
    public boolean shot(int pins){
      return pins == 10;
   }
    
    public String getBowlerName(){
        return bowlerName;
    }    
    public int getScore(){
        return score;
    }    
    public double getFrame(){
        return frame;
    }
    public byte getStrikes(){
        return strikes;
    }
    public byte getSpares(){
        return spares;
    }
    public byte getGutterBalls(){
        return gutterBalls;
    }
    
    public void setScore(int newScore){
        this.score += newScore;
    }
    public void setStrikes(boolean isStrike){
        if(isStrike) strikes++;
    }
    
    public void setFrame(){
        frame++;
    }
    public void setSpares(boolean isSpare){
        if (isSpare) spares++;
    }
    public void setGutterBalls(boolean isGutterBall){
        if (isGutterBall) gutterBalls++;
    }
    @Override
    public String toString(){
        return "Bowler: " + bowlerName +
               "\nFrame: " + frame +
               "\nScore: " + score +
               "\nStrikes: " + strikes +
               "\nSpares: " + spares +
               "\nGutter Balls: " + gutterBalls;
    }
}
