class MyHashMap:

    def __init__(self):
        self.size = 13001
        self.chain = [[] for _ in range(self.size)]

    def _hash(self, key):
        return key % self.size

    def put(self, key: int, value: int) -> None:
        bucket = self.chain[self._hash(key)]

        for pair in bucket:
            if pair[0] == key:
                pair[1] = value
                return

        bucket.append([key, value])

    def get(self, key: int) -> int:
        bucket = self.chain[self._hash(key)]

        for k, v in bucket:
            if k == key:
                return v

        return -1

    def remove(self, key: int) -> None:
        bucket = self.chain[self._hash(key)]

        for i, (k, v) in enumerate(bucket):
            if k == key:
                bucket.pop(i)
                return