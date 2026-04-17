class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        mapy={}
        for s in strs:
            key=tuple(sorted(s))
            if key in mapy:
                mapy[key].append(s)
            else:
                mapy[key]=[s]
        return list(mapy.values())
            
