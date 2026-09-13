import random

class RandomizedSet:

    def __init__(self):
        self.values = []
        self.index = {}

    def insert(self, val: int) -> bool:
        if val in self.index:
            return False

        self.index[val] = len(self.values)
        self.values.append(val)

        return True

    def remove(self, val: int) -> bool:
        if val not in self.index:
            return False

        idx = self.index[val]
        last = self.values[-1]

        # Move last element into the removed element's position
        self.values[idx] = last
        self.index[last] = idx

        # Remove last element
        self.values.pop()
        del self.index[val]

        return True

    def getRandom(self) -> int:
        return random.choice(self.values)