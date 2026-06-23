func majorityElement(nums []int) int {
    count:=0
    prev:=nums[0]
    for _,n:=range nums{
        if n==prev{
            count++
        }else{
            count--
            if count==0{
                prev=n
                count=1
            }
        }
    }
    return prev
}
