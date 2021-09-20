
public class Likelihood {
	// 9 first possible moves, 6 next possible moves, 6 possible 3rd moves
	private int[][][] countOccurences = new int[9][9][9];
	private int[][] countFirstTwoMoves = new int [9][9];
	private String[] algDatabase;
	public Likelihood(String[] algDatabase) {
		this.algDatabase = algDatabase;
		//set all counters to 0;
		for(int i = 0; i <countOccurences.length; i++) {
			for(int j = 0; j < countOccurences[0].length; j++) {
				for(int k = 0; k < countOccurences[0][0].length; k++) {
					countOccurences[i][j][k] = 1;
					countFirstTwoMoves[j][k]=1;
				}
			}
		}
		evaluateProbabilities();
	}
	public void evaluateProbabilities() {
		String[] arr;
		for(String str:algDatabase) {
			//turn the string to an array of moves
			arr = AlgToArray.makeArray(str);
			//Increase the count for the specified first 2 moves
			countFirstTwoMoves[turnToNum(arr[0])][turnToNum(arr[1])] +=1 ;
			//Increase the count for each 3 move sequence
			for(int i = 2; i < arr.length; i++) {
				countOccurences[turnToNum(arr[i-2])][turnToNum(arr[i-1])][turnToNum(arr[i])] +=1;
			}
		}
		
		//Printing the results
		/*for(int i = 0; i <countOccurences.length; i++) {
			for(int j = 0; j < countOccurences[0].length; j++) {
				for(int k = 0; k < countOccurences[0][0].length; k++) {
					if(countOccurences[i][j][k]!=0) {
					System.out.println(numToTurn(i) + " " + numToTurn(j) + " " + numToTurn(k)+ ": " + countOccurences[i][j][k]);
					}
				}
			}
		}
		for(int j = 0; j < countOccurences[0].length; j++) {
			for(int k = 0; k < countOccurences[0][0].length; k++) {
				if(countFirstTwoMoves[j][k]!=0) {
					System.out.println(numToTurn(j) + " " + numToTurn(k)+ ": " + countFirstTwoMoves[j][k]);
					}
				}
			}*/
		}
	
	
	
	
	
	
	// converts a read move into an integer indicating the position in a matrix
	public static int turnToNum(String str){
		if(str.charAt(0)==('R')) {
			if(str.length()==1) {return 0;}
			if(str.charAt(1)==('\t')) {return 0;}
			if(str.charAt(1)==('2')) {return 1;}
			if(str.charAt(1)==('\'')) {return 2;}
		}
		if(str.charAt(0)=='U') {
			if(str.length()==1) {return 3;}
			if(str.charAt(1)==('\t')) {return 3;}
			if(str.charAt(1)==('2')) {return 4;}
			if(str.charAt(1)==('\'')) {return 5;}
		}
		if(str.charAt(0)=='F') {
			if(str.length()==1) {return 6;}
			if(str.charAt(1)==('\t')) {return 6;}
			if(str.charAt(1)==('2')) {return 7;}
			if(str.charAt(1)==('\'')) {return 8;}
		}
		return -1;
	}
	public static String numToTurn(int i) {
		String[] s = new String[]{"R","R2", "R'", "U", "U2", "U'", "F", "F2", "F'"};
		return s[i];
	}
	public int[][][] getCountOccurences(){return countOccurences;}
	public int [][] getCountFirstTwoMoves(){return countFirstTwoMoves;}
}
