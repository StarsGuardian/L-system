package controller;

import javafx.scene.canvas.GraphicsContext;
import model.LindenmayerModel;

/**
 * This class connects view and model together. It passes the change that user made in view
 * to the model
 * @author ianfang
 *
 */
public class LindenmayerController {
	private LindenmayerModel model;
	private String axiom = "";
	private int iteration = 0;
	private double angle;
	private double x;
	private double y;
	private String chara1;
	private String chara2;
	private String conver1;
	private String conver2;
	private GraphicsContext gc;
	
	/**
	 * This is the constructor
	 * @param mdl this is the model instance
	 */
	public LindenmayerController(LindenmayerModel mdl) {
		model = mdl;
	}
	
	/**
	 * This method will be triggered if user changes axiom in the view
	 * This method also calls model to update the new axiom
	 * @param str new axiom that user entered
	 * @return axiom which is the new axiom
	 */
	public String getAxiom(String str) {
		axiom = str;
		model.getAxiom(axiom);
		return axiom;
	}
	/**
	 * This method will be triggered if user changes times of iteration
	 * in the view. This method also calls model to update the new times of
	 * iteration
	 * @param number this is the new iteration
	 * @return iteration this is the new iteration
	 */
	public int getIteration(int number) {
		iteration = number;
		model.getIteration(iteration);
		return iteration;
	}
	
	/**
	 * This method will be triggered if user changes the angle in the view
	 * This method also calls model to update the new angle
	 * @param d this is the new angle
	 * @return angle this is the new angle
	 */
	public double getDegree(double d) {
		angle = d;
		model.getAngle(angle);
		return angle;
	}
	
	/**
	 * This method will be triggered if user changes the X coordinate in the view
	 * This method also calls model to update the new X coordinate
	 * @param d this is the new X coordinate
	 * @return x this is the new X coordinate
	 */
	public double getXcoordinate(double d) {
		x = d;
		model.getX(d);
		return x;
	}
	
	/**
	 * This method will be triggered if user changes the Y coordinate in the view
	 * This method also calls model to update the new Y coordinate
	 * @param d this is the new Y coordinate
	 * @return y this is the new Y coordinate
	 */
	public double getYcoordinate(double d) {
		y = d;
		model.getY(d);
		return y;
	}
	
	/**
	 * This method will be triggered if user changes the character in the view
	 * This method also calls model to update the new character
	 * @param chara this is the new character
	 * @return chara1 this is the new character
	 */
	public String getCharacter1(String chara) {
		chara1 = chara;
		model.resetStr1(chara1);
		return chara1;
	}
	
	/**
	 * This method will be triggered if user changes the character in the view
	 * This method also calls model to update the new character
	 * @param charac this is the new character
	 * @return chara2 this is the new character
	 */
	public String getCharacter2(String charac) {
		chara2 = charac;
		model.resetStr2(chara2);
		return chara2;
	}
	
	/**
	 * This method will be triggered if user changes the mapping string of character
	 * This method also calls model to update the new mapping string
	 * @param replace1 this is the new mapping string
	 * @return conver1 this is the new mapping string
	 */
	public String getConver1(String replace1) {
		conver1 = replace1;
		model.resetConver1(conver1);
		return conver1;
	}
	
	/**
	 * This method will be triggered if user changes the mapping string of character
	 * This method also calls model to update the new mapping string
	 * @param replace2 this is the new mapping string
	 * @return conver2 this is the new mapping string
	 */
	public String getConver2(String replace2) {
		conver2 = replace2;
		model.resetConver2(conver2);
		return conver2;
	}
	
	/**
	 * This method takes the instance of GraphicsContext initialized in the view 
	 * and call the model to take over the GraphicsContext in order to draw the canvas
	 * @param graphicsDraw this is the GraphicsContext initialized in the view
	 * @return gc which is the instance of GraphicsContext
	 */
	public GraphicsContext getContext(GraphicsContext graphicsDraw) {
		gc = graphicsDraw;
		model.getGc(gc);
		return gc;
	}
	
	/**
	 * This method calls model to initializes the instance of TurtleGraphics class
	 */
	public void initialize() {
		model.initializing();
	}
	
	/**
	 * This method calls model checks if the TurtleGraphics is initialized successfully
	 * If successfully initialized, true will be returned. Otherwise false will
	 * be returned
	 * @return called it's boolean
	 */
	public boolean ifCalled() {
		return model.ifCalled();
	}
	
	/**
	 * This method will be called if any change was made in the view
	 */
	public void updateTurtle() {
		model.updateTurtle();
	}
	
	/**
	 * This method will be called by the update method in the view to update view
	 */
	public void continueDraw() {
		model.continueDraw();
	}
}
