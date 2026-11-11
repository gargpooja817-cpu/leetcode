import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        
        boolean[] used = new boolean[nums.length];
        
        backtrack(nums, new ArrayList<>(), ans, used);
        
        return ans;
    }
    
    public void backtrack(int[] nums, List<Integer> temp,
                          List<List<Integer>> ans, boolean[] used) {
        
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            
            if (used[i]) {
                continue;
            }
            
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            
            used[i] = true;
            temp.add(nums[i]);
            
            backtrack(nums, temp, ans, used);
            
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}