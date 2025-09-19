# class Solution:
#     def isValid(self, s: str) -> bool:

input_ = "()"
pairs = {")": "(", "]": "[", "}": "{"}  
null_list = []


class Solution:
    def isvalid(self, s:str) -> bool:
        stack = []
        pairs = {")": "(", "]": "[", "}": "{"} 

        for i in input_:
            if i in pairs.values[i]:
                null_list.append(i)
            elif i in pairs:
                if not stack or stack[-1] != pairs[i]:
                    return False
        return not stack
            


    