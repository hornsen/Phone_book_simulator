import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("+491234554321");

    public static void main(String[] args) {

        System.out.println("\n*** Starting phone ***");
        printActions();
        boolean quit = false;
        int option;

        while(!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    System.out.println("\nShutting down phone");
                    quit = true;
                    break;

                case 1:
                    mobilePhone.printContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    findContact();
                    break;

                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void addNewContact() {
        System.out.println("Please write the name of your new contact: ");
        String name = scanner.nextLine();

        System.out.println("Please write the number of your new contact: ");
        String number = scanner.nextLine();

        Contacts contact = Contacts.createContact(name, number);

        mobilePhone.addNewContact(contact);
    }

    private static void updateContact() {
        System.out.println("Please write the old name of the contact you want to update\n");
        String oldName = scanner.nextLine();

        System.out.println("Please write the new name of the contact you want to update\n");
        String newName = scanner.nextLine();

        System.out.println("Please write the new number of the contact you want to update\n");
        String newNumber = scanner.nextLine();

        Contacts newContact = Contacts.createContact(newName, newNumber);

        mobilePhone.updateContact(oldName, newContact);
    }

    private static void removeContact() {
        System.out.println("Please write the name of the contact you want to remove\n");
        String name = scanner.nextLine();

        mobilePhone.removeContact(name);
    }

    private static void findContact() {
        System.out.println("Please write the name of the contact you are searching\n");
        String name = scanner.nextLine();

        if( !mobilePhone.findContact(name) ) {
            System.out.println("There is no contact with name: " + name + "\n");
        }
    }

    private static void printActions() {
        System.out.println("\nAvailable actions: \n");
        System.out.println("0 - to shutdown\n" +
                "1 - to print contacts\n" +
                "2 - to add new contact\n" +
                "3 - to update an existing contact\n" +
                "4 - to remove an existing contact\n" +
                "5 - to search for an existing contact\n" +
                "6 - to print a list of available actions.");
    }
}
