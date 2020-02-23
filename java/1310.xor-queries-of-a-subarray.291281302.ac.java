class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] sum = new int[arr.length+1];
        
        sum[1] = arr[0];
        for (int i=2; i<=arr.length; i++) {
            sum[i] = sum[i-1] ^ arr[i-1];
            System.out.println(sum[i]);
        }
        
        int size = 0;
        int[] ans = new int[queries.length];
        for (int[] q: queries) 
            ans[size++] = sum[q[1]+1] ^ sum[q[0]];
        return ans;
    }
}
