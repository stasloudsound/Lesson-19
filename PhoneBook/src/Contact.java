import java.util.Objects;

public class Contact {
    private String name;
    private String surname;
    private String number;


    public Contact(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        this.number = number;


    }

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, surname, number);
    }


    @Override
    public boolean equals(Object o) {
        Contact contact = (Contact) o;
        return name == contact.name && this.surname.equals(contact.surname) && this.number.equals(contact.number);
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname + " " + this.number;
    }
}

