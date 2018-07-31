import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contacts> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }

    public void addNewContact(Contacts contact) {
        if( checkDuplicated(contact) ) {
            System.out.println("Contact has been added");
            this.myContacts.add(contact);

        } else {
            System.out.println("No contact was added");
        }
    }

    public void updateContact(String oldName, Contacts newContact) {
        if(queryContact(oldName) < 0) {
            System.out.println(oldName + " can't be found");

        } else if (checkDuplicated(newContact)) {
            int position = queryContact(oldName);
            this.myContacts.set(position, newContact);
            System.out.println("Contact has been updated");
        }
    }

    public boolean checkDuplicated(Contacts contact) {
        int matchNames = 1;
        int matchNumbers = 1;

        for(int i=0; i<this.myContacts.size(); i++) {
            if(this.myContacts.get(i).getName().equals(contact.getName())) {
                matchNames += 1;
            }

            if(this.myContacts.get(i).getNumber().equals(contact.getNumber())) {
                matchNumbers += 1;
            }
        }

        if(matchNames > 1) {
            System.out.println("Name: " + contact.getName() + ", already exists in phone book");
            return false;

        } else if(matchNumbers > 1) {
            System.out.println("Number: " + contact.getNumber() + ", already exists in phone book");
            return false;

        } else {
            return true;
        }
    }

    public void removeContact(String name) {
        int position = queryContact(name);

        if(position < 0) {
            System.out.println("No contact with name " + name + " was found");

        } else {
            this.myContacts.remove(position);
            System.out.println(name + " was deleted from phone book");
        }
    }

    public int queryContact(String name) {
        for(int i=0; i<this.myContacts.size(); i++) {
            if(this.myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean findContact(String name) {
        for(int i=0; i<this.myContacts.size(); i++) {
            if(this.myContacts.get(i).getName().equals(name)) {
                System.out.println(this.myContacts.get(i).getName() + ": " + this.myContacts.get(i).getNumber() );
                return true;
            }
        }
        return false;
    }

    public void printContacts() {
        if(this.myContacts.size() == 0) {
            System.out.println("Phone book is empty");
        } else {
            for(int i=0; i<this.myContacts.size(); i++) {
                System.out.println((i+1) + ". " + this.myContacts.get(i).getName() + ": "
                        + this.myContacts.get(i).getNumber());
            }
        }
    }
}
