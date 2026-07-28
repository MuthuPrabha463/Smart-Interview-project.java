import javax.swing.*;
import java.awt.*;

public class AssessmentFrame extends JFrame {

    JLabel questionLabel;

    JRadioButton option1;
    JRadioButton option2;
    JRadioButton option3;
    JRadioButton option4;

    ButtonGroup group;

    JButton nextBtn;

    int questionNo = 0;
    int score = 0;

    int candidateId;
    int interviewId;


    String[][] questions = {

            {
                "Which language is used for Android Development?",
                "Java",
                "HTML",
                "CSS",
                "SQL",
                "1"
            },

            {
                "Which database are we using in this project?",
                "Oracle",
                "MySQL",
                "MongoDB",
                "SQLite",
                "2"
            },

            {
                "Which keyword is used to inherit a class in Java?",
                "implements",
                "extends",
                "import",
                "package",
                "2"
            },

            {
                "Which company developed Java?",
                "Microsoft",
                "Oracle",
                "Google",
                "Apple",
                "2"
            },

            {
                "Which keyword is used to create an object in Java?",
                "class",
                "new",
                "void",
                "static",
                "2"
            }

    };


    public AssessmentFrame(int candidateId, int interviewId) {

        this.candidateId = candidateId;
        this.interviewId = interviewId;


        setTitle("Online Assessment");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        questionLabel = new JLabel();

        questionLabel.setFont(
                new Font("Arial", Font.BOLD, 18)
        );


        option1 = new JRadioButton();
        option2 = new JRadioButton();
        option3 = new JRadioButton();
        option4 = new JRadioButton();


        group = new ButtonGroup();

        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);



        nextBtn = new JButton("Next");



        JPanel panel = new JPanel();

        panel.setLayout(
                new GridLayout(6, 1, 10, 10)
        );


        panel.add(questionLabel);
        panel.add(option1);
        panel.add(option2);
        panel.add(option3);
        panel.add(option4);
        panel.add(nextBtn);



        add(panel);



        loadQuestion();



        nextBtn.addActionListener(e -> {


            checkAnswer();


            questionNo++;


            if(questionNo < questions.length) {

                loadQuestion();

            }
            else {

                saveResult();

            }


        });



        setVisible(true);

    }



    private void loadQuestion() {


        group.clearSelection();


        questionLabel.setText(
                "Q" + (questionNo + 1)
                + ". "
                + questions[questionNo][0]
        );


        option1.setText(
                "1. " + questions[questionNo][1]
        );


        option2.setText(
                "2. " + questions[questionNo][2]
        );


        option3.setText(
                "3. " + questions[questionNo][3]
        );


        option4.setText(
                "4. " + questions[questionNo][4]
        );


    }





    private void checkAnswer() {


        int answer = 0;


        if(option1.isSelected()) {

            answer = 1;

        }
        else if(option2.isSelected()) {

            answer = 2;

        }
        else if(option3.isSelected()) {

            answer = 3;

        }
        else if(option4.isSelected()) {

            answer = 4;

        }



        if(answer == Integer.parseInt(
                questions[questionNo][5]
        )) {

            score++;

        }


    }





    private void saveResult() {


        int technicalScore = score * 20;

        int communicationScore = 80;

        int confidenceScore = 80;

        int overallScore = technicalScore;


        String recommendation;


        if(overallScore >= 50) {

            recommendation = "Selected";

        }
        else {

            recommendation = "Rejected";

        }



        try {


            ResultDAO dao = new ResultDAO();


            dao.saveResult(
                    interviewId,
                    technicalScore,
                    communicationScore,
                    confidenceScore,
                    overallScore,
                    recommendation
            );



            JOptionPane.showMessageDialog(
                    this,
                    "Assessment Completed\n\n"
                    +
                    "Technical Score : "
                    + technicalScore
                    +
                    "\nOverall Score : "
                    + overallScore
                    +
                    "\nRecommendation : "
                    + recommendation
                    +
                    "\n\nResult Saved Successfully!"
            );


        }
        catch(Exception e) {


            e.printStackTrace();


            JOptionPane.showMessageDialog(
                    this,
                    "Error while saving result!"
            );


        }



        dispose();


    }

}
