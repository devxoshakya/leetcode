class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean flag = true;
        for(int i = left; i <= right; i++){
            flag = flag && cover(ranges,i);
        }
        return flag;
    }

    private boolean cover(int[][] ranges, int num){
        boolean flag = false;
        for(int i=0; i < ranges.length; i++){
            if( ranges[i][0] <= num && ranges[i][1] >= num ){
                flag = true;
            }
        }
        return flag;
    }
}