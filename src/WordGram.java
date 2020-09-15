/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author Kadriye Sude Almus
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for (int i = 0; i < size; i++) {
			myWords[i] = source[i+start];
		}
		myToString = "";
		myHash = 0;
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Return number of words in this WordGram
	 * @return integer length of myWords
	 */
	public int length(){
		return myWords.length;
	}


	/**
	 * Return a boolean representing whether this WordGram equals the object passed in the parameter
	 * @param o is an object
	 * @return boolean whether this WordGram equals o
	 */
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}

		else {
			WordGram wg = (WordGram) o;
			if (wg.toString().equals(this.toString())) {
				return true;
			}
			return false;
		}
	}

	@Override
	public int hashCode(){
		// TODO: complete this method: assign to myHash as needed
		if (myHash == 0) {
			myHash = this.toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * Create a new WordGram object with k entries whose first k-1 entries are
	 * the same as the last k-1 entries of this WordGram
	 * and whose last entry is the parameter last
	 * @param last is last String of returned WordGram
	 * @return shifted WordGram with last added to the end
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		for (int i = 0; i < myWords.length - 1; i++) {
			wg.myWords[i] = wordAt(i+1);
		}
		wg.myWords[myWords.length-1] = last;

		return wg;
	}

	@Override
	public String toString(){
		if (myToString.equals("")) {
			myToString = String.join(" ",myWords); }
		return myToString;
	}
}
