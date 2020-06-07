import java.util.HashMap;
import java.util.Scanner;

public class MenuController {

    private Scanner input = new Scanner(System.in);
    private Member member; // member object
    private Trainer trainer; // trainer object
    private GymAPI gymAPI; // gymAPI object
    private HashMap<String, String> packages = new HashMap();


    public static void main(String[] args) {
        MenuController c = new MenuController();
    }

    public MenuController() {

        gymAPI = new GymAPI();
        input = new Scanner(System.in);
        member = new Member();
        trainer = new Trainer();


        try {
            gymAPI.load();
        } catch (Exception e) {
            System.err.println("Error reading from file: " + e);
        }
        mainMenu();
    }

    /**
     *
     */

    private int mainMenu(){
        Trainer temptrainer;// temporary variable
        Member tempmember; //  temp store for search by email
        System.out.println("Main Menu");
        System.out.println("---------------");
        System.out.println(" Are you a trainer? (T)");
        System.out.println("  Are you a member? (M)");
        System.out.print("==>> ");
        String user = input.nextLine();
        if (user.equalsIgnoreCase("T") ){
            System.out.println(" Do you want to login or register?(L/R)") ;
            String login = input.nextLine();
            if (login.equalsIgnoreCase("L")){
                System.out.println("Enter Email");
                String email = input.nextLine();
                temptrainer = gymAPI.searchTrainersByEmail(email);
                 if (temptrainer == null){
                     System.out.println(email + "does not exist");
                 } else {// successfull login
                   //  System.out.println(temptrainer.toString());
                   //  int option = trainerMenu(); //
                     runTrainerMenu();
                 }


            } else if (login.equalsIgnoreCase("R")){
                // registering
            }
        }
        // Now processing Member logic
        else if (user.equalsIgnoreCase( "M")); {
            System.out.println(" Do you want to login or register?(L/R)") ;
            String login = input.nextLine();
            if (login.equalsIgnoreCase("L")){
                System.out.println("Enter Email");
                String email = input.nextLine();
                tempmember = gymAPI.searchMembersByEmail(email);
                if (tempmember == null){
                    System.out.println(email + "does not exist");
                } else {// successfull login
                    //  System.out.println(temptrainer.toString());
                    //  int option = trainerMenu(); //
                    runMemberMenu();
                }


            } else if (login.equalsIgnoreCase("R")){
                // registering
            }
        }


        System.out.println("---------");

        System.out.print("==>> ");
        int option = input.nextInt();
        return option;
    }
    private void runMainMenu(){
        int option = mainMenu();
        while (option != 0){
            switch (option){
                case 1:    addMember();
                    break;
                case 2:    System.out.println(gymAPI.listMembers());
                    break;
                case 3:    editMember();
                    break;
                case 4:    deleteMember();
                    break;


                default:    System.out.println("Invalid option entered: " + option);
                    break;
            }
            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine();  //this second read is required - bug in Scanner class; a String read is ignored straight after reading an int.

            //display the main menu again
            option = trainerMenu();
        }

        System.out.println("Exiting... bye");
        System.exit(0);
    }
    private int trainerMenu(){
        System.out.println("Trainer Menu");
        System.out.println("---------");
        System.out.println("  1) Add a Member");
        System.out.println("  2) List all Members");
        System.out.println("  3) Update a Member");
        System.out.println("  4) Delete a Member");
        System.out.println("---------");

        System.out.print("==>> ");
        int option = input.nextInt();
        return option;
    }


    // trainer menu
    private void runTrainerMenu(){
        int option = trainerMenu();
        while (option != 0){

            switch (option){
                case 1:    addMember();
                    break;
                case 2:    System.out.println(gymAPI.listMembers());
                    break;
                case 3:    editMember();
                    break;
                case 4:    deleteMember();
                    break;
            }

            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine();

            //display the main menu again
            option = trainerMenu();
        }
        System.out.println("Exiting... bye");
        System.exit(0);
    }
    private int memberMenu() {
        System.out.println("Gym Menu");
        System.out.println("---------");
        System.out.println("  1)View Profile");
        System.out.println("  2) List the List all Members");
        System.out.println("  3) Edit Profile");
        System.out.println("  4) Delete a Member");
        System.out.println("---------");

        System.out.print("==>> ");
        int option = input.nextInt();
        return option;
    }
    private void runMemberMenu() {
        int option = memberMenu();
        while (option != 0) {

            switch (option) {
                case 1:
                    addMember();
                    break;
                case 2:
                    System.out.println(gymAPI.listMembers());
                    break;
                case 3:
                    editMember();
                    break;
                case 4:
                    deleteMember();
                    break;


            }

            //pause the program so that the user can read what we just printed to the terminal window


            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine();  //this second read is required - bug in Scanner class; a String read is ignored straight after reading an int.

            //display the main menu again
            option = memberMenu();
        }

        //the user chose option 0, so exit the program
        System.out.println("Exiting... bye");
        System.exit(0);
    }
    //gather the memeber data from the user and create a new member.
    private void addMember() {
        //dummy read of String to clear the buffer - bug in Scanner class.
        input.nextLine();
        input.nextLine();
        System.out.print(" Name:  ");
        String name = input.nextLine();
        System.out.print("Email:  ");
        String email = input.nextLine();
        System.out.print("Age:  ");
        int age = input.nextInt();
        System.out.print("Enter your Address:  ");
        String address = input.nextLine();
        System.out.print("Specify Gender (M or F): ");
        String gender = input.nextLine();
        System.out.println(gender);
        input.nextLine();
        System.out.print("Enter your height in meters: ");
        float height = input.nextFloat();
        input.nextLine();
        System.out.print("Choose your Gym Package (1, 2, 3): ");
        String chosenPackage = input.nextLine();
        System.out.print("Enter your Weight, in KG's: ");
        float startWeight = input.nextFloat();


        gymAPI.addMember(new Member(email, name, address, gender, height, startWeight, chosenPackage));
    }








    private void editMember() {
        //list the products
        System.out.println(gymAPI.listMembers());

        if (gymAPI.getMembers().size() > 0) {
            //only ask the user to choose a product if products exist
            System.out.print("Enter the index of the product to update ==> ");
            int index = input.nextInt();

            if ((index >= 0) && (index < gymAPI.getMembers().size())) {
                //if the index is valid, gather new details for each field from the user

                System.out.print("Enter the Member Name:  ");
                String name = input.nextLine();

                System.out.print("Enter the email:  ");
                String email = input.nextLine();
                System.out.print("Enter the age:  ");
                int age = input.nextInt();
                System.out.print("Enter your Address:  ");
                String address = input.nextLine();
                System.out.print("Specify Gender (M or F): ");
                String gender = input.nextLine();
                System.out.print("Enter height in meters: ");
                float height = input.nextFloat();
                input.nextLine();
                System.out.print("Chose Gym Package (1, 2 or 3): ");
                String chosenPackage = input.nextLine();
                input.nextLine();
                System.out.print("Enter Starting Weight, in KG's: ");
                float startWeight = input.nextFloat();

                //retrieve the selected product from the ArrayList and update the details
                Member member = gymAPI.getMembers().get(index);
                member.setEmail(email);
                member.setName(name);
                member.setHeight(height);
                member.setGender(gender);
            } else {
                System.out.println("There are no products for this index number");
            }
        }
    }

    private void deleteMember() {
        //list the products
        System.out.println(gymAPI.listMembers());

        if (gymAPI.getMembers().size() > 0) {
            //only ask the user to choose the product to delete if products exist
            System.out.print("Enter the index of the product to delete ==> ");
            int index = input.nextInt();

            if ((index >= 0) && (index < gymAPI.getMembers().size())) {
                //if the index is valid, delete the product at the given index
                gymAPI.getMembers().remove(index);
                System.out.println("Product deleted.");
            } else {
                System.out.println("There is no product for this index number");
            }
        }
    }
}