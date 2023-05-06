
public class Card {
    private String cardName;
    private String cardClass;
    private String type;

    //Constructor
    public Card() {
        cardName = "No Name";
        cardClass = "No Class";
        type = "No Type";
    }

    //Accessors
    public String getCardName() { return cardName; }
    public String getCardClass() { return cardClass; }
    public String getType() { return type; }

    //Mutators
    public void setCardName(String newCardName) { cardName = newCardName; }
    public void setCardClass(String newCardClass) { cardClass = newCardClass; }
    public void setType(String newType) { type = newType; }

    //Param Constructor
    public void setCard(String newCardName, String newCardClass, String newType) {
        this.setCardName(newCardName);
        this.setCardClass(newCardClass);
        this.setType(newType);
    }

    public boolean equalsCard(Card c1){
        if (this.getCardName().equalsIgnoreCase(c1.getCardName()) && this.getCardClass().equalsIgnoreCase(c1.getCardClass()) && this.getType().equalsIgnoreCase(c1.getType()))
            return true;
        else
            return false;
    }


}