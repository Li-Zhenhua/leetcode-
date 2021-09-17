package 每日一题;

/**
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
数独部分空格内已填入了数字，空白格用 '.' 表示。

注意：

一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。

 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //因为是9*9的九宫格，27行的前九列表示原来九宫格每行包含的数字
        //中间9列表示每列包含的数字，后九列表示每一个小3*3的宫格内的数字
        boolean[][] used = new boolean[27][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                

                if(used[i][num-1]) return false;
                used[i][num-1] = true;

                if(used[9+j][num-1]) return false;
                used[9+j][num-1] = true;

                //第一个i除以3是为了取整
                int location = (i/3)*3+(j/3);
                if(used[18+location][num-1]) return false;
                used[18+location][num-1] = true;
            }
        }
        return true;
    }
}

public class _9_17_Q36 {
    
}
