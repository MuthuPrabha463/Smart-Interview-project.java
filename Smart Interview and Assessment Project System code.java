import java.sql.Connection;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Connection con = DBConnection.getConnection();

        if (con != null) {

            Scanner sc = new Scanner(System.in);

            int choice;

            do {

                System.out.println("\n==========================================");
                System.out.println(" Smart Interview Assessment &");
                System.out.println(" Proctoring System");
                System.out.println("==========================================");

                System.out.println("1. Candidate Registration");
                System.out.println("2. Schedule Interview");
                System.out.println("3. Start Assessment");
                System.out.println("4. View Result");
                System.out.println("5. Admin View");
                System.out.println("6. Candidate Login");
                System.out.println("7. Exit");

                System.out.print("Enter your choice: ");

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:

                        System.out.println("\n--- Candidate Registration ---");

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter Phone: ");
                        String phone = sc.nextLine();

                        System.out.print("Enter Qualification: ");
                        String qualification = sc.nextLine();

                        System.out.print("Enter Skills: ");
                        String skills = sc.nextLine();

                        System.out.print("Enter Experience: ");
                        String experience = sc.nextLine();

                        Candidate candidate = new Candidate(
                                name,
                                email,
                                phone,
                                qualification,
                                skills,
                                experience
                        );

                        CandidateDAO candidateDAO = new CandidateDAO();
                        candidateDAO.addCandidate(candidate);

                        break;

                    case 2:

                        System.out.println("\n--- Interview Scheduling ---");

                        System.out.print("Enter Candidate ID: ");
                        int candidateId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Interview Date (YYYY-MM-DD): ");
                        String interviewDate = sc.nextLine();

                        System.out.print("Enter Interview Type: ");
                        String interviewType = sc.nextLine();

                        Interview interview = new Interview(
                                candidateId,
                                interviewDate,
                                interviewType,
                                "Scheduled"
                        );

                        InterviewDAO interviewDAO = new InterviewDAO();
                        interviewDAO.scheduleInterview(interview);

                        break;

                    case 3:

                        System.out.println("\n--- MCQ Assessment ---");

                        System.out.print("Enter Interview ID: ");
                        int interviewId = sc.nextInt();

                        Assessment.startAssessment(interviewId);

                        break;

                    case 4:

                        System.out.println("\n--- View Interview Result ---");

                        System.out.print("Enter Interview ID: ");
                        int resultInterviewId = sc.nextInt();

                        ResultDAO resultDAO = new ResultDAO();
                        resultDAO.viewResult(resultInterviewId);

                        break;

                    case 5:

                        System.out.println("\n========== Admin View ==========");

                        AdminDAO adminDAO = new AdminDAO();

                        System.out.println("\n1. View Candidates");
                        System.out.println("2. View Interviews");
                        System.out.println("3. View Assessment Results");

                        System.out.print("Enter Admin Choice: ");

                        int adminChoice = sc.nextInt();

                        switch (adminChoice) {

                            case 1:
                                adminDAO.viewCandidates();
                                break;

                            case 2:
                                adminDAO.viewInterviews();
                                break;

                            case 3:
                                adminDAO.viewResults();
                                break;

                            default:
                                System.out.println("Invalid Admin Choice!");
                        }

                        break;

                    case 6:

                        System.out.println("\n--- Candidate Login ---");

                        System.out.print("Enter Email: ");
                        String loginEmail = sc.nextLine();

                        System.out.print("Enter Password: ");
                        String loginPassword = sc.nextLine();

                        LoginDAO loginDAO = new LoginDAO();

                        boolean success = loginDAO.loginCandidate(loginEmail, loginPassword);

                        if (success) {
                            CandidateDashboard.dashboard();
                        }

                        break;

                    case 7:

                        System.out.println("Thank you for using the system!");
                        break;

                    default:

                        System.out.println("Invalid Choice!");
                }

            } while (choice != 7);

            sc.close();

        } else {

            System.out.println("Database Connection Failed!");
        }
    }
}
