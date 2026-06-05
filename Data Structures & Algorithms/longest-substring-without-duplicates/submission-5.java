class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int maxL=0;
        Set<Character> set=new HashSet<>();
        for(int r=0;r<s.length();r++)
        {
            char ch=s.charAt(r);
            while(set.contains(ch))
            {
                set.remove(s.charAt(l));
                l++;
            }
            maxL=Math.max(maxL,r-l+1);
            set.add(ch);
        }
        return maxL;
    }
}
