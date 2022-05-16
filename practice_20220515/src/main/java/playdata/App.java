package playdata;

import javax.naming.spi.DirStateFactory.Result;

/**
 * Hello world!
 *
 */
public class App 
{
    private static int add(int no1, int no2) {
        int result;
        result = no1 + no2;
        return result;
    }

    

    public static void main( String[] args )
    {
        System.out.println(App.add(5, 6));
        
    }
}
