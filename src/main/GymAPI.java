import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


/**
 * Declarring the arraylist
 * keeps track on how many members and trainer
 * are in the gym
 */

public class GymAPI {
    // private fields
    // only methods within this class have access to it
    private ArrayList<Member> members; // declares arraylist of Member as a private instance variable members
    private ArrayList<Trainer> trainers; // stores trainers , using arraylist iof trainers

    /**
     * calling constructor of the arraylist
     * "new" keyword initilaized the members object variable
     */
    public GymAPI() {
        // constrcutor method saem name as the class
        members = new ArrayList<Member>(); // initialise members to be an new arraylist of member, constructor called using "()"
        trainers = new ArrayList<Trainer>();// initailise  trainer object variable

    }

    /**
     * get a specific element of the collection
     * @return members
     */
    public ArrayList<Member> getMembers() {
        return members;
    }

    /**
     * @param member adding a member object to an Arryalist of Member
     *               member = the object variable/ parameter
     *               Member = The arraylist hod object of this type
     *               members = arraylist of Member
     *               .add method requires a parameter ( member)
     */
    public void addMember(Member member) { // adds a member , passes member as a parameter to the .add method of the arraylist
        members.add(member); // .add method adds a the paramer member to the arraylist of members
    }

    /**
     * listMembers method
     * iterating through the members arraylist
     * public method member returns no value, lists out the members
     * for each value of i less than the size of  the collection,
     * list out the next member and increment index by 1
     * members.size gives the how many members are in the arraylist
     * members.get (i) - gets back the memebr at the current index
     * @return list of all the members
     */

    public String listMembers() { // displays the members
        if (members.size() == 0) { // if there are members
            return "No members";
        } else {
            String listMembers = " ";
            for (int i = 0; i < members.size(); i++) { // visits every element of the arraylist
                System.out.println(members.get(i).toString());
                listMembers += i + ": " + members.get(i) + "\n";
            }
            return listMembers; // returns a string of the  member
        }
    }

    /**
     * size method returns how many members are in the collection
     *
     * @returns the size of the arraylist of the members arraylist
     */
    public int numberOfMembers() {
        return members.size();
    }

    /**
     *
     * @param index
     * @return wether or not the member index is present in the array list of member
     */
    public boolean isValidMemberIndex(int index) {
        if (index >= 0 && index < members.size()) {
            return true;
        }
        return false;

    }

    public ArrayList<Trainer> getTrainers() {
        return trainers;

    }

    public void addTrainer(Trainer trainer) {
        trainers.add(trainer);

    }

    /**
     *
     * @return a string on
     */
    public String listTrainers() {
        if (trainers.size() == 0) {
            return "No members";
        } else {
            String listTrainers = "";
            for (int i = 0; i < trainers.size(); i++) { // visits every element in the trainer arraylist
                listTrainers += i + ": " + trainers.get(i) + "\n"; // bring back the field of the currenttrainer as a String
            }
            return listTrainers();
        }
    }
    public int numberOfTrainers() {
        return trainers.size();
    }


    /**
     *
     * @param nameEntered
     * @return
     */
    public ArrayList<String> searchMembersByName (String nameEntered){
        ArrayList<String> memberNames;
        {
            memberNames = new ArrayList<>();
            for (Member member : members) {// for member of type Member in the members arraylist
                if (member.getName().contains(nameEntered)) { // if member name emtered is contained in the members arraylist
                    memberNames.add(member.getName());
                }
            }
        }
        return memberNames;
    }

    public ArrayList<String> searchTrainersByName(String nameEntered) {
        ArrayList<String> trainerNames; //
        {
            trainerNames = new ArrayList<>();
            for (Trainer trainer : trainers) {
                if (trainer.getName().contains(nameEntered)) {
                    trainerNames.add(trainer.getName());
                }
            }
        }
        return trainerNames;
    }

    /**
     *
     * @param emailEntered
     * @return
     */


    public Member searchMembersByEmail(String emailEntered) {
        if (members.size() != 0) {
            for (Member member : members) {// for each member of type Member in the members collection
                if (member.getEmail().equals(emailEntered)) { // if the email entered matches the email stored
                    return member; // return that member
                }
            }
        }
        return null;
    }

    /**
     * for each trainer of type Trainer in the trainers collection, check if the email entered
     * is already stored in the arraylist of members. If not present return null.
     * @param emailEntered
     * @return
     */
    public Trainer searchTrainersByEmail(String emailEntered) {
        if (trainers.size() > 0) {
            for (Trainer trainer : trainers) { // trainer of type Trainer in the trainers arraylist
                if (trainer.getEmail().equals(emailEntered)) { // if the sepcific element of the array list
                    return trainer; // return the trainer object
                }
            }
        }
        return null;  // if email not in trainer list return null
    }




    /**
     * index validity checks using if,else if , else branch
     * @param index
     * @return
     */

    public boolean isValidTrainerIndex(int index) {
        if (index >= 0 && index < trainers.size()) {
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());

        // ------------------ PREVENT SECURITY WARNINGS-----------------------------
        // The Member and Trainer classes are what we are reading in.
        // Modify to include others if needed by modifying the next line,
        // add additional classes inside the braces, comma separated

        Class<?>[] classes = new Class[] { Member.class, Trainer.class };

        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);
        // -------------------------------------------------------------------------

        ObjectInputStream memberStream = xstream.createObjectInputStream(new FileReader("members.xml"));
        ObjectInputStream trainerStream = xstream.createObjectInputStream(new FileReader("trainers.xml"));
        members = (ArrayList<Member>) memberStream.readObject();
        System.out.println(members.toString());
        trainers = (ArrayList<Trainer>) trainerStream.readObject();
        memberStream.close();
        trainerStream.close();



    }

    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());

        // ------------------ PREVENT SECURITY WARNINGS-----------------------------
        // The Product class is what we are reading in.
        // Modify to include others if needed by modifying the next line,
        // add additional classes inside the braces, comma separated

        Class<?>[] classes = new Class[] { Member.class, Trainer.class };

        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);
        // -------------------------------------------------------------------------

        ObjectOutputStream memStream = xstream.createObjectOutputStream(new FileWriter("members.xml"));
        ObjectOutputStream trainStream = xstream.createObjectOutputStream(new FileWriter("trainers.xml"));
        memStream.writeObject(members);
        trainStream.writeObject(trainers);
        memStream.close();
        trainStream.close();
    }


}