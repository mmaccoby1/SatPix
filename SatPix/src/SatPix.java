import java.io.*;
import java.util.Scanner;

public class SatPix {

	public static void main(String[] args) throws IOException
	{
		/*boolean[][] booleanArr = fileToBoolArray("satpix.in");
		int sizeOfLargestPasture;
		
		YOUR CODE GOES HERE 
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("satpix.out")));
		out.println(sizeOfLargestPasture);
		out.close();
		}*/
		boolean[][] bill = fileToBoolArray("satpix.pdf");
		for(int r = 0; r<bill.length; r++){
			for(int c = 0; c<bill[0].length; c++){
				System.out.print(bill[r][c]);
			}
			System.out.println();
		}
	}
	
	private static boolean[][] fileToBoolArray(String fileName) throws FileNotFoundException, IOException
	{
		Scanner bob = new Scanner(new File(fileName));
		int col = bob.nextInt();
		int row = bob.nextInt();
		boolean[][] steve = new boolean[row][col];
		for(int r = 0; r<row; r++){
			String jeff = new String(bob.next());
			for(int c = 0; c<col; c++){
				if(jeff.charAt(c)=='*')
					steve[r][c] = true;
				else
					steve[r][c] = false;
			}
		}
		return steve;
			
	}

	private static int recursivelyMeasureAndMarkPasture(int row, int col, boolean[][] arr)
	{
		//This recursive method employs the flood-fill algorithm to
		//count the size of a single pasture and "mark" it so it is not double-counted
		return 0;
	}
	
}