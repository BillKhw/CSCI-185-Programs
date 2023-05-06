import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
public class Pokedex {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "pokemon.csv";
        String line;

        Scanner input = new Scanner(System.in);
        System.out.println("Gib pokemaner name NOW!!!:");
        String pokemon = input.next();

        try {
            Scanner inputStream = new Scanner(new File(fileName));
            String type1 = "";
            String type2 = "";
            String total = "";
            String hp = "";
            String attack = "";
            String defense = "";
            String spAtk = "";
            String spDef = "";
            String speed = "";
            String gen = "";
            String isLegendary = "";
            int flag = 0;
            while (inputStream.hasNextLine()) {
                line = inputStream.nextLine();
                String[] ary = line.split(",");
                String name = ary[1];
                if (name.equalsIgnoreCase(pokemon)) {
                    flag = 1;
                    type1 = ary[2];
                    type2 = ary[3];
                    total = ary[4];
                    hp = ary[5];
                    attack = ary[6];
                    defense = ary[7];
                    spAtk = ary[8];
                    spDef = ary[9];
                    speed = ary[10];
                    gen = ary[11];
                    isLegendary = ary[12];
                    break;
                }
            }

            if (flag == 1){
                System.out.println(pokemon +":");
                System.out.println(type1);
                System.out.println(type2);
                System.out.println(total);
                System.out.println(hp);
                System.out.println(attack);
                System.out.println(defense);
                System.out.println(spAtk);
                System.out.println(spDef);
                System.out.println(speed);
                System.out.println(gen);
                System.out.println("Legendary status: " +isLegendary);
            }
            else
                System.out.println("Your pokemanz wuz not found get freaked loser.");
        }

        catch(FileNotFoundException e)
        {
            System.out.println("Cannot find file " + fileName);
        }

    }
}