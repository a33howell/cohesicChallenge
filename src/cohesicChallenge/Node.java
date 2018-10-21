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
	 * @param name - name of node
	 */
	public Node(String name) {
		this.name = name;
		this.ancestor = ancestor;
		this.descendants = descendants;
	}
	
	
	
	/**
	 * @param ancestor - parent of the current Node
	 */
	public void setAncestor(Node ancestor) {this.ancestor = ancestor;}
	/**
	 * @param descendants - children of the current Node
	 */
	public void setDescendants(Node[] descendants) {this.descendants = descendants;}
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
		if(descendants != null) for(Node descendant: descendants) descendant.deselect();
	}
	
	
	
	/**
	 * Prints the current Node (root) and all its descendants to the terminal
	 */
	public void printHierarchy() {
		//Print info for root Node
		printNodeInfo();
		//Print info for descendants (if any)
		if(descendants != null) for(Node descendant: descendants) printHierarchy1(descendant, 1);
	}
	
	/**
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
		if(node.getDescendants() != null) for(Node descendant: node.getDescendants()) printHierarchy1(descendant, descendantHeight);
	}
	
	/**
	 * Prints relevant data of the Node to the terminal
	 */
	private void printNodeInfo() {
		String temp = " ";
		if (selected) temp = "X";
		System.out.println("[" + temp + "] " + name);
	}
}
