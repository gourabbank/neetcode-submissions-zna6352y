class Solution {
    public String longestPalindrome(String s) {
        int l=0,r=0;
        int maxL=0;
        int i=0;
        int idx=0;
        while(i<s.length())
        {
            l=i;
            r=i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
            {
                if(r-l+1>maxL)
                {
                    maxL=r-l+1;
                    idx=l;
                }
                l--;
                r++;
            }
            l=i;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
            {
                if(r-l+1>maxL)
                {
                    maxL=r-l+1;
                    idx=l;
                }
                l--;
                r++;
            }
            i++;
        }
        return s.substring(idx,idx+maxL);
    }
}
