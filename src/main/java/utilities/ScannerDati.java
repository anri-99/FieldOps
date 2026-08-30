package utilities;

import java.util.Scanner;

public class ScannerDati {

    Scanner scan = new Scanner(System.in);

    public String scanDati(){
        String result;

        result = scan.nextLine();

        return result;
    }
}

