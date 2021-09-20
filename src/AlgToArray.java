
public class AlgToArray {

	public static String[] makeArray(String moves){
	    int moveCount = 0;
	    //create list of characters signaling moves
	    String[] ismove = {"R","r","U","u","F","f"};
	     
	    //Counts the number of characters that signal moves in the string
	    for(int i = 0; i < moves.length(); i++) {
	        for(int j = 0; j< ismove.length;j++){
	            if (moves.substring(i,i+1).equals(ismove[j])){
	                moveCount ++;
	            }
	        }
	    }
	    //Create an array with that amount of strings
	    String[] moveArray = new String[moveCount];
	    
	    String holder = "";
	    int arpos = 0;
	    for (int i = 0; i < moves.length(); i++){
	        int button = 0;
	        //for each of the possible moves
	        for (int j = 0; j < ismove.length;j++)
	        	//if it matches the possible move
	        {if(moves.charAt(i)==(ismove[j]).charAt(0)){
	        	//set to true
	            button = 1;
	        }
	        
	    }
	        //if button is true  and the array position is within the number of moves
	    if (button == 1 && (arpos <= moveCount - 1)){
	    	//add the move to the holder
	        holder += moves.charAt(i);
	        //if the string is not over and the next character is not a space
	            if(i<moves.length()-1 && moves.charAt(i+1)!=' '){
	                if(moves.charAt(i+1)!=')') {holder += moves.charAt(i+1);}
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
	    if(moveArray[0].contains("U")) {
	    	String[] tempArray = moveArray;
	    	moveArray = new String[moveArray.length-1]; 
	    	for(int i = 0; i < moveArray.length; i++ ) {
	    		moveArray[i]=tempArray[i+1];	    		
	    	}
	    }
	    if(moveArray[moveArray.length-1].contains("U")) {
	    	String[] tempArray = moveArray;
	    	moveArray = new String[moveArray.length-1]; 
	    	for(int i = 0; i < moveArray.length; i++ ) {
	    		moveArray[i]=tempArray[i];	    		
	    	}
	    }
	    return moveArray;
	}
}
