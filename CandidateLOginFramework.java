import java.awt.*;
import javax.swing.*;

public class CandidateLoginFrame extends JFrame {

    JTextField emailField;
    JPasswordField passwordField;

    JButton loginBtn;
    JButton backBtn;


    public CandidateLoginFrame() {

        setTitle("Candidate Login");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel title = new JLabel(
                "Candidate Login",
                JLabel.CENTER
        );

        title.setFont(
                new Font("Arial", Font.BOLD, 22)
        );


        emailField = new JTextField();

        passwordField = new JPasswordField();


        loginBtn = new JButton("Login");

        backBtn = new JButton("Back");


        JPanel panel = new JPanel();

        panel.setLayout(
                new GridLayout(3, 2, 10, 10)
        );


        panel.add(new JLabel("Email"));
        panel.add(emailField);


        panel.add(new JLabel("Password"));
        panel.add(passwordField);


        panel.add(loginBtn);
        panel.add(backBtn);



        add(title, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);



        // Login Button

        loginBtn.addActionListener(e -> {


            String email = emailField.getText();


            String password = new String(
                    passwordField.getPassword()
            );


            LoginDAO dao = new LoginDAO();


            boolean status = dao.loginCandidate(
                    email,
                    password
            );


            if(status) {


                JOptionPane.showMessageDialog(
                        this,
                        "Login Successful!"
                );


                // Open Candidate Dashboard
                // Temporary candidate id for testing

                new CandidateDashboardFrame(1);


                dispose();


            }
            else {


                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Email or Password!"
                );

            }


        });



        // Back Button

        backBtn.addActionListener(e -> {


            new HomeFrame();

            dispose();


        });



        setVisible(true);

    }

}
