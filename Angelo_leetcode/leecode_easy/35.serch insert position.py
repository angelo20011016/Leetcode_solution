 

# Example 1:

# Input: nums = [1,3,5,6], target = 5
# Output: 2
# Example 2:

# Input: nums = [1,3,5,6], target = 2
# Output: 1
# Example 3:

# Input: nums = [1,3,5,6], target = 7
# Output: 4
from typing import List

class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        if target not in nums:
            nums.append(target)
            nums = sorted(nums)
            b = nums.index(target)
            print(b)
        else:
            nums.append(target)
            nums = sorted(nums)
            b = nums.index(target)
            print(b+nums.count(target)-2)

b = Solution()
b.searchInsert(nums = [1,3,5,6], target = 5)