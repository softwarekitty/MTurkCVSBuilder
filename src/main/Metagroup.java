package main;

import java.util.LinkedList;
import java.util.List;

public class Metagroup {
	List<SemanticGroup> groups;
	
	public Metagroup(){
		this.groups = new LinkedList<SemanticGroup>();
	}

	public void addGroup(SemanticGroup group){
		groups.add(group);
	}

	@Override
	public String toString() {
		return "Metagroup [groups=" + groups + "]";
	}
	
	
}
