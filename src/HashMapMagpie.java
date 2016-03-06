import java.util.HashMap;
import java.util.Map;

public class HashMapMagpie {
	Map<String,String> responseMap = new HashMap<>();
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	public void buildMap(){
		responseMap.put("no", "Why so negative?");
		responseMap.put("Mrs.", "She sounds like an interesting person.");
		responseMap.put("Mr.", "He sounds like an interesting person.");
		responseMap.put("Ms.", "She sounds like an interesing person.");
		responseMap.put("mother", "Tell me more about your family.");
		responseMap.put("father","Tell me more about your family.");
		responseMap.put("sister", "Tell me more about your family.");
		responseMap.put("brother", "Tell me more about your family.");
		responseMap.put("son", "Tell me more about your family.");
		responseMap.put("daughter", "Tell me more about your family.");
		responseMap.put("Hi", "What would you like to talk about?");
		responseMap.put("Hello", "What would you like to talk about?");
		responseMap.put("cat", "Tell me more about your pets.");
		responseMap.put("dog", "Tell me more about your pets.");
		responseMap.put("movie", "My favorite movie is The Breakfast Club. What is your favorite movie?");
		responseMap.put("music", "I like music. What is your favorite song?");
		responseMap.put("books", "I love reading!  What is your favorite book?");
		responseMap.put("color", "My favorite color is blue.  What is yours?");
	}
	
	public void response(){
		
		for(String key: responseMap.keySet()){
			if(findKeyword(key)){
				printResponse(responseMap.keySet());
				break;
			}
		}
	}
	
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim();
		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.toLowerCase().indexOf(
				goal.toLowerCase(), startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn)
						.toLowerCase();
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1)
						.toLowerCase();
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal.toLowerCase(),
					psn + 1);

		}

		return -1;
	}
	
	
	

	
}
