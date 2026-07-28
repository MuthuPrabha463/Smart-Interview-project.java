import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminLogin extends JFrame implements ActionListener {

    JLabel lblUser, lblPass;
    JTextField txtUser;
    JPasswordField txtPass;
    JButton btnLogin, btnClear;

    public AdminLogin() {

        setTitle("Admin Login");
        setSize(400,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,2,10,10));

        lblUser = new JLabel("Username");
        lblPass = new JLabel("Password");

        txtUser = new JTextField();
        txtPass = new JPasswordField();

        btnLogin = new JButton("Login");
        btnClear = new JButton("Clear");

        btnLogin.addActionListener(this);
        btnClear.addActionListener(this);

        add(lblUser);
        add(txtUser);

        add(lblPass);
        add(txtPass);

        add(btnLogin);
        add(btnClear);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnLogin) {

            String username = txtUser.getText();
            String password = String.valueOf(txtPass.getPassword());

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/interview_system",
                        "root",
                        "YOUR_PASSWORD");

                PreparedStatement ps = con.prepareStatement(
                        "SELECT * FROM admin WHERE username=? AND password=?");

                ps.setString(1, username);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();

                if(rs.next()) {

                    JOptionPane.showMessageDialog(this,
                            "Admin Login Successful");

                    // Open
