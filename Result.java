import javax.swing.*;
import java.awt.*;

public class DisplayResult extends JFrame {

    public DisplayResult(String candidateName, int score, int totalQuestions) {

        setTitle("Assessment Result");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10));

        double percentage = (score * 100.0) / totalQuestions;
        String status = (percentage >= 50) ? "PASS" : "FAIL";

        JLabel lblTitle = new JLabel("Assessment Result", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel lblName = new JLabel("Candidate Name : " + candidateName);
        JLabel lblScore = new JLabel("Score : " + score + " / " + totalQuestions);
        JLabel lblPercentage = new JLabel("Percentage : " + String.format("%.2f", percentage) + "%");
        JLabel lblStatus = new JLabel("Status : " + status);

        add(lblTitle);
        add(lblName);
        add(lblScore);
        add(lblPercentage);
        add(lblStatus);

        setVisible(true);
    }

    public static void main(String[] args) {

        // Sample Output
        new DisplayResult("Padmashree", 8, 10);

    }
}
