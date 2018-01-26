import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SnakeWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeWorld extends World
{
    private final int MAX_PARTS = (1100*700)/(25*25);

    private int[] x = new int[MAX_PARTS];
    private int[] y = new int[MAX_PARTS];
    private int parts = 4;

    private boolean startGame = false;
    private Snake body;

    /**
     * Constructor for objects of class SnakeWorld.
     * 
     */
    public SnakeWorld()
    {    
        super(1100, 700, 1);
        for(int i = 0;i < parts; i++)
        {
            x[i] = 150 - i*25;
            y[i] = 25;
        }

        setPaintOrder(Score.class, Snake.class, Food.class);
        placeElements();
        prepare();
        populate();
    }
    
    public void reset()
    {
        showText("Press Space To Start", 200, 550);
        startGame = false;
    }
    
     public boolean getStarted()
    {
        return startGame;
    }
    
    private void populate()
    {
        addObject(new Score(), getWidth()/2, 50);
       
    }
    
     private void checkKeyPress()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            showText("",200, 550);
            startGame = true;
        }
    }
    
    private void placeElements()
    {
        for(int i = 0; i < parts;i++)
        {
            body = new Snake(i);
            addObject(body, x[i], y[i]);
        }
    }

    public void act()
    {
        for(int i = parts;i > 0;i--)
        {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
    }

    public void setSX(int s, int sx)
    {
        x[s] = sx;
    }

    public void setSY( int s, int sy)
    {
        y[s] = sy; 
    }

    public int getMyX( int s)
    {
        return x[s];
    }

    public int getMyY( int s)
    {
        return y[s];
    }

    public void addSnake()
    {
        int parentX = x[parts-1];
        int parentY = y[parts-1];

        body = new Snake(parts);
        addObject( body, parentX, parentY );
        parts++;

    }

    public void addFood()
    {
        Food food = new Food ();
        addObject(food,Greenfoot.getRandomNumber(getWidth() ), Greenfoot.getRandomNumber(getHeight()));
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Food food = new Food();
        addObject(food,164,293);
        Food food2 = new Food();
        addObject(food2,186,535);
        Food food3 = new Food();
        addObject(food3,272,466);
        Food food4 = new Food();
        addObject(food4,422,364);
        Food food5 = new Food();
        addObject(food5,607,244);
        Food food6 = new Food();
        addObject(food6,611,538);
        Food food7 = new Food();
        addObject(food7,637,603);
        Food food8 = new Food();
        addObject(food8,953,191);
        Food food9 = new Food();
        addObject(food9,839,620);
        Food food10 = new Food();
        addObject(food10,1043,536);
        Food food11 = new Food();
        addObject(food11,1074,311);
        Food food12 = new Food();
        addObject(food12,965,319);
        Food food13 = new Food();
        addObject(food13,906,342);
        Food food14 = new Food();
        addObject(food14,825,266);
        Food food15 = new Food();
        addObject(food15,813,191);
        Food food16 = new Food();
        addObject(food16,708,69);
    }
}
