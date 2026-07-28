import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CandidateDashboardDAO {

    public void viewInterview(int candidateId) {

        String sql = "SELECT * FROM interview WHERE candidate_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, candidateId);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                System.out.println("\n========== My Interview ==========");

                System.out.println("Interview ID : " + rs.getInt("interview_id"));
                System.out.println("Candidate ID : " + rs.getInt("candidate_id"));
                System.out.println("Interview Date : " + rs.getString("interview_date"));
                System.out.println("Interview Type : " + rs.getString("interview_type"));
                System.out.println("Status : " + rs.getString("status"));

                System.out.println("==================================");

            } else {

                System.out.println("No Interview Found!");

            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
