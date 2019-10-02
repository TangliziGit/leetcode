class Solution {
    public int trap(int[] hei) {
        if (hei.length==0) return 0;
        int maxidx=0, max=hei[0], sum=0;
        for (int i=0; i<hei.length; i++){
            if (hei[i]>max){
                max=hei[i];
                maxidx=i;
            }
            sum+=hei[i];
        }
        
        int ans=0, h=0;
        for (int i=0; i<maxidx; i++)
            if (h<hei[i]){
                ans+=(maxidx-i)*(hei[i]-h);
                h=hei[i];
            }
        h=0;
        for (int i=hei.length-1; i>maxidx; i--)
            if (h<hei[i]){
                ans+=(i-maxidx)*(hei[i]-h);
                h=hei[i];
            }
        return ans-sum+hei[maxidx];
    }
}
