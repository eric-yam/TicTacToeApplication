package com.example.tictactoeapplication;

public class GameTester {

    public static void main(String[] args) {
        Game g = new Game();


//        System.out.println(g.toString()); //initial board
//        g.setPxName("Cire");
//        g.setPoName("Eric");
////        System.out.println(g.getCurrentPlayer());
//
//        System.out.println();
//        g.setPlayerChoice(1,1);
//        g.checkCurrentStatus();
//        System.out.println(g.toString());
////        System.out.println(g.getCurrentPlayer());
//
//        System.out.println();
//        g.checkCurrentStatus();
//        g.setPlayerChoice(1,2);
//        System.out.println(g.toString());
////        System.out.println(g.getCurrentPlayer());

        g.setPxName("Cire"); //player x : Cire
        g.setPoName("Eric"); //player O : Eric
        g.setPlayerTurn(0);
        g.checkCurrentStatus();
        System.out.println(g.toString());

        g.setPlayerChoice(1,1); //x
        System.out.println(g.toString());
        g.setPlayerChoice(2,1); //o
        System.out.println(g.toString());
        g.setPlayerChoice(1,2); //x
        System.out.println(g.toString());
        g.setPlayerChoice(2,2); //o
        System.out.println(g.toString());
        g.setPlayerChoice(1,3); //x
        System.out.println(g.toString());




//        //Testing Player X wins
//
//        g.setPlayerChoice(1,3);//x
//        g.checkCurrentStatus();
//        System.out.println(g.toString());
//        System.out.println("reverse diagonal win : " + g.checkReverseDiagonal());
//
//        g.setPlayerChoice(1,2);
//        g.checkCurrentStatus();
//        System.out.println(g.toString());
//        System.out.println("reverse diagonal win : " + g.checkReverseDiagonal());
//
//        g.setPlayerChoice(2,2);//x
//        g.checkCurrentStatus();
//        System.out.println(g.toString());
//        System.out.println("reverse diagonal win : " + g.checkReverseDiagonal());
//
//        g.setPlayerChoice(3,2);
//        g.checkCurrentStatus();
//        System.out.println(g.toString());
//        System.out.println("reverse diagonal win : " + g.checkReverseDiagonal());
//
//        g.setPlayerChoice(3,1);//x wins
//        g.checkCurrentStatus();
//        System.out.println(g.toString());
//        System.out.println("reverse diagonal win : " + g.checkReverseDiagonal());




        // Test Error: space is already occupied

//        g.setPlayerChoice(1,1);
//        g.checkCurrentStatus(); //updates the Current status string
//        System.out.println(g.toString());
//
//        g.setPlayerChoice(1,1);
//        g.checkCurrentStatus();
//        System.out.println(g.toString());



//        //Checking fullboard
//        g.setPlayerChoice(2,1);//x
//        g.checkCurrentStatus();
//        System.out.println(g.toString());
//        System.out.println(g.checkFullBoard());
//
//        g.setPlayerChoice(1,1);//x
//        g.checkCurrentStatus();
//        System.out.println(g.toString());
//        System.out.println(g.checkFullBoard());
//
//        g.setPlayerChoice(2,2);//x
//        g.checkCurrentStatus();
//        System.out.println(g.toString());
//        System.out.println(g.checkFullBoard());
//
//        g.setPlayerChoice(2,3);//x
//        g.checkCurrentStatus();
//        System.out.println(g.toString());
//        System.out.println(g.checkFullBoard());
//
//        g.setPlayerChoice(3,2);//x
//        g.checkCurrentStatus();
//        System.out.println(g.toString());
//        System.out.println(g.checkFullBoard());
//
//        g.setPlayerChoice(1,2);//x
//        g.checkCurrentStatus();
//        System.out.println(g.toString());
//        System.out.println(g.checkFullBoard());
//
//        g.setPlayerChoice(3,3);//x
//        g.checkCurrentStatus();
//        System.out.println(g.toString());
//        System.out.println(g.checkFullBoard());
//
//        g.setPlayerChoice(3,1);//x
//        g.checkCurrentStatus();
//        System.out.println(g.toString());
//        System.out.println(g.checkFullBoard());
//
//        g.setPlayerChoice(1,3);//x
//        g.checkCurrentStatus();
//        System.out.println(g.toString());
//        System.out.println(g.checkFullBoard());






    }
}
