class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();

        for (String x : operations) {
            if (x.equals("+")) {
                int a = s.pop();
                int b = s.peek();
                int sum = a + b;
                s.push(a);
                s.push(sum);

            } else if (x.equals("D")) {
                s.push(2 * s.peek());

            } else if (x.equals("C")) {
                s.pop();

            } else {
                s.push(Integer.parseInt(x));
            }
        }

        int result = 0;
        for (int val : s) result += val;

        return result;
    }
}