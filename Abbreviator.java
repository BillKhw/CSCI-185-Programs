import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Abbreviator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String abbreviation;
        String definition;

        try {
            FileWriter writer = new FileWriter("abbreviations.txt");

            while (true) {
                System.out.println("Gib abbreviation to a word or type 'exit' : ");
                abbreviation = input.nextLine();

                if (abbreviation.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.println("Gib meaning to da word: ");
                definition = input.nextLine();

                writer.write(abbreviation + "|" + definition + "\n");
            }

            writer.close();
            System.out.println("SAVED!");
        } catch (IOException e) {
            System.out.println("Awkwurrrd... Program failed!");
        }
    }
}