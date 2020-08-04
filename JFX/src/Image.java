import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;

public class Image extends Application {
	@Override
	public void start(Stage primaryStage) {
		// Create a pane to hold the image views
		Pane pane = new HBox(10);
		pane.setPadding(new Insets(5, 5, 5, 5));
		// Image image= new Image("/Tide_ult.jpg");
		//BufferedImage image = null;
		//image = ImageIO.read(new File("Tide_ult.jpg"));
		//pane.getChildren().add(new ImageView( new Image ("Tide_ult.jpg")));
		ImageView imageView2= new ImageView();
		imageView2.setFitHeight(100);
		imageView2.setFitWidth(100);
		imageView2.setRotate(90);
		pane.getChildren().add(imageView2);
		Scene scene = new Scene(pane);
		primaryStage.setTitle("ShowImage");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
