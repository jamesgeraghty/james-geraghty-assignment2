/**
 * @author James Geraghty
 *
 * this class stores information about the member the Gym Application
 * the main section of the class consists of the member height, startweight
 * and chosen package
 */

import java.util.HashMap;

// in heritance of fields used from the person class.

public class Member extends Person {
    private float height;
    private float startWeight;
    private String chosenPackage;
    public HashMap<String, Assessment> assessmentHashMap;

    /**
     * member class constructors
     * @param email the email of the person
     * @param name the persons name
     * @param address the persons address
     * @param gender the persons gender
     * @param height the members height, we are not taking the trainer height here
     * @param startWeight the the member startweight, we will not be taking the trainers start weight
     * @param chosenPackage the members shosen package
     */
    public Member(String email, String name, String address, String gender,
                  float height, float startWeight, String chosenPackage)
                  //HashMap assessmentHashMap)
    {
        super(email, name, address, gender);
        setHeight(height);
        setStartWeight(startWeight);
        setChosenPackage(chosenPackage);
      //  this.assessmentHashMap = assessmentHashMap;
    }

    public Member() {

    }


// getters

    /**
     *
     * @return the chosen package
     */

    public String getChosenPackage()
    {
        return chosenPackage;
    }

    /**
     *
     * @return the perseon height
     */

    public float getHeight()
    {
        return height;
    }

    /**
     *
     * @return returns the persons starting weight
     */
    public double getStartWeight()
    {
        return startWeight;
    }


    //Setters

    /**
     * startweight method to determine the memeber starting weight , the weight has to between
     * 35 kgs abd 250kgs, if not a default value of 125 kgs is entered
     * @param startWeight
     */
    public void setStartWeight(float startWeight) {
        if ((startWeight >= 35f) && (startWeight <= 250f)) {
            this.startWeight = startWeight;
        } else {
            this.startWeight = 125f;
        }
    }

    /**
     *
     *
     * @param chosenPackage
     */

    public void setChosenPackage(String chosenPackage)
    {
        this.chosenPackage = chosenPackage;
    }

    /**
     * setHeight method is used to determine the height of the member,
     * the height has to between 1 metre and 3 metres , if no the default value is
     * set to 1.5 metres
     *
     * @param height
     */
    public void setHeight(float height) {
        if((height >= 1.0f) && (height <= 3.0f)) {
            this.height = height ;
        }
        else {
            this.height = 1.5f;
        }
    }


    /**
     * toString methods  buids a string representing a user friendly representation
     * of the object
     *
     *
     * @return details about the specific member
     */

    @Override
    public String toString()
    {
        return  super.toString() + ", "
               + "Height: " + height
                + ", startWeight: " + startWeight
                + ", chosenPackage: " + chosenPackage;

    }
}

