package application;
import chess.ChessException;
import chess.ChessMatch;
import java.util.InputMismatchException;
import java.util.Scanner;
import chess.ChessPosition;
import chess.ChessPiece;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source) ;
				application.UI.clearScreen(); //application é o nome do pacote, não precisa colocar ele, mas vou deixar
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				ChessPiece capturePiece = chessMatch.performChessMove(source, target);
		
			}catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}
