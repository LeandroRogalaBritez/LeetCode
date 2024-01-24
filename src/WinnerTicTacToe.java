
/**
 * Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:
 *
 * Players take turns placing characters into empty squares ' '.
 * The first player A always places 'X' characters, while the second player B always places 'O' characters.
 * 'X' and 'O' characters are always placed into empty squares, never on filled ones.
 * The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
 * The game also ends if all squares are non-empty.
 * No more moves can be played if the game is over.
 * Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".
 *
 * You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.
 */

public class WinnerTicTacToe {

    public static void main(String[] args) {
        System.out.println(tictactoe(new int[][] {{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}})); // A
        System.out.println(tictactoe(new int[][] {{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}})); // B
        System.out.println(tictactoe(new int[][] {{0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}})); // Draw
    }

    private static String tictactoe(int[][] moves) {
        int[][] board = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
            int player = (i % 2 == 0) ? 1 : 2;
            board[moves[i][0]][moves[i][1]] = player;

            if (verificaVencedor(board, player)) {
                return player == 1 ? "A" : "B";
            }
        }

        if (moves.length < 9) {
            return "Pending";
        }

        return "Draw";
    }

    private static boolean verificaVencedor(int[][] board, int player) {
        boolean venceu = verificaLinhaColuna(board, player);
        if (venceu) {
            return venceu;
        }
        venceu = verificaDiagonal(board, player);
        return venceu;
    }

    private static boolean verificaDiagonal(int[][] board, int player) {
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }

    private static boolean verificaLinhaColuna(int[][] board, int player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return false;
    }
}
