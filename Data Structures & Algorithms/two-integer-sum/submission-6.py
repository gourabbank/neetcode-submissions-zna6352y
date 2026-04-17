class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mapy={}
        for i in range(len(nums)):
            comp=target-nums[i]
            if comp in mapy:
                return [mapy[comp],i]
            mapy[nums[i]]=i
        return [-1,-1]