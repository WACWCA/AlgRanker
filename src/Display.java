import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Display extends JFrame {
	private JButton reset;
	private JButton submit;
	private JLabel name;
	private JLabel title;
	private JTextArea enterAlgs;
	private JScrollPane scrollpane;
	private String[] list;
	public Display(String[] l){
	 super("Algorithm trainer");
	 list = l;
     setLayout(new GridBagLayout());
     GridBagConstraints c = new GridBagConstraints();
     
     c.gridheight=1;
     c.ipadx=150;
     c.gridwidth=1;
     c.gridx=2;
     c.gridy=0;
     c.fill=GridBagConstraints.BOTH;
     name = new JLabel("	Made by Will Callan");
     name.setFont(new Font("Times",Font.PLAIN,16));
     add(name,c);
     
     c.gridheight=1;
     c.gridwidth=1;
     c.gridx=1;
     c.gridy=0;
     c.fill=GridBagConstraints.BOTH;
     reset = new JButton("Clear");
     reset.setPreferredSize(new Dimension(150,75));
     reset.setFont(new Font("Times",Font.PLAIN,28));
     add(reset,c);
     
     c.gridheight=1;
     c.gridwidth=1;
     c.gridx=0;
     c.gridy=0;
     c.fill=GridBagConstraints.BOTH;
     title = new JLabel("2x2 Algorithm Sorter	");
     title.setFont(new Font("Times",Font.PLAIN,16));
     add(title,c);
     
     c.gridx=0;
     c.gridy=1;
     c.gridwidth=3;
     c.ipady=450;
     c.ipadx=450;
     enterAlgs = new JTextArea("Enter text here... \n \n");
     enterAlgs.setFont(new Font("Times",Font.PLAIN, 20));
     scrollpane = new JScrollPane(enterAlgs);
     enterAlgs.setEditable(true);
     add(scrollpane,c);
     
     c.fill=GridBagConstraints.BOTH;
     submit = new JButton("Submit");
    // submit.setFont(new Font("Times",Font.PLAIN,28));
     c.ipady=0;
     c.ipadx=0;
     c.gridx=0;
     c.gridy=2;
     c.gridwidth=3;
     c.gridheight=1;
     submit.setPreferredSize(new Dimension(150,75));
     submit.setFont(new Font("Times",Font.PLAIN,28));
     c.fill=GridBagConstraints.BOTH;
     add(submit,c);
     
     submit.addActionListener(new SubmitHandler());
     reset.addActionListener(new ResetHandler());
	}
	
	
	private class SubmitHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String[] algs = (enterAlgs.getText()).split("\n");
			algs = removeImproper(algs);
			AlgorithmRater ar = new AlgorithmRater(list, algs);
			
			String[] resultsList = ar.getResults();
			String output = "";
			for(String s: resultsList ) {
				output += (s+"\n");
			}
			enterAlgs.setText(output);
		}
		public String[] removeImproper(String[] s) {
			
			int counter = 0;
			String[] returner;
			String[] bad = new String[] {"A","a","B","b","C","c","D","d","E","e","G","g","H","h","I","i","J","j","K","k","L","l","M","m","N","n","O","o","P","p","Q","q","S","s","T","t","V","v","W","w","X","x","Y","y","Z","z","0","1","3","4","5","6","7","8","9"};
			//for each string
			for(int i = 0; i<s.length; i++) {
				// for each bad letter
				for(String str: bad) {
					// if the string isnt null and contains the bad letter, make it equal to null
					if(s[i]!=null&&(s[i].equals("")||s[i].equals(" "))) {s[i]=null;}
					if(s[i]!=null && s[i].contains(str)) {s[i]=null;}
				}
				// if the string isnt null increase the counter
				if(s[i]!=null){counter++;}
		}
			//the length of returner is the size of the counter
			returner = new String[counter];
			int i = 0;
				for(String str:s) {
					if(str!=null) {returner[i]=str; i++;}
				}
			
			return returner;
			}
			
	}
	private class ResetHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			enterAlgs.setText("");
			
		}
		
	}
	
}
