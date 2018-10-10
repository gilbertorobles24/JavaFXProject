package app;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class RandomClass {
	
	public static void randomScene() {
		GridPane layout3 = new GridPane();
		layout3.setPadding(new Insets(10, 0, 0, 10));

		Scene scene = new Scene(layout3, 1500, 750);
		scene.getStylesheets().add("RoblesNetworkStyle.css");
		
        Label back_to1 = new Label("Welcome to the random window");
		
		Button back_button_to1 = new Button("Back");
		
		Scene scene_1 = SwitchingScenes.scene1;  //imports the scene from the SwitchingScenes class
		back_button_to1.setOnAction(e -> SwitchingScenes.window.setScene(scene_1));

		layout3.add(back_to1, 0, 0);
		layout3.add(back_button_to1, 0, 1);
		
		Stage window_1 = SwitchingScenes.window; //imports the window from the SwitchingScenes class
		window_1.setScene(scene);
		window_1.show();
	}
}
