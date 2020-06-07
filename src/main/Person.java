


/**@author James Geraghty
 *
 *
 *
 */
public class Person {
    private String email;
    private String name;
    private String address;
    private String gender;

    /**
     * constructor for objects of class class Person
     *
     * @param email person's email
     * @param name Person's name
     *
     * @param address person's address
     * @param gender person's gender
     */

    public Person(String email, String name, String address, String gender) {
        this.email = email;
        setName(name);
        this.address = address;
        setGender(gender);
    }

    public Person() {

    }

    /**
     *
     * @return the persons email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return the persons name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return  the persons gender
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @return the persons address
     */
    public String getAddress() {
        return address;
    }



    //-------
    //setters
    //-------
    /**
     * Updates the Person's Code to the value passed as a parameter
     */
    /**
     * updates the person email as a valuse passes as a parameter
     * @param email the person's email address
     */
    public void setEmail(String email) {
        this.email =  email;
    }

    /**
     * updates the person name as a value passed as a parameter, but it cannot
     * be longer than 30 character long
     * @param name the persons name
     */
    public void setName(String name) {
        if(name.length()<30)
        {
            this.name = name;
        }else{
            this.name = name.substring(0,30);
        }
    }


    /**
     * updates the person gender as a vlaue passed as a parameter, the user can select m or f
     * if neither as selected the default value is set to unspeified
     * @param gender
     */
    public void setGender(String gender) {
        if ((gender.equals("M") || gender.equals("m"))) {
            this.gender = "M";
        } else if ((gender.equals("F") || gender.equals("f"))) {
            this.gender = "F";
        }else {
            this.gender = "Unspecified";

        }
    }

    /**
     * updates the address as a value passed as a parameter
     * @param address the address of the person
     */
    public void setAddress(String address) {
        this.address = address;
    }



    /**
     * Builds a String representing a user friendly representation of the object state
     * @return Details of the specific member
     */
    public String toString()
    {
        return "Name: " + name
                + ", Email: " + email
                + ", Address: " + address
                + ", Gender: " + gender;
    }
}
