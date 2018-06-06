import java.util.*;
public class Node {
	private Node parent_;
	private ArrayList<Node> children_;
	private String name_;
	//creating variable names
	public Node(String n, Node p) {
		name_ = n;
		parent_ = p;
		children_ = new ArrayList<Node>();
	}
	public String name() {
		return name_;
	}
	public void addChild(Node n) {
		children_.add(n);
	}
	public ArrayList<Node> children(){
		return children_;
	}
	public Node parent() {
		return parent_;
	}
	public void setParent(Node p) {
		parent_=p;
	}
}
