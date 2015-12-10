package main;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static final String filePath = "/Users/carlchapman/Desktop/inputData.txt";
	private static final String M = "METAGROUP";
	private static final String E = "END";
	private static final String R = "REGEX";
	private static final String S = "STRING";
	private static final String D = "•";
	private static final String T = "T";

	public static void main(String[] args) throws IOException {
		List<Metagroup> mgroups = new ArrayList<Metagroup>(10);
		List<String> lines = Files.readAllLines(new File(filePath).toPath(), StandardCharsets.UTF_8);
		//System.out.println(lines);
		Metagroup currentMetagroup = null;
		SemanticGroup currentSemanticGroup = null;
		for (String line : lines) {
			if(line.equals(E)){
				currentMetagroup.addGroup(currentSemanticGroup);
				mgroups.add(currentMetagroup);
			}else if (line.equals(M)) {
				if (currentMetagroup != null) {
					mgroups.add(currentMetagroup);
					currentMetagroup.addGroup(currentSemanticGroup);
				}
				currentMetagroup = new Metagroup();
				currentSemanticGroup = null;
			}else if (line.startsWith(R)){

				if(currentSemanticGroup != null){
					currentMetagroup.addGroup(currentSemanticGroup);
				}
				String[] tokens = line.split(D);
				ArrayList<String> regexes = new ArrayList<String>();
				for(int i=1;i<tokens.length;i++){
					regexes.add(tokens[i]);
				}
				currentSemanticGroup = new SemanticGroup(regexes);
			}else if(line.startsWith(S)){
				String[] tokens = line.split(D);
				QuestionString qs = new QuestionString(tokens[1], T.equals(tokens[2]));
				currentSemanticGroup.addString(qs);;
			}
		}
		for(Metagroup mg : mgroups){
			System.out.println(mg);	
		}
	}
}
