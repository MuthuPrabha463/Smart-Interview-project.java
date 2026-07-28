public class Candidate {

    private String name;
    private String email;
    private String phone;
    private String qualification;
    private String skills;
    private String experience;

    public Candidate(String name, String email, String phone,
                     String qualification, String skills, String experience) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.qualification = qualification;
        this.skills = skills;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getQualification() {
        return qualification;
    }

    public String getSkills() {
        return skills;
    }

    public String getExperience() {
        return experience;
    }
}
