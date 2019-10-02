class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        int row=n, col=n;
        int x=0, y=0, rowDir=1, colDir=1, size=1;

        while (size!=n*n+1){
            for (int i=0; i<row; i++)
                matrix[y][x+i*rowDir]=size++; // ans.add(matrix[y][x+i*rowDir]);
            x+=rowDir*(row-1); y+=colDir;
            col--; row--; rowDir*=-1;
            for (int i=0; i<col; i++)
                matrix[y+i*colDir][x]=size++; // ans.add(matrix[y+i*colDir][x];
            y+=colDir*(col-1); x+=rowDir;
            colDir*=-1;
        }
        return matrix;
    }
}
