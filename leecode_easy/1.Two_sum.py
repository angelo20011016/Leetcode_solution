class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """


        empty_dict = {}
        for i,num in enumerate(nums):
            residual_num = target - num
            if residual_num in empty_dict:
                return [empty_dict[residual_num],i]
            else:
                empty_dict[num] = i