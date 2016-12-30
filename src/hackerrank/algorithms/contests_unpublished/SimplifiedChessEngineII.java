package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w27/challenges/simplified-chess-engine-ii
 */

public class SimplifiedChessEngineII {
    private static final int SIZE = 4;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        int G = in.nextInt();

        for (int g = 0; g < G; g++) {
            int w = in.nextInt();
            int b = in.nextInt();
            int m = in.nextInt();

            final Board board = new Board();

            for (int i = 0; i < w; i++) {
                String piece = in.next();
                String col = in.next();
                int row = Math.abs(SIZE - Integer.parseInt(in.next()));

                switch (col) {
                    case "A":
                        board.setPiece(ChessPiece.getPiece(Color.WHITE, Piece.convert(piece)), row * SIZE);
                        break;
                    case "B":
                        board.setPiece(ChessPiece.getPiece(Color.WHITE, Piece.convert(piece)), row * SIZE + 1);
                        break;
                    case "C":
                        board.setPiece(ChessPiece.getPiece(Color.WHITE, Piece.convert(piece)), row * SIZE + 2);
                        break;
                    case "D":
                        board.setPiece(ChessPiece.getPiece(Color.WHITE, Piece.convert(piece)), row * SIZE + 3);
                        break;
                }
            }

            for (int i = 0; i < b; i++) {
                String piece = in.next();
                String col = in.next();
                int row = Math.abs(SIZE - Integer.parseInt(in.next()));

                switch (col) {
                    case "A":
                        board.setPiece(ChessPiece.getPiece(Color.BLACK, Piece.convert(piece)), row * SIZE);
                        break;
                    case "B":
                        board.setPiece(ChessPiece.getPiece(Color.BLACK, Piece.convert(piece)), row * SIZE + 1);
                        break;
                    case "C":
                        board.setPiece(ChessPiece.getPiece(Color.BLACK, Piece.convert(piece)), row * SIZE + 2);
                        break;
                    case "D":
                        board.setPiece(ChessPiece.getPiece(Color.BLACK, Piece.convert(piece)), row * SIZE + 3);
                        break;
                }
            }

            //printBoard(board, Color.WHITE, m);
            if (makeTurn(board, Color.WHITE, new IntArray(16 * m), m, 0)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean makeTurn(Board board, Color colorToMove, IntArray moves, int remainingMoves, int movesShift) {
        //printBoard(board, colorToMove, 3 - remainingMoves);
        if (remainingMoves == 0) {
            return false;
        }

        for (int i = 0; i < 16; i++) {
            // If examined cell contains figure of current color
            if (board.getPiece(i) != ChessPiece.EMPTY && board.getPiece(i).color == colorToMove) {
                // Get possible moves for chosen figure
                int movesCount = getMoves(board, moves, i);

                // Check if Queen can be captured immediately to prune tree
                for (int j = movesShift; j < movesShift + movesCount; j++) {
                    final ChessPiece piece = board.getPiece(i);
                    final ChessPiece capturedPiece = board.getPiece(moves.get(j));
                    if (capturedPiece != ChessPiece.EMPTY
                            && capturedPiece.piece == Piece.QUEEN
                            && !(piece.piece == Piece.PAWN && i % SIZE == moves.get(j) % SIZE)) {
                        moves.trimToSize(movesShift);
                        return colorToMove == Color.WHITE;
                    }
                }

                // Try every possible move
                for (int j = movesShift; j < movesShift + movesCount; j++) {
                    final ChessPiece piece = board.getPiece(i);
                    final ChessPiece capturedPiece = board.getPiece(moves.get(j));

                    // Skip if target cell is busy with same color figure
                    if (capturedPiece != ChessPiece.EMPTY && capturedPiece.color == colorToMove) {
                        continue;
                    }

                    // Check if this move is promoting pawn
                    if (piece.piece == Piece.PAWN && ((colorToMove == Color.WHITE && moves.get(j) / SIZE == 0) || (colorToMove == Color.BLACK && moves.get(j) / SIZE == 3))) {
                        // Promote to Bishop
                        doMove(board, i, moves.get(j), ChessPiece.getPiece(colorToMove, Piece.BISHOP));
                        boolean tmp = makeTurn(board, colorToMove == Color.WHITE ? Color.BLACK : Color.WHITE, moves, remainingMoves - 1, movesShift + movesCount);
                        undoMove(board, i, moves.get(j), piece, capturedPiece);
                        if (tmp && colorToMove == Color.WHITE) {
                            moves.trimToSize(movesShift);
                            return true;
                        } else if (!tmp && colorToMove == Color.BLACK) {
                            moves.trimToSize(movesShift);
                            return false;
                        }

                        // Promote to Rook
                        doMove(board, i, moves.get(j), ChessPiece.getPiece(colorToMove, Piece.ROOK));
                        tmp = makeTurn(board, colorToMove == Color.WHITE ? Color.BLACK : Color.WHITE, moves, remainingMoves - 1, movesShift + movesCount);
                        undoMove(board, i, moves.get(j), piece, capturedPiece);
                        if (tmp && colorToMove == Color.WHITE) {
                            moves.trimToSize(movesShift);
                            return true;
                        } else if (!tmp && colorToMove == Color.BLACK) {
                            moves.trimToSize(movesShift);
                            return false;
                        }

                        // Promote to Knight
                        doMove(board, i, moves.get(j), ChessPiece.getPiece(colorToMove, Piece.KNIGHT));
                        tmp = makeTurn(board, colorToMove == Color.WHITE ? Color.BLACK : Color.WHITE, moves, remainingMoves - 1, movesShift + movesCount);
                        undoMove(board, i, moves.get(j), piece, capturedPiece);
                        if (tmp && colorToMove == Color.WHITE) {
                            moves.trimToSize(movesShift);
                            return true;
                        } else if (!tmp && colorToMove == Color.BLACK) {
                            moves.trimToSize(movesShift);
                            return false;
                        }
                    } else {
                        //Move to empty field or capturing a regular piece
                        doMove(board, i, moves.get(j), piece);
                        boolean tmp = makeTurn(board, colorToMove == Color.WHITE ? Color.BLACK : Color.WHITE, moves, remainingMoves - 1, movesShift + movesCount);
                        undoMove(board, i, moves.get(j), piece, capturedPiece);
                        if (tmp && colorToMove == Color.WHITE) {
                            moves.trimToSize(movesShift);
                            return true;
                        } else if (!tmp && colorToMove == Color.BLACK) {
                            moves.trimToSize(movesShift);
                            return false;
                        }
                    }
                }
            }
            moves.trimToSize(movesShift);
        }

        moves.trimToSize(movesShift);
        return colorToMove != Color.WHITE;
    }

    private static void doMove(Board board, int fromIndex, int toIndex, ChessPiece piece) {
        board.setPiece(ChessPiece.EMPTY, fromIndex);
        board.setPiece(piece, toIndex);
    }

    private static void undoMove(Board board, int fromIndex, int toIndex, ChessPiece piece, ChessPiece captured) {
        board.setPiece(piece, fromIndex);
        board.setPiece(captured, toIndex);
    }

    private static void printBoard(Board board, Color color, int shift) {
        StringBuilder sb = new StringBuilder(32);

        sb.append(color).append("\n");
        for (int i = 0; i < 4; i++) {
            for (int s = 0; s < shift; s++) {
                sb.append("\t");
            }

            for (int j = 0; j < 4; j++) {
                if (board.getPiece(i * SIZE + j) == ChessPiece.EMPTY) {
                    sb.append("__ ");
                } else {
                    sb.append(board.getPiece(i * SIZE + j).color.name().charAt(0));
                    switch (board.getPiece(i * SIZE + j).piece) {
                        case QUEEN:
                            sb.append("Q ");
                            break;
                        case BISHOP:
                            sb.append("B ");
                            break;
                        case KNIGHT:
                            sb.append("N ");
                            break;
                        case ROOK:
                            sb.append("R ");
                            break;
                        case PAWN:
                            sb.append("P ");
                            break;
                        default:
                            throw new IllegalArgumentException("Unsupported piece type");
                    }
                }
            }
            sb.append('\n');
        }
        sb.append('\n');

        System.out.println(sb);
    }

    private static int getMoves(Board board, IntArray moves, int fromIndex) {
        switch (board.getPiece(fromIndex).piece) {
            case ROOK:
                return getRookMoves(board, moves, fromIndex);
            case BISHOP:
                return getBishopMoves(board, moves, fromIndex);
            case QUEEN:
                return getQueenMoves(board, moves, fromIndex);
            case KNIGHT:
                return getKnightMoves(board, moves, fromIndex);
            case PAWN:
                return getPawnMoves(board, moves, fromIndex);
            default:
                throw new IllegalArgumentException("Unsupported piece type");
        }
    }

    private static int getPawnMoves(Board board, IntArray moves, int fromIndex) {
        int count = 0;
        final int fromRow = fromIndex / SIZE;
        final int fromCol = fromIndex % SIZE;

        final Color color = board.getPiece(fromIndex).color;
        if (color == Color.WHITE) {
            int r = fromRow - 1;
            int c = fromCol - 1;
            int toIndex = r * SIZE + c;
            if (r >= 0 && c >= 0 && board.getPiece(toIndex) != ChessPiece.EMPTY && board.getPiece(toIndex).color != color) {
                moves.add(toIndex);
                count++;
            }

            r = fromRow - 1;
            c = fromCol;
            toIndex = r * SIZE + c;
            if (r >= 0 && board.getPiece(toIndex) == ChessPiece.EMPTY) {
                moves.add(toIndex);
                count++;
            }

            r = fromRow - 1;
            c = fromCol + 1;
            toIndex = r * SIZE + c;
            if (r >= 0 && c < 4 && board.getPiece(toIndex) != ChessPiece.EMPTY && board.getPiece(toIndex).color != color) {
                moves.add(toIndex);
                count++;
            }
        } else {
            int r = fromRow + 1;
            int c = fromCol - 1;
            int toIndex = r * SIZE + c;
            if (r < 4 && c >= 0 && board.getPiece(toIndex) != ChessPiece.EMPTY && board.getPiece(toIndex).color != color) {
                moves.add(toIndex);
                count++;
            }

            r = fromRow + 1;
            c = fromCol;
            toIndex = r * SIZE + c;
            if (r < 4 && board.getPiece(toIndex) == ChessPiece.EMPTY) {
                moves.add(toIndex);
                count++;
            }

            r = fromRow + 1;
            c = fromCol + 1;
            toIndex = r * SIZE + c;
            if (r < 4 && c < 4 && board.getPiece(toIndex) != ChessPiece.EMPTY && board.getPiece(toIndex).color != color) {
                moves.add(toIndex);
                count++;
            }
        }

        return count;
    }

    private static int getRookMoves(Board board, IntArray moves, int fromIndex) {
        int count = 0;
        final int fromRow = fromIndex / SIZE;
        final int fromCol = fromIndex % SIZE;

        // Moves UP
        for (int r = fromRow - 1; r >= 0; r--) {
            int toIndex = r * SIZE + fromCol;
            if (board.getPiece(toIndex) == ChessPiece.EMPTY) {
                moves.add(toIndex);
                count++;
            } else {
                if (board.getPiece(toIndex).color != board.getPiece(fromIndex).color) {
                    moves.add(toIndex);
                    count++;
                }
                break;
            }
        }

        // Moves DOWN
        for (int r = fromRow + 1; r < 4; r++) {
            int toIndex = r * SIZE + fromCol;
            if (board.getPiece(toIndex) == ChessPiece.EMPTY) {
                moves.add(toIndex);
                count++;
            } else {
                if (board.getPiece(toIndex).color != board.getPiece(fromIndex).color) {
                    moves.add(toIndex);
                    count++;
                }
                break;
            }
        }

        // Moves LEFT
        for (int c = fromCol - 1; c >= 0; c--) {
            int toIndex = fromRow * SIZE + c;
            if (board.getPiece(toIndex) == ChessPiece.EMPTY) {
                moves.add(toIndex);
                count++;
            } else {
                if (board.getPiece(toIndex).color != board.getPiece(fromIndex).color) {
                    moves.add(toIndex);
                    count++;
                }
                break;
            }
        }

        // Moves RIGHT
        for (int c = fromCol + 1; c < 4; c++) {
            int toIndex = fromRow * SIZE + c;
            if (board.getPiece(toIndex) == ChessPiece.EMPTY) {
                moves.add(toIndex);
                count++;
            } else {
                if (board.getPiece(toIndex).color != board.getPiece(fromIndex).color) {
                    moves.add(toIndex);
                    count++;
                }
                break;
            }
        }

        return count;
    }

    private static int getBishopMoves(Board board, IntArray moves, int fromIndex) {
        int count = 0;
        final int fromRow = fromIndex / SIZE;
        final int fromCol = fromIndex % SIZE;

        // Moves UP-LEFT
        for (int r = fromRow - 1, c = fromCol - 1; c >= 0 && r >= 0; r--, c--) {
            int toIndex = r * SIZE + c;
            if (board.getPiece(toIndex) == ChessPiece.EMPTY) {
                moves.add(toIndex);
                count++;
            } else {
                if (board.getPiece(toIndex).color != board.getPiece(fromIndex).color) {
                    moves.add(toIndex);
                    count++;
                }
                break;
            }
        }

        // Moves UP-RIGHT
        for (int r = fromRow - 1, c = fromCol + 1; c < 4 && r >= 0; r--, c++) {
            int toIndex = r * SIZE + c;
            if (board.getPiece(toIndex) == ChessPiece.EMPTY) {
                moves.add(toIndex);
                count++;
            } else {
                if (board.getPiece(toIndex).color != board.getPiece(fromIndex).color) {
                    moves.add(toIndex);
                    count++;
                }
                break;
            }
        }

        // Moves DOWN-RIGHT
        for (int r = fromRow + 1, c = fromCol + 1; c < 4 && r < 4; r++, c++) {
            int toIndex = r * SIZE + c;
            if (board.getPiece(toIndex) == ChessPiece.EMPTY) {
                moves.add(toIndex);
                count++;
            } else {
                if (board.getPiece(toIndex).color != board.getPiece(fromIndex).color) {
                    moves.add(toIndex);
                    count++;
                }
                break;
            }
        }

        // Moves DOWN-LEFT
        for (int r = fromRow + 1, c = fromCol - 1; c >= 0 && r < 4; r++, c--) {
            int toIndex = r * SIZE + c;
            if (board.getPiece(toIndex) == ChessPiece.EMPTY) {
                moves.add(toIndex);
                count++;
            } else {
                if (board.getPiece(toIndex).color != board.getPiece(fromIndex).color) {
                    moves.add(toIndex);
                    count++;
                }
                break;
            }
        }

        return count;
    }

    private static int getQueenMoves(Board board, IntArray moves, int fromIndex) {
        return getRookMoves(board, moves, fromIndex) + getBishopMoves(board, moves, fromIndex);
    }

    private static int getKnightMoves(Board board, IntArray moves, int fromIndex) {
        int count = 0;
        final int fromRow = fromIndex / SIZE;
        final int fromCol = fromIndex % SIZE;

        // UP-LEFT
        int r = fromRow - 2;
        int c = fromCol - 1;
        if (r >= 0 && c >= 0) {
            int toIndex = r * SIZE + c;

            if (board.getPiece(toIndex) == ChessPiece.EMPTY) {
                moves.add(toIndex);
                count++;
            } else {
                if (board.getPiece(toIndex).color != board.getPiece(fromIndex).color) {
                    moves.add(toIndex);
                    count++;
                }
            }
        }

        // UP-RIGHT
        r = fromRow - 2;
        c = fromCol + 1;
        if (r >= 0 && c < 4) {
            int toIndex = r * SIZE + c;

            if (board.getPiece(toIndex) == ChessPiece.EMPTY) {
                moves.add(toIndex);
                count++;
            } else {
                if (board.getPiece(toIndex).color != board.getPiece(fromIndex).color) {
                    moves.add(toIndex);
                    count++;
                }
            }
        }

        // RIGHT-UP
        r = fromRow - 1;
        c = fromCol + 2;
        if (r >= 0 && c < 4) {
            int toIndex = r * SIZE + c;

            if (board.getPiece(toIndex) == ChessPiece.EMPTY) {
                moves.add(toIndex);
                count++;
            } else {
                if (board.getPiece(toIndex).color != board.getPiece(fromIndex).color) {
                    moves.add(toIndex);
                    count++;
                }
            }
        }

        // RIGHT-DOWN
        r = fromRow + 1;
        c = fromCol + 2;
        if (r < 4 && c < 4) {
            int toIndex = r * SIZE + c;

            if (board.getPiece(toIndex) == ChessPiece.EMPTY) {
                moves.add(toIndex);
                count++;
            } else {
                if (board.getPiece(toIndex).color != board.getPiece(fromIndex).color) {
                    moves.add(toIndex);
                    count++;
                }
            }
        }

        // DOWN-RIGHT
        r = fromRow + 2;
        c = fromCol + 1;
        if (r < 4 && c < 4) {
            int toIndex = r * SIZE + c;

            if (board.getPiece(toIndex) == ChessPiece.EMPTY) {
                moves.add(toIndex);
                count++;
            } else {
                if (board.getPiece(toIndex).color != board.getPiece(fromIndex).color) {
                    moves.add(toIndex);
                    count++;
                }
            }
        }

        // DOWN-LEFT
        r = fromRow + 2;
        c = fromCol - 1;
        if (r < 4 && c >= 0) {
            int toIndex = r * SIZE + c;

            if (board.getPiece(toIndex) == ChessPiece.EMPTY) {
                moves.add(toIndex);
                count++;
            } else {
                if (board.getPiece(toIndex).color != board.getPiece(fromIndex).color) {
                    moves.add(toIndex);
                    count++;
                }
            }
        }

        // LEFT-DOWN
        r = fromRow + 1;
        c = fromCol - 2;
        if (r < 4 && c >= 0) {
            int toIndex = r * SIZE + c;

            if (board.getPiece(toIndex) == ChessPiece.EMPTY) {
                moves.add(toIndex);
                count++;
            } else {
                if (board.getPiece(toIndex).color != board.getPiece(fromIndex).color) {
                    moves.add(toIndex);
                    count++;
                }
            }
        }

        // LEFT-UP
        r = fromRow - 1;
        c = fromCol - 2;
        if (r >= 0 && c >= 0) {
            int toIndex = r * SIZE + c;

            if (board.getPiece(toIndex) == ChessPiece.EMPTY) {
                moves.add(toIndex);
                count++;
            } else {
                if (board.getPiece(toIndex).color != board.getPiece(fromIndex).color) {
                    moves.add(toIndex);
                    count++;
                }
            }
        }

        return count;
    }

    private enum Color {
        WHITE, BLACK, NONE
    }

    private enum Piece {
        QUEEN, KNIGHT, BISHOP, ROOK, PAWN, EMPTY;

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
                case "P":
                    return PAWN;
                default:
                    throw new IllegalArgumentException("Wrong piece type");
            }
        }
    }

    private enum ChessPiece {
        EMPTY(Color.NONE, Piece.EMPTY),
        WHITE_PAWN(Color.WHITE, Piece.PAWN),
        WHITE_KNIGHT(Color.WHITE, Piece.KNIGHT),
        WHITE_BISHOP(Color.WHITE, Piece.BISHOP),
        WHITE_ROOK(Color.WHITE, Piece.ROOK),
        WHITE_QUEEN(Color.WHITE, Piece.QUEEN),
        BLACK_PAWN(Color.BLACK, Piece.PAWN),
        BLACK_KNIGHT(Color.BLACK, Piece.KNIGHT),
        BLACK_BISHOP(Color.BLACK, Piece.BISHOP),
        BLACK_ROOK(Color.BLACK, Piece.ROOK),
        BLACK_QUEEN(Color.BLACK, Piece.QUEEN);

        private Color color;
        private Piece piece;

        ChessPiece(Color color, Piece piece) {
            this.color = color;
            this.piece = piece;
        }

        public static ChessPiece getPiece(Color color, Piece piece) {
            if (color == Color.WHITE) {
                switch (piece) {
                    case PAWN:
                        return WHITE_PAWN;
                    case KNIGHT:
                        return WHITE_KNIGHT;
                    case BISHOP:
                        return WHITE_BISHOP;
                    case ROOK:
                        return WHITE_ROOK;
                    case QUEEN:
                        return WHITE_QUEEN;
                }
            } else {
                switch (piece) {
                    case PAWN:
                        return BLACK_PAWN;
                    case KNIGHT:
                        return BLACK_KNIGHT;
                    case BISHOP:
                        return BLACK_BISHOP;
                    case ROOK:
                        return BLACK_ROOK;
                    case QUEEN:
                        return BLACK_QUEEN;
                }
            }

            return EMPTY;
        }
    }

    private static class Board {
        private ChessPiece[] board = new ChessPiece[16];

        public Board() {
            Arrays.fill(board, ChessPiece.EMPTY);
        }

        public ChessPiece getPiece(int index) {
            return board[index];
        }

        public void setPiece(ChessPiece piece, int index) {
            board[index] = piece;
        }
    }

    private static class IntArray implements Iterable<Integer> {
        private final int[] array;
        private int size = 0;

        public IntArray(int maxSize) {
            this.array = new int[maxSize];
        }

        public void add(int E) {
            array[size++] = E;
        }

        public void trimToSize(int trimSize) {
            size = trimSize;
        }

        public int get(int index) {
            if (index < size) {
                return array[index];
            } else {
                throw new IndexOutOfBoundsException("Index out of bound: " + index + " from " + size);
            }
        }

        @Override
        public Iterator<Integer> iterator() {
            return Arrays.stream(array).iterator();
        }
    }
}
