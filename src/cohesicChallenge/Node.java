package cohesicChallenge;

/**
 * @author      Andrew Howell
 * @version		1.0
 */
public class Node {
	private String name;
	private Node ancestor = null;
	private Node[] descendants;
	private Boolean selected = false;
	
	/**
	 * Constructor
	 * @param name - 
	 * @param ancestor - parent of the current Node
	 * @param descendants - children of the current Node
	 */
	public Node(String name, Node ancestor, Node[] descendants) {
		this.name = name;
		this.ancestor = ancestor;
		this.descendants = descendants;
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
		for(Node descendant: descendants) descendant.deselect();
	}
}
