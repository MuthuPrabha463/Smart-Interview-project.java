import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CandidateDAO {

    // Candidate Registration
    public void addCandidate(Candidate candidate) {

        String sql = "INSERT INTO candidate(name, email, phone, qualification, skills, experience, password) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, candidate.getName());
            pst.setString(2, candidate.getEmail());
            pst.setString(3, candidate.getPhone());
            pst.setString(4, candidate.getQualification());
            pst.setString(5, candidate.getSkills());
            pst.setString(6, candidate.getExperience());

            // Default password
            pst.setString(7, "1234");

            pst.executeUpdate();

            System.out.println("Candidate Registered Successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Candidate Login
    public boolean login(String email, String password) {

        boolean status = false;

        String sql = "SELECT * FROM candidate WHERE email=? AND password=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, email);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();


            if(rs.next()) {
                status = true;
            }


            con.close();


        } catch(Exception e) {

            e.printStackTrace();

        }

        return status;
    }
}
