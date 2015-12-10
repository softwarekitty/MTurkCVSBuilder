package main;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.tuple.ImmutablePair;

public class Metagroup {
	List<SemanticGroup> groups;
	int index;
	
	public Metagroup(int index){
		this.index = index;
		this.groups = new LinkedList<SemanticGroup>();
	}

	public void addGroup(SemanticGroup group){
		groups.add(group);
	}
	
	public ImmutablePair<String, List<QuestionString>> getPairAt(int index, Random gen){
		int rIndex = 0;
		for(SemanticGroup sg : groups){
			for(String regex : sg.regexes){
				if(rIndex++ == index){
					List<QuestionString> qstrings = new LinkedList<QuestionString>(sg.strings);
					Collections.shuffle(qstrings,gen);
					return new ImmutablePair<String, List<QuestionString>>(regex,qstrings);
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
