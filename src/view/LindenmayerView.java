package view;


import java.util.Observable;
import java.util.Observer;

import controller.LindenmayerController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.LindenmayerModel;


/**
 * This class draws the GUI window. All required data for L-System need to be entered in the TextField correspondingly.
 * @author ianfang
 *
 */
public class LindenmayerView extends Application implements Observer{
	
	private LindenmayerController controller; // Create an instance of controller
	private LindenmayerModel model; // Create an instance of Model, but this model will not be modified in this class.
	private TurtleGraphics turtle;
	/**
	 * This main function executes the JavaFx, displays GUI window on the screen.
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	/**
	 * This method draws BorderPane and all the required elements inside the BorderPane. Including
	 * the Vbox on the left with Hbox which is holding TextField, Slider, Label in it; The ScrollPane which
	 * is holding a StackPane with Canvas in it in the center of the BorderPane.
	 */
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane window = new BorderPane();
		ScrollPane scroll = new ScrollPane();
		StackPane stack = new StackPane();
		Canvas canvas = new Canvas(5000, 5000);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		VBox leftV = new VBox();
		HBox hori1 = new HBox();
		HBox hori2 = new HBox();
		HBox hori3 = new HBox();
		HBox hori4 = new HBox();
		HBox hori5 = new HBox();
		HBox hori6 = new HBox();
		HBox hori7 = new HBox();
		HBox hori8 = new HBox();
		HBox hori9 = new HBox();
		HBox hori10 = new HBox();
		HBox hori11 = new HBox();
		
		Label position = new Label("Initial Position");
		position.setFont(new Font(15));
		position.setAlignment(Pos.CENTER);
		
		Label x = new Label("X");
		x.setFont(new Font(15));
		x.setAlignment(Pos.CENTER);
		//This TextField records the x coordinate
		TextField xcor = new TextField();
		xcor.setAlignment(Pos.CENTER);
		xcor.setPrefWidth(50);
		
		Label y = new Label("Y");
		y.setFont(new Font(15));
		y.setAlignment(Pos.CENTER);
		//This TextField records the y coordinate
		TextField ycor = new TextField();
		ycor.setAlignment(Pos.CENTER);
		ycor.setPrefWidth(50);
		
		Label iteration = new Label("Iteration");
		iteration.setFont(new Font(15));
		iteration.setAlignment(Pos.CENTER);
		Slider slid = new Slider(0,10,6);
		slid.setShowTickMarks(true);
		slid.setMajorTickUnit(5);
		slid.setMinorTickCount(0);
		//This label reflects the current iteration number
		Label slidint = new Label(Integer.toString((int) slid.getValue()));
		
		Label angle = new Label("Angle");
		angle.setFont(new Font(15));
		angle.setAlignment(Pos.CENTER);
		//This TextField records the angle
		TextField ang = new TextField();
		ang.setAlignment(Pos.CENTER);
		
		Label axiom = new Label("Axiom");
		axiom.setFont(new Font(15));
		axiom.setAlignment(Pos.CENTER);
		//This TextField records the axiom
		TextField axi = new TextField();
		axi.setAlignment(Pos.CENTER);
		
		Label mapping = new Label("Mappings");
		mapping.setFont(new Font(15));
		mapping.setAlignment(Pos.CENTER);
		//This TextField records the first character of L-system
		TextField chara1 = new TextField();
		chara1.setAlignment(Pos.CENTER);
		chara1.setPrefWidth(40);
		
		Label point1 = new Label("->");
		point1.setFont(new Font(15));
		point1.setAlignment(Pos.CENTER);
		//This TextField records the mapping string of first character
		TextField conver1 = new TextField();
		conver1.setAlignment(Pos.CENTER);
		conver1.setPrefWidth(105);
		
		//This TextField records the second character of L-system
		TextField chara2 = new TextField();
		chara2.setAlignment(Pos.CENTER);
		chara2.setPrefWidth(40);
		Label point2 = new Label("->");
		point2.setFont(new Font(15));
		point2.setAlignment(Pos.CENTER);
		//This TextField records the mapping string of second character
		TextField conver2 = new TextField();
		conver2.setAlignment(Pos.CENTER);
		conver2.setPrefWidth(105);
		
		//Using Hbox to hold all the elements created above
		hori1.getChildren().addAll(position);
		hori1.setAlignment(Pos.CENTER);
		hori2.getChildren().addAll(x,xcor,y,ycor);
		hori2.setAlignment(Pos.CENTER);
		hori3.getChildren().addAll(iteration);
		hori3.setAlignment(Pos.CENTER);
		hori4.getChildren().addAll(slid, slidint);
		hori4.setAlignment(Pos.CENTER);
		hori5.getChildren().addAll(angle);
		hori5.setAlignment(Pos.CENTER);
		hori6.getChildren().addAll(ang);
		hori6.setAlignment(Pos.CENTER);
		hori7.getChildren().addAll(axiom);
		hori7.setAlignment(Pos.CENTER);
		hori8.getChildren().addAll(axi);
		hori8.setAlignment(Pos.CENTER);
		hori9.getChildren().addAll(mapping);
		hori9.setAlignment(Pos.CENTER);
		hori10.getChildren().addAll(chara1, point1, conver1);
		hori10.setAlignment(Pos.CENTER);
		hori11.getChildren().addAll(chara2, point2, conver2);
		hori11.setAlignment(Pos.CENTER);
		
		//Using Vbox to hold all the Hbox
		leftV.getChildren().addAll(hori1,hori2,hori3,hori4,hori5,hori6,hori7,hori8,hori9,hori10,hori11);
		leftV.setAlignment(Pos.TOP_CENTER);
		
		//Setting canvas
		stack.getChildren().addAll(canvas);
		stack.setStyle("-fx-background-color: white");
		scroll.setContent(stack);
		window.setCenter(scroll);
		window.setLeft(leftV);
		
		//Setting scene
		Scene scene = new Scene(window, 900, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Lidenmayer System Visualizer");
		primaryStage.setFullScreen(true);
		primaryStage.show();
		
		//Initializing model and controller, add observer to the observer list
		turtle = new TurtleGraphics(gc);
		model = new LindenmayerModel(turtle);
		controller = new LindenmayerController(model);
		model.addObserver(this);
		
		//Pass GraphicsContext to controller in order to call TurtleGraphics to draw image
		controller.getContext(gc);
		controller.getIteration(Integer.parseInt(slidint.getText()));
		//Set slider a drag event
		slid.setOnDragDetected(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(event.isDragDetect()) {
					slidint.setText(Integer.toString((int) slid.getValue()));
				}
				controller.getIteration(Integer.parseInt(slidint.getText()));
				if (controller.ifCalled()) {
					controller.updateTurtle();
				}
				else {
					controller.initialize();
				}
			}
		});
		
		//Set slider a mouse click event
		slid.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if (event.MOUSE_PRESSED != null) {
					slidint.setText(Integer.toString((int) slid.getValue()));
				}
				controller.getIteration(Integer.parseInt(slidint.getText()));
				if (controller.ifCalled()) {
					controller.updateTurtle();
				}
				else {
					controller.initialize();
				}
			}
		});
		
		//Set axiom TextField action event
		axi.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				axi.getText();
				try {
					Double.parseDouble(axi.getText());
					axi.clear();
					event.consume();
				}catch(NumberFormatException e) {
					controller.getAxiom(axi.getText());
					if (controller.ifCalled()) {
						controller.updateTurtle();
					}
					else {
						controller.initialize();
					}
				}
			}
		});
		
		//Set angle TextField action event
		ang.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				ang.getText();
				try {
					Double.parseDouble(ang.getText());
					controller.getDegree(Double.parseDouble(ang.getText()));
					if (controller.ifCalled()) {
						controller.updateTurtle();
					}
					else {
						controller.initialize();
					}
				}catch(NumberFormatException e) {
					ang.clear();
					event.consume();
				}
			}
			
		});
		
		//Set canvas mouse click event to get X,Y coordinates by clicking on canvas
		canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				xcor.setText(Double.toString(event.getX()));
				ycor.setText(Double.toString(event.getY()));
				controller.getXcoordinate(Double.parseDouble(xcor.getText()));
				controller.getYcoordinate(Double.parseDouble(ycor.getText()));
				if (controller.ifCalled()) {
					controller.updateTurtle();
				}
				else {
					controller.initialize();
				}
			}
			
		});
		
		//Set X TextField action event
		xcor.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				xcor.getText();
				try {
					if (Double.parseDouble(xcor.getText()) < 0) {
						xcor.clear();
						event.consume();
					}
					else {
						controller.getXcoordinate(Double.parseDouble(xcor.getText()));
						if (controller.ifCalled()) {
							controller.updateTurtle();
						}
						else {
							controller.initialize();
						}
					}
				}catch(NumberFormatException e) {
					xcor.clear();
					event.consume();
				}
			}
		});
		
		//Set Y TextField action event
		ycor.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				ycor.getText();
				try {
					if (Double.parseDouble(ycor.getText()) < 0) {
						ycor.clear();
						event.consume();
					}
					else {
						controller.getYcoordinate(Double.parseDouble(ycor.getText()));
						if (controller.ifCalled()) {
							controller.updateTurtle();
						}
						else {
							controller.initialize();
						}
					}
				}catch(NumberFormatException e) {
					ycor.clear();
					event.consume();
				}
			}
		});
		
		//Set first character of mapping TextField action event
		chara1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				chara1.getText();
				try {
					Double.parseDouble(chara1.getText());
					chara1.clear();
					event.consume();
				}catch(NumberFormatException e) {
					controller.getCharacter1(chara1.getText());
					if (controller.ifCalled()) {
						controller.updateTurtle();
					}
					else {
						controller.initialize();
					}
				}
			}
		});
		
		//Set second character of mapping TextField action event
		chara2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				chara2.getText();
				try {
					Double.parseDouble(chara2.getText());
					chara2.clear();
					event.consume();
				}catch(NumberFormatException e) {
					controller.getCharacter2(chara2.getText());
					if (controller.ifCalled()) {
						controller.updateTurtle();
					}
					else {
						controller.initialize();
					}
				}
			}
		});
		
		//Set first mapping string of mapping TextField action event
		conver1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				conver1.getText();
				try {
					Double.parseDouble(conver1.getText());
					conver1.clear();
					event.consume();
				}catch(NumberFormatException e) {
					controller.getConver1(conver1.getText());
					if (controller.ifCalled()) {
						controller.updateTurtle();
					}
					else {
						controller.initialize();
					}
				}
			}
		});
		
		//Set second mapping string of mapping TextField action event
		conver2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				conver2.getText();
				try {
					Double.parseDouble(conver2.getText());
					conver2.clear();
					event.consume();
				}catch(NumberFormatException e) {
					controller.getConver2(conver2.getText());
					if (controller.ifCalled()) {
						controller.updateTurtle();
					}
					else {
						controller.initialize();
					}
				}
			}
		});
	}
	
	//This function will be called by notifyObserver in model class to update the view
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (controller.ifCalled()) {
			turtle.clear();
			controller.continueDraw();
		}
	}
}
