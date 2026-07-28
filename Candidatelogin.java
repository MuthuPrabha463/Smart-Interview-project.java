import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CandidateLogin extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextField tfUsername;
    JPasswordField pfPassword;
    JButton btnLogin, btnClear;

    public CandidateLogin() {

        setTitle("Candidate Login");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        l1 = new JLabel("Username:");
        l2 = new JLabel("Password:");

        tfUsername = new JTextField();
        pfPassword = new JPasswordField();

        btnLogin = new JButton("Login");
        btnClear = new JButton("Clear");

        btnLogin.addActionListener(this);
        btnClear.addActionListener(this);

        add(l1);
        add(tfUsername);
        add(l2);
        add(pfPassword);
        add(btnLogin);
        add(btnClear);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnLogin) {

            String username = tfUsername.getText();
            String password = String.valueOf(pfPassword.getPassword());

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/interview_system",
                        "root",
                        "YOUR_PASSWORD");

                PreparedStatement ps = con.prepareStatement(
                        "SELECT * FROM candidate WHERE username=? AND password=?");

                ps.setString(1, username);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this,
                            "Login Successful!");

                    // Open Candidate Dashboard here

                } else {
                    JOptionPane.showMessageDialog(this,
                            "Invalid Username or Password");
                }

                con.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }

        }

        if (e.getSource() == btnClear) {
            tfUsername.setText("");
            pfPassword.setText("");
        }
    }

    public static void main(String[] args) {
        new CandidateLogin();
    }
}
