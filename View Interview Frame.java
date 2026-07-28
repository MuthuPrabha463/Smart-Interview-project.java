import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class ViewInterviewFrame extends JFrame {

    JTextArea area;
    JButton backBtn;

    int candidateId;


    public ViewInterviewFrame(int candidateId) {

        this.candidateId = candidateId;


        setTitle("My Interview Details");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JLabel title = new JLabel(
                "My Interview Details",
                JLabel.CENTER
        );

        title.setFont(
                new Font("Arial", Font.BOLD, 22)
        );



        area = new JTextArea();

        area.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        area.setEditable(false);



        backBtn = new JButton("Back");



        add(title, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);
        add(backBtn, BorderLayout.SOUTH);



        loadInterview();



        backBtn.addActionListener(e -> {

            new CandidateDashboardFrame(candidateId);

            dispose();

        });



        setVisible(true);

    }



    private void loadInterview() {


        try {


            Connection con = DBConnection.getConnection();


            String query =
            "SELECT * FROM interview WHERE candidate_id=?";


            PreparedStatement ps =
            con.prepareStatement(query);


            ps.setInt(1, candidateId);


            ResultSet rs =
            ps.executeQuery();



            if(rs.next()) {


                area.setText(
                        "========== My Interview ==========\n\n"
                        +
                        "Interview ID : "
                        + rs.getInt("interview_id")
                        +
                        "\nCandidate ID : "
                        + rs.getInt("candidate_id")
                        +
                        "\nInterview Date : "
                        + rs.getDate("interview_date")
                        +
                        "\nInterview Type : "
                        + rs.getString("interview_type")
                        +
                        "\nStatus : "
                        + rs.getString("status")
                        +
                        "\n\n=================================="
                );


            }
            else {


                area.setText(
                        "No Interview Found!"
                );


            }


        }
        catch(Exception e) {


            e.printStackTrace();

        }

    }

}
