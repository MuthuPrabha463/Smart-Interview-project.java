import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {


    public boolean loginCandidate(String email, String password) {

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
