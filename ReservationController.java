package application;

//import java.awt.TextField;  cause error in reservation.fxml
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.TextField; // should use this instead
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

public class ReservationController {

	@FXML
	private Text errortextRfxml;

	@FXML
	private TextField fullname;

	@FXML
	private TextField pax;

	@FXML
	private TextField email;

	ResultSet rs = null;
	Statement statement = null;
	Connection conn = null;
	String conString = "jdbc:sqlserver://DESKTOP-4LGJ5AC;Database=Users; Username=root; Password=1234";

	private static SignUpcontroller obj1 = new SignUpcontroller();
	private static Main obj = new Main();

//=========================================================
	// when next button is clicked
	public void HandleNextButtonReserve() throws IOException {
		obj.changeScene("Seat.fxml");
	}

//==========================================================
	// when reserve button is clicked , this one still doesnt work so i am still
	// working on it
	public void HandlereserveButton() throws SQLException {
		conn = obj1.DatabaseConnection();
		String sql = "SELECT fullname FROM reservation WHERE fullname = '" + fullname.getText() + "'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();

		String p = pax.getText();
		int y = Integer.parseInt(p);

		if (!fullname.getText().equals("") && !pax.getText().equals("") && !email.getText().equals("")) {
			if (!fullname.getText().equals(rs.getString("fullname"))) {
				if (y <= 6) {
					String insertquery = ("INSERT INTO Users.dbo.reservation(fullname, numberofguest, email) VALUES ('"
							+ fullname.getText() + "','" + pax.getText() + "','" + email.getText() + "')");
					statement.executeUpdate(insertquery);
					errortextRfxml.setFill(Color.GREEN);
					errortextRfxml.setFont(Font.font("Helvetica", FontPosture.ITALIC, 13));
					errortextRfxml.setText("Reservation was successful!");

				} else {
					errortextRfxml.setFill(Color.RED);
					errortextRfxml.setFont(Font.font("Helvetica", FontPosture.ITALIC, 13));
					errortextRfxml.setText("Only 6 Pax per reservation !");
				}
			} else {

				errortextRfxml.setFill(Color.RED);
				errortextRfxml.setFont(Font.font("Helvetica", FontPosture.ITALIC, 13));
				errortextRfxml.setText("Guest with this name already reserved !");
			}
		} else {
			errortextRfxml.setFill(Color.RED);
			errortextRfxml.setFont(Font.font("Helvetica", FontPosture.ITALIC, 13));
			errortextRfxml.setText("Only 6 Pax per reservation !");
			System.out.println("Your Data was not inserted");
			errortextRfxml.setText("Please fill all fields!");
		}
	}

//=======================================================
	// when cancel button is clicked
	public void HandleCancelButtonReserve() throws IOException {
		obj.changeScene("Menu.fxml");
	}
}
