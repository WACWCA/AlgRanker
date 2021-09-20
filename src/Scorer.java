
public class Scorer {
public Scorer() {}
static int getScore(String s) {
	int algScore = 0;
	String[] sArray = makeArray(s);
	int l = sArray.length-1;
	//Scores the first move
	System.out.println(sArray[0]);
	if(sArray[0].length()==1) {
		if(sArray[0].equals("R")) {algScore +=20;}
		if(sArray[0].equals("F")) {algScore -= 5;}
	}else {
		if(sArray[0].equals("R'")) {algScore += 20;} 
		else if(sArray[0].equals("F'")) {algScore -= 5;}
		else if(sArray[0].equals("F2")) {algScore -= 10;}
		else if(sArray[0].equals("R2")) {algScore += 10;}
	}
	//Scores the last move
	if(sArray[l].length()==1) {
		if(sArray[l].equals("R")) {algScore +=20;}	
		if(sArray[l].equals("F")) {algScore -= 5;}
	}else{
		if(sArray[l].equals("R'")) {algScore +=20;}
		else if(sArray[l].equals("F'")) {algScore -=5;}
		else if(sArray[l].equals("F2")) {algScore -= 10;}
		else if(sArray[l].equals("R2")) {algScore += 10;}
	}
	//Checks for symmetry
	int matching = 0;
	if(sArray.length%2==1){
		for(int i =0; i < (sArray.length/2); i++) {
		if(sArray[i].substring(0,1).equals(sArray[l-i].substring(0,1))) {matching++;}
	}
	}
	if(matching==(sArray.length/2)) {algScore += 50;}
	
	// Gives points for each Ax1 Bx Ax2 format
	int multiplier = 10;
	for(int i = 2; i< sArray.length; i++) {
		if(sArray[i].charAt(0)==(sArray[i-2].charAt(0))){
			algScore += multiplier;
			multiplier +=10;
		}else {multiplier = 0;}
		
	}
	//Subtracts points based on moves
	algScore -=((sArray.length)*5);
	
	//count number of occurances for percentages
	for(int i = 0; i < sArray.length; i++) {
		int fPercent = 0;
		int f2Percent = 0;
		int fpPercent = 0;
		int rPercent = 0;
		int r2Percent = 0;
		int rpPercent = 0;
		int uPercent = 0;
		int u2Percent = 0;
		int upPercent = 0;
		if(sArray[i].equals("F")) {fPercent++;}
		if(sArray[i].equals("F2")) {f2Percent++;}
		if(sArray[i].equals("F'")) {fpPercent++;}
		if(sArray[i].equals("R")) {rPercent++;}
		if(sArray[i].equals("R2")) {r2Percent++;}
		if(sArray[i].equals("R'")) {rpPercent++;}
		if(sArray[i].equals("U")) {uPercent++;}
		if(sArray[i].equals("U2")) {u2Percent++;}
		if(sArray[i].equals("U'")) {upPercent++;}
	}

	System.out.println(algScore);
	return algScore;
}
public static String[] makeArray(String moves){
    int moveCount = 0;
    String[] ismove = {"R","r","U","u","F","f","L","l","d","D","B","b"};
     
    for(int i = 0; i < moves.length(); i++)
        for(int j = 0; j< ismove.length;j++){
            if (moves.substring(i,i+1).equals(ismove[j])){
                moveCount ++;
            }
        }
    String[] moveArray = new String[moveCount];
    
    String holder = "";
    int arpos = 0;
    for (int i = 0; i < moves.length(); i++){
        int button = 0;
        
        for (int j = 0; j < ismove.length;j++)
        {if(moves.charAt(i)==(ismove[j]).charAt(0)){
            button = 1;
        }
        
    }
    if (button == 1 && (arpos <= moveCount - 1)){
        holder += moves.charAt(i);
            if(i<moves.length()-1 && moves.charAt(i+1)!=' '){
                holder += moves.charAt(i+1);
                moveArray[arpos]= holder;
                arpos ++;
                holder = "";
            } else if(arpos <= moveCount - 1){ 
                moveArray[arpos]= holder;
                arpos++;
                holder = "";
            }
        }
    }
    return moveArray;
}
}
