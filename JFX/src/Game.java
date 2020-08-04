import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Luis F. Hernandez, 109959584
 */
public class Game extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        Deck deck = new Deck();

        ArrayList<Card> p1 = new ArrayList();
        ArrayList<Card> p2 = new ArrayList();
        ArrayList<Card> p3 = new ArrayList();
        ArrayList<Card> p4 = new ArrayList();
        ArrayList<Card> center = new ArrayList();
        
        Boolean playerTurn = true;

        dealCards(deck, p1, p2, p3, p4);

        // Bottom - Player 1
        HBox bottomPane = new HBox();
        for (int card = 0; card < 13; card++) {
            Card a = p1.get(card);
            ImageView cardView = a.getFace();
            cardView.setOnMouseClicked((MouseEvent event) -> {
                //System.out.println(p1.get(card).getRank() +
//                " of " + p1.get(card).getSuitStringValue()+"s");
                if (playerTurn == true) {
                    System.out.print("Clicked!");
                    center.add(a);

//            p1.remove(card);
                }
            });
            bottomPane.getChildren().add(cardView);

        }
        root.setBottom(bottomPane);

        // Left - Player 2
        VBox leftPane = new VBox();
        for (int card = 0; card < 13; card++) {
            ImageView cardView = p2.get(card).getBack();
            cardView.setRotate(90.0);
            leftPane.getChildren().add(cardView);
            leftPane.setSpacing(-70.0);

        }
        root.setLeft(leftPane);

        // Top - Player 3
        HBox topPane = new HBox();
        for (int card = 0; card < 13; card++) {
            topPane.getChildren().add(p3.get(card).getBack());
            topPane.setSpacing(-50.0);
        }
        root.setTop(topPane);

        // Right - Player 4
        VBox rightPane = new VBox();
        for (int card = 0; card < 13; card++) {
            ImageView cardView = p4.get(card).getBack();
            cardView.setRotate(90.0);
            rightPane.getChildren().add(cardView);
            rightPane.setSpacing(-70.0);
        }
        root.setRight(rightPane);

        // Center
        HBox CenterPane = new HBox();
        if (center.isEmpty() == false) {
            for (int i = 0; i < 4; i++) {
                CenterPane.getChildren().add(center.get(i).getFace());
            }
           
        }
        root.setCenter(CenterPane);

        topPane.setAlignment(Pos.CENTER);
        leftPane.setAlignment(Pos.CENTER);
        bottomPane.setAlignment(Pos.CENTER);
        rightPane.setAlignment(Pos.CENTER);
        CenterPane.setAlignment(Pos.CENTER);

        root.setBackground(null);
        Scene scene = new Scene(root, 1000, 600, Color.GREEN);
        primaryStage.setTitle("Contract Bridge");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void dealCards(Deck deck, ArrayList<Card> p1, ArrayList<Card> p2,
            ArrayList<Card> p3, ArrayList<Card> p4) {
        for (int i = 0; i < 13; i++) {
            p1.add(deck.dealCard());
            p2.add(deck.dealCard());
            p3.add(deck.dealCard());
            p4.add(deck.dealCard());
        }
    }

    public Card playHighest(ArrayList<Card> hand, Card currentCard) {
        Card highestCard = null;
        for (Card card : hand) {
            if (currentCard.getSuit() == card.getSuit()) {
                if (currentCard.compareTo(card) == -1) {
                    if (highestCard == null) {
                        highestCard = card;
                    } else {
                        if (card.compareTo(highestCard) == 1) {
                            highestCard = card;
                        }

                    }
                }
            }

        }
        if (highestCard == null) {
            return hand.get((int) (Math.random() * hand.size()));
        }
        return highestCard;
    }

//    public ArrayList<Card> round(ArrayList<Card> p1, ArrayList<Card> p2, 
//            ArrayList<Card> p3, ArrayList<Card> p4, ArrayList<Card> centre) {
//    for(int i = 0; i < 4; i++){
//    p1.
//    }
//    return 0;
//    }
//    
//    public Card playCard(ArrayList<Card> player) {
//        Card selectedCard = null;
//        
//        for(Card c : player) {
//           c.get
//        }
//    }
    public static void main(String[] args) {
        launch(args);
    }
}