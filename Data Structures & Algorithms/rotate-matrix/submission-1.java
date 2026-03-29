class Solution {
    public void rotate(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        //int[][] newMatrix=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=i;j<n;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<m;i++)
        {
            int l=0,r=m-1;
            while(l<r)
            {
                int temp=matrix[i][l];
                matrix[i][l]=matrix[i][r];
                matrix[i][r]=temp;
                l++;
                r--;
            }
        }
    }
}