class Solution {
    StringBuilder sb=new StringBuilder();

    public String encode(List<String> strs) {
        for(String s:strs)
        {
            sb.append(s.length());
            sb.append('#');
            sb.append(s);
        }
        return sb.toString();
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
