func groupAnagrams(strs []string) [][]string {
    m:=make(map[string][]string)
    for i:=0; i<len(strs);i++{
        b:=[]byte(strs[i])
        sort.Slice(b,func(j,k int)bool {return b[j]<b[k]})
        key:=string(b)
        m[key]=append(m[key],strs[i])
    }
    ans:=[][]string{}
    for _,group:=range m{
        ans=append(ans,group)
    }
    return ans
}
