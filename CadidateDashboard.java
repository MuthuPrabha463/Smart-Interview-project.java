import java.util.Scanner;

public class CandidateDashboard {

    public static void dashboard() {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("      Candidate Dashboard");
            System.out.println("=================================");
            System.out.println("1. View My Interview");
            System.out.println("2. Start Assessment");
            System.out.println("3. View My Result");
            System.out.println("4. Logout");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    CandidateDashboardDAO dashboardDAO = new CandidateDashboardDAO();
                    dashboardDAO.viewInterview(LoginDAO.loggedInCandidateId);

                    break;

                case 2:

                    InterviewSearchDAO searchDAO = new InterviewSearchDAO();

                    int interviewId = searchDAO.getInterviewId(LoginDAO.loggedInCandidateId);

                    if (interviewId != -1) {

                        Assessment.startAssessment(interviewId);

                    } else {

                        System.out.println("Interview not scheduled!");

                    }

                    break;

                case 3:

                    InterviewSearchDAO resultSearchDAO = new InterviewSearchDAO();

                    int resultInterviewId = resultSearchDAO.getInterviewId(LoginDAO.loggedInCandidateId);

                    if (resultInterviewId != -1) {

                        ResultDAO resultDAO = new ResultDAO();
                        resultDAO.viewResult(resultInterviewId);

                    } else {

                        System.out.println("No Result Found!");

                    }

                    break;

                case 4:

                    System.out.println("Logged Out Successfully.");
                    break;

                default:

                    System.out.println("Invalid Choice!");

            }

        } while (choice != 4);

    }

}
