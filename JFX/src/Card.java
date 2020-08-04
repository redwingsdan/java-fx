import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * @author Luis F. Hernandez, 109959584
 */
public class Card implements Comparable {

    final int CARD_WIDTH = 75;

    private final String suitStringValue;
    private int suit;
    private final int rank;
    private Image card_face;
    private final Image card_back
            = new Image("file:images/Playing_card_back.jpg");
    private ImageView face;
    private ImageView back;

    public Card(int rank, int suit, String suitStringValue) {
        this.rank = rank;
        this.suitStringValue = suitStringValue;
        this.suit = suit;
        String imageUri = "file:images/Playing_card_" + suitStringValue
                + "_" + rank + ".jpg";
        this.card_face = new Image(imageUri);
        face = new ImageView(this.card_face);
        face.setFitWidth(CARD_WIDTH);
        face.setPreserveRatio(true);
        back = new ImageView(this.card_back);
        back.setFitWidth(CARD_WIDTH);
        back.setPreserveRatio(true);
       
    }

    public String getSuitStringValue() {
        return suitStringValue;
    }

    public int getRank() {
        return rank;
    }

    public Image getCard_face() {
        return card_face;
    }

    public ImageView getFace() {
        return face;
    }

    public Image getCard_back() {
        return card_back;
    }

    public ImageView getBack() {
        return back;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suitStringValue + "s";
    }

    @Override
    public int compareTo(Object o) {
        Card c2 = (Card) o;
//        if (suit > c2.suit) {
//            return 1;
//        }
//        if (suit < c2.suit) {
//            return -1;
//        }
        if (rank > c2.rank) {
            return 1;
        }
        if (rank < c2.rank) {
            return -1;
        }
        return 0;
    }

}