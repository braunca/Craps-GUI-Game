
/**
 * Write a description of class CrapsTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrapsTest
{
  
    public static void main(String[] args)
    {
        Craps crp = new Craps();
        crp.setCredits(10);
        while(crp.getCredits() != 0)
        {
            if(crp.okToRoll())
            {
                crp.roll();
                System.out.println(crp.getMessage());
            }
            else
            {
                crp.comeOut();
                 System.out.println(crp.getMessage());
            }
                
        }
        crp.roll();
        
        crp.roll();
        
    }
}
