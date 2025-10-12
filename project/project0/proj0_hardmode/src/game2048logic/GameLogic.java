package game2048logic;

import game2048rendering.Side;
import static game2048logic.MatrixUtils.rotateLeft;
import static game2048logic.MatrixUtils.rotateRight;

/**
 * @author  Josh Hug
 */
public class GameLogic {
    /**
     * Modifies the board to simulate tilting the entire board to
     * the given side.
     *
     * @param board the current state of the board
     * @param side  the direction to tilt
     */
    public static void tilt(int[][] board, Side side) {
        // fill this in

        if (side == Side.NORTH) {
            // Don't you dare try to write all of your
            // code in this method. You will want to write
            // helper methods. And those helper methods should
            // have helper methods.
            MatrixUtils.rotateLeft(board);
            leftTileOptimized(board);
            leftMerge(board);
            leftTileOptimized(board);
            MatrixUtils.rotateRight(board);
            return;
        } else if (side == Side.EAST) {
            MatrixUtils.rotateLeft(board);
            MatrixUtils.rotateLeft(board);
            leftTileOptimized(board);
            leftMerge(board);
            leftTileOptimized(board);
            MatrixUtils.rotateRight(board);
            MatrixUtils.rotateRight(board);
            return;
        } else if (side == Side.WEST) {
            leftTileOptimized(board);
            leftMerge(board);
            leftTileOptimized(board);
            return;
        } else { // SOUTH
            MatrixUtils.rotateRight(board);
            leftTileOptimized(board);
            leftMerge(board);
            leftTileOptimized(board);
            MatrixUtils.rotateLeft(board);
            return;
        }
    }
    public static void leftTile(int[][] board) {
        for (int t = 0; t < board.length; t++) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length - 1; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] += board[i][j + 1];
                        board[i][j + 1] = 0;
                    }
                }
            }
        }
    }
    public static void leftMerge(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length-1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    board[i][j] *=2;
                    board[i][j + 1] = 0;
                }
            }
        }
    }
    public static void leftTileOptimized(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            int writeIndex = 0;

            // 遍历当前行的所有元素
            for (int readIndex = 0; readIndex < board[i].length; readIndex++) {
                // 如果当前元素不为零
                if (board[i][readIndex] != 0) {
                    board[i][writeIndex] = board[i][readIndex];

                    if (readIndex != writeIndex) {
                        board[i][readIndex] = 0;
                    }
                    writeIndex++;
                }
            }
        }
    }
}
