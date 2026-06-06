class Solution {
    class UnionFind{
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
        public boolean union(int i, int j)
        {
            int irep=find(i);
            int jrep=find(j);
            if(irep==jrep) return true; //cycle
            parent[irep]=jrep;
            return false;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;
        UnionFind uf=new UnionFind(n);
        for(int[] e:edges)
        {
            if(uf.union(e[0],e[1])) return false;
        }
        return true;
    }
}
