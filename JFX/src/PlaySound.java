import javafx.application.Application;

import javafx.stage.Stage;

import javafx.scene.Scene;

import javafx.scene.layout.StackPane;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;

import javafx.scene.media.Media;

import javafx.scene.media.MediaPlayer;

public class PlaySound extends Application {

	Button btn;

	MediaPlayer mediaPlayer;

	@Override
	public void start(Stage primaryStage) {

		Media hit = new Media(
				
				"http://hydra-media.cursecdn.com/dota2.gamepedia.com/1/17/Snip_ability_shrapnel_03.mp3");
		// Media hit = mew
		// Media("http://hydra-media.cursecdn.com/dota2.gamepedia.com/c/c5/Snip_ability_assass_04.mp3");
		// If you have a media file on your own machine you can load it with:

		// Media hit = new Media(new File("audio/name.mp3").toURI().toString());

		mediaPlayer = new MediaPlayer(hit);

		mediaPlayer.play();

		btn = new Button("Pause");

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				if (btn.getText().equals("Pause")) {

					mediaPlayer.pause();

					btn.setText("Play");

				} else {

					mediaPlayer.play();

					btn.setText("Pause");

				}

			}

		});

		StackPane root = new StackPane();

		root.getChildren().add(btn);

		Scene scene = new Scene(root, 300, 250);

		primaryStage.setScene(scene);

		primaryStage.show();

	}

	public static void main(String[] args) {

		launch(args);
	}

}