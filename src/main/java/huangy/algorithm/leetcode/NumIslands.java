package huangy.algorithm.leetcode;

/**
 * @author huangy on 2020-04-04
 */
public class NumIslands {

    private int row;

    private int col;

    private boolean[][] tag;

    /**
     * 只要是1，并且没有找过的，则开始递归查找，
     * 找过的则更新标志位
     */
    public int numIslands(char[][] grid) {

        if ((grid == null) || (grid.length == 0)) {
            return 0;
        }

        row = grid.length;
        col = grid[0].length;

        tag = new boolean[row][col];

        int count = 0;

        for (int i=0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!tag[i][j] && (grid[i][j] == '1')) {

                    dfs(grid, i, j);

                    count++;
                }
            }
        }

        return count;
    }

    void dfs(char[][] grid, int i, int j) {
        if ((i < 0) || (i >= row) || (j < 0) || (j >= col)) {
            return;
        }

        if (grid[i][j] == '0') {
            return;
        }

        if (tag[i][j]) {
            return;
        }

        if (grid[i][j] == '1') {
            tag[i][j] = true;
        }

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        char[][] tem = {{'1','1','0','0','0'},
        {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        System.out.println(
                new NumIslands().numIslands(tem));
    }
}
