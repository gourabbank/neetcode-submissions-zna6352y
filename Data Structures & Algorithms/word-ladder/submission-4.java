class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> q=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        q.offer(beginWord);
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
                        chars[j]=ch;
                        String next=new String(chars);
                        if(!visited.contains(next) && set.contains(next))
                        {
                            q.offer(next);
                            visited.add(next);
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
