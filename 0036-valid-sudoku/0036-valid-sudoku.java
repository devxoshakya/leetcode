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
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> set = new HashSet<>();
                for (int row = i; row < i + 3; row++) {
                    for (int col = j; col < j + 3; col++) {
                        char item = board[row][col];
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
