interface IArrayWrapper {
    valueOf() : number;
    toString() : string;
}

class ArrayWrapper implements IArrayWrapper {

    private val : number;
    private str : string;
    
    constructor(nums: number[]) {
        this.val = nums.reduce((a,c) => a + c, 0);
        this.str = `[${nums.toString()}]`;
    }
    
    valueOf(): number {
        return this.val;
    }
    
    toString(): string {
        return this.str;
    }
};

/**
 * const obj1 = new ArrayWrapper([1,2]);
 * const obj2 = new ArrayWrapper([3,4]);
 * obj1 + obj2; // 10
 * String(obj1); // "[1,2]"
 * String(obj2); // "[3,4]"
 */