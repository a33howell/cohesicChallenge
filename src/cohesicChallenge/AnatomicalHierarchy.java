package cohesicChallenge;

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
		root = new Node("Chest");
		Node lungs = initializeLungs();
		Node heart = initializeHeart();
		root.setDescendants(new Node[]{lungs, heart});
	}
	
	
	
	/**
	 * Creates a Node hierarchy representing the lungs
	 * @return Root Node of the lungs hierarchy
	 */
	private Node initializeLungs() {
		// Create the right lung Node and its descendants
		Node rightLung = new Node("Right Lung");
		rightLung.setDescendants(new Node[]{
					new Node("Superior Lobe"),
					new Node("Middle Lobe"),
					new Node("Inferior Lobe")});
		
		// Create the left lung Node and its descendants
		Node leftLung = new Node("Left Lung");
		leftLung.setDescendants(new Node[]{
				new Node("Superior Lobe"),
				new Node("Inferior Lobe")});
		
		// Combine left and right lungs into "lungs" hierarchy
		Node lungs = new Node("Lungs");
		lungs.setDescendants(new Node[]{rightLung, leftLung});
		
		return lungs;
	}
	
	
	
	/**
	 * Creates a Node hierarchy representing the heart
	 * @return Root Node of the heart hierarchy
	 */
	private static Node initializeHeart() {
		// Create heart Node and its descendants
		Node heart = new Node("Heart");
		heart.setDescendants(new Node[]{
					new Node("Left Ventricle"),
					new Node("Right Ventricle"),
					new Node("Left Aorta"),
					new Node("Right Aorta"),
					new Node("Septum")});
		
		return heart;
	}
	
	
	
	/**
	 * Creates a chest hierarchy and prints its info to the terminal
	 * @param args - no args are used in this method
	 */
	public static void main(String[] args) {
		//Create a new chest hierarchy and print its info to the terminal
		AnatomicalHierarchy hierarchy = new AnatomicalHierarchy();
		hierarchy.root.printHierarchy();
	}
}
