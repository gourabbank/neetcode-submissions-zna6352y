class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray())
        {
            if(Character.isLetterOrDigit(ch)) sb.append(Character.toLowerCase(ch));
        }
        String str=sb.toString();
        int l=str.length();
        int i=0;
        while(i<l/2)
        {
            if(str.charAt(i)!=str.charAt(l-i-1)) return false;
            i++;
        }
        return true;
    }
}
