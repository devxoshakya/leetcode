class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i=0; i<image.length; i++){
             for(int j = 0; j < (image[i].length +1)/2 ; j++){
                //reversing the array and doing XOR 1 to get complement of flipped number.
               int temp = image[i][j] ^ 1;
               image[i][j] = image[i][image[0].length-j-1] ^ 1;
               image[i][image[0].length-j-1] = temp;
            }
        }
        return image;
    }
}