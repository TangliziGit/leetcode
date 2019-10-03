object Solution {
    def setZeroes(matrix: Array[Array[Int]]): Unit = {
        if (matrix == null || matrix.length==0 || matrix(0).length==0) return;
        
        var row0 = false
        for (x <- matrix(0); if (x == 0)) row0=true
        
        for (y <- 1 until matrix.length;
             x <- 0 until matrix(y).length; if (matrix(y)(x)==0)){
            matrix(y)(0)=0; matrix(0)(x)=0
        }
                
        for (y <- 1 until matrix.length;
             x <- 1 until matrix(y).length; if (matrix(y)(0)==0 || matrix(0)(x)==0))
                matrix(y)(x)=0
        
        if (matrix(0)(0)==0) for (y <- 0 until matrix.length)
            matrix(y)(0)=0;
        if (row0) matrix(0)=matrix(0).map(_ => 0);
    }
}
