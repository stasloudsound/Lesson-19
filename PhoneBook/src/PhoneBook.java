import java.util.ArrayList;
import java.util.List;


public class PhoneBook {
    public static List<Contact> contacts;

    {
        contacts = new ArrayList<>();

        contacts.add(new Contact("Pawa", "Aliev", "89416319646"));
        contacts.add(new Contact("Masha", "Sinicina", "85330125254"));
        contacts.add(new Contact("Sergey", "Danilov", "83135312315"));


    }


    //SEARCH
    public static List<Contact> search(String s) {
        return contacts.stream().filter(contact -> contact.getName().contains(s) || contact.getSurname().contains(s) || contact.getNumber().contains(s)).toList();
    }

    //PRINT
    public void printAll() {
        int count = 1;
        for (Contact c : contacts) {
            System.out.println(count + ") " + c.toString());
            count++;

        }
    }

    //ADD
    public void add(Contact contact) throws Exception {
        if (contacts.contains(contact)) {
            throw new Exception("Danniy contact suwestvuet");
        }
        contacts.add(contact);
    }


    //DELIT
    public void delete(int index) throws Exception {
        if (contacts.size() > index && index >= 0) {
            contacts.remove(index);
        } else {
            throw new Exception("incorrect index");
        }
    }

}