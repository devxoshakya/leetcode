type Fn<T> = () => Promise<T>

function promiseAll<T>(functions: Fn<T>[]): Promise<T[]> {
    return new Promise((resolve, reject) => {
        const results = new Array(functions.length);
        let count = 0;
        functions.forEach((fn,_) => {
            fn()
            .then(val => {
                results[_]= val;
                count++;
                if(count === functions.length) resolve(results);
            })
            .catch(reason => reject(reason));
        });
    })
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */