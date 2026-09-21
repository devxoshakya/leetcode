class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        count = {}
        for i, num in enumerate(arr):
            key = abs(num - x)
            if key not in count:
                count[key] = []
            count[key].append(i)
        
        ans = []

        for key in sorted(count):
            for element in count[key]:
                if len(ans) == k:
                    break
                ans.append(arr[element])

            if len(ans) == k:
                break
        return sorted(ans)