package com.example.tictactoeapplication;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

    @Test
    public void Test_01 () { //Test default board filled with "*" on creation
        Game g = new Game();
        char[][] tempBoard = g.getBoard();
        boolean isMatch = true;

        for (int i = 0; i < tempBoard.length; i++) {
            for (int j = 0; j < tempBoard[i].length; j++) {
                isMatch = isMatch && tempBoard[i][j] == '*';
            }
        }
        assertTrue(isMatch);
    }

    @Test
    public void Test_02 () { //Test setName for px and po
        Game g = new Game();

        g.setPxName("Eric");
        g.setPoName("Yam");

        String p1 = g.getPxName();
        String p2 = g.getPoName();

        assertEquals("Eric",p1);
        assertEquals("Yam", p2);
    }

    @Test
    public void Test_03 () { //Test Setting Player Choice where Player X goes first
        Game g = new Game();
        char[][] tempBoard = g.getBoard();
        //By Default, Player X goes first (Eric goes first)
        //Then it should switch to Player O, (Yam goes second)
        g.setPxName("Eric");
        g.setPoName("Yam");

        assertTrue(g.getCurrentPlayer().equals("Eric"));
        g.setPlayerChoice(1,1); //Player X marks (1,1), then it is Player O's turn
        assertTrue(tempBoard[0][0] == 'X'); //board at (1,1) is marked as 'X'

        assertTrue(g.getCurrentPlayer().equals("Yam"));
        g.setPlayerChoice(1,2); //Player O marks (1,2), then it is Player X's turn
        assertTrue(tempBoard[0][1] == 'O'); //board at (1,2) is marked as 'O'


        assertTrue(g.getCurrentPlayer().equals("Eric"));

    }

    @Test
    public void Test_3_5() { //Test Setting player choice where Player O goes first
        Game g = new Game();
        char[][] tempBoard = g.getBoard();

        //Manually set Player O to go first (Yam goes first)
        //Then Player X goes second (Eric goes second)
        g.setPlayerTurn(1);
        g.setPxName("Eric");
        g.setPoName("Yam");

        assertTrue(g.getCurrentPlayer().equals("Yam"));
        g.setPlayerChoice(1,1);
        assertTrue(tempBoard[0][0] == 'O');

        assertTrue(g.getCurrentPlayer().equals("Eric"));
        g.setPlayerChoice(1,2);
        assertTrue(tempBoard[0][1] == 'X');

        assertTrue(g.getCurrentPlayer().equals("Yam"));


    }

    @Test
    public void Test_04() { //Test Error: attempting ot mark an occupied space

        Game g = new Game();
        String expectedError = "Error: slot @(1,1) already occupied.";
        String expectedStatus = "Next player to play is: Eric";
        String expectedStatus2 = "Next player to play is: Yam";


        g.setPlayerTurn(0); //Player X goes first
        g.setPxName("Eric"); //Player X
        g.setPoName("Yam"); //Player O
//        g.checkCurrentStatus();

        //When an error occurs, turn is not passed to the next player
        //The current player must try again to enter a space that is not occupied.
        g.setPlayerChoice(1,1); //Player X marks (1,1)
        g.checkCurrentStatus();

        g.setPlayerChoice(1,1); //Player O marks (1,1), but already occupied
        g.checkCurrentStatus();

//        assertEquals(g.getErrorMsg(), expectedError);

        assertEquals(g.getErrorMsg(),expectedError);
        assertEquals(g.getCurrentStatus(),expectedStatus2);
    }

    @Test
    public void Test_05 () { //Horizontal win
        Game g = new Game();
        //Game setup
        g.setPlayerTurn(0); //Player X goes first
        g.setPxName("Eric"); //Player X
        g.setPoName("Yam"); //Player O

        g.setPlayerChoice(1,1); //x
        g.setPlayerChoice(2,1); //o
        g.setPlayerChoice(1,2); //x
        g.setPlayerChoice(2,2); //o
        g.setPlayerChoice(1,3); //x

        assertEquals("Eric",g.getWinner());

        Game g2 = new Game();
        //Game setup
        g2.setPlayerTurn(0); //Player X goes first
        g2.setPxName("Eric"); //Player X
        g2.setPoName("Yam"); //Player O

        g2.setPlayerChoice(2,1); //x
        g2.setPlayerChoice(1,1); //o
        g2.setPlayerChoice(2,2); //x
        g2.setPlayerChoice(1,2); //o
        g2.setPlayerChoice(2,3); //x

        assertEquals("Eric",g2.getWinner());

        Game g3 = new Game();
        //Game setup
        g3.setPlayerTurn(0); //Player X goes first
        g3.setPxName("Eric"); //Player X
        g3.setPoName("Yam"); //Player O

        g3.setPlayerChoice(3,1); //x
        g3.setPlayerChoice(1,1); //o
        g3.setPlayerChoice(3,2); //x
        g3.setPlayerChoice(1,2); //o
        g3.setPlayerChoice(3,3); //x

        assertEquals("Eric",g3.getWinner());

    }

    @Test
    public void Test_06(){ //Vertical win
        Game g2 = new Game();
        //Game setup
        g2.setPlayerTurn(0); //Player X goes first
        g2.setPxName("Eric"); //Player X
        g2.setPoName("Yam"); //Player O

        g2.setPlayerChoice(1,1); //x
        g2.setPlayerChoice(1,2); //o
        g2.setPlayerChoice(2,1); //x
        g2.setPlayerChoice(1,3); //o
        g2.setPlayerChoice(3,1); //x

        assertEquals("Eric",g2.getWinner());
    }

    @Test
    public void Test_07 () { //Diagonal win

        Game g2 = new Game();
        //Game setup
        g2.setPlayerTurn(0); //Player X goes first
        g2.setPxName("Eric"); //Player X
        g2.setPoName("Yam"); //Player O

        g2.setPlayerChoice(1,1); //x
        g2.setPlayerChoice(1,3); //o
        g2.setPlayerChoice(2,2); //x
        g2.setPlayerChoice(1,2); //o
        g2.setPlayerChoice(3,3); //x

        assertEquals("Eric",g2.getWinner());
    }

    @Test
    public void Test_08(){ //Reverse diagonal win

        Game g2 = new Game();
        //Game setup
        g2.setPlayerTurn(0); //Player X goes first
        g2.setPxName("Eric"); //Player X
        g2.setPoName("Yam"); //Player O

        g2.setPlayerChoice(1,3); //x
        g2.setPlayerChoice(1,1); //o
        g2.setPlayerChoice(2,2); //x
        g2.setPlayerChoice(1,2); //o
        g2.setPlayerChoice(3,1); //x

        assertEquals("Eric",g2.getWinner());
    }
}