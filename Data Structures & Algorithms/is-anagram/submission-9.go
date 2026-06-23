func isAnagram(s string, t string) bool {
    a:=make([]int,26)
    b:=make([]int,26)
    for _,ch :=range s{
        a[ch-'a']++
    }
    for _,ch :=range t{
        b[ch-'a']++
    }
    for i:=range 26{
        if a[i]!=b[i]{
            return false
        }
    }
    return true;
}
