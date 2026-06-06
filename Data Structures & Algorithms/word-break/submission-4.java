class Solution {
    class Trie{
        Trie[] children=new Trie[26];
        boolean isEnd=false;
    }
    Trie root=new Trie();
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie curr=root;
        for(String w:wordDict)
        {
            curr=root;
            for(char ch:w.toCharArray())
            {
                int idx=ch-'a';
                if(curr.children[idx]==null) curr.children[idx]=new Trie();
                curr=curr.children[idx];
            }
            curr.isEnd=true;
        }
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=0;i<n;i++)
        {
            if(!dp[i]) continue;
            curr=root;
            for(int j=i;j<n;j++)
            {
                int idx=s.charAt(j)-'a';
                if(curr.children[idx]==null) break;
                curr=curr.children[idx];
                if(curr.isEnd) dp[j+1]=true;
            }
        }
        return dp[n];
    }
}
