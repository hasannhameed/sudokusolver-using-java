
public class sudokusolver2 {
    public static final int BOARD_SIZE=9;
    public boolean solvesudoku(int[][] board)
    {
        int row=0;
        int col=0;
        boolean isEmpty=true;
        for(int i=0;i<BOARD_SIZE;i++){
            for(int j=0;j<BOARD_SIZE;j++){
                if(board[row][col]==0)
                {
                    row=i;
                    col=j;
                    isEmpty =false;
                    break;
                }
            }
            if(!isEmpty)
            {
               break;
            }
        }
        if(isEmpty)
        {
            return true;
        }
        {
             for(int number=1;number<BOARD_SIZE;number++)
                {
                    if(isEmpty(board,row,col,number))
                    {
                    board[row][col]=number;
                    }
                    if(solvesudoku(board))
                    {
                        return true;
                    }
                    else
                    {
                        board[row][col]=0;
                    }
                }
        }
        return false;

    }
    public boolean isEmpty(int [][] board,int row,int col,int number)
    {
        for(int i=0;i<BOARD_SIZE;i++)
        {
            if(board[row][i]==number||board[i][col]==number)
            {
                return false;
            }
        }
        // Check if the number exists in the current 3x3 grid
        int gridrow=row-row%3;
        int gridcol=col-col%3;
        for(int i=0;i<BOARD_SIZE;i++)
        {
            if(board[gridrow+i][gridcol+i]==number)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[])
    {
        int[][] puzzle={
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        sudokusolver2 solver= new sudokusolver2();
        if(solver.solvesudoku(puzzle))
        {
            System.out.println("sudoku puzzle solved");
            printboard(puzzle);
        }
        else{
            System.out.print("No solution is founded");
        }
    }
    public static void printboard(int [][]board)
    {
        for(int i=0;i<BOARD_SIZE;i++)
        {
            for(int j=0;j<BOARD_SIZE;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

}
    