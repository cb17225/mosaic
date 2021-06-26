// Volkov, Matvey
import java.awt.*;
import java.util.Scanner;

public class MosaicCreator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of rows: ");
		int rows = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter the number of columns: ");
		int columns = Integer.parseInt(scanner.nextLine());
		int width = 40;
		int height = 40;
		Mosaic.open(rows, columns, width, height);
		Mosaic.fill(Color.BLACK);
		//r: red, c: cyan, y: yellow, w: white
		//g: green, b: blue, m: magenta, anything else: black);
		for (int i = 0; i < rows; i++) {
			System.out.print("Row #" + (i + 1) + "? ");
			String input = scanner.nextLine();
			char[] inputArray = createUserArray(input, columns);
			for (int j = 0; j < columns; j++) {
				interpretInput(i, j, inputArray);
			}
		}
		while (Mosaic.isOpen()) {
			Mosaic.delay(1000);
			for (int i = 0; i < rows; i++)	{
				for (int j = 0; j < columns; j++)	{
					changeColor(i, j);
				}
			}
		}
	}
	
	private static void changeColor(int row, int column) {
		if (Mosaic.getColor(row, column).equals(Color.RED)) {
			Mosaic.setColor(row, column, Color.CYAN);
		} else if (Mosaic.getColor(row, column).equals(Color.CYAN)) {
			Mosaic.setColor(row, column, Color.YELLOW);
		} else if (Mosaic.getColor(row, column).equals(Color.GREEN)) {
			Mosaic.setColor(row, column, Color.BLUE);
		} else if (Mosaic.getColor(row, column).equals(Color.BLUE)) {
			Mosaic.setColor(row, column, Color.MAGENTA);
		} else if (Mosaic.getColor(row, column).equals(Color.YELLOW)) {
			Mosaic.setColor(row, column, Color.WHITE);
		} else if (Mosaic.getColor(row, column).equals(Color.MAGENTA)) {
			Mosaic.setColor(row, column, Color.BLACK);
		} else if (Mosaic.getColor(row, column).equals(Color.WHITE)) {
			Mosaic.setColor(row, column, Color.GREEN);
		} else {
			Mosaic.setColor(row, column, Color.RED);
		}
	}
	
	private static void interpretInput(int r, int c, char[] array) {
		switch (array[c]) {
		case 'r':
			Mosaic.setColor(r, c, Color.RED);
			break;
		case 'c':
			Mosaic.setColor(r, c, Color.CYAN);
			break;
		case 'g':
			Mosaic.setColor(r, c, Color.GREEN);
			break;
		case 'b':
			Mosaic.setColor(r, c, Color.BLUE);
			break;
		case 'y':
			Mosaic.setColor(r, c, Color.YELLOW);
			break;
		case 'm':
			Mosaic.setColor(r, c, Color.MAGENTA);
			break;
		case 'w':
			Mosaic.setColor(r, c, Color.WHITE);
			break;
		default :
			Mosaic.setColor(r, c, Color.BLACK);
		}
	}
	
	private static char[] createUserArray(String userInput, int colNum) {
		char[] array = new char[colNum];
		if (userInput.length() - colNum > 0) {
			for (int k = 0; k < colNum; k++) {
				array[k] = userInput.charAt(k);
			}
		} else {
			for (int k = 0; k < userInput.length(); k++) {
				array[k] = userInput.charAt(k);
			}
		}
		return array;
	}
}
