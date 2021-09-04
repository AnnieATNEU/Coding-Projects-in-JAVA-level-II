package application;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Main extends Application {

	private static Stage stg;
	@Override
	public void start(Stage stage) throws IOException {
		//firstpage fxml will show up when prpgram is run
		stg = stage;
		Parent root = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
		stage.setTitle("BEEII EVENTS BOOKING");
		stage.setResizable(false); // so user cannot resize the window
		stage.setScene(new Scene(root));
		stage.show();
	}

	// method to change the Scene
	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	} 

	public static void main(String[] args) {
		launch(args);
	}


}
