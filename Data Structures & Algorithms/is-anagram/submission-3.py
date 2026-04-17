class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        l=sorted(s)
        m=sorted(t)
        return l==m

        