package app;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class LoginScreen {
	
	public static void layout_2() {
		VBox layout2 = new VBox(20);
		layout2.setPadding(new Insets(10, 0, 0, 10));
		layout2.setSpacing(10);
		
		Scene scene2 = new Scene(layout2, 1500, 750);
		scene2.getStylesheets().add("RoblesNetwork.css");
		
		Label back_label = new Label("This is scene 2");
		
		Button back_button = new Button("Back");
		
		Scene scene_1 = SwitchingScenes.scene1;  //imports the scene from the SwitchingScenes class
		back_button.setOnAction(e -> SwitchingScenes.window.setScene(scene_1));
		
		layout2.getChildren().addAll(back_label, back_button);
		
		Stage window_1 = SwitchingScenes.window; //imports the window from the SwitchingScenes class
		window_1.setScene(scene2);
		window_1.show();
	}
}
