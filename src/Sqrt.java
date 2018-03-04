/**
 * Created by liuwenxiu on 2018/2/14.
 */
public class Sqrt {
    public int sqrt(int x){
       if (x==0)
           return 0;
       int start= 1;
       int end = x;
       while(start<end){
           int middle = (start + end) /2;
           if(middle == x/middle){
               return middle;
           }
           else if(middle  > x/middle){
               end = middle;
               continue;
           }
           else if (middle  < x/middle && (middle+1) >x/(middle+1)){//终止条件
               return middle;
           }
           else if(middle < x/middle){
               start = middle;
               continue;
           }
       }
       return start;
    }
    public static void main(String[] args){
        int result =  new Sqrt().sqrt(2147395599);
        System.out.print(result);
    }
}
