class Solution {
    public void setZeroes(int[][] matrix) {
        boolean hasRowZero = false;
        boolean hasColumnZero = false;
        for(int i = 0; i< matrix.length; i++){
            if(matrix[i][0]==0){
                hasColumnZero = true;
                break;
            }
        }
        for(int j = 0; j< matrix[0].length; j++){
            if(matrix[0][j]==0){
                hasRowZero = true;
                break;
            }
        }

        for(int i = 1; i< matrix.length; i++){
            for(int j = 1; j< matrix[0].length; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 ) {
                    matrix[i][j] = 0;
                }
                if (matrix[i][0] == 0 ) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(hasColumnZero){
            for(int i = 0; i< matrix.length; i++){
                matrix[i][0]=0;
            }
        }

        if(hasRowZero){
            for(int j = 0; j< matrix[0].length; j++){
                matrix[0][j]=0;
            }
        }
    }
}