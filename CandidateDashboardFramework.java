import java.awt.*;
import javax.swing.*;

public class CandidateDashboardFrame extends JFrame {


    JButton viewInterviewBtn;
    JButton startAssessmentBtn;
    JButton viewResultBtn;
    JButton logoutBtn;


    int candidateId;



    public CandidateDashboardFrame(int candidateId) {


        this.candidateId = candidateId;


        setTitle("Candidate Dashboard");

        setSize(500, 400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JLabel title = new JLabel(
                "Candidate Dashboard",
                JLabel.CENTER
        );


        title.setFont(
                new Font("Arial", Font.BOLD, 24)
        );



        viewInterviewBtn = new JButton(
                "View My Interview"
        );


        startAssessmentBtn = new JButton(
                "Start Assessment"
        );


        viewResultBtn = new JButton(
                "View My Result"
        );


        logoutBtn = new JButton(
                "Logout"
        );



        Font buttonFont = new Font(
                "Arial",
                Font.BOLD,
                16
        );


        viewInterviewBtn.setFont(buttonFont);
        startAssessmentBtn.setFont(buttonFont);
        viewResultBtn.setFont(buttonFont);
        logoutBtn.setFont(buttonFont);



        JPanel panel = new JPanel();


        panel.setLayout(
                new GridLayout(4,1,15,15)
        );


        panel.add(viewInterviewBtn);
        panel.add(startAssessmentBtn);
        panel.add(viewResultBtn);
        panel.add(logoutBtn);



        add(title, BorderLayout.NORTH);

        add(panel, BorderLayout.CENTER);




        // View Interview

        viewInterviewBtn.addActionListener(e -> {


            new ViewInterviewFrame(candidateId);


        });





        // Start Assessment

        startAssessmentBtn.addActionListener(e -> {


            new AssessmentFrame(candidateId, candidateId);



        });






        // View Result

        viewResultBtn.addActionListener(e -> {


            new ViewResultFrame(candidateId);



        });







        // Logout

        logoutBtn.addActionListener(e -> {


            new HomeFrame();


            dispose();


        });




        setVisible(true);


    }


}
