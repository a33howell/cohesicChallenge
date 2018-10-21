package cohesicChallenge;
import java.io.*;

/**
 * @author      Andrew Howell
 * @version		1.0
 */
public class AnatomicalHierarchy {
	private static Node root;
	
	/**
	 * Constructor
	 * Creates chest hierarchy at the root Node
	 * Chest includes lungs and heart hierarchies
	 */
	public AnatomicalHierarchy() {
		root = new Node("Chest", new Node[]{
				initializeLungs(),
				initializeHeart()});
	}
	
	
	
	/**
	 * Creates a Node hierarchy representing the lungs
	 * @return Root Node of the lungs hierarchy
	 */
	private Node initializeLungs() {
		// Create the right lung Node and its descendants
		Node rightLung = new Node("Right Lung", new Node[]{
					new Node("R Superior Lobe", null),
					new Node("R Middle Lobe", null),
					new Node("R Inferior Lobe", null)});
		
		// Create the left lung Node and its descendants
		Node leftLung = new Node("Left Lung", new Node[]{
				new Node("L Superior Lobe", null),
				new Node("L Inferior Lobe", null)});
		
		// Combine left and right lungs into "lungs" hierarchy
		Node lungs = new Node("Lungs", new Node[]{rightLung, leftLung});
		
		return lungs;
	}
	
	
	
	/**
	 * Creates a Node hierarchy representing the heart
	 * @return Root Node of the heart hierarchy
	 */
	private static Node initializeHeart() {
		// Create heart Node and its descendants
		Node heart = new Node("Heart", new Node[]{
					new Node("Left Ventricle", null),
					new Node("Right Ventricle", null),
					new Node("Left Aorta", null),
					new Node("Right Aorta", null),
					new Node("Septum", null)});
		
		return heart;
	}
	
	
	
	/**
	 * Prints error message to the terminal when user provides invalid input
	 */
	private static void printErrorMessage() {
		System.out.println("Invalid input");
		System.out.println("Input must have the form \"select/deselect [node name]\"");
		System.out.println("Input \"END\" to terminate the program");
		System.out.println();
	}
	
	
	
	/**
	 * Creates a chest hierarchy and prints its info to the terminal
	 * @param args - no args are used in this method
	 */
	public static void main(String[] args) {
		//Create a new chest hierarchy and print its info to the terminal
		AnatomicalHierarchy hierarchy = new AnatomicalHierarchy();
		hierarchy.root.printHierarchy();
		
		//Create new buffer reader for user command line input
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		while(!input.equals("END")) {
			try {
				//Take user input
				System.out.print("Input: ");
				input = bufferReader.readLine();
				System.out.println();
				
				//Terminate program if user inputs "END"
				if (input.equals("END")) return;
				
				//Print error message if user provides invalid input
				String[] inputSplit = input.split(" ", 2);
				if (inputSplit.length != 2) {
					printErrorMessage();
					continue;
				}
				
				//Search for Node with given name
				//If no such Node exists, then print an error message
				Node node = root.nodeSearch(inputSplit[1]);
				if (node == null) {
					System.out.println("\"" + inputSplit[1] + "\" not found");
					continue;
				}
				
				//Select specified Node
				if (inputSplit[0].equals("select")) node.select();
				//Deselect specified Node
				else if (inputSplit[0].equals("deselect")) node.deselect();
				//Print error message if user provides invalid input
				else {
					printErrorMessage();
					continue;
				}
				
				//Print updated hierarchy
				hierarchy.root.printHierarchy();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
