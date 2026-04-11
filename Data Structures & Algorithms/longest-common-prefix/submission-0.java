class Solution {
    public String longestCommonPrefix(String[] strs) {
        int curr=0;
        for(int i=0;i<200;i++)
        {
            for(String s:strs)
            {
                if(i==s.length()||s.charAt(i)!=strs[0].charAt(i))
                {
                    return s.substring(0,i);
                }
            }
        }
        return strs[0];
    }
}