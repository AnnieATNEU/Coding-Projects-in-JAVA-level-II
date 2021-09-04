package application;

import javafx.scene.paint.Color;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class SignIncontroller implements Initializable {

	@FXML
	private TextField username2;

	@FXML
	private PasswordField password2;

	@FXML
	private Text errortext2;

	ResultSet rs = null;
	Statement statement = null;
	Connection conn = null;
	String conString = "jdbc:sqlserver://DESKTOP-4LGJ5AC;Database=Users; Username=root; Password=1234";

	static Text text = new Text();
	private static SignUpcontroller obj1 = new SignUpcontroller();
	private static Main obj = new Main();

//==============================================================================	
	public void handleLogInButton() throws SQLException, IOException {

		//selecting data ,targeting the data from database that match to validate log in 
		conn = obj1.DatabaseConnection();
		String sql = "SELECT username,password FROM users_info WHERE username = '" + username2.getText() + "'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		//if fields are not blank 
		if (!username2.getText().equals("") && !password2.getText().equals("")) {
			
			//if password entered matches the password from database
			if (password2.getText().equals(rs.getString("password"))) {
				errortext2.setFill(Color.GREEN);
				errortext2.setFont(Font.font("Helvetica", FontPosture.ITALIC, 13));
				errortext2.setText("Log in successfully!");
				// Open home page
				obj.changeScene("Menu.fxml");
				Userinfo();
				
				// else if password entered DOES NOT match the password from database
			} else if ((!password2.getText().equals(rs.getString("password"))
					|| (!username2.getText().equals(rs.getString("username"))))) {
				errortext2.setFill(Color.RED);
				errortext2.setFont(Font.font("Helvetica", FontPosture.ITALIC, 13));
				errortext2.setText("Incorrect password or username!");

			} else {
				errortext2.setFill(Color.RED);
				errortext2.setFont(Font.font("Helvetica", FontPosture.ITALIC, 13));
				errortext2.setText("Incorrect password or username!");
			}

			//if password and username is empty
		} else if (username2.getText().equals("") && password2.getText().equals("")) {
			errortext2.setFill(Color.RED);
			errortext2.setFont(Font.font("Helvetica", FontPosture.ITALIC, 13));
			errortext2.setText("Please enter username & password!");

			//if username is empty
		} else if (username2.getText().equals("")) {
			errortext2.setFill(Color.RED);
			errortext2.setFont(Font.font("Helvetica", FontPosture.ITALIC, 13));
			errortext2.setText("Please enter username!");

			//if password is empty
		} else if (password2.getText().equals("")) {
			errortext2.setFill(Color.RED);
			errortext2.setFont(Font.font("Helvetica", FontPosture.ITALIC, 13));
			errortext2.setText("Please enter password!");

		} else {
			errortext2.setFill(Color.RED);
			errortext2.setFont(Font.font("Helvetica", FontPosture.ITALIC, 13));
			errortext2.setText("Oops..Enter Username and Password!");
		}
	}

	// ==================================================
	public void handlecreateAccountButton() throws IOException {
		obj.changeScene("Signup.fxml"); // invoking method changeScene
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}

//=============================================================	
	// experiment code
	// trying to get user data to print to my account fxml page when user log in and fetching that user data
	//but still doesnt work
	
	public void Userinfo() throws SQLException {
		conn = obj1.DatabaseConnection();
		String sql = "SELECT username FROM users_info WHERE username = '" + username2.getText() + "'  ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		if (username2.getText().equals(rs.getString("username"))) {
			System.out.println("data with this username is found");
			String s1 = rs.getString("username");
			String s2 = rs.getString("mobile");
			String s3 = rs.getString("email");
			System.out.println(s1 + s2 + s3);

			FXMLLoader loader = new FXMLLoader(getClass().getResource("Account.fxml"));
			try {
				Parent root = loader.load();

				AccountController accountcontroller = loader.getController();
				accountcontroller.DisplayAccountinfo(s1, s2, s3);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("no data with this username is found");

		}

	}
}
