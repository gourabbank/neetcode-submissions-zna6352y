func getConcatenation(nums []int) []int {
    ans:=make([]int, 0, 2*len(nums))
    for i:=0; i<2;i++{
        for _,num :=range nums{
            ans=append(ans,num)
        }
    }
    return ans
}
