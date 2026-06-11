class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map=new HashMap<>();
        int l=0;
        int maxL=0;
        int freq=0;
        for(int r=0;r<s.length();r++)
        {
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            freq=Math.max(map.get(s.charAt(r)),freq);
            while(r-l+1>freq+k)
            {
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }
            maxL=Math.max(r-l+1,maxL);
        }
        return maxL;
    }
}
