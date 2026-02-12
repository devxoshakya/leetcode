type MultiDimensionalArray = (number | MultiDimensionalArray)[];

var flat = function (arr:  MultiDimensionalArray, n: number):  MultiDimensionalArray {
    if(n === 0) return arr;

    const answer : MultiDimensionalArray = [];

    for ( let i=0; i < arr.length; i++){
        if ( n>0 && Array.isArray(arr[i])){
            answer.push(...flat(arr[i] as MultiDimensionalArray,n-1));
        } else {
            answer.push(arr[i]);
        }
    }

    return answer;
};