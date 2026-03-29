class WordDictionary {

    class Node{
        Node[] children=new Node[26];
        boolean isEnd=false;
    }

    private Node root;
    
    public WordDictionary() {
        root=new Node();
    }

    public void addWord(String word) {
        Node curr=root;
        for(char ch:word.toCharArray())
        {
            int idx=ch-'a';
            if(curr.children[idx]==null) curr.children[idx]=new Node();
            curr=curr.children[idx];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }

    private boolean dfs(String word, int j, Node root)
    {
        Node curr=root;
        for(int i=j;i<word.length();i++)
        {
            char ch=word.charAt(i);
            if(ch=='.')
            {
                for(Node child:curr.children)
                {
                    if(child!=null && dfs(word,i+1,child))
                    {
                        return true;
                    }
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
