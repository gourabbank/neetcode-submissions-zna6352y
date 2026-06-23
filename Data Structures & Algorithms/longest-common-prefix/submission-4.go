func longestCommonPrefix(strs []string) string {
    prefix:=strs[0]
    ans:=""
    for i,ch:=range prefix{
        for j :=range strs{
            if i>=len(strs[j]) || ch!=rune(strs[j][i]){
                return ans
            }
        }
        ans+=string(ch)
    }
    return ans
}
