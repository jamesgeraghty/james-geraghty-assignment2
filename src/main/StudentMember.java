public class StudentMember extends Member  {

    private String collegeId;
    private String studentName;

    public StudentMember (String email, String name, String address,
                          String gender, float height, float startWeight, String chosenPackage) {
        super(email, name, address, gender, height, startWeight, chosenPackage);
        setStudentName(studentName);
        setCollegeId(collegeId);



    }


    public String getCollegeId() {
        return collegeId;
    }



    public String getStudentName() {
        return studentName;
    }


    public void setCollegeId(String collegeId)
    {
        this.collegeId = collegeId;
    }


    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }


    @Override
    public String toString()
    {
        return  super.toString() + ", "

                + ", collegeId: " + collegeId
                + ", studentName: " + studentName;

    }
}


