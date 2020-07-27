/**
 * Name: Eric Truong
 * Date: November 19, 2019
 * Description: Add 5 points to a stack, plot them on a grid, then remove them, and place numbers at the coordinates and
 * neighboring points
 */

import java.awt.Point;

public class Stacks {
    public static void main (String[] args){

        //create a new stack
        LinkedStack stack = new LinkedStack();

        //make a 5x5 array and populate it
        char [][] board = new char[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                board[i][j] = '.';
            }
        }

        //prompt user for 5 points
        System.out.print("Please enter 5 points: \n");

        int counter = 1;
        for(int i = 0; i < 5; i++){

            System.out.print("x" + counter + ": ");
            int x = CheckInput.getIntRange(0, 4);
            System.out.print("y" + counter + ": ");
            int y = CheckInput.getIntRange(0, 4);

            Point coord = new Point(x, y);

            stack.push(coord);

            counter++;

            if(i == 4){
                System.out.println();
            }

        }

        //keep removing points till the stack is empty, and put numbers at those coordinates and the neighbors
        for(int i = 5; i > 0; i--){
            char number = (char) (i + '0');
            Point select = stack.pop();
            int row = select.y;
            int column = select.x;

            board[row][column] = number;

            row += 1;

            if(row > 4 || row < 0){
                row -= 1;
            }
            else{
                board[row][column] = number;
                row -= 1;
            }

            row -= 1;

            if(row > 4 || row < 0){
                row += 1;
            }
            else{
                board[row][column] = number;
                row += 1;
            }

            column += 1;

            if(column > 4 || column < 0){
                column -= 1;
            }
            else{
                board[row][column] = number;
                column -= 1;
            }

            column -= 1;

            if(column > 4 || column < 0){
                column += 1;
            }
            else{
                board[row][column] = number;
                column += 1;
            }

        }

        //print out the board
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
