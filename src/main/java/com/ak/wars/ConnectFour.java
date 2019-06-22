package com.ak.wars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

public class ConnectFour {

    enum Color {
        YELLOW("Yellow"), RED("Red");

        private final String strValue;

        Color(String color) {
            this.strValue = color;
        }
    }

    private static Map<Character, Color> letterOnColor = Map.of(
            'R', Color.RED,
            'Y', Color.YELLOW);
    private static Map<Character, Integer> letterOnIndex = Map.of(
            'A', 0,
            'B', 1,
            'C', 2,
            'D', 3,
            'E', 4,
            'F', 5,
            'G', 6);


    public static String whoIsWinner(List<String> piecesPositionList) {
        Board board = new Board();
        String winner = "Draw";
        for (String piece : piecesPositionList) {
            Integer column = letterOnIndex.get(piece.charAt(0));
            Color color = letterOnColor.get(piece.charAt(2));
            boolean isWinner = board.addCoin(column, color);
            if (isWinner) {
                winner = color.strValue;
                break;
            }
        }
        return winner;
    }


    private static class Board {

        static final int COLUMN_COUNT = 7;
        static final int ROW_COUNT = 6;
        private final List<Integer> inputColumns = Arrays.asList(0, 0, 0, 0, 0, 0, 0);
        private final List<Position> redCoins = new ArrayList<>();
        private final List<Position> yellowCoins = new ArrayList<>();

        boolean addCoin(int column, Color color) {
            Integer row = inputColumns.get(column);
            List<Position> colorList = getProperCoinList(color);
            Position lastPosition = new Position(row, column);
            colorList.add(lastPosition);
            incrementColumnValue(column);
            return validateWin(lastPosition, colorList);
        }

        private void incrementColumnValue(int column) {
            inputColumns.set(column, inputColumns.get(column) + 1);
        }

        private List<Position> getProperCoinList(Color color) {
            return color.equals(Color.RED) ? redCoins : yellowCoins;
        }

        private boolean validateWin(Position lastPosition, List<Position> positions) {

            int columnQualifier = countColumnQualifier(lastPosition, Set.copyOf(positions));
            int rowQualifier = countRowQualifier(lastPosition, Set.copyOf(positions));
            int diagonalQualifier = countDiagonalQualifier(lastPosition, positions);
            int swingedDiagonalQualifier = countSwingedDiagonalQualifier(lastPosition, positions);

            return checkQualifiers(rowQualifier, columnQualifier, diagonalQualifier, swingedDiagonalQualifier);
        }

        private boolean checkQualifiers(int rowQualifier, int columnQualifier, int diagonalQualifier, int swingedDiagonalQualifier) {
            boolean isRowQualified = checkQualifier(rowQualifier);
            boolean isColumnQualified = checkQualifier(columnQualifier);
            boolean isDiagonalQualified = checkQualifier(diagonalQualifier);
            boolean isSwingedDiagonalQualified = checkQualifier(swingedDiagonalQualifier);

            return isRowQualified || isColumnQualified || isDiagonalQualified || isSwingedDiagonalQualified;
        }


        private int countSwingedDiagonalQualifier(Position lastPosition, List<Position> positions) {
            int qualifier = 0B00000000;
            int multiplier = 0;
            int shift = lastPosition.col + lastPosition.row;

            int[] columns = shift > ROW_COUNT - 1 ?
                    IntStream.range(shift % ROW_COUNT + 1, COLUMN_COUNT).toArray() :
                    IntStream.range(0, shift + 1).toArray();
            for (int col : columns) {
                if (positions.contains(new Position(-1 * col + shift, col))) {
                    qualifier = qualifier | (1 << multiplier);
                }
                multiplier++;
            }

            return qualifier;
        }

        private int countDiagonalQualifier(Position lastPosition, List<Position> positions) {
            int qualifier = 0B00000000;
            int multiplier = 0;
            int shift = lastPosition.row - lastPosition.col;

            int[] columns = shift >= 0 ?
                    IntStream.range(0, COLUMN_COUNT - shift - 1).toArray() :
                    IntStream.range(Math.abs(shift), COLUMN_COUNT).toArray();

            for (int col : columns) {
                if (positions.contains(new Position(col + shift, col))) {
                    qualifier = qualifier | (1 << multiplier);
                }
                multiplier++;
            }

            return qualifier;
        }

        private int countColumnQualifier(Position lastPosition, Set<Position> positions) {
            int qualifier = 0B00000000;
            int multiplier = 0;
            int[] rows = IntStream.range(0, ROW_COUNT).toArray();
            for (int row : rows) {
                if (positions.contains(new Position(row, lastPosition.col))) {
                    qualifier = qualifier | (1 << multiplier);
                }
                multiplier++;
            }
            return qualifier;
        }

        private int countRowQualifier(Position lastPosition, Set<Position> positions) {
            int qualifier = 0B00000000;
            int multiplier = 0;
            int[] columns = IntStream.range(0, COLUMN_COUNT).toArray();
            for (int column : columns) {
                if (positions.contains(new Position(lastPosition.row, column))) {
                    qualifier = qualifier | (1 << multiplier);
                }
                multiplier++;
            }
            return qualifier;
        }

        private boolean checkQualifier(int qualifier) {
            int initial = 0B1111;
            return (qualifier & initial) == initial
                    || (qualifier >> 1 & initial) == initial
                    || (qualifier >> 2 & initial) == (initial)
                    || (qualifier >> 3 & initial) == (initial);

        }

    }

    static class Position {
        final int row;
        final int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return row == position.row &&
                    col == position.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
