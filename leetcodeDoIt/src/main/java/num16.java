import java.util.Arrays;

/**
 * 构建组：游荡的野指针
 * 作者：hekiraku
 * 邮箱:1239407570@qq.com
 * 日期:2019/10/25
 * 功能说明：
 * git地址：https://github.com/kowasaretaneko17/
 */
public class num16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if(nums.length<3){
            throw new IllegalArgumentException("不满足格式，需要至少三个数字");
        }
        int ans = nums[0]+nums[1]+nums[2];
        int gap = Math.abs(target-ans);
        for(int i = 0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(Math.abs(target-sum)<gap){
                    gap = Math.abs(target-sum);
                    ans = sum;
                }
                if(sum>target){
                    right--;
                    while(left<right&&nums[right]==nums[right+1]){
                        right--;
                    }
                }
                else{
                    left++;
                    while(left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                }
                while(i<nums.length-2&&nums[i]==nums[i+1]){
                    i++;
                }
            }
        }
        return ans;
    }
}
