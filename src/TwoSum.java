import java.util.HashMap;

/**
 * Created by liuwenxiu on 2017/12/26.
 */
public class TwoSum {
    public int[] twoSum1(int[] nums , int target){
        int[] result = new int[2];
        int length = nums.length;
        for(int i=0; i<length; i++){
            for(int j = i+1 ;j<length; j++){
                if (nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
    public int[] twoSum2(int[] nums, int target){
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        int length = nums.length;
        for(int i = 0;i<length;i++){
            if(map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return result;
    }


    public  static void main(String[] args) throws Exception{
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = new TwoSum().twoSum2(nums,target);
        int len = result.length;
        for (int i=0 ;i < len;i++){
            System.out.println(result[i]);
        }

    }
}
