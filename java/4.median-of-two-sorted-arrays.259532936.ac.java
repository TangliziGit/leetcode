class Solution {
    private int[] a, b;
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        this.a=nums1; this.b=nums2;
        int n=nums1.length, m=nums2.length;
        
        if (n==0 && m==0) return 0;
        int left=findKth(0, 0, (n+m-1)/2+1), right=findKth(0, 0, (n+m)/2+1);
        return (left+right)/(double)2;
    }
    
    public int findKth(int ai, int bi, int k){
        if (bi>=b.length) return a[ai+k-1];
        if (ai>=a.length) return b[bi+k-1];
        if (k==1) return Math.min(a[ai], b[bi]);
        
        int aMid=Integer.MAX_VALUE, bMid=Integer.MAX_VALUE;
        if (ai+k/2-1<a.length) aMid=a[ai+k/2-1];
        if (bi+k/2-1<b.length) bMid=b[bi+k/2-1];
        
        if (aMid<bMid)
            return findKth(ai+k/2, bi, k-k/2);
        else return findKth(ai, bi+k/2, k-k/2);
    }
}
