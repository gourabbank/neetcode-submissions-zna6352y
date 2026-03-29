class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top=0;
        int bottom=matrix.length-1;
        while(top<=bottom)
        {
            int midHeight=(top+bottom)/2;
            int left=0;
            int right=matrix[0].length-1;
            if(target>=matrix[midHeight][left] && target<=matrix[midHeight][right])
            {
                while(left<=right)
                {
                    int mid=(left+right)/2;
                    if(matrix[midHeight][mid]==target) return true;
                    else if(matrix[midHeight][mid]<target) left=mid+1;
                    else right=mid-1;
                }
                return false;
            }
            else if(matrix[midHeight][0]<target)
            {
                top=midHeight+1;
            }
            else
            {
                bottom=midHeight-1;
            }
        }
        return false;
    }
}
