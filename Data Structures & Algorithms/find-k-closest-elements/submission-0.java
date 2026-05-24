class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> sol=new ArrayList<>();
        for(int n:arr) sol.add(n);   
        sol.sort((a,b)->
            {
                int diff=Math.abs(a-x) - Math.abs(b-x);
               return diff==0?Integer.compare(a,b):diff;
            }
        );
        List<Integer> result=sol.subList(0,k);
        Collections.sort(result);
        return result;
    }
}