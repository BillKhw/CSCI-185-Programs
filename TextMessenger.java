import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextMessenger {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("TEXT MESSAGE GIMME NOW:");
            String message = input.nextLine();
            String filename = "abbreviations.txt";

            Scanner inputStream = new Scanner(new File(filename));
            String[] words = message.split("\\s+");
            String translation = "";

            for (String word : words) {
                inputStream = new Scanner(new File(filename));
                int flag = 0;

                while (inputStream.hasNextLine()) {
                    String line = inputStream.nextLine();
                    String[] parts = line.split("\\|");

                    if (parts[0].equals(word)) {
                        translation += parts[1] + " ";
                        flag = 1;
                        break;
                    }
                }

                if (flag == 0) {
                    translation += word + " ";
                }
            }

            System.out.println("Translated text: " + translation.trim());

            inputStream.close();
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Awkurrddd... File not found!");
        }
    }
}
