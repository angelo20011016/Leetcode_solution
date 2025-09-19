# class Solution:
#     def longestCommonPrefix(self, strs: List[str]) -> str:
        

strs = ["flower","flow","flight"]
longer_one = 0
ans_ = []
for i in range(len(strs)):
    if len(strs[i]) > longer_one:
        longer_one = len(strs[i]) #6

for y in range(len(longer_one)):
    for x in range(len(strs)):
        if strs[x][y] == strs[x+1][y] == strs[x+2][y]:
            ans_.append()
