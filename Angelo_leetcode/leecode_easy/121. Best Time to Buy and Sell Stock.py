from typing import List
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        a = prices[0]
        profit = []
        for i in prices:
            if i < a :
                a=i   
            if i > a:
                profit.append(i-a)
        print(max(profit))
a = Solution()
a.maxProfit([7,1,5,3,6,4])




prices = [7,1,5,3,6,4]

#Input: prices = [7,1,5,3,6,4]
#Output: 5

#條件1 最小值 跟 最小值之後的最大價差
#邊迴圈邊找最小值
#如果最小值是最後一個 print(0)