class WordDictionary {
    class TreeNode{
        TreeNode[] children=new TreeNode[26];
        boolean isEnd=false;
    }
    private TreeNode root;
    public WordDictionary() {
        this.root=new TreeNode();
    }

    public void addWord(String word) {
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
        return dfs(word,0,root);
    }
    public boolean dfs(String word,int j, TreeNode root)
    {
        TreeNode curr=root;
        for(int i=j;i<word.length();i++)
        {
            char ch=word.charAt(i);
            if(ch=='.')
            {
                for(TreeNode child:curr.children)
                {
                    if(child!=null && dfs(word,i+1,child)) return true;
                }
                return false;
            }
            else
            {
                int idx=ch-'a';
                if(curr.children[idx]==null) return false;
                curr=curr.children[idx];
            }
        }
        return curr.isEnd;
    }
}
