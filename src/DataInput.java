import java.util.Scanner;

public class DataInput {


    public  static void printPrompt() {
        System.out.println("Wpisz wektor atrybutów(wpisz tab pomiędzy) a następnie prawidłową klasyfikacje");
        System.out.println("Albo koniec aby zakończyć program!");
    }

    public static  String getInput() throws Exception {
        String input;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        if(input.equalsIgnoreCase("")){
            throw new Exception("Null Input");
        }
        if (input.equalsIgnoreCase("koniec")) {
            throw new Exception("Zakończono program");
        } else {
            return input;
        }
    }


}
