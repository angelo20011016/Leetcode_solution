def isPalindrome(x: int) -> bool:
    if x < 0:
        return False
    
    original, rev = x, 0
    step = 1
    while x > 0:
        digit = x % 10
        print(f"Step {step}:")
        print(f"  digit = {digit}")
        print(f"  rev(before) = {rev}")
        
        rev = rev * 10 + digit
        x //= 10
        
        print(f"  rev(after)  = {rev}")
        print(f"  x(after)    = {x}")
        print("-" * 20)
        step += 1

    print(f"original = {original}, rev = {rev}")
    return original == rev


print(isPalindrome(121))
print(isPalindrome(-121))
print(isPalindrome(10))