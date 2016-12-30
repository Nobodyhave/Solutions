package hackerrank.algorithms.recursion;

/**
 * Created by Aleksandr on 20/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/simplified-chess-engine
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimplifiedChessEngine {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        int G = in.nextInt();

        for (int g = 0; g < G; g++) {
            int w = in.nextInt();
            int b = in.nextInt();
            int m = in.nextInt();

            ChessPiece[][] board = new ChessPiece[4][4];

            for (int i = 0; i < w; i++) {
                String piece = in.next();
                String col = in.next();
                int row = Math.abs(4 - Integer.parseInt(in.next()));

                switch (col) {
                    case "A":
                        board[row][0] = new ChessPiece(Color.WHITE, Piece.convert(piece));
                        break;
                    case "B":
                        board[row][1] = new ChessPiece(Color.WHITE, Piece.convert(piece));
                        break;
                    case "C":
                        board[row][2] = new ChessPiece(Color.WHITE, Piece.convert(piece));
                        break;
                    case "D":
                        board[row][3] = new ChessPiece(Color.WHITE, Piece.convert(piece));
                        break;
                }
            }

            for (int i = 0; i < b; i++) {
                String piece = in.next();
                String col = in.next();
                int row = Math.abs(4 - Integer.parseInt(in.next()));

                switch (col) {
                    case "A":
                        board[row][0] = new ChessPiece(Color.BLACK, Piece.convert(piece));
                        break;
                    case "B":
                        board[row][1] = new ChessPiece(Color.BLACK, Piece.convert(piece));
                        break;
                    case "C":
                        board[row][2] = new ChessPiece(Color.BLACK, Piece.convert(piece));
                        break;
                    case "D":
                        board[row][3] = new ChessPiece(Color.BLACK, Piece.convert(piece));
                        break;
                }
            }

            if (makeTurn(board, Color.WHITE, m)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean makeTurn(ChessPiece[][] board, Color colorToMove, int remainingMoves) {
        if (remainingMoves == 0) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != null && (board[i][j]).color == colorToMove) {
                    final List<Move> moves = getMoves(board, i, j);
                    for (Move move : moves) {
                        // Skip if target cell is busy with same color figure
                        if (board[move.toRow][move.toCol] != null && board[move.toRow][move.toCol].color == colorToMove) {
                            continue;
                        }
                        // Capturing Black Queen?
                        if (board[move.toRow][move.toCol] != null && board[move.toRow][move.toCol].color != colorToMove && board[move.toRow][move.toCol].piece == Piece.QUEEN) {
                            return colorToMove == Color.WHITE;
                        }
                        // Move to empty field or capturing a regular piece
                        if (board[move.toRow][move.toCol] == null || board[move.toRow][move.toCol].color != colorToMove) {
                            final ChessPiece[][] newBoard = new ChessPiece[4][4];
                            for (int k = 0; k < 4; k++) {
                                System.arraycopy(board[k], 0, newBoard[k], 0, 4);
                            }
                            newBoard[i][j] = null;
                            newBoard[move.toRow][move.toCol] = board[i][j];
                            boolean tmp = makeTurn(newBoard, colorToMove == Color.WHITE ? Color.BLACK : Color.WHITE, remainingMoves - 1);
                            if (tmp && colorToMove == Color.WHITE) {
                                return true;
                            } else if (!tmp && colorToMove == Color.BLACK) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return colorToMove != Color.WHITE;
    }

    private static List<Move> getMoves(ChessPiece[][] board, int fromRow, int fromCol) {
        List<Move> possibleMoves;
        switch (board[fromRow][fromCol].piece) {
            case ROOK:
                possibleMoves = getRookMoves(board, fromRow, fromCol);
                break;
            case BISHOP:
                possibleMoves = getBishopMoves(board, fromRow, fromCol);
                break;
            case QUEEN:
                possibleMoves = getQueenMoves(board, fromRow, fromCol);
                break;
            case KNIGHT:
                possibleMoves = getKnightMoves(board, fromRow, fromCol);
                break;
            default:
                throw new IllegalArgumentException("Unsupported piece type");
        }

        return possibleMoves;
    }

    private static List<Move> getRookMoves(ChessPiece[][] board, int fromRow, int fromCol) {
        final List<Move> possibleMoves = new ArrayList<>();

        // Moves UP
        for (int r = fromRow - 1; r >= 0; r--) {
            if (board[r][fromCol] == null) {
                possibleMoves.add(new Move(r, fromCol));
            } else {
                if (board[r][fromCol].color != board[fromRow][fromCol].color) {
                    possibleMoves.add(new Move(r, fromCol));
                }
                break;
            }
        }

        // Moves DOWN
        for (int r = fromRow + 1; r < 4; r++) {
            if (board[r][fromCol] == null) {
                possibleMoves.add(new Move(r, fromCol));
            } else {
                if (board[r][fromCol].color != board[fromRow][fromCol].color) {
                    possibleMoves.add(new Move(r, fromCol));
                }
                break;
            }
        }

        // Moves LEFT
        for (int c = fromCol - 1; c >= 0; c--) {
            if (board[fromRow][c] == null) {
                possibleMoves.add(new Move(fromRow, c));
            } else {
                if (board[fromRow][c].color != board[fromRow][fromCol].color) {
                    possibleMoves.add(new Move(fromRow, c));
                }
                break;
            }
        }

        // Moves RIGHT
        for (int c = fromCol + 1; c < 4; c++) {
            if (board[fromRow][c] == null) {
                possibleMoves.add(new Move(fromRow, c));
            } else {
                if (board[fromRow][c].color != board[fromRow][fromCol].color) {
                    possibleMoves.add(new Move(fromRow, c));
                }
                break;
            }
        }

        return possibleMoves;
    }

    private static List<Move> getBishopMoves(ChessPiece[][] board, int fromRow, int fromCol) {
        final List<Move> possibleMoves = new ArrayList<>();

        // Moves UP-LEFT
        for (int r = fromRow - 1, c = fromCol - 1; c >= 0 && r >= 0; r--, c--) {
            if (board[r][c] == null) {
                possibleMoves.add(new Move(r, c));
            } else {
                if (board[r][c].color != board[fromRow][fromCol].color) {
                    possibleMoves.add(new Move(r, c));
                }
                break;
            }
        }

        // Moves UP-RIGHT
        for (int r = fromRow - 1, c = fromCol + 1; c < 4 && r >= 0; r--, c++) {
            if (board[r][c] == null) {
                possibleMoves.add(new Move(r, c));
            } else {
                if (board[r][c].color != board[fromRow][fromCol].color) {
                    possibleMoves.add(new Move(r, c));
                }
                break;
            }
        }

        // Moves DOWN-RIGHT
        for (int r = fromRow + 1, c = fromCol + 1; c < 4 && r < 4; r++, c++) {
            if (board[r][c] == null) {
                possibleMoves.add(new Move(r, c));
            } else {
                if (board[r][c].color != board[fromRow][fromCol].color) {
                    possibleMoves.add(new Move(r, c));
                }
                break;
            }
        }

        // Moves DOWN-LEFT
        for (int r = fromRow + 1, c = fromCol - 1; c >= 0 && r < 4; r++, c--) {
            if (board[r][c] == null) {
                possibleMoves.add(new Move(r, c));
            } else {
                if (board[r][c].color != board[fromRow][fromCol].color) {
                    possibleMoves.add(new Move(r, c));
                }
                break;
            }
        }

        return possibleMoves;
    }

    private static List<Move> getQueenMoves(ChessPiece[][] board, int fromRow, int fromCol) {
        final List<Move> possibleMoves = new ArrayList<>();

        possibleMoves.addAll(getRookMoves(board, fromRow, fromCol));
        possibleMoves.addAll(getBishopMoves(board, fromRow, fromCol));

        return possibleMoves;
    }

    private static List<Move> getKnightMoves(ChessPiece[][] board, int fromRow, int fromCol) {
        final List<Move> possibleMoves = new ArrayList<>();

        // UP-LEFT
        int r = fromRow - 2;
        int c = fromCol - 1;
        if (r >= 0 && c >= 0) {
            if (board[r][c] == null) {
                possibleMoves.add(new Move(r, c));
            } else {
                if (board[r][c].color != board[fromRow][fromCol].color) {
                    possibleMoves.add(new Move(r, c));
                }
            }
        }

        // UP-RIGHT
        r = fromRow - 2;
        c = fromCol + 1;
        if (r >= 0 && c < 4) {
            if (board[r][c] == null) {
                possibleMoves.add(new Move(r, c));
            } else {
                if (board[r][c].color != board[fromRow][fromCol].color) {
                    possibleMoves.add(new Move(r, c));
                }
            }
        }

        // RIGHT-UP
        r = fromRow - 1;
        c = fromCol + 2;
        if (r >= 0 && c < 4) {
            if (board[r][c] == null) {
                possibleMoves.add(new Move(r, c));
            } else {
                if (board[r][c].color != board[fromRow][fromCol].color) {
                    possibleMoves.add(new Move(r, c));
                }
            }
        }

        // RIGHT-DOWN
        r = fromRow + 1;
        c = fromCol + 2;
        if (r < 4 && c < 4) {
            if (board[r][c] == null) {
                possibleMoves.add(new Move(r, c));
            } else {
                if (board[r][c].color != board[fromRow][fromCol].color) {
                    possibleMoves.add(new Move(r, c));
                }
            }
        }

        // DOWN-RIGHT
        r = fromRow + 2;
        c = fromCol + 1;
        if (r < 4 && c < 4) {
            if (board[r][c] == null) {
                possibleMoves.add(new Move(r, c));
            } else {
                if (board[r][c].color != board[fromRow][fromCol].color) {
                    possibleMoves.add(new Move(r, c));
                }
            }
        }

        // DOWN-LEFT
        r = fromRow + 2;
        c = fromCol - 1;
        if (r < 4 && c >= 0) {
            if (board[r][c] == null) {
                possibleMoves.add(new Move(r, c));
            } else {
                if (board[r][c].color != board[fromRow][fromCol].color) {
                    possibleMoves.add(new Move(r, c));
                }
            }
        }

        // LEFT-DOWN
        r = fromRow + 1;
        c = fromCol - 2;
        if (r < 4 && c >= 0) {
            if (board[r][c] == null) {
                possibleMoves.add(new Move(r, c));
            } else {
                if (board[r][c].color != board[fromRow][fromCol].color) {
                    possibleMoves.add(new Move(r, c));
                }
            }
        }

        // LEFT-UP
        r = fromRow - 1;
        c = fromCol - 2;
        if (r >= 0 && c >= 0) {
            if (board[r][c] == null) {
                possibleMoves.add(new Move(r, c));
            } else {
                if (board[r][c].color != board[fromRow][fromCol].color) {
                    possibleMoves.add(new Move(r, c));
                }
            }
        }

        return possibleMoves;
    }

    private static class Move {
        private int toRow;
        private int toCol;

        public Move(int toRow, int toCol) {
            this.toRow = toRow;
            this.toCol = toCol;
        }
    }

    private static class ChessPiece {
        private Color color;
        private Piece piece;

        public ChessPiece(Color color, Piece piece) {
            this.color = color;
            this.piece = piece;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ChessPiece that = (ChessPiece) o;

            return color == that.color && piece == that.piece;

        }

        @Override
        public int hashCode() {
            int result = color.hashCode();
            result = 31 * result + piece.hashCode();
            return result;
        }
    }

    private enum Color {
        WHITE, BLACK
    }

    private enum Piece {
        QUEEN, KNIGHT, BISHOP, ROOK;

        public static Piece convert(String piece) {
            switch (piece) {
                case "Q":
                    return QUEEN;
                case "N":
                    return KNIGHT;
                case "B":
                    return BISHOP;
                case "R":
                    return ROOK;
                default:
                    throw new IllegalArgumentException("Wrong piece type");
            }
        }
    }
}
