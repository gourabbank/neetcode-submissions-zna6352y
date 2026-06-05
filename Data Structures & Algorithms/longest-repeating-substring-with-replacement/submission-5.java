class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map=new HashMap<>();
        int maxL=0;
        int l=0;
        int sol=0;
        for(int r=0;r<s.length();r++)
        {
            char ch=s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxL=Math.max(maxL,map.get(ch));
            while(r-l+1>maxL+k)
            {
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }
            sol=Math.max(sol,r-l+1);
        }
        return sol;
    }
}
