package application;

import java.awt.Button;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

public class SeatController {
	@FXML
	private Text TextA;
	@FXML
	private Text TextB;
	@FXML
	private Text TextC;
	@FXML
	private Text TextD;

	@FXML

	private static Main obj = new Main();

	// changing scenes with methods hooked in each buttons
	public void HandleCancelButtonSeat() throws IOException {
		obj.changeScene("Menu.fxml");
	}

	public void HandleNextButtonSeat() throws IOException {
		obj.changeScene("ViewTicket.fxml");
	}

	public void HandleBackButtonSeat() throws IOException {
		obj.changeScene("Reservation.fxml");
	}

   //to change Text display everytime user click seat Area
	public void HandleButtonASeat() throws IOException {
		TextA.setFill(Color.GREEN);
		TextA.setFont(Font.font("Helvetica", FontPosture.ITALIC, 13));
		TextA.setText("You chose seat Area A !");
		TextB.setText("");
		TextC.setText("");
		TextD.setText("");

	}

	public void HandleButtonBSeat() throws IOException {
		TextB.setFill(Color.BLUE);
		TextB.setFont(Font.font("Helvetica", FontPosture.ITALIC, 13));
		TextB.setText("You chose seat Area B !");
		TextA.setText("");
		TextC.setText("");
		TextD.setText("");
	}

	public void HandleButtonCSeat() throws IOException {
		TextC.setFill(Color.VIOLET);
		TextC.setFont(Font.font("Helvetica", FontPosture.ITALIC, 13));
		TextC.setText("You chose seat Area C !");
		TextB.setText("");
		TextA.setText("");
		TextD.setText("");
	}

	public void HandleButtonDSeat() throws IOException {
		TextD.setFill(Color.RED);
		TextD.setFont(Font.font("Helvetica", FontPosture.ITALIC, 13));
		TextD.setText("You chose seat Area D !");
		TextB.setText("");
		TextC.setText("");
		TextA.setText("");
	}
	// =====================================================

}