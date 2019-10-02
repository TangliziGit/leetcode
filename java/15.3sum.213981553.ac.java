// ! 排序两边夹原理
// 设z=x+y;
//  if (z>tar) y<-; else x->;
//  作用：O(n)二元找x+y==z相等（一元找x==z相等用二分）

// 1. O(n^3)
// 2. O(n^2logn): for^2 + binarySearch
// 3. O(n^2+nlogn+n) with a big constant:
//      取得两项和的map，然后遍历，最后去重
// 4. O(n^2+nlogn+2n) with a small constant:
//      排序，得一个元素的对应下标map，若重复取最后
//      for^2 查找，插入HashSet
// 5. O(n^2) with a smaller constant:
//      for x: 两边夹找y+z==-x

class Solution{
    public List<List<Integer>> threeSum(int[] nums) {
        LinkedList<List<Integer>> ans=new LinkedList();
        
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++)
            if (i==0 || nums[i]!=nums[i-1]){
                int l=i+1, r=nums.length-1;
                while (l<r){
                    int sum=nums[l]+nums[r];
                    if (sum==-nums[i]){
                        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l<r && nums[l]==nums[l+1]) l++;
                        while (l<r && nums[r]==nums[r-1]) r--;
                    }
                    if (sum>-nums[i]) r--;
                    else l++;
                }
            }
        return ans;
    } 
}

// O(n^2+nlogn+n) with a small constant:
// class Solution{
//     public List<List<Integer>> threeSum(int[] nums) {
//         Map<Integer, Integer> map=new HashMap();
//         Set<List<Integer>> set=new HashSet();
//         LinkedList<List<Integer>> ans=new LinkedList();
        
//         Arrays.sort(nums);
//         // if duplicated, use the last one
//         for (int i=0; i<nums.length; i++)
//             map.put(nums[i], i);
        
//         for (int i=0; i<nums.length; i++)
//             for (int j=i+1; j<nums.length; j++){
//                 int sum=nums[i]+nums[j];
//                 if (!map.containsKey(-sum)) continue;
//                 if (map.get(-sum)<=j) continue;
//                 set.add(Arrays.asList(nums[i], nums[j], nums[map.get(-sum)]));
//             }
        
//         for (List list: set)
//             ans.add(list);
//         return ans;
//     }
// }


// O(n^2+nlogn) solution:
// class Solution {
    
//     public List<List<Integer>> threeSum(int[] nums) {
//         Map<Integer, List<Pair>> map=new HashMap();
//         Set<List<Integer>> set=new HashSet();
//         ArrayList<List<Integer>> ans=new ArrayList();
        
//         Arrays.sort(nums);
//         for (int i=0; i<nums.length; i++){
//             for (int j=i+1; j<nums.length; j++){
//                 int sum=nums[i]+nums[j];
//                 if (!map.containsKey(sum))
//                     map.put(sum, new LinkedList<Pair>());       // O(1)
                
//                 List<Pair> list=map.get(sum);                   // O(1)
//                 list.add(new Pair(i, j));                       // O(1)?
//             }
//         }
        
//         for (int i=0; i<nums.length; i++){
//             if (!map.containsKey(-nums[i])) continue;
//             for (Pair pair: map.get(-nums[i]))
//                 if (i>pair.y && i!=pair.x && i!=pair.y){
//                     set.add(Arrays.asList(nums[pair.x], nums[pair.y], nums[i]));
//                 }
//         }
        
        
//         for (List<Integer> list: set)
//             ans.add(list);
        
//         return ans;
//     }
    
//     static class Pair{
//         final int x, y;
//         Pair(int x, int y){
//             this.x=x;
//             this.y=y;
//         }
//     }
// }
