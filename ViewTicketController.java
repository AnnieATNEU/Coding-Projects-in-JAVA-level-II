package application;

import java.io.IOException;

public class ViewTicketController {

	// creating obj from Main class
	private static Main obj = new Main();

//change scenes methods by invoking the method changeScene from Main class
	public void Handlegobackviewtickets() throws IOException {
		obj.changeScene("Menu.fxml");
	}

	public void Handlelogoutviewtickets() throws IOException {
		obj.changeScene("SignIn.fxml");
	}

	public void Handlereserveanother() throws IOException {
		obj.changeScene("Reservation.fxml");
	}

}
