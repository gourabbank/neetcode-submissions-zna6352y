class Solution {
    public boolean isAnagram(String s, String t) {
        int[] a=new int[26];
        int[] b=new int[26];
        for(char ch:s.toCharArray())
        {
            a[ch-'a']++;
        }
        for(char ch:t.toCharArray())
        {
            b[ch-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(a[i]!=b[i]) return false;
        }
        return true;
    }
}
