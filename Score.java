import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    private int playerScore;
    private boolean scoreChanged;
    
    public Score()
    {
        playerScore = 0;
        displayScore();
    }
    
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(scoreChanged == true)
        {
            displayScore();
        }
    }    
    
    public void countScore()
    {
        playerScore++;
        scoreChanged = true;
    }
    
    private void displayScore()
    {
        GreenfootImage display;
        display = new GreenfootImage( Integer.toString( playerScore ), 30, (Color.WHITE), Color.BLACK );
        setImage(display);
        scoreChanged = false;
    }
    
    public  int getScore()
    {
        return playerScore;
    }
     
}
