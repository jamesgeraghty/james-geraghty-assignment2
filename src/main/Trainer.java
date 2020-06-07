public class Trainer extends Person  {

    private String chosenSpeciality;

    public Trainer(String email, String name, String address,
                  String gender, String chosenSpeciality) {
        super(email, name, address, gender);

        setChosenSpeciality(chosenSpeciality);
    }

    public Trainer() {
        super();
    }


    public String getChosenSpeciality()
    {
        return getChosenSpeciality();
    }

    public void setChosenSpeciality(String chosenSpeciality)
    {
        this.chosenSpeciality = chosenSpeciality;
    }
    @Override
    public String toString()
    {
        return  super.toString() + ", "

                + ", chosenSpeciality: " + chosenSpeciality;

    }
}



