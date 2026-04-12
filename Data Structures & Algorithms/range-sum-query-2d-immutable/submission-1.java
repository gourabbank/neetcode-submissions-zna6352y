class NumMatrix {
    int nums[][];
    public NumMatrix(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        this.nums=new int [rows+1][cols+1];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                nums[i+1][j+1]=matrix[i][j]+nums[i][j+1]+nums[i+1][j]-nums[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=nums[row2+1][col2+1]-nums[row1][col2+1]-nums[row2+1][col1]+nums[row1][col1];
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */