import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InterviewSearchDAO {

    public int getInterviewId(int candidateId) {

        int interviewId = -1;

        String sql = "SELECT interview_id FROM interview WHERE candidate_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, candidateId);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                interviewId = rs.getInt("interview_id");

            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return interviewId;
    }
}
