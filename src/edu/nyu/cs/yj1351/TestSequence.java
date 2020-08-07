package edu.nyu.cs.yj1351;

/**
 * A program that display characters and words in a sentence
 * 
 * @author Yaojia Ju
 * @version 1.0
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * abstract class of OrderedThing
 */
abstract class OrderedThing {
	private int index;
	private String content;
	
	/**
	 * no-args constructor.
	 */
	public OrderedThing() {
	}
	
	/**
	 * Constructor of OrderedThing
	 * @param s a String that contain the content of the object
	 * @param index the position of the object in the sequence
	 */
	public OrderedThing(String s, int index) {
		this.setContent(s);
		this.setIndex(index);
	}
	
	
	/**
	 * 
	 * Getter method for the content of the object
	 * @return a string presenting the content of the object
	 */
	public String getContent() {
		return this.content;
	}
	
	/**
	 * 
	 * Setter method for the content of the object
	 * @param s a String that contain the content of the object
	 */
	public void setContent(String s) {
		this.content = s;
	}
	
	/**
	 * 
	 * Getter method for the position of the object
	 * @return an integer presenting the position of the object
	 */
	public int getIndex() {
		return this.index;
	}
	
	/**
	 * 
	 * Setter method for the position of the object
	 * @param i an integer presenting the position of the object
	 */
	public void setIndex(int i) {
		if (i >= 0) this.index = i;
	}
	
	
}

/**
 * Character class
 */
class Character extends OrderedThing {
	
	/**
	 * no-args constructor.
	 */
	public Character() {	
	}
	
	/**
	 * Overload constructor of Character
	 * @param s a String that contain the content of the Character object
	 * @param n the position of the Character object in the sequence
	 */
	public Character(String s, int n) {	
		super(s,n);
	}

}

/**
 * Word class
 */
class Word extends OrderedThing implements SequentiallyOrdered {
	
	private ArrayList<Character> characters = new ArrayList<Character>();
	private int pos;
	
	/**
	 * no-args constructor.
	 */
	public Word() {
	}
	
	/**
	 * Overload constructor of Word
	 * @param w a String that contain the content of the Word object
	 * @param n the position of the Word object in the sequence
	 */
	public Word(String w, int n) {
		super(w,n);
		//Split words and add new Character objects to the ArrayList
		for(int i=0;i<w.length();i++) {
			OrderedThing character = new Character(java.lang.Character.toString(w.charAt(i)),n);
			characters.add((Character)character);
		this.pos = this.getIndex();
		}
	}
	
	/**
	 * 
	 * Getter method for the position of the object
	 * @return an integer presenting the position of the object
	 */
	public int getPosition() {
		return this.pos;
	}
	
	/**
	 * Get the first character of the word
	 * @return the first character of the word as an OrderedThing object
	 */
	@Override
	public OrderedThing getFirst() {
		return characters.get(0);
	}
	
	/**
	 * Get the last character of the word
	 * @return the last character of the word as an OrderedThing object
	 */
	@Override
	public OrderedThing getLast() {
		return characters.get(characters.size()-1);
	}
	
	/**
	 * Get a sequence of the Character objects
	 * @return a sequence of the Character objects in Word as an ArrayList
	 */
	@Override
	public ArrayList<OrderedThing> getSequence() {
		ArrayList<OrderedThing> characterList = new ArrayList<OrderedThing>();
		for (Character c : characters) characterList.add((OrderedThing)c);
		return characterList;
	}
	
	/**
	 * Convert the content of OrderedThing object to a string
	 * @param o an OrderedThing object
	 * @return the content of OrderedThing object as a string
	 */
	public String toString(OrderedThing o) {
		return o.getContent();
	}
	
	/**
	 * Convert the sequence of OrderedThing object to a string
	 * @param o an ArrayList of OrderedThing objects
	 * @return the sequence of OrderedThing object as a string
	 */
	public String toStringList (ArrayList<OrderedThing> o) {
		String[] list = new String[o.size()];
		for (int i =0;i<o.size();i++) {
			list[i] = o.get(i).getContent();
		}
		return Arrays.toString(list);
	}
}

/**
 * Sentence class
 */
class Sentence implements SequentiallyOrdered {
	
	private ArrayList<Word> words = new ArrayList<Word>();
	
	/**
	 * no-args constructor.
	 */
	public Sentence() {
	}
	
	/**
	 * Overload constructor of Sentence, adding each Word of the sentence to the ArrayList<Word>
	 * @param completeSen a sentence entered by the user
	 */
	public Sentence(String completeSen) {
		//split the sentence and convert words to Word object and put into the ArrayList
		String[] rawWords = completeSen.split("[, !?.]");
		int count = 0;
		for(String w: rawWords) {
			if (w.length()>0) {
				OrderedThing word = new Word(w,count);
				words.add((Word)word);
				count++;
			}
		}
	}

	/**
	 * Get the first word of the sentence
	 * @return the first word of the sentence as an OrderedThing object
	 */
	@Override
	public OrderedThing getFirst() {
		return words.get(0);
	}
	
	/**
	 * Get the last word of the sentence
	 * @return the last word of the sentence as an OrderedThing object
	 */
	@Override
	public OrderedThing getLast() {
		return words.get(words.size()-1);
	}
	
	/**
	 * Get a sequence of the Word objects
	 * @return a sequence of the Word objects in the sentence as an ArrayList
	 */
	@Override
	public ArrayList<OrderedThing> getSequence(){
		ArrayList<OrderedThing> wordsList = new ArrayList<OrderedThing>();
		for (Word w : words) wordsList.add((OrderedThing)w);
		return wordsList;
	}
	
	/**
	 * Convert the content of OrderedThing object to a string
	 * @param o an OrderedThing object
	 * @return the content of OrderedThing object as a string
	 */
	public String toString(OrderedThing o) {
		return o.getContent();
	}
	
	/**
	 * Convert the sequence of OrderedThing object to a string
	 * @param o an ArrayList of OrderedThing objects
	 * @return the sequence of OrderedThing object as a string
	 */
	public String toStringList (ArrayList<OrderedThing> o) {
		String[] list = new String[o.size()];
		for (int i =0;i<o.size();i++) {
			list[i] = o.get(i).getContent();
		}
		return Arrays.toString(list);
	}

}
/**
 * Test the function of each class
 */
public class TestSequence {
	// the main method
	public static void main(String[] args) {
		System.out.println("Enter a sentence of your choice: ");
		Scanner scn = new Scanner(System.in);
		String response = scn.nextLine();
		Sentence sentenceTest = new Sentence(response);
		Word firstWord = (Word)(sentenceTest.getFirst());
		Word lastWord = (Word)(sentenceTest.getLast());
		Character firstChar1 = (Character)(firstWord.getFirst());
		Character lastChar1 = (Character)(firstWord.getLast());
		Character firstChar2 = (Character)(lastWord.getFirst());
		Character lastChar2 = (Character)(lastWord.getLast());
		ArrayList<OrderedThing> wordSequence = sentenceTest.getSequence();
		ArrayList<OrderedThing> charSequence1 = firstWord.getSequence();
		ArrayList<OrderedThing> charSequence2 = lastWord.getSequence();
		System.out.println("The first Word of the Sentence is: " + sentenceTest.toString(firstWord));
		System.out.println("The last Word of the Sentence is: " + sentenceTest.toString(lastWord));
		System.out.println("The word sequence of Sentence is: " + sentenceTest.toStringList(wordSequence));
		System.out.println("The first Character of the first word is: " + firstWord.toString(firstChar1));
		System.out.println("The last Character of the first word is: " + firstWord.toString(lastChar1));
		System.out.println("The first Character of the last word is: " + lastWord.toString(firstChar2));
		System.out.println("The last Character of the last word is: " + lastWord.toString(lastChar2));
		System.out.println("The character sequence of the first word is: " + firstWord.toStringList(charSequence1));
		System.out.println("The character sequence of the last word is: " + lastWord.toStringList(charSequence2));
		int randomIndex = (int)(Math.random() * (wordSequence.size() + 1));
		Word randomWord = (Word)wordSequence.get(randomIndex);
		System.out.println("The random word " + randomWord.toString(randomWord) + " in this sentence is on position " + randomWord.getPosition() + ".");
		
		scn.close();
	}
}
