class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        if len(s) != len(goal):
            return False
        length = len(s)

       
        for _ in range(length):

            s = s[1:] + s[0]
            if s == goal:
                return True
        return False
    
    # Check if lengths of both strings are equal
# If lengths are different → rotation is impossible → return False

# Combine string s with itself (s + s)
# All possible rotations of s will exist inside (s + s)

# Check if goal string is a substring of (s + s)
# If yes → goal can be formed by shifting s → return True

# Otherwise → return False


# def rotateString(s, goal):
  #  if len(s) != len(goal):
   #     return False
    
   # return goal in (s + s)