// 1. O(n^2)
// 2. O(nlogn)
//      a. BST从后向前区间更新最高高度（覆盖），然后从前遍历；再反向计算，取最大值
//      b. 二叉搜索树
// 3. O(n)
//      两边夹

class Solution {
    public int maxArea(int[] height) {
        int l=0, r=height.length-1, ans=0;
        while (l<r){
            int area=Math.min(height[l], height[r])*(r-l);
            ans=Math.max(ans, area);
            if (height[l]<height[r]) l++;
            else r--;
        }return ans;
    }
}
