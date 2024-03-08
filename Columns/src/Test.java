import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 

import enigma.core.Enigma;
public class Test {
	static enigma.console.Console cn = Enigma.getConsole("Column", 50, 15, 40, 7);
	static KeyListener klis;
	static int keypr;
	static int rkey;
	static int playerScore = 0;
	static SingleLinkedList Box = new SingleLinkedList();
	static SingleLinkedList c1 = new SingleLinkedList();
	static SingleLinkedList c2 = new SingleLinkedList();
	static SingleLinkedList c3 = new SingleLinkedList();
	static SingleLinkedList c4 = new SingleLinkedList();
	static SingleLinkedList c5 = new SingleLinkedList();
	static String[] highScoreTable = new String[50];
	public static void main(String[] args) {
		
		// Load High Score Table
		
		try {
			
	    	File hst_file = new File("HighScoreTable.txt");
	        Scanner Reader = new Scanner(hst_file);
	        int i = 0;
	        
	        while (Reader.hasNextLine()) {
	        	String data = Reader.nextLine();
	        	highScoreTable[i]=data;
	        	i++;
		      }
		      Reader.close();	 
		    } catch (FileNotFoundException e) {
		      System.out.println("File not found.");
		      e.printStackTrace();
		    }
		
		Box.fillingBox();

		// Filling Columns
		for (int i = 0; i < 6; i++) {
			c1.add(Box.choosingRandomNumber());
			c2.add(Box.choosingRandomNumber());
			c3.add(Box.choosingRandomNumber());
			c4.add(Box.choosingRandomNumber());
			c5.add(Box.choosingRandomNumber());
		}
		displayScreen();
		// Key Events
		/*cn.getTextWindow().setCursorPosition(5,3);
		System.out.println(Box.choosingRandomNumber());*/
		
		
		/*keypr = 0;
		klis = new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if (keypr == 0) {
					keypr = 1;
					rkey = e.getKeyCode();
				}
			}

			public void keyReleased(KeyEvent e) {
			}
		};
		cn.getTextWindow().addKeyListener(klis);*/
	}
	
	static void displayScreen() {
		cn.getTextWindow().setCursorPosition(3,2);
		System.out.println("C1  C2  C3  C4  C5     Transfer:     \n   --  --  --  --  --     Score   : ");
		cn.getTextWindow().setCursorPosition(26,6);
		System.out.println("Box");
		cn.getTextWindow().setCursorPosition(26,7);
		System.out.println("+--+");
		cn.getTextWindow().setCursorPosition(26,8); // 28 ya 8 rastgele gelen number yazdýrýlacak
		System.out.println("|  |");
		cn.getTextWindow().setCursorPosition(26,9);
		System.out.println("+--+");
		
		// display columns
		c1.displayColumn(1);
		c2.displayColumn(2);
		c3.displayColumn(3);
		c4.displayColumn(4);
		c5.displayColumn(5);
		
		// HST test
		cn.getTextWindow().setCursorPosition(0,15);

		int x = 0;
		while(highScoreTable[x]!=null) {
			System.out.println(highScoreTable[x]);
			x++;
		}
		
	}

}
