package com.basics;


import java.util.HashSet;

/**
 * For a full filled valid Sudoku:
 * 1). Grid size is 9x9, divided into 9 regions of 3x3
 * 2). Each row must contain all digits from 1-9
 * 3). Each column must contain all digits from 1-9
 * 4). Each 3x3 square must contain all digits from 1-9
 * <p>
 * For a partial filled valid Sudoku: Empty cells are filled with the character.
 * 1). Each row can only have the numbers 1-9 occuring just once.
 * 2). Each column can only have the numbers 1-9 occuring just once.
 * 3). And the numbers 1-9 must occur just once in each of the 9 sub-boxes of the grid.
 */
public class Sudoku {

    private static final int GRID_SIZE = 9;

    public static boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < GRID_SIZE; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> columns = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();

            for (int j = 0; j < GRID_SIZE; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !columns.add(board[j][i])) {
                    return false;
                }

                int rowIndex = 3 * (i / 3) + j / 3;
                int colIndex = 3 * (i % 3) + j % 3;
                if (board[rowIndex][colIndex] != '.' && !cube.add(board[rowIndex][colIndex])) {
                    return false;
                }
            }
        }
        return true;
    }
}
