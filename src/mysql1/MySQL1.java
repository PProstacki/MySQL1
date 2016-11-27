package mysql1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MySQL1 {

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        SingletonConnection singletonConnection = SingletonConnection.getInstance();
        Scanner scanner1 = new Scanner(System.in);
        int choice = 0;

        System.out.println("1. Wyswietlenie tablicy");
        System.out.println("2. Zmiana istniejącej tablicy");
        System.out.println("3. Koniec");
        System.out.print("Wybor: ");
        choice = scanner1.nextInt();

        if (choice == 1) {
            try{
            ResultSet outcome = singletonConnection.executeQuery("Select * from lista_filmow");
            while (outcome.next()) {
                System.out.println(outcome.getString(1) + ", " + outcome.getString(2) + ", " + outcome.getString(3) + ", " + outcome.getString(4));
            }
            }catch(SQLException e){
                e.printStackTrace();
            }
        } else if (choice == 2) {
            String commandSQL;
            Scanner scanner2 = new Scanner(System.in);
            System.out.print("Prosze wpisac komende SQL: ");
            commandSQL = scanner2.nextLine();
            System.out.println("Wiersze zmienione: " + singletonConnection.executeUpdate(commandSQL));
        } else if (choice == 3) {
            System.exit(0);
        }
    }

}
