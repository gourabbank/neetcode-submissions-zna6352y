class Solution {
    public String longestPalindrome(String s) {
        int res=0,idx=0;
        for(int i=0;i<s.length();i++)
        {
            int l=i,r=i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
            {
                if(r-l+1>res)
                {
                    res=r-l+1;
                    idx=l;
                }
                l--;
                r++;
            }
            l=i;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
            {
                if(r-l+1>res)
                {
                    res=r-l+1;
                    idx=l;
                }
                l--;
                r++;
            }
        }
        return s.substring(idx,idx+res);
    }
}
