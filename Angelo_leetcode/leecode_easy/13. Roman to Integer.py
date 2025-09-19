class Solution:
    def romanToInt(self, s: str) -> int:
        ROM_dict = {
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000
        }
        
        count = 0
        for i in range(len(s)):
            # 不是最後一個字元，且當前值 < 下一個值 → 減
            if i < len(s) - 1 and ROM_dict[s[i]] < ROM_dict[s[i+1]]:
                count -= ROM_dict[s[i]]
            else:
                count += ROM_dict[s[i]]
        return count
    


class Solution:
    def romanToInt(self, s: str) -> int:
        ROM_dict = {"I":1,"V":5,"X":10,"L":50,"C":100,"D":500,"M":1000}
        total = 0
        for cur, nxt in zip(s, s[1:]):  # 逐一比對相鄰兩個字元
            if ROM_dict[cur] < ROM_dict[nxt]:
                total -= ROM_dict[cur]
            else:
                total += ROM_dict[cur]
        return total + ROM_dict[s[-1]]  # 最後一個字補上

