/**
 * Created by liuwenxiu on 2018/1/2.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs){
        int strslen = strs.length;
        if (strslen == 0){
            return "";
        }
        int s  = 0;// s 记录长度最短的字符串下标
        for( int i = 1;i<strslen;i++){
            if(strs[i].length() < strs[s].length()){
                s = i;
            }
        }
        for(int j = 0; j< strs[s].length() ;j++){
            for(int k = 0;k< strs.length;k++){
                if( strs[k].charAt(j) != strs[s].charAt(j)){
                    return strs[s].substring(0,j);
                }
            }
        }
        return strs[s];
    }
    public static void main (String[] args) throws Exception{
        String[] A = new String[]{};
        String result = new LongestCommonPrefix().longestCommonPrefix(A);
        System.out.println(result);

    }
}
