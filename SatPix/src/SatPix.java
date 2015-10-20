import java.io.*;
import java.util.Scanner;

public class SatPix {

	public static void main(String[] args) throws IOException
	{
		boolean[][] bill = fileToBoolArray("satpix.txt");
		int joe = 0;
		int fred = 0;
		for(int r = 0; r<bill.length; r++){
			for(int c = 0; c<bill[0].length; c++){
				if(bill[r][c]==true){
					fred = recursivelyMeasureAndMarkPasture(r, c, bill);
					if(fred>joe)
						joe=fred;
				}
			}
		}
		PrintWriter peter = new PrintWriter(new BufferedWriter(new FileWriter("satpix.out")));
		peter.println(joe);
		peter.close();
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
		if (row >= 0
				&& col >= 0
				&& row < arr.length
				&& col < arr[0].length
				&& arr[row][col]==true)
		{
			arr[row][col] = false;
			return 1 + recursivelyMeasureAndMarkPasture(row+1, col, arr)
					+ recursivelyMeasureAndMarkPasture(row-1, col, arr)
					+ recursivelyMeasureAndMarkPasture(row, col-1, arr)
					+ recursivelyMeasureAndMarkPasture(row, col+1, arr);
		}
		return 0;
	}
	
	
}