class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();
        Set<String> visited=new HashSet<>();
        for(String s:wordList) set.add(s);
        int ans=0;
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int steps=1;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int j=0;j<size;j++)
            {
                String currWord=q.poll();
                if(currWord.equals(endWord)) return steps;
                char[] chars=currWord.toCharArray();
                for(int i=0;i<chars.length;i++)
                {
                    char og=chars[i];
                    for(char c='a';c<='z';c++)
                    {
                        chars[i]=c;
                        String next=new String(chars);
                        if(!visited.contains(next) && set.contains(next))
                        {
                            q.offer(next);
                            visited.add(next);
                        }
                    }
                    chars[i]=og;
                }
            }
            steps++;
        }
        return 0;
    }
}
