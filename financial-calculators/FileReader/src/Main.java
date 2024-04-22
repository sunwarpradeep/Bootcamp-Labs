import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        try {
            FileInputStream fileInputStream = new FileInputStream("Yeats-poem.text");

            Scanner scanner = new Scanner(fileInputStream);
            String input;
            while (scanner.hasNextLine()) ;
            input = scanner.nextLine();
            System.out.println(input);

            scanner.close();
        }



        catch ( FileNotFoundException ex){

        }


    }
}