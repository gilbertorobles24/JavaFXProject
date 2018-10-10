import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class SimpleGUI extends Application{
	
	Button button1;
	Button button2;
	
	////////MAIN METHOD/////////////
	public static void main(String[] args){
		launch(args);
	}

	//a stage is a Window, while a scene is whatever is inside the window
	//////////START METHOD//////////
	@Override
	public void start(Stage primaryStage) throws Exception {  //it starts the program
		primaryStage.setTitle("Robles Network"); //window title
		
		//LAYOUT
		GridPane layout = new GridPane(); //creates layout scene
		
		//WIDGETS
		button1 = new Button("Click Me!");
		button1.setOnAction(e -> System.out.println("Lambdas are lit af"));
		
		button2 = new Button("Button2");
		button2.setOnAction(e -> System.out.println("this is button 2"));
		
		//ADD WIDGETS TO LAYOUT
		GridPane.setConstraints(button1, 0, 0); //include the button widget in layout
		GridPane.setConstraints(button2, 0, 1); //col=2, row=2
		
		//add to pane
		layout.getChildren().addAll(button1, button2);
		
		primaryStage.setScene(new Scene(layout, 500, 450));  //inside of the stage create a layout
		primaryStage.show(); //shows the whole window(stage)
	}
	
}