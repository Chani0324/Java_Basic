package playdata;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // int num = 1;
        // int sum = 0;

        // while(num <= 50) {
        //     sum += num;
        //     num++;
        //     }
        // System.out.println("합 : " + sum);

        // do {
        //     sum += num;
        //     num++;
        // }while(num <= 10);
        // System.out.println("합 : " + sum);

        // int i ;
        // int sum;

        // for (i = 1, sum = 0; i <= 5; i++){
        //     sum += i;
        // }

        // System.out.println("합  " + sum);

        // int no1;
        // int no2;

        // for(no1 = 2; no1 <= 9; no1++) {
        //     for(no2 = 1; no2 <= 9; no2++){
        //         System.out.println(no1 +  "x" + no2 + "=" + no1 * no2);
        //     }
        //     System.out.println("=================");
        // }

        int total;
        int num;

        for (total = 0, num = 1; num <= 100; num++) {
            if (num % 2 == 0) {
                continue;
            }
            total += num;
        }

        System.out.println("1부터 100까지 홀수 합 : " + total);

    }
}
