class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int l=0;
        int maxL=0;
        for(int r=0;r<s.length();r++)
        {
            while(set.contains(s.charAt(r)))
            {
                set.remove(s.charAt(l));
                l++;
            }
            maxL=Math.max(maxL,r-l+1);
            set.add(s.charAt(r));
        }
        return maxL;
    }
}
