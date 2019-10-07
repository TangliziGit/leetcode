class Solution {
    public int largestRectangleArea(int[] hei) {
        if (hei == null || hei.length == 0) return 0;
        int[] left = new int[hei.length];
        int[] right= new int[hei.length];
        
        left[0]=-1; right[hei.length-1]=hei.length;
        for (int i=1; i<hei.length; i++){
            int ptr=i-1;
            while (ptr>=0 && hei[ptr]>=hei[i]) ptr=left[ptr];
            left[i]=ptr;
        }
        
        for (int i=hei.length-2; i>=0; i--){
            int ptr=i+1;
            while (ptr<hei.length && hei[ptr]>=hei[i]) ptr=right[ptr];
            right[i]=ptr;
        }
        
        int ans=0;
        for (int i=0; i<hei.length; i++)
            ans=Math.max(ans, (right[i]-left[i]-1)*hei[i]);
        return ans;
    }
}
