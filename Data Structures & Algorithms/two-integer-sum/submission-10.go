func twoSum(nums []int, target int) []int {
    m:=make(map[int]int)
    for i,n :=range nums{
        comp:=target-n
        if index, ok:=m[comp]; ok{
            return []int{index,i}
        }
        m[n]=i
    }
    return []int{}
}
