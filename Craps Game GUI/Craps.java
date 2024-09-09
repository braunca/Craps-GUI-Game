
/**
 * Write a description of class Craps here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Craps
{
    // instance variables 
    private GVdie die1, die2;
    private int current_points;
    private int credit_balance;
    private String current_message;
    private boolean legal;

    /**
     * Constructor for objects of class Craps
     */
    public Craps()
    {
        // initialise instance variables
        // setting all the values to -1, false or empty String
        die1 = new GVdie();
        die2 = new GVdie();
        current_points = -1;
        credit_balance = 0;
        legal = true;
        current_message = "Welcome to Craps game!";
    }
    //Accessors.
    public int getCredits()
    {
        return credit_balance;
    }
    public int getPoint()
    {
        return current_points;
    }
    public String getMessage()
    {
        return current_message;
    }
    //Value of num is the die we return
    public GVdie getDie(int num)
    {
        if(num == 1)
            return die1;
        else
        { if(num == 2)
            return die2;
          else
            return null;
        }
    }
    public boolean okToRoll()
    {
        if(legal)
            return false;
        else
            return true;
    }
    //Mutators
    public void comeOut()
    {
        if(legal && credit_balance >= 1)
        {
        die1.roll();
        die2.roll();
        int value1 = die1.getValue();
        int value2 = die2.getValue();
        int total = value1 + value2;
        //if total is 7 or 11
        if(total == 7 || total == 11)
        {
            credit_balance++;
            current_message = "You come out 7 or 11 in total! Credit +1!";
            
        }
        else //if total 2, 3 or 12
        {
            if(total == 2 || total == 3 || total == 12)
            {
                credit_balance--;
                current_points = -1;
                current_message = "You come out 2, 3 or 12 in total! You lose 1 point and credit! CRAPPED OUT";
            }
            else//otherwise put the points to total.
            {
                current_points = total;
                legal = false;
            }
                
        }
        
    }
    else
    {
        current_message = "It is not legal for you to come out!";
    }
        
    }
   
    
    public void roll()
    {
        if(okToRoll())
        {
        die1.roll();
        die2.roll();
        int value1 = die1.getValue();
        int value2 = die2.getValue();
        int total = value1 + value2;
        
        if(total == 7)
        {
            credit_balance--;
            current_points = -1;
            current_message = "You rolled 7, lost one credit! LOST";
            legal = true;
            
        }
        else
        {
            if(value1 == current_points || value2 == current_points)
            {
                credit_balance++;
                current_points = -1;
                current_message = "One of the dices is equal to your points! Credit up for 1! You win!";
                legal = true;
            }
            else
            {
                current_message = "Continue to roll!";
            }
        }
    }
    else
        current_message = "It is not time to roll!";
}
    
    public void setCredits(int amount)
    {
        //if the balance is equal or greater than 0, set the amount
        if(amount>=0)
            credit_balance = amount;
    }
    
}
