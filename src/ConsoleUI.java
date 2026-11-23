public class ConsoleUI {
    public MenuChoice menu;

    public void run() {
        menu = MenuChoice.DEFAULT;
        while (menu == MenuChoice.DEFAULT) {
            showMenu();
            int choice = Integer.parseInt("");
            switch (choice) {
                case 1 -> showChairmanMenu();
                case 2 -> showCashierMenu();
                case 3 -> showTrainerMenu();

            }
        }
        while (menu == MenuChoice.CHAIRMAN){
            int choice = Integer.parseInt("");
            switch (choice) {
                case 1 -> IO.println("chairman");
                case 2 -> IO.println("");
                case 3 -> IO.println("");
            }
        }
        while (menu == MenuChoice.CASHIER){
            int choice = Integer.parseInt("");
            switch (choice) {
                case 1 -> IO.println("cashier");
                case 2 -> IO.println("");
                case 3 -> IO.println("");
            }
        }
        while (menu == MenuChoice.TRAINER){
            int choice = Integer.parseInt("");
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
                
                 1. chairman
                 2. 
                 3. 
                
                """);
        menuFooter();
    }

    public void showCashierMenu() {
        menu = MenuChoice.CASHIER;
        menuHeader();
        IO.println("""  
                
                 1. cashier
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
}
