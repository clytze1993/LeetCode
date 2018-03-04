import javax.sound.midi.Track;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by liuwenxiu on 2018/1/2.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        int length = s.length();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i<length;i++){
            if(!stack.empty()){
                if(stack.peek() ==  map.get(s.charAt(i))){
                    stack.pop();
                }
                else {
                    stack.add(s.charAt(i));
                }
            }
            else {
                stack.add(s.charAt(i));
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }
    public  static  void main(String[] args) throws Exception{
        String A = "";
        boolean result = new ValidParentheses().isValid(A);
        System.out.print(result);
    }
}
