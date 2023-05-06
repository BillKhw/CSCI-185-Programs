import java.util.IllegalFormatException;
import java.util.Scanner;
public class Deck extends Card {
    private Card[] deck = new Card[30];
    private String gamerTag;
    private int position;

    public String getGamerTag(){ return gamerTag; }
    public void setGamerTag(String newGamerTag){ gamerTag = newGamerTag; }

    //Default Constructor
    public Deck(){
        gamerTag = "TootleMcGoober";
        position = 0;
        for (int i = 0; i < 30; i++)
            deck[i] = new Card();
    }

    private int getCount(Card c){
        int count = 0;
        for (int i = 0; i < 30; i++){
            if (deck[i].equalsCard(c))
                count++;
        }
        return count;
    }

    public void addCard(Card c){
        int flagForType = 0;
        int flagForThreeCards = 0;
        try {
            for (int i = 0; i < 30; i++){
                if (deck[i].getType().equalsIgnoreCase("LEGENDARY") && c.getType().equalsIgnoreCase("LEGENDARY"))
                    flagForType = 1;
                if (this.getCount(c) == 2)
                    flagForThreeCards++;
            }
            if (flagForType == 1 || flagForThreeCards >= 2)
                throw new ArrayStoreException();
            deck[position] = c;
            position++;
        }
        catch (ArrayIndexOutOfBoundsException deckIsFull){
            System.out.println("No more space for adding more cards silly goopa");
        }
        catch (ArrayStoreException maxCardQuantity){
            System.out.println("Card not acceptable in deck due to balance issues");
        }
        if (position == 30){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void removeCard(){
        try {
            position--;
            deck[position] = new Card();
            System.out.println("Removed last card!");
            }

        catch (ArrayIndexOutOfBoundsException cardNotInDeck){
            System.out.println("Cannot remove card due to bounds issue");
        }

        if (position == 0){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void printDeck(){
        for (int i = 0; i < 30; i++){
            System.out.println("CARD "+ (i+1)+ ":");
            System.out.println(deck[i].getCardName());
            System.out.println(deck[i].getCardClass());
            System.out.println(deck[i].getType());
        }
    }

    public void buildDeck(){
        Scanner input = new Scanner(System.in);
        Card temp = new Card();
        String cardName;
        String cardClass;
        String type;
        System.out.println("Give username poopa");
        gamerTag = input.next();
        System.out.println("OK we build deck now");
        while (position < 30){
            System.out.println("Would you like to add a card, remove a card, or print a card? To add a card type ADD, to remove type REMOVE, and to print type PRINT. If you would like to quit type QUIT.");
            String answer = input.next();
            if (answer.equalsIgnoreCase("ADD")) {
                System.out.println("Give me the name, the class, and then the type of the card you would like me to add");
                cardName = input.next();
                cardClass = input.next();
                type = input.next();
                temp.setCard(cardName, cardClass, type);
                this.addCard(temp);
            }
            else if (answer.equalsIgnoreCase("REMOVE")) {
                this.removeCard();
            }
            else if (answer.equalsIgnoreCase("PRINT"))
                this.printDeck();

            else
                break;
        }


    }



}
