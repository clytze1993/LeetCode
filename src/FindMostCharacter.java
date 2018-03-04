import java.util.HashMap;

/**
 * Created by liuwenxiu on 2018/2/16.
 */
public class FindMostCharacter {
    public Character findMostCharacter(String s){
        int len = s.length();
        if(len==0){
            return null;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<len; i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
            else {
                map.put(s.charAt(i), 1);
            }
        }
        Character result = s.charAt(0) ;
        for(Character key:map.keySet()){
            if(map.get(key) > map.get(result)){
                result = key;
            }
        }
        System.out.print(result);
        return result;
    }
    public static void main(String[] args) throws Exception{
        String s= "abyyyeowooo";
        new FindMostCharacter().findMostCharacter(s);
    }
}
