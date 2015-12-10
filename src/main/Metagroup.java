package main;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;

public class Metagroup {
	List<SemanticGroup> groups;
	
	public Metagroup(){
		this.groups = new LinkedList<SemanticGroup>();
	}

	public void addGroup(SemanticGroup group){
		groups.add(group);
	}
	
	public ImmutablePair<String, List<QuestionString>> getPairAt(int index){
		int rIndex = 0;
		for(SemanticGroup sg : groups){
			for(String regex : sg.regexes){
				if(rIndex++ == index){
					return new ImmutablePair<String, List<QuestionString>>(regex,sg.strings);
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		int nRegexes = 0;
		int nStrings = 0;
		for(SemanticGroup sg : groups){
			nRegexes += sg.regexes.size();
			nStrings += sg.strings.size();
		}
		return "Metagroup [ nGroups: " + groups.size() + " nRegexes: " + nRegexes + " nStrings: " + nStrings + " groups=" + groups + "]";
	}
	
	
}
