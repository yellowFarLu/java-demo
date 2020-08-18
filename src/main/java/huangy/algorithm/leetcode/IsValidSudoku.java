package huangy.algorithm.leetcode;

/**
 * @author huangy on 2020-04-05
 */
public class IsValidSudoku {

    private int row = 9;

    private int col = 9;

    private int countLen = 10;

    private int margin = 3;

    public boolean isValidSudoku(char[][] board) {

        if (board == null) {
            return false;
        }

        if (!checkRow(board)) {
            return false;
        }

        if (!checkCol(board)) {
            return false;
        }

        return checkThree(board);
    }

    private boolean checkThree(char[][] board) {

        int[] countArr;

        for (int iBegin = 0; iBegin < row; iBegin += margin) {
            for (int jBegin = 0; jBegin < col; jBegin += margin) {

                int iEnd = iBegin + margin;
                int jEnd = jBegin + margin;

                countArr = new int[countLen];

                for (int i = iBegin; i < iEnd; i++) {
                    for (int j = jBegin; j < jEnd; j++) {

                        if (isDianChar(board[i][j])) {
                            continue;
                        }

                        countArr[charToInt(board[i][j])]++;
                        if (!checkCountArr(countArr)) {
                            return false;
                        }
                    }
                }

            }
        }

        return true;
    }

    private boolean checkRow(char[][] board) {

        int[] countArr;

        for (int i = 0; i < row; i++) {

            countArr = new int[countLen];

            for (int j = 0; j < col; j++) {

                if (isDianChar(board[i][j])) {
                    continue;
                }

                countArr[charToInt(board[i][j])]++;
            }

            if (!checkCountArr(countArr)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCol(char[][] board) {

        int[] countArr;

        for (int j = 0; j < col; j++) {

            countArr = new int[countLen];

            for (int i = 0; i < row; i++) {

                if (isDianChar(board[i][j])) {
                    continue;
                }

                countArr[charToInt(board[i][j])]++;
            }

            if (!checkCountArr(countArr)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCountArr(int[] countArr) {
        for (int k = 0; k < countLen; k++) {
            if (countArr[k] > 1) {
                return false;
            }
        }
        return true;
    }

    private int charToInt(char c) {
        return Integer.parseInt(String.valueOf(c));
    }

    private boolean isDianChar(char c) {
        return c == '.';
    }

    public static void main(String[] args) {
        char[][] arr = {{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        new IsValidSudoku().isValidSudoku(arr);
    }
}
