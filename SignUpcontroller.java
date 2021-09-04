package application;

//import java.awt.TextField; wrong causes error
import javafx.scene.control.TextField; //correct
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;

public class SignUpcontroller implements Initializable {

	@FXML
	private TextField username1;
	@FXML
	private PasswordField password1;
	@FXML
	private PasswordField reenterpassword1;
	@FXML
	private TextField mobile1;
	@FXML
	private TextField email1;

	static Text text = new Text();


	private static Main obj = new Main();
	Statement statement = null;
	Connection conn = null;

	String conString = "jdbc:sqlserver://DESKTOP-4LGJ5AC;Database=Users; Username=root; Password=1234";

	@FXML
	private Text errortext;
	

	@FXML
	// Sign up button in Signup.fxml
	public void handleSUButtonclick() throws IOException, SQLException {

		DatabaseConnection();

		// selecting data ,targeting the data from database that match to validate log
		// in
		String sql = "SELECT username FROM users_info WHERE username = '" + username1.getText() + "'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();

		// if fields are not blank
		if (!username1.getText().equals("") && !password1.getText().equals("") && !reenterpassword1.getText().equals("")
				&& !mobile1.getText().equals("") && !email1.getText().equals("")) {

			// if password entered matches re-enter password
			if (password1.getText().equals(reenterpassword1.getText())) {

				// inserting the data filled from textfield to database if password entered
				// matches re-enter password
				String insertquery = ("INSERT INTO Users.dbo.users_info(username, password, reenterpassword,mobile,email) VALUES ('"
						+ username1.getText() + "','" + password1.getText() + "','" + reenterpassword1.getText() + "','"
						+ mobile1.getText() + "','" + email1.getText() + "')");
				int i = statement.executeUpdate(insertquery);
				if (i > 0) {
					errortext.setFill(Color.GREEN);
					errortext.setFont(Font.font("Helvetica", FontPosture.ITALIC, 13));
					System.out.println("Your Data was inserted");
					errortext.setText("Registration Successful! Click Log In");

				} else {
					System.out.println("Your Data was not inserted");
					errortext.setFill(Color.RED);
					errortext.setFont(Font.font("Helvetica", FontPosture.ITALIC, 13));
					errortext.setText("Error");
				}
			} else {

				System.out.println("Your Data was not inserted");
				errortext.setFill(Color.RED);
				errortext.setFont(Font.font("Helvetica", FontPosture.ITALIC, 13));
				errortext.setText("Passwords didn't match! \nor Username already exist!  ");
			}
		} else {
			errortext.setFill(Color.RED);
			errortext.setFont(Font.font("Helvetica", FontPosture.ITALIC, 13));
			System.out.println("Your Data was not inserted");
			errortext.setText("Please fill all fields!");
		}
	}

	// change the scene to sign in when user already have account
	public void handleLogInButton() throws IOException {
		obj.changeScene("SignIn.fxml");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}

//========================================================
	// database connection
	public Connection DatabaseConnection() {
		System.out.println("This is Database Connection");

		try {
			conn = DriverManager.getConnection(conString);
			System.out.println("You are now connected to the database");
			statement = conn.createStatement();

		} catch (SQLException ex) {
			System.out.println("Sorry we can't connect to your database ");
			ex.printStackTrace();
		}
		return conn;
	}

//==================================
	public void insert() {

		try {
			String insertquery = ("INSERT INTO Users.dbo.users_info(username, password, reenterpassword,mobile,email) VALUES ('"
					+ username1.getText() + "','" + password1.getText() + "','" + reenterpassword1.getText() + "','"
					+ mobile1.getText() + "','" + email1.getText() + "')");
			statement.executeUpdate(insertquery);
			System.out.println("Your Data was inserted");

		} catch (Exception e) {
			System.out.println("Your data was not inserted");
		}
	}
}
