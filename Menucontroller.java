package application;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Menucontroller {
	@FXML
	private Button userlogout;

	private static Main obj = new Main();

	//all are methods to change the scenes
	public void UserLogOutMenu() throws IOException {
		obj.changeScene("SignIn.fxml");
	}

	public void HandleMyAccount() throws IOException {
		obj.changeScene("Account.fxml"); // invoking method changeScene

	}

	public void HandleMyEventInfo() throws IOException {
		obj.changeScene("EventInformation.fxml");
	}

	public void HandleviewmyTickets() throws IOException {
		obj.changeScene("ViewTicket.fxml"); // invoking method changeScene
	}

	public void HandleRegistermenu() throws IOException {
		obj.changeScene("Reservation.fxml"); // invoking method changeScene
	}
}
