package application;

import java.io.IOException;

public class FirstPageController {

	private static Main obj = new Main();
	
	// changing scene to sign up
	public void HandleFirstPageBooknow() throws IOException {	
		    obj.changeScene("Signup.fxml"); 
	}
}
