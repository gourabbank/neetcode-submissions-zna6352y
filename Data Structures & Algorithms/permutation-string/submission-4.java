class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1=s1.length();
        int l2=s2.length();
        if(l1>l2) return false;
        int[] chars=new int[26];
        for(char ch:s1.toCharArray())
        {
            chars[ch-'a']++;
        }
        for(int r=0;r<=s2.length()-l1;r++)
        {
            if(check(chars,s2.substring(r,r+l1))) return true;
        }
        return false;
    }


    public boolean check(int[] chars, String s)
    {
        int[] arr=new int[26];
        for(char ch:s.toCharArray())
        {
            arr[ch-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(chars[i]!=arr[i]) return false;
        }
        return true;
    }
}
