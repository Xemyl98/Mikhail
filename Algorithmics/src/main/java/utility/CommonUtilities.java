package utility;

import java.util.Random;

public class CommonUtilities {


    public static int getRandomValue(int count)
    {
        Random random=new Random();
      return   random.nextInt(count);
    }

    public static int calculateFactorial(int n){
        int result = 1;
        for (int i = 1; i <=n; i ++){
            result = result*i;
        }
        return result;
    }
}
