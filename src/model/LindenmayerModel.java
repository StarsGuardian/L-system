package model;

import java.util.HashMap;
import java.util.Observable;
import javafx.scene.canvas.GraphicsContext;
import view.TurtleGraphics;

/**
 * This class contains all the state and data which will be used in L-system
 * This class also calls TurtleGraphics class and update information to TurtleGraphics class
 * to draw the image
 * @author ianfang
 *
 */
public class LindenmayerModel extends Observable{
	private static String current;
	private StringBuffer next;
	private int iteration;
	private int count = 0;
	private char str1;
	private char str2;
	private String conver1;
	private String conver2;
	private double x;
	private double y;
	private double angle;
	private GraphicsContext gc;
	private boolean called =false;
	private TurtleGraphics turtle;
	private String axiom;
	private HashMap<Character, String>map = new HashMap<Character, String>();
	
	/**
	 * This is the constructor, in constructor those constant keys and values will be 
	 * stored in hash map
	 */
	public LindenmayerModel(TurtleGraphics turtl) {
		map.put('+', "+");
		map.put('-', "-");
		map.put('[', "[");
		map.put(']', "]");
		turtle = turtl;
	}
	
	/**
	 * This method will be called by controller if user changes axiom
	 * @param str this is the new axiom
	 * @return axiom this is the new axiom
	 */
	public String getAxiom(String str) {
		current = str;
		axiom = str;
		return axiom;
	}
	
	/**
	 * This method will be called if model made any changes
	 * @param str is the axiom
	 */
	public void notify(String str) {
		setChanged();
		notifyObservers();
	}
	
	/**
	 * This method will be called by controller if user changes X
	 * coordinate
	 * @param d this is the new X coordinate
	 * @return x this is the new X coordinate
	 */
	public double getX(double d) {
		x = d;
		return x;
	}
	
	/**
	 * This method will be called by controller if user changes Y
	 * coordinate
	 * @param d this is the new Y coordinate
	 * @return y this is the new Y coordinate
	 */
	public double getY(double d) {
		y = d;
		return y;
	}
	
	/**
	 * This method will be called by controller if user changes angle
	 * @param angle2 this is the new angle
	 * @return angle this is the new angle
	 */
	public double getAngle(double angle2) {
		angle = angle2;
		return angle;
	}
	
	/**
	 * This method will be called by controller if user changes iteration
	 * @param number this is the new iteration
	 * @return iteration this is the new iteration
	 */
	public int getIteration(int number) {
		iteration = number;
		return iteration;
	}
	
	/**
	 * This method will be called by controller if user changes the character
	 * This method also stores the character as key in hash map along with conver1 as
	 * its value
	 * @param str this is the new character
	 * @return str1 this is the new character
	 */
	public char resetStr1(String str) {
		if (map.containsKey(str1)) {
			map.remove(str1);
		}
		str1 = str.charAt(0);
		map.put(str1, conver1);
		return str1;
	}
	
	/**
	 * This method will be called by controller if user changes the character
	 * This method also stores the character as key in hash map along with conver2 as 
	 * its value
	 * @param str this is the new character
	 * @return str2 this is the new character
	 */
	public char resetStr2(String str) {
		if (map.containsKey(str2)) {
			map.remove(str2);
		}
		str2 = str.charAt(0);
		map.put(str2, conver2);
		return str2;
	}
	
	/**
	 * This method will be called by controller if user changes the mapping string of 
	 * the character
	 * This method also stores the mapping string as value in hash map under key str1
	 * @param str this is the new mapping string
	 * @return conver1 this is the new mapping string
	 */
	public String resetConver1(String str) {
		conver1 = str;
		map.put(str1, conver1);
		return conver1;
	}
	
	/**
	 * This method will be called by controller if user changes the mapping string of 
	 * the character
	 * This method also stores the mapping string as value in hash map under key str2
	 * @param str this is the new mapping string
	 * @return conver2 this is the new mapping string
	 */
	public String resetConver2(String str) {
		conver2 = str;
		map.put(str2, conver2);
		return conver2;
	}
	
	/**
	 * This method will be called by controller if GraphicsContext needs to be passed to
	 * model for TurtleGraphics class to draw image
	 * @param gcC this is the instance of GraphicsContext
	 * @return gc this is the instance of GraphicsContext passed by controller
	 */
	public GraphicsContext getGc(GraphicsContext gcC) {
		gc = gcC;
		return gc;
	}
	
	/**
	 * This method generates the final string according to the iteration number
	 * Method reads through current which starts with axiom. Then checking each 
	 * character in current and see if it is in the hash map. If it's found, the value
	 * under this character will be appended to the string buffer. Method keeps doing
	 * the checking and appending until the loop ends.
	 * @return current which is the final string after the loop ends
	 */
	public String generating() {
		while (count < iteration) {
			next = new StringBuffer();
			for (int i = 0; i < current.length(); i++) {
				char c = current.charAt(i);
				if (map.containsKey(c)) {
					next.append(map.get(c));
				}
			}
			current = next.toString();
			count ++;
		}
		count = 0;
		return current;
	}
	
	/**
	 * This method checks if the final string is correct
	 */
	public void checkCurrent() {
		System.out.println(current);
	}
	
	/**
	 * This method will be called by controller when user trying to fill out the fields in the view
	 * This method will check if user fills out all of the required fields with valid inputs
	 * If all required fields are filled with valid input, final string will be generated and 
	 * TurtleGraphics will be initialized. Final String along with other critical info
	 * will be passed into turtle to draw the image
	 */
	public void initializing() {
		if (axiom != null && iteration >= 0 && x >= 0 && y >= 0
				&& Character.toString(str1) != null && Character.toString(str2) != null &&
				conver1 != null && conver2 != null) {
			updateTurtle();
			turtle.drawing();
			called = true;
			System.out.println("Initializing Success!");
		}
		else {
			System.out.println("Initializing Fail! Filling out all the fields!");
		}
	}
	
	/**
	 * This method checks if TurtleGraphics has been successfully initialized
	 * If it is, true will be returned. vice versa
	 * @return
	 */
	public boolean ifCalled() {
		return called;
	}
	
	/**
	 * This method will be called by controller if any change was made in the view
	 * after TurtleGraphics class has been successfully initialized
	 */
	public void updateTurtle() {
		if (ifCalled()) {
			getAxiom(axiom);
		}
		turtle.updateFianlStr(generating());
		turtle.updateangle(angle);
		turtle.updateX(x);
		turtle.updateY(y);
		turtle.updateChara1(Character.toString(str1));
		turtle.updateChara2(Character.toString(str2));
		if (ifCalled()) {
			notify(axiom);
		}
	}
	
	/**
	 * This method will be used to update the view by most recent user input
	 */
	public void continueDraw() {
		turtle.drawing();
	}
}
