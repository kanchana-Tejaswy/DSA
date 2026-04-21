class UnionFind:
    def __init__(self, n):
        self.fa = list(range(n))
        self.rank = [0] * n

    def find(self, x):
        if self.fa[x] != x:
            self.fa[x] = self.find(self.fa[x])
        return self.fa[x]

    def union(self, x, y):
        x = self.find(x)
        y = self.find(y)
        if x == y:
            return
        if self.rank[x] < self.rank[y]:
            x, y = y, x
        self.fa[y] = x
        if self.rank[x] == self.rank[y]:
            self.rank[x] += 1


class Solution:
    def minimumHammingDistance(
        self,
        source: List[int],
        target: List[int],
        allowedSwaps: List[List[int]],
    ) -> int:
        n = len(source)
        uf = UnionFind(n)
        for a, b in allowedSwaps:
            uf.union(a, b)

        sets = defaultdict(lambda: defaultdict(int))
        for i in range(n):
            f = uf.find(i)
            sets[f][source[i]] += 1

        ans = 0
        for i in range(n):
            f = uf.find(i)
            if sets[f][target[i]] > 0:
                sets[f][target[i]] -= 1
            else:
                ans += 1
        return ans
    
# 1722. Minimize Hamming Distance After Swap Operations
#
# Solved
# Medium
#
# Topics
# Companies
# Hint
#
# You are given two integer arrays, source and target,
# both of length n.
#
# You are also given an array allowedSwaps where
# allowedSwaps[i] = [ai, bi] indicates that you are
# allowed to swap the elements at index ai and index bi
# (0-indexed) of array source.
#
# Note:
# You can swap elements at a specific pair of indices
# multiple times and in any order.
#
# The Hamming distance of two arrays of the same length,
# source and target, is the number of positions where
# the elements are different.
#
# Formally:
# Number of indices i such that
# 0 <= i <= n-1 and source[i] != target[i].
#
# Return the minimum Hamming distance of source and target
# after performing any amount of swap operations on array source.
#
# ------------------------------------------------------------
# Example 1:
#
# Input:
# source = [1,2,3,4]
# target = [2,1,4,5]
# allowedSwaps = [[0,1],[2,3]]
#
# Output:
# 1
#
# Explanation:
# Swap indices 0 and 1 -> source = [2,1,3,4]
# Swap indices 2 and 3 -> source = [2,1,4,3]
#
# Hamming distance = 1 (different at index 3)
#
# ------------------------------------------------------------
# Example 2:
#
# Input:
# source = [1,2,3,4]
# target = [1,3,2,4]
# allowedSwaps = []
#
# Output:
# 2
#
# Explanation:
# No swaps allowed.
# Different positions: index 1 and index 2.
#
# ------------------------------------------------------------
# Example 3:
#
# Input:
# source = [5,1,2,4,3]
# target = [1,5,4,2,3]
# allowedSwaps = [[0,4],[4,2],[1,3],[1,4]]
#
# Output:
# 0
#
# ------------------------------------------------------------
# Constraints:
#
# n == source.length == target.length
# 1 <= n <= 10^5
# 1 <= source[i], target[i] <= 10^5
# 0 <= allowedSwaps.length <= 10^5
# allowedSwaps[i].length == 2
# 0 <= ai, bi <= n - 1
# ai != bi
#
# Seen this question in a real interview before?
# Yes / No
#
# Accepted: 55,523 / 87K
# Acceptance Rate: 63.8%