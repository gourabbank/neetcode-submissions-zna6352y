class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int l=s1.length();
        int[] a=new int[26];
        int[] b=new int[26];
        for(int i=0;i<s1.length();i++)
        {
            a[s1.charAt(i)-'a']++;
            b[s2.charAt(i)-'a']++;
        }
        int left=0;
        if(check(a,b)) return true;
        for(int right=l;right<s2.length();right++)
        {
            b[s2.charAt(left)-'a']--;
            left++;
            b[s2.charAt(right)-'a']++;
            if(check(a,b)) return true;
        }
        return false;
    }
    


    public boolean check(int[] a, int[] b)
    {
        for(int i=0;i<a.length;i++)
        {
            if(a[i]!=b[i]) return false;
        }
        return true;
    }
}
