package LeetCode.Daily_Challenge.Medium.Design_Spreadsheet;

public class Solution {
    
    class Spreadsheet {
        private int[][] grid;

        public Spreadsheet(int rows) {
            grid = new int[rows][26];
        }

        public void setCell(String cell, int value) {
            int[] pos = parseCell(cell);
            grid[pos[0]][pos[1]] = value;
        }

        public void resetCell(String cell) {
            int[] pos = parseCell(cell);
            grid[pos[0]][pos[1]] = 0;
        }

        public int getValue(String formula) {
            String expr = formula.substring(1); 
            String[] parts = expr.split("\\+");

            return getOperandValue(parts[0]) + getOperandValue(parts[1]);
        }

        private int getOperandValue(String operand) {
            if (Character.isLetter(operand.charAt(0))) {
                int[] pos = parseCell(operand);
                return grid[pos[0]][pos[1]];
            } else
                return Integer.parseInt(operand);
        }

        private int[] parseCell(String cell) {
            int col = cell.charAt(0) - 'A';
            int row = Integer.parseInt(cell.substring(1)) - 1;
            return new int[]{row, col};
        }
    }
}
