package main;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticGroup {
	public List<String> regexes;
	public List<QuestionString> strings;

	public SemanticGroup(List<String> regexes) {
		this.regexes = regexes;
		strings = new ArrayList<QuestionString>(5);
	}

	public void addString(QuestionString qs) {
		strings.add(qs);
	}



	@Override
	public String toString() {
		return "SemanticGroup [regexes=" + regexes + ", strings=" + strings +
			", isValid()=" + isValid() + "]";
	}

	public boolean isValid() {
		for (String regex : regexes) {
			for (QuestionString qs : strings) {
				Matcher m = Pattern.compile(regex).matcher(qs.string);
				if (m.find() != qs.matches) {
					System.out.println("is not valid because regex: " + regex +
						" and qs: " + qs.string + " expects: " + qs.matches);
					return false;
				}
			}
		}
		return true;
	}
}
