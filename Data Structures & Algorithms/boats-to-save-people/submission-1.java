class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l=0,r=people.length-1;
        int ans=0;
        while(l<=r)
        {
            int rem=limit-people[r];
            ans++;
            r--;
            if(l<=r && rem>=people[l])
            {
                l++;
            }
        }
        return ans;
    }
}