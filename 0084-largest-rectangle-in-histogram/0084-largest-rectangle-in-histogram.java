class Solution {
    public int largestRectangleArea(int[] heights) {
         Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        stack.push(0);
        for(int i=1; i<heights.length; i++){
            while (!stack.isEmpty() && (stack.peek() == null || heights[stack.peek()] > heights[i])){
                maxArea = getMAX(heights, stack, maxArea, i);
                
            }
            stack.push(i);
        }
        int i = heights.length;
        while(!stack.isEmpty()){
            maxArea = getMAX(heights, stack, maxArea, i);
        }
        return maxArea;
    }
    private int getMAX(int[] heights, Stack<Integer> stack, int maxArea, int i) {
        int area;
        int popped = stack.pop();
        if(stack.isEmpty()){
            area = heights[popped] * i;
        }else{
            area = heights[popped] * (i - stack.peek() - 1);
        }
        return Math.max(maxArea, area); 
    }
}