class Solution {
    public boolean lemonadeChange(int[] bills) {
        int total=0;
        int ten=0, five=0;
        for(int i=0;i<bills.length;i++)
        {
            int b=bills[i];
            if(b==5)
            {
                five++;
            }
            else if(b==10)
            {
                five--;
                ten++;
            }
            else if(ten>0)
            {
                five--;
                ten--;
            }
            else
            {
                five-=3;
            }
            if(five<0)
            {
                return false;
            }
        }
        return true;
    }
}