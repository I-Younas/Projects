import java.util.*;

public class A2_Q1 {

 public static int[] game(String[][] board) {

  int number_balls = 0;//number of balls on the board

  //get number of balls and their positions
  for (int i = 0; i < board.length; i++)//iterates through the rows
  {
   for (int j = 0; j < board[i].length; j++)//iterates through the columns
   {
    if (board[i][j].equals("o")) {
     number_balls++;
    }
   }
  }

  if(number_balls == 0){
   return new int[]{0,0};
  }

  int[] minMoves=movement_possibilities(board,0,number_balls,0,number_balls);

  return minMoves;
 }

 public static int[] movement_possibilities(String[][] board,int jumps, int number_balls,int min_jumps,int min_ball_count) {


  for (int i = 0; i < board.length; i++)//iterates through the rows
  {
   for (int j = 0; j < board[i].length; j++)//iterates through the columns
   {
    boolean left=false;
    boolean right=false;
    boolean up=false;
    boolean down=false;

    if (board[i][j].equals("o")) {

     //left check
     if ((j >= 2) && (board[i][j - 1].equals("o")) && (!board[i][j-2].equals("#")) && (!board[i][j-2].equals("o"))) {

      left = true;
      board[i][j - 2] = "o";
      board[i][j - 1] = ".";
      board[i][j] = ".";


//                        System.out.println("Movement left:");
//                        display_grid(board);
//                        System.out.println();

      jumps++;
      number_balls--;

      int[] result_array = movement_possibilities(board, jumps, number_balls, min_jumps,min_ball_count);
      int result_balls = result_array[0];
      int result_jumps = result_array[1];

      if ((result_balls == min_ball_count) && (result_jumps < min_jumps)) {
       min_jumps = result_jumps;

      }
      else if (result_balls < min_ball_count) {
       min_ball_count = result_balls;
       min_jumps = result_jumps;
      }

     }

     //undoing the left move
     if (left == true) {

      board[i][j - 2] = ".";
      board[i][j - 1] = "o";
      board[i][j] = "o";

      jumps--;
      number_balls++;


//                        System.out.println("Backtracking left:");
//                        display_grid(board);
//                        System.out.println();
     }

     //right check
     if (((j+2)<board[i].length) && (board[i][j + 1].equals("o")) && (!board[i][j + 2].equals("#")) && (!board[i][j+2].equals("o"))) {

      right = true;
      board[i][j + 2] = "o";
      board[i][j + 1] = ".";
      board[i][j] = ".";

//                        System.out.println("Movement right:");
//                        display_grid(board);
//                        System.out.println();

      jumps++;
      number_balls--;

      int[] result_array = movement_possibilities(board, jumps, number_balls, min_jumps,min_ball_count);
      int result_balls = result_array[0];
      int result_jumps = result_array[1];

      if ((result_balls == min_ball_count) && (result_jumps < min_jumps)) {
       min_jumps = result_jumps;

      }
      else if (result_balls < min_ball_count) {
       min_ball_count = result_balls;
       min_jumps = result_jumps;
      }
     }


     //undoing the right move
     if (right == true) {

      board[i][j + 2] = ".";
      board[i][j + 1] = "o";
      board[i][j] = "o";

//                        System.out.println("Backtracking right:");
//                        display_grid(board);
//                        System.out.println();

      jumps--;
      number_balls++;

     }
     //down check
     if (((i+2)<board.length) && (board[i + 1][j].equals("o")) && (!board[i + 2][j].equals("#")) && (!board[i+2][j].equals("o"))) {

      down = true;
      board[i + 2][j] = "o";
      board[i + 1][j] = ".";
      board[i][j] = ".";

      jumps++;
      number_balls--;

//                        System.out.println("Movement down:");
//                        display_grid(board);
//                        System.out.println();

      int[] result_array = movement_possibilities(board, jumps, number_balls,min_jumps,min_ball_count);
      int result_balls = result_array[0];
      int result_jumps = result_array[1];

      if ((result_balls == min_ball_count) && (result_jumps < min_jumps)) {
       min_jumps = result_jumps;

      }
      else if (result_balls < min_ball_count) {
       min_ball_count = result_balls;
       min_jumps = result_jumps;
      }
     }


     //undoing the down move
     if (down == true) {

      board[i + 2][j] = ".";
      board[i + 1][j] = "o";
      board[i][j] = "o";

      jumps--;
      number_balls++;

//                        System.out.println("Backtracking down:");
//                        display_grid(board);
//                        System.out.println();
     }

     //up check
     if ((i>=2) && (board[i - 1][j].equals("o")) && (!board[i - 2][j].equals("#")) && (!board[i-2][j].equals("o")) ) {
      up = true;

      board[i - 2][j] = "o";
      board[i - 1][j] = ".";
      board[i][j] = ".";

//                        System.out.println("Movement up:");
//                        display_grid(board);
//                        System.out.println();


      jumps++;
      number_balls--;

      int[] result_array = movement_possibilities(board, jumps, number_balls,min_jumps,min_ball_count);
      int result_balls = result_array[0];
      int result_jumps = result_array[1];


      if ((result_balls == min_ball_count) && (result_jumps < min_jumps)) {
       min_jumps = result_jumps;

      }
      else if (result_balls < min_ball_count) {
       min_ball_count = result_balls;
       min_jumps = result_jumps;
      }

     }

     //undoing the up move
     if (up == true) {
      board[i - 2][j] = ".";
      board[i - 1][j] = "o";
      board[i][j] = "o";

      jumps--;
      number_balls++;

//                        System.out.println("Backtracking up:");
//                        display_grid(board);
//                        System.out.println();

     }


    }
   }
  }

  if(number_balls<min_ball_count){
   min_ball_count=number_balls;
   min_jumps=jumps;
  }
  else if ((number_balls == min_ball_count) && (jumps < min_jumps)) {
   min_jumps = jumps;

  }
//
//        System.out.println("Minimum Balls:" + min_ball_count);
//        System.out.println("Minimum Jumps:" + min_jumps);
//        System.out.println();



  int [] answer=new int[]{min_ball_count,min_jumps};
  return answer;
 }


 public static void display_grid(String[][] board) {
  for (int i = 0; i < board.length; i++) {
   for (int j = 0; j < board[i].length; j++) {
    System.out.print(board[i][j] + " ");
   }
   System.out.println();
  }
 }

 public static void main(String[] args) {

  String[][] input_string = new String[4][8];
  input_string = new String[][]{
          {"#", "#", "#", ".", "o", ".", "#", "#", "#"},
          {".", ".", ".", "o", "o", ".", "o", ".", "."},
          {".", ".", "o", ".", ".", ".", "o", ".", "."},
          {"o", ".", ".", "o", ".", ".", ".", ".", "."},
          {"#", "#", "#", ".", ".", ".", "#", "#", "#"}

  };
  String[][] input_string7=new String[][]{
          {"#", "#", "#", "o", "o", ".", "#", "#", "#"},
          {"o", ".", ".", ".", ".", ".", ".", ".", "."},
          {".", ".", ".", ".", "o", ".", ".", ".", "o"},
          {".", "o", "o", "o", ".", ".", ".", ".", "."},
          {"#", "#", "#", ".", ".", ".", "#", "#", "#"}

  };
  String[][] input_string3=new String[][]{
          {"#", "#", "#", ".", ".", ".", "#", "#", "#"},
          {"o", ".", "o", ".", "o", ".", ".", ".", "o"},
          {".", ".", "o", ".", ".", ".", "o", ".", "."},
          {".", ".", ".", ".", ".", ".", "o", ".", "."},
          {"#", "#", "#", ".", ".", ".", "#", "#", "#"}

  };


  //movement_possibilities(input_string3,0,8,8,0);
  //game(input_string3);
 }
}


