class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length==0 || matrix[0].length==0) return;
        
        boolean row0 = false;
        for (int x=0; x<matrix[0].length; x++)
            if (matrix[0][x]==0) row0=true;
        for (int y=1; y<matrix.length; y++)
            for (int x=0; x<matrix[y].length; x++) if (matrix[y][x]==0)
                matrix[y][0]=matrix[0][x]=0;
                
        for (int y=1; y<matrix.length; y++)
            for (int x=1; x<matrix[y].length; x++) if (matrix[y][0]==0 || matrix[0][x]==0)
                matrix[y][x]=0;
        
        if (matrix[0][0]==0) for (int y=0; y<matrix.length; y++)
            matrix[y][0]=0;
        if (row0) for (int x=0; x<matrix[0].length; x++)
            matrix[0][x]=0;
    }
}
