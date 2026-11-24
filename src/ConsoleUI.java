import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ConsoleUI {
    public MenuChoice menu;
    private ArrayList<Member> members;

    public void run() {
        menu = MenuChoice.DEFAULT;
        while (menu == MenuChoice.DEFAULT) {
            showMenu();
            int choice = Integer.parseInt(IO.readln());
            switch (choice) {
                case 1 -> showChairmanMenu();
                case 2 -> showCashierMenu();
                case 3 -> showTrainerMenu();

            }
        }
        while (menu == MenuChoice.CHAIRMAN){
            int choice = Integer.parseInt(IO.readln());
            switch (choice) {
                case 1 -> createMember();
                case 2 -> IO.println("");
                case 3 -> IO.println("");
            }
        }
        while (menu == MenuChoice.CASHIER){
            int choice = Integer.parseInt(IO.readln());
            switch (choice) {
                case 1 -> showExpectedIncome();
                case 2 -> IO.println("");
                case 3 -> IO.println("");
            }
        }
        while (menu == MenuChoice.TRAINER){
            int choice = Integer.parseInt(IO.readln());
            switch (choice) {
                case 1 -> IO.println("trainer");
                case 2 -> IO.println("");
                case 3 -> IO.println("");
            }
        }

    }
    public void menuHeader() {
        IO.println("""
                ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
                      🐬  M E N U  🐬
                ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
                """);
    }

    public void menuFooter() {
        IO.println("""               
                .·´¯`·.´¯`·.¸¸.·´¯`·.¸><(((º>
                ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
                """);
    }

    public void showMenu() {
        menuHeader();
        IO.println("""  
                
                 1. Formand
                 2. Kassere
                 3. Træner
                
                """);
        menuFooter();
    }

    public void showChairmanMenu() {
        menu = MenuChoice.CHAIRMAN;
        menuHeader();
        IO.println("""  
                
                 1. Opret medlem
                 2. Opret konkurrencesvømmer
                 3. Ændre medlem
                
                """);
        menuFooter();
    }
    private Member createMember(){
        DateTimeFormatter euFormat = DateTimeFormatter.ofPattern("[d-M-yyyy][d/M/yyyy][d.M.yyyy]");
        String name = IO.readln("Fulde navn: ");
        Address address = createAddress();
        String email = IO.readln("Email: ");
        int phoneNumber = Integer.parseInt(IO.readln("Telefon Nummer: "));
        LocalDate birthday = LocalDate.parse(IO.readln("Fødselsdag DD-MM-YYYY: "), euFormat);
        menu = MenuChoice.DEFAULT;
        run();
        return new Member(name, address,email, phoneNumber,birthday);

    }
    private Address createAddress(){
        String Streetname = IO.readln("Vejnavn: ");
        String houseNumber = IO.readln("Nummer: ");
        int postalCode = Integer.parseInt(IO.readln("Postnummer: "));
        String city = IO.readln("By: ");
        String country = IO.readln("Land: ");
        return new Address(Streetname,houseNumber,postalCode,city,country);
    }

    public void showCashierMenu() {
        menu = MenuChoice.CASHIER;
        menuHeader();
        IO.println("""  
                
                 1. Vis årlig kontigent indkomst
                 2. 
                 3. 
                
                """);
        menuFooter();
    }

    public void showTrainerMenu() {
        menu= MenuChoice.TRAINER;
        menuHeader();
        IO.println("""  
                
                 1. trainer
                 2. 
                 3. 
                
                """);
        menuFooter();
    }

    public void showExpectedIncome() {
        MembershipCalculator calculator = new MembershipCalculator();

        double expectedIncome =
                calculator.CalculateMembershipTotal(members);

        IO.println("Forventet årlig kontigent indkomst: "
                + expectedIncome + " kr.");
    }
    public ConsoleUI(ArrayList<Member> members) {
        this.members = members;
    }
}
