class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> currMap=new HashMap<>();
        Map<Character,Integer> reqMap=new HashMap<>();
        int l=0;
        int r=0;
        int minL=Integer.MAX_VALUE;
        int currL=0;
        String sol="";
        int formed=0;
        for(char ch:t.toCharArray()) reqMap.put(ch,reqMap.getOrDefault(ch,0)+1);
        int required=reqMap.size();
        while(r<s.length())
        {
            char ch=s.charAt(r);
            currMap.put(ch,currMap.getOrDefault(ch,0)+1);
            if(reqMap.containsKey(ch) && currMap.get(ch)==reqMap.get(ch)) formed++;
            while(formed==required)
            {
                if(r-l+1<minL)
                {
                    minL=r-l+1;
                    sol=s.substring(l,r+1);
                }
                currMap.put(s.charAt(l),currMap.get(s.charAt(l))-1);
                if(reqMap.containsKey(s.charAt(l)) && currMap.get(s.charAt(l))<reqMap.get(s.charAt(l)))
                {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return sol;
    }
}
