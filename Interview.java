upblic class Interview {

    private int candidateId;
    private String interviewDate;
    private String interviewType;
    private String status;

    public Interview(int candidateId, String interviewDate,
                     String interviewType, String status) {

        this.candidateId = candidateId;
        this.interviewDate = interviewDate;
        this.interviewType = interviewType;
        this.status = status;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public String getInterviewType() {
        return interviewType;
    }

    public String getStatus() {
        return status;
    }
}
