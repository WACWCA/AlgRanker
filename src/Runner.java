import javax.swing.*;

public class Runner {
public static void main(String args[]) {
	ReadFile rf = new ReadFile();
	rf.openFile("FINAL.txt");
	rf.readFileFirst();
	rf.openFile("FINAL.txt");
	String[] list = rf.readFileSecond();
//	rf.openFile("compareThese.txt");
//	rf.readFileFirst();
//	rf.openFile("compareThese.txt");
//	String[] listToCompare = rf.readFileSecond();
	rf.closeFile();
//	AlgorithmRater ar = new AlgorithmRater(list, listToCompare);
	Display display = new Display(list);
    display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    display.setSize(2000,800);
    display.setVisible(true);
	
}
}
