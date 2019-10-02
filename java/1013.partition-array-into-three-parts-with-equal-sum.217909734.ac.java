class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        if (A==null || A.length<3) return false;
        int[] sum=new int[A.length];
        
        sum[0]=A[0];
        for (int i=1; i<A.length; i++)
            sum[i]=sum[i-1]+A[i];
        
        for (int i=0; i<A.length; i++){
            for (int j=i+1; j<A.length; j++){
                if (sum[i]==sum[j]-sum[i] && sum[j]-sum[i]==sum[A.length-1]-sum[j])
                    return true;
            }
        }return false;
    }
}
