class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> sol=new ArrayList<>();
        backtrack(0,new ArrayList<>(),sol,s);
        return sol;
    }
    public void backtrack(int idx, List<String> curr, List<List<String>> sol, String s)
    {
        if(idx==s.length())
        {
            sol.add(new ArrayList<>(curr));
        }
        for(int i=idx;i<s.length();i++)
        {
            String sub=s.substring(idx,i+1);
            if(isPalindrome(sub))
            {
                curr.add(sub);
                backtrack(i+1,curr,sol,s);
                curr.removeLast();
            }
        }
    }
    public boolean isPalindrome(String s)
    {
        if (s == null || s.length() < 2) 
        {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
