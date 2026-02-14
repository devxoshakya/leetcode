import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        // validate rows
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                char item = board[i][j];

                if (item != '.') {
                    if (set.contains(item)) {
                        return false;
                    }
                    set.add(item);
                }
            }
        }

        // validate columns
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                char item = board[j][i];

                if (item != '.') {
                    if (set.contains(item)) {
                        return false;
                    }
                    set.add(item);
                }
            }
        }

        // validate 3x3 boxes
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {

                Set<Character> set = new HashSet<>();

                for (int i = boxRow; i < boxRow + 3; i++) {
                    for (int j = boxCol; j < boxCol + 3; j++) {

                        char item = board[i][j];

                        if (item != '.') {
                            if (set.contains(item)) {
                                return false;
                            }
                            set.add(item);
                        }
                    }
                }
            }
        }

        return true;
    }
}
