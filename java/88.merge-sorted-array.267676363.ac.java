class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list=new LinkedList<>();
        int i=0, j=0;
        while (i<m && j<n){
            if (nums1[i] < nums2[j]) list.add(nums1[i++]);
            else list.add(nums2[j++]);
        }
        while (i<m) list.add(nums1[i++]);
        while (j<n) list.add(nums2[j++]);
        
        i=0;
        for (Integer x: list) nums1[i++]=x;
    }
}
