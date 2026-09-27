class MinStack:

    def __init__(self):
        self.s = []

    def push(self, val: int) -> None:
        min_val = self.getMin()
        if min_val == None or min_val > val:
            min_val = val
        self.s.append([val,min_val])

    def pop(self) -> None:
        self.s.pop()

    def top(self) -> int:
        return self.s[-1][0] if self.s else None

    def getMin(self) -> int:
        return self.s[-1][1] if self.s else None
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(value)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()