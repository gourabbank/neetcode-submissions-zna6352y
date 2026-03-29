class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> sol=new ArrayList<>();
        if(digits.length()==0) return sol;
        Map<Character,String> map=Map.of(
            '2',"abc",
            '3',"def",
            '4',"ghi",
            '5',"jkl",
            '6',"mno",
            '7',"pqrs",
            '8',"tuv",
            '9',"wxyz"
        );
        backtrack(0,sol,map,new StringBuilder(),digits);
        return sol;
    }
    public void backtrack(int idx, List<String> sol, Map<Character,String> map, StringBuilder sb, String digits)
    {
        if(sb.length()==digits.length())
        {
            sol.add(sb.toString());
            return;
        }
        for(int i=idx;i<digits.length();i++)
        {
            String s=map.get(digits.charAt(i));
            for(char ch:s.toCharArray())
            {
                sb.append(ch);
                backtrack(i+1,sol,map,sb,digits);
                sb.deleteCharAt(sb.length()-1);
            }
        }

    }
}
