class Solution {
    public int[] finalPrices(int[] prices) {
        
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<prices.length; i++){
            while(!s.isEmpty() && prices[i] <= prices[s.peek()]){
                int idx = s.pop();
                prices[idx] -= prices[i];
            }
            s.push(i);
        }
        return prices;
    }
}

// stack = empty

// for i = 0 to n-1:
//     while stack not empty AND prices[i] <= prices[stack.top]:
//         idx = stack.pop()
//         prices[idx] = prices[idx] - prices[i]

//     push i onto stack

// return prices