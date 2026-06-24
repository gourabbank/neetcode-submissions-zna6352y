class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()) map.put(ch,map.getOrDefault(ch,0)+1);
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for (int freq : map.values()) {
            if (freq > (s.length() + 1) / 2) return "";
        }
        for(char ch:map.keySet()) pq.offer(ch);
        StringBuilder sb=new StringBuilder();
        char prevChar='#';
        int prevFreq=0;
        while(!pq.isEmpty())
        {
            char curr=pq.poll();
            sb.append(curr);
            map.put(curr,map.get(curr)-1);
            if(prevFreq>0) pq.offer(prevChar);
            prevChar=curr;
            prevFreq=map.get(curr);
        }
        return sb.toString();
    }
}