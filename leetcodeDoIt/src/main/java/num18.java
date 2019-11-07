import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 构建组：游荡的野指针
 * 作者：hekiraku
 * 邮箱:1239407570@qq.com
 * 日期:2019/10/30
 * 功能说明：
 * git地址：https://github.com/kowasaretaneko17/
 */
public class num18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if(nums.length<4){
            //没有符合要求的四个数
            return ans;
        }
        for(int i = 0;i<nums.length-3;i++){
            //最小的比目标大，直接返回
            if(nums[i]>target){
                return ans;
            }

            for(int j = i+1;j<nums.length;j++){
                if(j>1&&nums[j]==nums[j-1]){
                    continue;
                }
                int l = j+1;
                int r = nums.length-1;
                while(l<r){
                    int sum = nums[i]+nums[j]+nums[l]+nums[r];
                    if(r<nums.length-1&&nums[r]==nums[r+1]||sum>target){
                        r--;
                    }else
                    if(l>j+1&&nums[l]==nums[l-1]||sum<target){
                        l++;
                    }else {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[l++]);
                        temp.add(nums[r--]);
                        ans.add(temp);
                    }

                }
            }
        }
        return ans;
    }
}
