
import java.util.*;

public class game {


	// board = ["ram", "seeta", "radha"]
	static String[] board;
	static String sider;

	static String checkWinner()
	{
		for (int a = 0; a < 8; a++) {
			String line = null;

			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
		
			if (line.equals("XXX")) {
				return "X";
			}
			
			
			else if (line.equals("OOO")) {
				return "O";
			}
		}
		
		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(
					String.valueOf(a + 1))) {
				break;
			}
			else if (a == 8) {
				return "draw";
			}
		}

		System.out.println(
			sider + "'s sider; enter a slot number to place "
			+ sider + " in:");
		return null;
	}
	

	static void printBoard()
	{
		System.out.println("|---|---|---|");
		System.out.println("| " + board[0] + " | "
						+ board[1] + " | " + board[2]
						+ " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | "
						+ board[4] + " | " + board[5]
						+ " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | "
						+ board[7] + " | " + board[8]
						+ " |");
		System.out.println("|---|---|---|");
	}

	// here, we have to decide whether the chance goes to which side. 
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		board = new String[9];
		sider = "X";
		String winner = null;

		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a + 1);
		}

		System.out.println("Welcome to 3x3 Tic Tac Toe.");
		printBoard();

		System.out.println(
			"X will play first. Enter a slot number to place X in:");

		while (winner == null) {
			int testt;
		
			try {
				testt = in.nextInt();
				if (!(testt > 0 && testt <= 9)) {
					System.out.println(
						"Invalid input; re-enter slot number:");
					continue;
				}
			}
			catch (InputMismatchException e) {
				System.out.println(
					"Invalid input; re-enter slot number:");
				continue;
			}
			

			if (board[testt - 1].equals(
					String.valueOf(testt))) {
				board[testt - 1] = sider;

				if (sider.equals("X")) {
					sider = "O";
				}
				else {
					sider = "X";
				}

			      {
				printBoard();
				winner = checkWinner();
			}
				System.out.println(
					"Slot already taken; re-enter slot number:");
			}
		}

		if (winner.equalsIgnoreCase("draw")) {
			System.out.println(
				"It's a draw! Thanks for playing.");
		}

		else {
			System.out.println(
				"Congratulations! " + winner
				+ "'s have won! Thanks for playing.");
		}
	in.close();
	}
}
