package cohesicChallenge;

/**
 * @author      Andrew Howell
 * @version		1.0
 */
public class Node {
	private String name;
	private Node ancestor = null;
	private Node[] descendants = null;
	private Boolean selected = false;
	
	/**
	 * Constructor
	 * Sets name and descendants of the Node
	 * !!! Ensure that nodes in a hierarchy have unique names
	 * !!! Current version does not support searching for Nodes with same names
	 * @param name - name of node
	 */
	public Node(String name, Node[] descendants) {
		this.name = name;
		this.descendants = descendants;
		
		//Update the ancestor pointers of the descendants (if any)
		if (descendants != null)
			for(Node descendant: descendants) descendant.setAncestor(this);
	}
	
	
	
	/**
	 * @param ancestor - parent of the current Node
	 */
	private void setAncestor(Node ancestor) {this.ancestor = ancestor;}
	/**
	 * @return Name of the current Node
	 */
	public String getName() {return name;}
	/**
	 * @return Selection status of the current Node
	 */
	public Boolean getSelected() {return selected;}
	/**
	 * @return All descendants of the current Node
	 */
	public Node[] getDescendants() {return descendants;}
	
	
	
	/**
	 * Inspects the current Node and its descendants to find a Node with a particular
	 * @param name - name of the Node that we want to find
	 * @return The Node with the same name as the parameter (returns null if no such Node exists)
	 */
	public Node nodeSearch(String name) {
		//Return the current Node if it has a matching name
		if(this.name.equals(name)) return this;
		//If current node isn't a match, then search its descendants
		else if (descendants != null){
			//Loop/recurse through each descendant until a match is found
			for(Node descendant: descendants) {
				Node foundNode = descendant.nodeSearch(name);
				if(foundNode != null) return foundNode;
			}
		}
		//If no match is found, then return null
		return null;
	}
	
	
	
	/**
	 * Sets current Node as "selected", as well as its ancestors
	 */
	public void select() {
		selected = true;
		if(ancestor != null) ancestor.select();
	}
	
	/**
	 * Sets current Node as "deselected", as well as its descendants
	 */
	public void deselect() {
		selected = false;
		if(descendants != null)
			for(Node descendant: descendants) descendant.deselect();
	}
	
	
	
	/**
	 * Prints the current Node (root) and all its descendants to the terminal
	 */
	public void printHierarchy() {
		//Print info for root Node
		printNodeInfo();
		//Print info for descendants (if any)
		if(descendants != null)
			for(Node descendant: descendants) printHierarchy1(descendant, 1);
		System.out.println();
	}
	
	/**
	 * Complimentary method for printHierarchy()
	 * Prints a sub-Node within a greater hierarchy
	 * @param node - Current Node in the hierarchy we wish to print
	 * @param height - Height of the current Node in the hierarchy tree
	 */
	private void printHierarchy1(Node node, int height) {
		//Properly indent the current Node before printing its info
		int temp = height;
		while(temp > 0) {
			System.out.print("\t");
			temp--;
		}
		
		//Print info for current Node
		node.printNodeInfo();
		//Print info for descendants (if any)
		int descendantHeight = height + 1;
		if(node.getDescendants() != null)
			for(Node descendant: node.getDescendants()) printHierarchy1(descendant, descendantHeight);
	}
	
	/**
	 * Prints relevant data of the Node to the terminal
	 */
	private void printNodeInfo() {
		//If node is selected, then print an 'X' to the terminal
		String temp = " ";
		if (selected) temp = "X";
		System.out.println("[" + temp + "] " + name);
	}
}
