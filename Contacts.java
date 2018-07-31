public class Contacts {

    String name;
    String number;

    public Contacts(String name, String number) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public static Contacts createContact(String name, String number) {
        return new Contacts(name, number);
    }
}
