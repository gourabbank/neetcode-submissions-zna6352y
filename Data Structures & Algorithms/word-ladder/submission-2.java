class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words=new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        Set<String> visited=new HashSet<>();
        visited.add(beginWord);
        int steps=1;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                String curr=q.poll();
                if(curr.equals(endWord)) return steps;
                char[] chars=curr.toCharArray();
                for(int j=0;j<chars.length;j++)
                {
                    char og=chars[j];
                    for(char ch='a';ch<='z';ch++)
                    {
                        if(ch==og)continue;
                        chars[j]=ch;
                        String next=new String(chars);
                        if(words.contains(next) && !visited.contains(next))
                        {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                    chars[j]=og;
                }
            }
            steps++;
        }
        return 0;
    }
}
