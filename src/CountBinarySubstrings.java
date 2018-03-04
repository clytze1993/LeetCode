/**
 * Created by liuwenxiu on 2018/2/17.
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s){
        int len = s.length();
        int result = 0;
        for(int start = 0;start < len-1;start ++)//双重循环，会出现超时问题
            for(int end = start +1; end < len; end++){
            String sub =  s.substring(start,end+1);
            if(this.isvaild(sub)){
                result = result +1;
            }
        }
        return result;
    }
    public Boolean isvaild(String s){
        int sublen0 = 0;
        int sublen1 = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i)=='0'){
                sublen0= sublen0+1;
            }else if(s.charAt(i)=='1'){
                sublen1 = sublen1 +1;
            }
        }
        if((s.length() % 2==0) && (sublen0==sublen1)  ){
            for(int j=0; j<s.length()/2;j++){
                if (s.charAt(j) != s.charAt(0)){
                    return false;
                }
            }
            return true;
        }else {
            return false;
        }

    }
    /*观察到其实可以把字符串s转化为0和1的堆。
    譬如，“1111000011010001011”转化为“4 4 2 1 1 3 1 1 2 ”，
    也就是统计一下每个连续子串的个数，这样我们就可以方便的获得满足条件的子串个数，
    统计转化后的数组相邻元素之间最小的那个求和即可*/

    public int countBinarySubstrings2( String s){
        int len = s.length();
        if(len==0){
            return 0;
        }
        int[] arr =  new int[len];
        int j = 0;
        int k = 0;
        Character flag = s.charAt(0);
        for(int i = 0; i <len; i++){
            if (s.charAt(i) != flag){
                arr[j] = i-k;
                j++;
                flag = s.charAt(i);
                k = i;
            }
        }
        arr[j] = len -k;
        int sum =0;
        for(int i = 0; i<len-1;i++){
            if(arr[i] !=0 ){
                sum = sum + ((arr[i]>arr[i+1])?arr[i+1]:arr[i]);
            }
        }
        return sum;
    }
    public static void main(String[] args) throws Exception{
        String s = "10101";
        int result = new CountBinarySubstrings().countBinarySubstrings2(s);
        System.out.print(result);
    }
}
