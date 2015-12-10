package main;

public class QuestionString {
	public final String string;
	public final boolean matches;

	public QuestionString(String string, boolean matches) {
		this.string = string;
		this.matches = matches;

	}

	@Override
	public String toString() {
		return "QuestionString [string=" + string + ", matches=" + matches +
			"]";
	}
}
