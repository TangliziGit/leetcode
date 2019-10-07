class Solution {
    private char[][] matrix;
    private int[] hei;
    private int[] left;
    private int[] right;
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        this.matrix=matrix;
        this.hei = new int[matrix[0].length];
        this.left = new int[matrix[0].length];
        this.right = new int[matrix[0].length];
        
        int ans=0;
        for (int y=matrix.length-1; y>=0; y--){
            for (int x=0; x<matrix[y].length; x++)
                hei[x]=(matrix[y][x]=='0')?0:hei[x]+1;
            ans=Math.max(ans, solveRow());
        }
        return ans;
    }
    
    private int solveRow(){
        left[0]=-1; right[right.length-1]=right.length;
        for (int i=1; i<left.length; i++){
            int ptr=i-1;
            while (ptr>=0 && hei[ptr] >= hei[i]) ptr=left[ptr];
            left[i]=ptr;
        }
        
        for (int i=right.length-2; i>=0; i--){
            int ptr=i+1;
            while (ptr<right.length && hei[ptr] >= hei[i]) ptr=right[ptr];
            right[i]=ptr;
        }
        
        int ans=0;
        for (int i=0; i<hei.length; i++)
            ans=Math.max(ans, (right[i]-left[i]-1)*hei[i]);
        return ans;
    }
}
