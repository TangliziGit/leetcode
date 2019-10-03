class Solution {
    private int[][] matrix;
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length==0 || matrix[0].length==0) return false;
        this.matrix = matrix;
        return binarySearchItem(binarySearchRow(target), target);
    }
    
    int binarySearchRow(int tar){
        int l=0, r=matrix.length-1;
        while (l<r){
            int mid=(l+r)/2;
            if (matrix[mid][0] < tar) l=mid+1;
            else r=mid;
        }
        
        for (int i=Math.min(r+2, matrix.length-1); i>=Math.max(0, l-2); i--)
            if (matrix[i][0]<=tar) return i;
        return -1;
    }
    
    boolean binarySearchItem(int row, int tar){
        if (row == -1) return false;
        
        int l=0, r=matrix[row].length-1;
        while (l<r){
            int mid=(l+r)/2;
            if (matrix[row][mid] < tar) l=mid+1;
            else r=mid;
        }
        
        for (int i=Math.min(r+2, matrix[row].length-1); i>=Math.max(0, l-2); i--)
            if (matrix[row][i]==tar) return true;
        return false;
    }
}
