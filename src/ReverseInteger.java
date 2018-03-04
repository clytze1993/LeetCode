/**
 * Created by liuwenxiu on 2017/12/27.
 * 考虑溢出的情况
 */
public class ReverseInteger {
    public int reverse(int x){
        long result = 0;

        while(x!= 0){
            int tail = x % 10;
            result = result *10 + tail;
            x = x/10;
            if(result > Integer.MAX_VALUE || result<Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int)result;
    }
    public static void main(String[] args) throws Exception{
        int x = 1534236469;
        int result = new  ReverseInteger().reverse(x);
        System.out.println(result);
        System.out.println(Integer.MAX_VALUE);

    }
}
