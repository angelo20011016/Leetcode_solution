from typing import List
nums = [2,2,1]
null_dict = {}
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        for i in nums:
            if i not in null_dict:
                null_dict[i]=1
            else:
                null_dict[i]=2
        single_key = next(k for k, v in null_dict.items() if v == 1)
        print(single_key)   # b
