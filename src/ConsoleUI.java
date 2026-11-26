import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConsoleUI {
    public MenuChoice menu;
    private Club club;
    public ConsoleUI(Club club){
        this.club = club;
    }

    public void run() {
        menu = MenuChoice.DEFAULT;
        while (true) {
            if (menu == MenuChoice.DEFAULT) {
                showMenu();
                int choice = parseInt("Vælg: ");
                switch (choice) {
                    case 1 -> showChairmanMenu();
                    case 2 -> showCashierMenu();
                    case 3 -> showTrainerMenu();
                    case 0 -> {
                        return;
                    }
                }
            } else if (menu == MenuChoice.CHAIRMAN) {
                int choice = parseInt("Vælg: ");
                switch (choice) {
                    case 1 -> createMember();
                    case 2 -> IO.println("Opret Konkurrencesvømmer");
                    case 3 -> editMember();
                    case 0 -> menu = MenuChoice.DEFAULT;
                }
            } else if (menu == MenuChoice.CASHIER) {
                int choice = parseInt("Vælg: ");
                switch (choice) {
                    case 1 -> showExpectedIncome();
                    case 0 -> menu = MenuChoice.DEFAULT;
                }
            } else if (menu == MenuChoice.TRAINER) {
                int choice = parseInt("Vælg: ");
                switch (choice) {
                    case 1 -> IO.println("Trainer");
                    case 0 -> menu = MenuChoice.DEFAULT;
                }
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
                 0. Afslut
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
                 0. Tilbage
                """);
        menuFooter();
    }
    public void showCashierMenu() {
        menu = MenuChoice.CASHIER;
        menuHeader();
        IO.println("""  
                
                 1. Vis årlig kontigent indkomst
                 2. 
                 3. 
                 0. Tilbage
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
                 0. Tilbage
                """);
        menuFooter();
    }
    private void createMember(){
        DateTimeFormatter euFormat = DateTimeFormatter.ofPattern("[d-M-yyyy][d/M/yyyy][d.M.yyyy]");
        String name = IO.readln("Fulde navn: ");
        Address address = createAddress();
        String email = IO.readln("Email: ");
        int phoneNumber = parseInt("Telefon Nummer: ");
        LocalDate birthday = null;
        while (birthday == null){
            try {
                String dateStr = IO.readln("Fødselsdag DD-MM-YYYY: ");
                birthday = LocalDate.parse(dateStr, euFormat);
            }
            catch (Exception e){
                IO.println(" ! Ugyldig dato. Prøv igen. ");
            }
        }
        int memberNumber = club.nextMemberNumber();
        Member newMember = new Member(memberNumber, name, address, email, phoneNumber, birthday);
        club.addMember(newMember);
        IO.println("\n Medlem oprettet: " + newMember);
        menu = MenuChoice.DEFAULT;
    }
    private Address createAddress(){
        String Streetname = IO.readln("Vejnavn: ");
        String houseNumber = IO.readln("Nummer: ");
        int postalCode = parseInt("Postnummer: ");
        String city = IO.readln("By: ");
        String country = IO.readln("Land: ");
        return new Address(Streetname,houseNumber,postalCode,city,country);
    }

    public void showExpectedIncome() {
        double expectedIncome = club.calculateTotalIncome(LocalDate.now());
        IO.println("Forventet årlig contingent indkomst: "
                + expectedIncome + " kr.");
    }
    private void editMember(){
        IO.println("\n --- Ændre Medlem ---");
        int memberNumber = parseInt("Indtast medlemsnummer (0 for at annullere):");
        if (memberNumber == 0){
            menu = MenuChoice.DEFAULT;
            return;
        }
        Member member = club.findMember(memberNumber);
        if (member == null){
          IO.println(" ! Intent medlem fundet med nummer " + memberNumber);
          return;
        }
        IO.println("Redigerer: " + member.getName());
        IO.println("1. Ændre Navn");
        IO.println("2. Ændre Address");
        IO.println("3. Ændre Email");
        IO.println("4. Ændre Telefonnummer");
        IO.println("0. Annuller");

        int choice = parseInt("Valg hvad der skal ændres: ");

        switch (choice){
            case 1 -> {
                String newName = IO.readln("Nyt navn: ");
                member.setName(newName);
                IO.println("Navn opdateret.");
            }
            case 2 -> {
                Address newAddress = createAddress();
                member.setAddress(newAddress);
                IO.println("Navn opdateret.");
            }
            case 3 -> {
                String newEmail = IO.readln("Ny email: ");
                member.setEmail(newEmail);
                IO.println("Email opdateret. ");
            }
            case 4 -> {
                int newPhone = Integer.parseInt(IO.readln("Nyt telefonnummer: "));
                member.setPhoneNumber(newPhone);
                IO.println(" Telefonnummer opdateret. ");
            }
            case 0 -> IO.println("Annulleret. ");
            default -> IO.println(" ! Ugyldigt valg. ");
        }
    }

    private int parseInt(String prompt){
        while (true){
            try{
                return Integer.parseInt(IO.readln(prompt).trim());
            }
            catch (NumberFormatException e){
                IO.println(" ! Indtast venligst et heltal.");
            }
        }
    }
}
