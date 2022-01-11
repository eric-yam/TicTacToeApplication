package com.example.tictactoeapplication;

public class Game {

    //Attributes
    private char [][] board;
    private String pxName;
    private String poName;
    private int pTurn;

    private String currentStatus;
    private String errorMsg;

    private boolean error;
    private boolean gameOver;

    private String winner;

    //Constructor (overloaded)
    public Game () {
        this.board = new char[3][3];
        this.setDefaultBoard(); //fills the board with default character '*'
        this.pTurn = 0;
        this.pxName = "";
        this.poName = "";

        this.currentStatus = ""; //Reports who plays next or if game is over

        this.errorMsg = ""; //Reports error messages
        this.error = false; //flag indicates an error has occured

        this.gameOver = false; //flag indicates if the game is over

        this.winner = "";
    }

    public Game(String px, String po, String turnFirst) {
        this.board = new char[3][3];
        this.setDefaultBoard(); //fills the board with default character '*'
        this.pTurn = this.firstTurn(turnFirst);
        this.pxName = px;
        this.poName = po;

        this.currentStatus = ""; //Reports who plays next or if game is over

        this.errorMsg = ""; //Reports error messages
        this.error = false; //flag indicates an error has occured

        this.gameOver = false; //flag indicates if the game is over

        this.winner = "";
    }

    //Error handling methods
    public void resetError() {
        this.error = false;
        this.errorMsg = "";
    }

    public void setErrorMsg (String msg) {
        this.error = true;
        this.errorMsg = msg;
    }


    //Mutator Methods
    public void setDefaultBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                this.board[i][j] = '*';
            }
        }
    }

    public void setPxName (String newName) {
        this.pxName = newName;
    }

    public void setPoName (String newName) {
        this.poName = newName;
    }

    public void setPlayerTurn (int turn) {
        /*
        * Player Turn :
        * 0 is Player X's turn
        * 1 is Player O's turn
        *
        * By Default, Player X is player 1 and Player O is player 2
        * */

        this.pTurn = turn;
    }

    public void setPlayerChoice (int r, int c) {
        //When board is already full
        //When space is already occupied
        //When someone has already won

        //rank each error

        //convert r,c values into valid indicies
        int row = r - 1;
        int col = c - 1;
        if (this.gameOver) { //if the game is over, cannot mark a new space, must restart the game
            this.setErrorMsg("Error: Game is already over.");
        }else if (this.board[row][col] != '*') { //If (row,col) is not '*', space is already occupied
            this.setErrorMsg("Error: slot @(" + r + "," + c + ") already occupied.");
        } else { //no error, valid choice
            this.resetError();
            if (this.pTurn == 0) { // Player X sets 'X' at (row,col)
                this.board[row][col] = 'X';
                this.checkWinner();
                this.passTurn(); //Pass turn to the next player
            } else if (this.pTurn == 1) { //Player O sets 'O' at (row,col)
                this.board[row][col] = 'O';
                this.checkWinner();
                this.passTurn(); //Pass turn to the next player;
            }
        }
    }

    public void passTurn () {
        if (!gameOver) {
            if (this.pTurn == 0) {
                this.pTurn = 1;
            } else if (this.pTurn == 1) {
                this.pTurn = 0;
            }
        }
    }

    public void setCurrentStatus (String message) {
        this.currentStatus = message;
    }

    public void checkCurrentStatus () {

        if (!this.gameOver) { //If the game is not over, another player may still have a turn
            this.setCurrentStatus("Next player to play is: " + this.getCurrentPlayer());
        } else { //When game is over, display who is the winner or tie game
            //A tie occurs when the board is full, but there is no winner
            //A game is won when either player has a horizontal, vertical or diagonal
            if (this.getWinner().equals("")) { // a tie has occurred
                this.setCurrentStatus("Game is over with a tie between " + this.getPxName() + " and " + this.poName);
            }else {
                this.setCurrentStatus("Game is over with " + this.getWinner() + " as the winner.");
            }
        }
    }

    public void setGameOver (boolean isOver) {
        this.gameOver = isOver;
    }

    public void checkWinner() {
        if (this.checkHorizontal() || this.checkVertical() || this.checkDiagonal() || this.checkReverseDiagonal()) {
            this.setGameOver(true);
            this.setWinner(this.getCurrentPlayer());
        } else if (this.checkFullBoard()) { //if neither player has a horizontal,vertical,diagonal, and the board is now full, game is over as a tie
            this.setGameOver(true);
            this.setWinner("");
        }
    }


    public void setWinner (String p) {
        this.winner = p;
    }

    //Accessor Methods
    public char[][] getBoard () {
        return this.board;
    }
    public String getPxName (){
        return this.pxName;
    }
    public String getPoName () {
        return this.poName;
    }

    public String getWinner() {return this.winner;}

    public String getErrorMsg() { return this.errorMsg;}

    public int getpTurn () {
        return this.pTurn;
    }

    public int firstTurn (String ft) {
        int val = 0;
        if (ft.equalsIgnoreCase("Player X")) {
            val = 0;
        }else if (ft.equalsIgnoreCase("Player O")) {
            val = 1;
        }
        return val;
    }

    public String getCurrentPlayer () {
        String p = "";

        if (this.getpTurn() == 0) { //Player X is playing next
            p = this.getPxName();
        } else if (this.getpTurn() == 1) { //Player O is playing next
            p = this.getPoName();
        }

        return p;
    }

    public String getCurrentStatus() {
        return this.currentStatus;
    }


    public boolean checkHorizontal() {
        boolean isHorizontal = false;

        for (int i = 0; i < this.board.length; i++) {
            boolean isRow = true;
            for (int j = 0; j < this.board[i].length; j++) {

                if (this.pTurn == 0) { //Look for 'X's
                    isRow = isRow && this.board[i][j] == 'X';
                } else if (this.pTurn == 1) { //Look for 'O's
                    isRow = isRow && this.board[i][j] == 'O';
                }

            }
            isHorizontal = isHorizontal || isRow;
        }
        return isHorizontal;
    }

    public boolean checkVertical() {
        boolean isVertical = false;

        for (int i = 0; i < this.board.length; i++) {
            boolean isColumn = true;
            for (int j = 0; j < this.board[i].length; j++) {

                if (this.pTurn == 0) { //Look for 'X's
                    isColumn = isColumn && this.board[j][i] == 'X';
                }else if (this.pTurn == 1) {// Look for 'O's
                    isColumn = isColumn && this.board[j][i] == 'O';
                }
            }
            isVertical = isVertical || isColumn;
        }
        return isVertical;
    }

//
    public boolean checkDiagonal() {
        boolean isDiagonal = true;

        for (int i = 0; i < this.board.length; i++) {
            for (int j = i; j <= i; j++) {
                if (this.pTurn == 0) { //Look for 'X's
                    isDiagonal = isDiagonal && this.board[i][j] == 'X';
                } else if (this.pTurn == 1) { // Look for 'O's
                    isDiagonal = isDiagonal && this.board[i][j] == 'O';
                }
            }
        }
        return isDiagonal;
    }
//
    public boolean checkReverseDiagonal() {
        boolean isRevDiagonal = true;

        for (int i = 0; i < this.board.length; i++) {
            for (int j = this.board[i].length - 1 - i; j >= this.board[i].length - 1 - i; j--) {
                if (this.pTurn == 0) { //Look for 'X's
                    isRevDiagonal = isRevDiagonal && this.board[i][j] == 'X';
                } else if (this.pTurn == 1) { // Look for 'O's
                    isRevDiagonal = isRevDiagonal && this.board[i][j] == 'O';
                }
            }
        }
        return isRevDiagonal;
    }

    public boolean checkFullBoard() {
        boolean isFull = true;

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                isFull = isFull && this.board[i][j] != '*';
            }
        }
        return isFull;
    }


    @Override
    public String toString() {
        String s = "";

        if (error) {
            s += this.errorMsg;
            s += "\n";
        }
        s += "Current Game Status:" + "\n";

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length;j++) {
                s += this.board[i][j];
            }
            s += "\n";
        }

        this.checkCurrentStatus();
        s += this.getCurrentStatus();

        return s;
    }

} //End of Class
