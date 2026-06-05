class Solution {
    public String minWindow(String s, String t) {
        int l=0;
        Map<Character,Integer> needed=new HashMap<>();
        for(char c:t.toCharArray()) needed.put(c,needed.getOrDefault(c,0)+1);
        Map<Character,Integer> window=new HashMap<>();
        int minLen=Integer.MAX_VALUE;
        int formed=0;
        String ans="";
        for(int r=0;r<s.length();r++)
        {
            char ch=s.charAt(r);
            window.put(ch,window.getOrDefault(ch,0)+1);
            if(needed.containsKey(ch) && window.get(ch).equals(needed.get(ch))) formed++;
            while(formed==needed.size())
            {
                if(r-l+1<minLen)
                {
                    minLen=r-l+1;
                    ans=s.substring(l,r+1);
                }
                char lc=s.charAt(l);
                window.put(lc,window.get(lc)-1);
                if(needed.containsKey(lc) && window.get(lc) < needed.get(lc)) formed--;
                l++;
            }
        }
        return ans;
    }
}
