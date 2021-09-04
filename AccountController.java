package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

public class AccountController {

	private static Main obj = new Main();
	@FXML
	private Text username3;
	@FXML
	private Text email3;
	@FXML
	private Text mobile3;
	@FXML
	private Text errortext3;

	private static SignIncontroller obj2 = new SignIncontroller();
	ResultSet rs = null;
	Statement statement = null;
	Connection conn = null;
	String conString = "jdbc:sqlserver://DESKTOP-4LGJ5AC;Database=Users; Username=root; Password=1234";
	private static SignUpcontroller obj1 = new SignUpcontroller();

	// ====================================================================
	// Trying to catch user data from they log in in signin fxml but it doesnt work
	// so still working on it
	public void DisplayAccountinfo(String s1, String s2, String s3) throws IOException, SQLException {

		username3.setText(s1);
		mobile3.setText(s2);
		email3.setText(s3);

	}

//============================================
	// To Go back button in Main Menu
	public void Handlegobackbutton() throws IOException {
		obj.changeScene("Menu.fxml");
	}
}
