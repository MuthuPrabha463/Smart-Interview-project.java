import javax.swing.*;
import java.awt.event.*;

public class Assessment extends JFrame implements ActionListener {

    JLabel question;
    JRadioButton op1, op2, op3, op4;
    ButtonGroup bg;
    JButton next;

    int score = 0;
    int qNo = 0;

    String questions[] = {
            "1. Java is a ______ language?",
            "2. Which package is used for Swing?",
            "3. JDBC stands for?"
    };

    String options[][] = {
            {"Programming", "Database", "Browser", "Operating System"},
            {"java.io", "java.sql", "javax.swing", "java.net"},
            {"Java Database Connectivity", "Java Data Control", "Java Driver Connection", "None"}
    };

    int answers[] = {0, 2, 0};

    public Assessment() {

        setTitle("Online Assessment");
        setSize(500,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        question = new JLabel();
        question.setBounds(20,20,450,30);

        op1 = new JRadioButton();
        op2 = new JRadioButton();
        op3 = new JRadioButton();
        op4 = new JRadioButton();

        op1.setBounds(40,60,300,25);
        op2.setBounds(40,90,300,25);
        op3.setBounds(40,120,300,25);
        op4.setBounds(40,150,300,25);

        bg = new ButtonGroup();
        bg.add(op1);
        bg.add(op2);
        bg.add(op3);
        bg.add(op4);

        next = new JButton("Next");
        next.setBounds(180,200,100,30);
        next.addActionListener(this);

        add(question);
        add(op1);
        add(op2);
        add(op3);
        add(op4);
        add(next);

        loadQuestion();

        setVisible(true);
    }

    void loadQuestion() {

        question.setText(questions[qNo]);

        op1.setText(options[qNo][0]);
        op2.setText(options[qNo][1]);
        op3.setText(options[qNo][2]);
        op4.setText(options[qNo][3]);

        bg.clearSelection();
    }

    public void actionPerformed(ActionEvent e) {

        int selected = -1;

        if(op1.isSelected()) selected = 0;
        if(op2.isSelected()) selected = 1;
        if(op3.isSelected()) selected = 2;
        if(op4.isSelected()) selected = 3;

        if(selected == answers[qNo])
            score++;

        qNo++;

        if(qNo < questions.length) {
            loadQuestion();
        }
        else {
            JOptionPane.showMessageDialog(this,
                    "Assessment Completed!\nYour Score : "
                            + score + "/" + questions.length);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Assessment();
    }
}
