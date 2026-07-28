import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;


public class ViewResultFrame extends JFrame {


    JLabel titleLabel;

    JLabel technicalLabel;
    JLabel communicationLabel;
    JLabel confidenceLabel;
    JLabel overallLabel;
    JLabel recommendationLabel;

    JButton closeBtn;


    int candidateId;



    public ViewResultFrame(int candidateId) {


        this.candidateId = candidateId;


        setTitle("My Assessment Result");

        setSize(500,400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        titleLabel = new JLabel(
                "Latest Interview Result",
                JLabel.CENTER
        );


        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 22)
        );



        technicalLabel = new JLabel();

        communicationLabel = new JLabel();

        confidenceLabel = new JLabel();

        overallLabel = new JLabel();

        recommendationLabel = new JLabel();



        Font font = new Font(
                "Arial",
                Font.BOLD,
                16
        );


        technicalLabel.setFont(font);
        communicationLabel.setFont(font);
        confidenceLabel.setFont(font);
        overallLabel.setFont(font);
        recommendationLabel.setFont(font);



        closeBtn = new JButton("Close");



        JPanel panel = new JPanel();


        panel.setLayout(
                new GridLayout(6,1,10,10)
        );


        panel.add(technicalLabel);

        panel.add(communicationLabel);

        panel.add(confidenceLabel);

        panel.add(overallLabel);

        panel.add(recommendationLabel);

        panel.add(closeBtn);



        add(titleLabel, BorderLayout.NORTH);

        add(panel, BorderLayout.CENTER);



        loadResult();



        closeBtn.addActionListener(e -> {

            dispose();

        });



        setVisible(true);

    }






    private void loadResult() {


        String sql =
                "SELECT ar.* FROM assessment_result ar "
                +
                "JOIN interview i "
                +
                "ON ar.interview_id=i.interview_id "
                +
                "WHERE i.candidate_id=? "
                +
                "ORDER BY ar.result_id DESC LIMIT 1";



        try {


            Connection con =
                    DBConnection.getConnection();



            PreparedStatement pst =
                    con.prepareStatement(sql);



            pst.setInt(1, candidateId);



            ResultSet rs =
                    pst.executeQuery();




            if(rs.next()) {



                technicalLabel.setText(
                        "Technical Score : "
                        +
                        rs.getInt("technical_score")
                );



                communicationLabel.setText(
                        "Communication Score : "
                        +
                        rs.getInt("communication_score")
                );



                confidenceLabel.setText(
                        "Confidence Score : "
                        +
                        rs.getInt("confidence_score")
                );



                overallLabel.setText(
                        "Overall Score : "
                        +
                        rs.getInt("overall_score")
                );



                recommendationLabel.setText(
                        "Recommendation : "
                        +
                        rs.getString("recommendation")
                );



            }
            else {


                JOptionPane.showMessageDialog(
                        this,
                        "No Result Found!"
                );


            }



            con.close();



        }
        catch(Exception e) {


            e.printStackTrace();


        }


    }


}
