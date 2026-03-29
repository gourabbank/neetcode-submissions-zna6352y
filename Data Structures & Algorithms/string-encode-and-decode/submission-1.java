class Solution {
    StringBuilder sb;
    List<String> sol;
    public String encode(List<String> strs) {
        sb=new StringBuilder();
        for(String s:strs)
        {
            int l=s.length();
            sb.append(l);
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        sol=new ArrayList<>();
        sb=new StringBuilder();
        int i=0;
        while(i<str.length())
        {
            int j=i;
            while(str.charAt(j)!='#') j++;
            int len=Integer.parseInt(str.substring(i,j));
            j++;
            String word=str.substring(j,j+len);
            sol.add(word);
            i=j+len;
        }
        return sol;
    }
}
