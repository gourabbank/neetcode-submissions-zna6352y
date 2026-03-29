class PrefixTree {
    class TreeNode{
        TreeNode[] children=new TreeNode[26];
        boolean isEnd=false;
    }
    private TreeNode root;
    
    public PrefixTree() {
        this.root=new TreeNode();
    }

    public void insert(String word) {
        TreeNode curr=root;
        for(char ch:word.toCharArray())
        {
            int idx=ch-'a';
            if(curr.children[idx]==null) curr.children[idx]=new TreeNode();
            curr=curr.children[idx];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        TreeNode curr=root;
        for(char ch:word.toCharArray())
        {
            int idx=ch-'a';
            if(curr.children[idx]==null) return false;
            curr=curr.children[idx];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TreeNode curr=root;
        for(char ch:prefix.toCharArray())
        {
            int idx=ch-'a';
            if(curr.children[idx]==null) return false;
            curr=curr.children[idx];
        }
        return true;
    }
}
