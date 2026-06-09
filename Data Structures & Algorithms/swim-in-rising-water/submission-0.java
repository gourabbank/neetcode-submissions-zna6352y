class Solution {
    class UnionFind
    {
        int[] parent;
        public UnionFind(int size)
        {
            this.parent=new int[size];
            for(int i=0;i<size;i++)
            {
                parent[i]=i;
            }
        }
        public int find(int i)
        {
            if(parent[i]==i) return i;
            return find(parent[i]);
        }
        public void union(int i, int j)
        {
            int iRep=find(i);
            int jRep=find(j);
            if(iRep==jRep) return;
            parent[iRep]=jRep;
            return;
        }
        
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        UnionFind uf=new UnionFind(n*n);
        int[][] cells=new int[n*n][2];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                cells[grid[i][j]]=new int[]{i,j};
            }
        }
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        for(int t=0;t<n*n;t++)
        {
            int r=cells[t][0],c=cells[t][1];
            for(int[] d:dirs)
            {
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr<0 || nc<0 || nr>=n || nc>=n) continue;
                if(grid[nr][nc]<=t)
                {
                    uf.union(r*n+c,nr*n+nc);
                }
            }
            if(uf.find(0)==uf.find(n*n-1)) return t;
        }
        return n*n-1;
    }
}
