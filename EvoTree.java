import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.HashMap;
public class EvoTree  implements Tester{
	public ArrayList<String> compute( Scanner log ){
//creating compute arraylist
		String childName;
		String parentName;
		HashMap<String,Node> map = new HashMap();

		while(log.hasNextLine()) {
			
			String s = log.nextLine();
			if(s.equals("end")) {
				break;
			}
			String[] sts = s.split(" evolved from ");
			//going through the code
			childName = sts[0];
			parentName = sts[1];
			Node child;
			if(map.containsKey(childName)) {
				child=map.get(childName);
			}
			else {
				child = new Node(childName,null);
				map.put(childName, child);
			}
			Node parent;
			if(map.containsKey(parentName)) {
				parent = map.get(parentName);
			}
			else {
				parent = new Node(parentName, null);
				map.put(parentName, parent);
			}
			parent.children().add(child);
			child.setParent(parent);
		}
		Node root=null;
		for(String key: map.keySet()) {
			Node  n = map.get(key);
			n.children().sort((p1, p2) -> p1.name().compareTo(p2.name()));
			if(n.parent() == null) {
				root = n; //if there is no parent then it is the root. 
			}
		}
		//creating new arraylist if root is null
		if(root==null) {
			return new ArrayList<String>();
		}
		return dfs(root);
	}
	private ArrayList<String> dfs(Node n){
		ArrayList<String> result = new ArrayList<String>();
		result.add(n.name());
		for(Node child:n.children()) {
			dfs(child,0,result);
		}
		return result;
	}
	//creating the phylogenetic tree very similar to previous assignment. 
	private void dfs(Node n, int depth, ArrayList<String> result) {
		String s ="|";
		for(int i=0;i<depth; ++i) {
			s+=" |";
		}
		s += "-" + n.name();
		result.add(s);
		for(Node child:n.children()) {
			dfs(child,depth+1,result);
		}
	}
}
