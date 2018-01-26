import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends Actor
{
    private int x;
    private int y;
    private int s;
    private final int SNAKE_SIZE = 25;
    
    public Snake(int part)
    {
        GreenfootImage snakeImage = new GreenfootImage( SNAKE_SIZE,SNAKE_SIZE );
        s = part;
        
        if(s == 0)
        {
            snakeImage.setColor(Color.BLACK);
        }
        else
        {
            snakeImage.setColor(Color.GREEN);
        }
        snakeImage.fillOval(0, 0, SNAKE_SIZE,SNAKE_SIZE);
        setImage(snakeImage);
        
    }
    
    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(s == 0)
        {
            lead();
            lookForFood();
            lookForEdge();
            lookForTail();
        }
        else
        {
            follow();
        }
    }  
    
    private void lead()
    {
       double angle;
       SnakeWorld myWorld = (SnakeWorld)getWorld();
       x = getX();
       y = getY();
       
       if( Greenfoot.isKeyDown("left") )
       {
           setRotation(180);
       }
       else if( Greenfoot.isKeyDown("right") )
       {
           setRotation(0);
       }
       else if(Greenfoot.isKeyDown("up") )
       {
           setRotation(270);
       }
       else if( Greenfoot.isKeyDown("down") )
       {
           setRotation(90);
       }
       
       angle = Math.toRadians( getRotation() );
       x = (int) Math.round( getX() + Math.cos(angle) * SNAKE_SIZE );
       y = (int) Math.round( getY() + Math.sin(angle) * SNAKE_SIZE );
       
       setLocation(x, y);
       myWorld.setSX(s, x);
       myWorld.setSY(s, y);
    }
    
    private void  lookForFood()
    {
        SnakeWorld myWorld = (SnakeWorld)getWorld();
        Score playerScore = (Score)getWorld().getObjects(Score.class).get(0);
        if(isTouching(Food.class) )
        {
            removeTouching(Food.class);
            playerScore.countScore();
            growTail();
           
            myWorld.addFood();
        }
    }
    
    private void lookForEdge()
    { 
        
         if(isAtEdge())
       {        
           getWorld().showText("YOU LOSE!!",getWorld().getWidth()/2, getWorld().getHeight()/2 );
           Greenfoot.stop();
       }
    }
    
    private void lookForTail()
    {
       if( isTouching(Snake.class) )
       {   
           getWorld().showText("YOU LOSE!!",getWorld().getWidth()/2, getWorld().getHeight()/2 );
           Greenfoot.stop();
       }
    }
    
    private void follow()
    {
        SnakeWorld myWorld = (SnakeWorld)getWorld();
        x = myWorld.getMyX(s);
        y = myWorld.getMyY(s);
        setLocation(x, y);
    }
    
    private void growTail()
    {
        SnakeWorld world = (SnakeWorld)getWorld();
        world.addSnake();
    }
}
