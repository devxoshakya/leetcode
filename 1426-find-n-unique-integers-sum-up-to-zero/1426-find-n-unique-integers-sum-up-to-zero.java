class Solution {
    public int[] sumZero(int n) {
        int[] ansArray=new int[n];
        if(n%2==0){    
            for(int c=0;c<n/2;c++){
                ansArray[c]=c+1;
                ansArray[n/2+c]=-( ansArray[c]);
            }
        }
        else{
            ansArray[n/2]=0;
            for(int c=0;c<n/2;c++){
                ansArray[c]=c+1;
                ansArray[n/2+c]=-( ansArray[c]);
            }

        }
        return ansArray;

    }
}