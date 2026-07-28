mpiort java.sql.Connection;
import java.sql.PreparedStatement;

public class InterviewDAO {

    public void scheduleInterview(Interview interview) {

        String sql = "INSERT INTO interview(candidate_id, interview_date, interview_type, status) VALUES (?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, interview.getCandidateId());
            pst.setString(2, interview.getInterviewDate());
            pst.setString(3, interview.getInterviewType());
            pst.setString(4, interview.getStatus());

            pst.executeUpdate();

            System.out.println("Interview Scheduled Successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
