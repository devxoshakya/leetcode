class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> l = new ArrayList<>();
        int i = 1;
        while ( i <= n){
            if(i % 3 == 0 && i % 5 == 0){
                l.add("FizzBuzz");
            } else if (i % 3 == 0) {
                l.add("Fizz");
            } else if ( i % 5 == 0){
                l.add("Buzz");
            } else {
                l.add(Integer.toString(i));
            }

           i++;
        }
        return l;
    }
}