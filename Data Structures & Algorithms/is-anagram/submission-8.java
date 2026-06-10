class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] a=new int[26];
        for(char ch:s.toCharArray())
        {
            a[ch-'a']++;
        }
        for(char ch:t.toCharArray())
        {
            a[ch-'a']--;
        }
        for(int i=0;i<26;i++)
        {
            if(a[i]!=0) return false;
        }
        return true;
    }
}
