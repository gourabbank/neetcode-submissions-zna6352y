class Solution {
    public String longestCommonPrefix(String[] strs) {
        String key=strs[0];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<key.length();i++)
        {
            for(String s:strs)
            {
                if(s.length()<=i || s.charAt(i)!=key.charAt(i))
                {
                    return sb.toString();
                }
            }
            sb.append(key.charAt(i));
        }
        return sb.toString();
    }
}