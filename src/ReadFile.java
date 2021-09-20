import java.io.*;
import java.util.*;



public class ReadFile {
    private Scanner scanner;
    private String[] list;
    
    public void openFile(String fileName){
        try{scanner = new Scanner(new File(fileName));
            
        }
        catch(Exception e){
           
        }
    }
    
    public void readFileFirst(){
        int i = 0;
        
        while(scanner.hasNext()){
            String a = scanner.nextLine();
            if (!(a.contains("ept"))) {
            i++;}
        
    }
        list = new String[i];    
}
    public String[] readFileSecond(){  
    int i = 0;    
        while(scanner.hasNext()){
            String a = scanner.nextLine();
           if(!(a.contains("ept"))){
            list[i] = a;
             i++;
           }
        
    }
        //for(int k = 0; k< list.length; k++) {
    	//	if(list[k].substring(0,3).equals("U2 ")||list[k].substring(0,3).equals("U' ")) {
    			//list[k]=list[k].substring(3);
    		//}
    	//}
    return list;
    }
    
    
    public void closeFile(){
        scanner.close();
    }
        
    }