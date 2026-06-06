class WordDictionary {
    class Trie{
        Trie[] children=new Trie[26];
        boolean isEnd=false;
    }
    Trie root;
    public WordDictionary() {
        this.root=new Trie();
    }

    public void addWord(String word) {
        Trie curr=root;
        for(char ch:word.toCharArray())
        {
            int idx=ch-'a';
            if(curr.children[idx]==null) curr.children[idx]=new Trie();
            curr=curr.children[idx];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        return find(word,0,root);
    }
    public boolean find(String word, int i, Trie node)
    {
        if(i==word.length()) return node.isEnd;
        char ch=word.charAt(i);
        if(ch=='.')
        {
            for(Trie t:node.children)
            {
                if(t!=null && find(word,i+1,t)) return true;  
            }
            return false;
        }
        else
        {
            int idx=ch-'a';
            if(node.children[idx]==null) return false;
            return find(word,i+1,node.children[idx]);
        }
    }
}
