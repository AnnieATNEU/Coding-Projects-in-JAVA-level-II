package application;

import java.io.IOException;

public class EventInformationController {
	private static Main obj= new Main();
	
// To Go back button in Main Menu
public void HandlegobackmenuEI() throws IOException {
	obj.changeScene("Menu.fxml"); 
}
}
