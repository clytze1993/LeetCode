/**
 * Created by liuwenxiu on 2018/2/18.
 */
public class StrStr {
    public int strStr(String haystack, String needle){
        int len = haystack.length();
        int sublen = needle.length();
        if(len == 0 && sublen == 0){
            return 0;
        }//两个空字符串的情况
        if(sublen > len){
            return -1;
        }
        if((haystack.equals(needle)) || (sublen==0 && len!=0)){
            return 0;
        }
        for(int i = 0 ; i<len-sublen+1; i++){
            if(haystack.substring(i,i+sublen).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public  static void main(String[] args) throws Exception{
        String a = "mississippi";
        String b =  "pi";
        int result = new StrStr().strStr(a,b);
        System.out.print(result);
    }
}
