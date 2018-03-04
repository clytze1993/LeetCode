/**
 * Created by liuwenxiu on 2017/12/27.
 */
public class PalindromeNumber {
    public  boolean isPalindrome(int x){
        long result = 0;
        int old = x;
        if(x < 0){
            return false;
        }
        while (x!=0){
            result = result *10 + x % 10;
            if(result > Integer.MAX_VALUE)
            {
                return false;
            }
            x = x / 10;
        }
        if ((int)result == old){
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws Exception{
        boolean result = new PalindromeNumber().isPalindrome(-2147447412);
        System.out.print(result);
    }
}
