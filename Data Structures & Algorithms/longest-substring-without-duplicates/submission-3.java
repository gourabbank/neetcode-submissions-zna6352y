class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int max=0;
        int l=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            while(set.contains(ch))
            {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(ch);
            max=Math.max(max,i-l+1);
        }
        return max;
    }
}
