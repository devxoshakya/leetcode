class MyHashSet:

    def __init__(self):
        self.size = 10000
        self.chain = [[] for _ in range(self.size)]

    def add(self, key: int) -> None:
        hash = key % self.size

        if key not in self.chain[hash]:
            self.chain[hash].append(key)

    def remove(self, key: int) -> None:
        hash = key % self.size

        if key in self.chain[hash]:
            self.chain[hash].remove(key)

    def contains(self, key: int) -> bool:
        hash = key % self.size
        return key in self.chain[hash]