import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void readFile(String filePuth) {

        try (FileReader reader = new FileReader(filePuth)) {

            int c;
            while ((c = reader.read()) != -1) {

                System.out.print((char) c);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static void writingToFile(String filePuth, String name, String surname, String number) {

        try (FileWriter writer = new FileWriter(filePuth, true)) {
            String sep = "/";

            writer.write(name + sep + surname + sep + number + sep + "\n ");

            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        int select, delete;
        String name, surname, number;
        Contact contact;
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        String filePuth = "listIndividuals.txt";

        do {
            System.out.println("""
                           Menu:
                    0 - SEARCH 
                    1 - PRINT ALL 
                    2 - ADD 
                    3 - EDIT  
                    4 - REMOVE 
                    5 - EXIT
                                     
                      """);


            try {
                select = scanner.nextInt();


                //SEARCH
                if (Codes.getEnumByCode(select) == Codes.SEARCH) {
                    System.out.println("Введите номер, имя, или фамилию");
                    scanner = new Scanner(System.in);
                    String s = scanner.nextLine();
                    System.out.println(PhoneBook.search(s));
                }

                //PRINT
                else if (Codes.getEnumByCode(select) == Codes.PRINT) {
                    System.out.println("PRINT: ");
                    readFile(filePuth);
                    phoneBook.printAll();
                }


                //ADD
                else if (Codes.getEnumByCode(select) == Codes.ADD) {
                    System.out.println("ADD");
                    scanner = new Scanner(System.in);
                    try {
                        System.out.print("Enter name: ");
                        name = scanner.next();
                        System.out.print("Enter surname: ");
                        surname = scanner.next();
                        System.out.print("Enter number: ");
                        number = scanner.next();
                        contact = new Contact(name, surname, number);
                        writingToFile(filePuth, name, surname, number);
                        phoneBook.add(contact);
                        System.out.println("Dobavlenie uspewno prowlo");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        System.out.println("Contact ne bil dobavlen");
                    }
                }


                //EDIT
                else if (Codes.getEnumByCode(select) == Codes.EDIT) {
                    System.out.println("EDIT: ");
                    phoneBook.printAll();
                    System.out.print("Введите индекс контакта: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("""
                                 Выберите тип изменения:
                                 1. Имя
                                 2. Фамилия
                                 3. Номер
                                           
                            """);
                    int index1 = scanner.nextInt();
                    if (index1 == 1) {
                        System.out.print("Введите имя: ");
                        String value = scanner.next();
                        PhoneBook.contacts.get(index).setName(value);
                    } else if (index1 == 2) {
                        System.out.print("Введите фамилию: ");
                        String value = scanner.next();
                        PhoneBook.contacts.get(index).setSurname(value);
                    } else if (index1 == 3) {
                        System.out.print("Введите номер: ");
                        String value = scanner.next();
                        PhoneBook.contacts.get(index).setNumber(value);
                    }
                }


                //DELIT
                else if (Codes.getEnumByCode(select) == Codes.DELETE) {
                    phoneBook.printAll();
                    try {
                        delete = scanner.nextInt();
                        phoneBook.delete(delete - 1);
                        System.out.println("Ydachno ydadili contact");
                    } catch (Exception ex) {
                        System.out.println("Ne Correctnie danie");
                    }
                    System.out.println("DELETE");
                }


                //EXIT
                else if (Codes.getEnumByCode(select) == Codes.EXIT) {
                    System.out.println("Goodbye");
                    break;
                }


            } catch (InputMismatchException ex) {
                System.out.println("Enter wrong data");
                //scanner.remove();
                scanner = new Scanner(System.in);
            } catch (Exception ex) {
                System.out.println("Invalid select");
            }
        } while (true);
    }
}







