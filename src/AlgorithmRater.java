import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;
public class AlgorithmRater {
private String[] topList;
private String[] results;
public AlgorithmRater(String[] list, String[] listToCompareTo) {
	LinkedHashSet<String> tempList = new LinkedHashSet<String>(Arrays.asList(listToCompareTo));
    listToCompareTo = tempList.toArray(new String[tempList.size()]);
    double[] algRatings = rate(list, listToCompareTo);
    Dictionary algPoints = new Hashtable();
    for(int i = 0; i<listToCompareTo.length; i++) {
    	algPoints.put(algRatings[i], listToCompareTo[i]);
    }
    ArrayList sortedKeys=new ArrayList(((Hashtable) algPoints).keySet());
    Collections.sort(sortedKeys);
    
    results = new String[sortedKeys.size()];
    
    
    for (int i = 0; i < sortedKeys.size(); i++)  
        results[i]=(sortedKeys.get(i) +" " +  algPoints.get(sortedKeys.get(i)));

}
public double[] rate(String[] list, String[] listToCompareTo) {
	Likelihood l = new Likelihood(list);
	int [][][] likelihood1 = l.getCountOccurences();
	int[][] likelihood2 = l.getCountFirstTwoMoves();
	double[] ratings = new double[listToCompareTo.length];
	double score;
	
	for(int i = 0; i< listToCompareTo.length; i++) {
		//convert the alg we are working with to an array
		score = 0;
		String[] sArray = AlgToArray.makeArray(listToCompareTo[i]);
		//calculate the percentage chance for the 3 move sequence and add it to the total score
		for(int j = 2; j < sArray.length; j++) {
			double occ = likelihood1[Likelihood.turnToNum(sArray[j-2])][Likelihood.turnToNum(sArray[j-1])][Likelihood.turnToNum(sArray[j])];
			double subtotal = 0;
			//calculates the total occurences to calculate probability
			for (int k = 0; k<9; k++) {
		
				subtotal+= likelihood1[Likelihood.turnToNum(sArray[j-2])][Likelihood.turnToNum(sArray[j-1])][k];
			}
			//add the log of the percentage of the 3rd moves in the sequence
			//System.out.println("Occurence/subtotal: "+ occ + "/"+subtotal+" log:"+Math.log(occ/subtotal));
			score += Math.log(occ/subtotal);// else {score += (-5);}
			//System.out.println("score = " + score);
			
		}
		//calculate the percentage chance for the second move and add it to the score
			double occ1 = likelihood2[Likelihood.turnToNum(sArray[0])][Likelihood.turnToNum(sArray[1])];
			double subtotal1 = 0;
			for (int k = 0; k<9; k++) {
		//		System.out.println(" " + Likelihood.turnToNum(sArray[k]));
				subtotal1+= likelihood2[Likelihood.turnToNum(sArray[0])][k];
			}
			 {score += Math.log(occ1/subtotal1);} //else {score += (-5);}
			//count all of the first moves
			int totalDataPoints = 0;
			for(int[] firstMoves: likelihood2) {
				for(int secondMoves: firstMoves) {
					totalDataPoints += secondMoves;
				}
			}
			// total for the move chosen / complete total
			 {score += Math.log(subtotal1/totalDataPoints);} //else {score += (-5);}
			ratings[i] = score;
	}
	return ratings;
	
}
public String[] getResults() {
	return results;
}
}
