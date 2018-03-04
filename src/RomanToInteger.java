import java.util.HashMap;

/**
 * Created by liuwenxiu on 2017/12/27.
 */
public class RomanToInteger {
    public int romanToInt(String s) {

        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('I',1);
        map.put('X',10);
        map.put('C',100);
        map.put('M',1000);
        map.put('V',5);
        map.put('L',50);
        map.put('D',500);

        int length = s.length();
        int result = 0 ;
        for (int i = 0;i<length-1 ;i++){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                result = result - map.get(s.charAt(i));
            }
            else {
                result = result + map.get(s.charAt(i));
            }
        }
        result = result + map.get(s.charAt(length-1));
        return result;
    }
    public static void main(String[] args) throws Exception{
        int result = new RomanToInteger().romanToInt("MCMLXXX");
        System.out.print(result);
    }
}
