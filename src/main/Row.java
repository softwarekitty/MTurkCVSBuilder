package main;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.tuple.ImmutablePair;

public class Row {
	List<ImmutablePair<String, List<QuestionString>>> pairs;
	
	public Row(){
		pairs = new LinkedList<ImmutablePair<String, List<QuestionString>>>();
	}
	
	public void addPair(ImmutablePair<String, List<QuestionString>> pair){
		pairs.add(pair);
	}
	
	public void shuffle(Random gen){
		Collections.shuffle(pairs, gen);
	}
}
