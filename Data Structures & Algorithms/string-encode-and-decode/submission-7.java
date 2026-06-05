class Solution {

    public String encode(List<String> strs) {
        StringBuilder s=new StringBuilder();
        for(String str:strs)
        {
            s.append(str.length());
            s.append("#");
            s.append(str);
        }
        return s.toString();
    }

    public List<String> decode(String str) {
        List<String> sol=new ArrayList<>();
        int i=0;
        while(i<str.length())
        {
            int j=i;
            while(str.charAt(j)!='#') j++;
            int len=Integer.parseInt(str.substring(i,j));
            j++;
            sol.add(str.substring(j,j+len));
            i=j+len;
        }
        return sol;
    }
}
