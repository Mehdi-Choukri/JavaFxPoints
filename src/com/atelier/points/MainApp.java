package com.atelier.points;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MainApp extends Application {
	private static int cpt =0;
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hello JavaFX");
		//all FONTS 
		Font fontBtn = Font.font("Comic Sans MS", FontWeight.BOLD, 20);
		Font fontLabelCpt = Font.font("Calibri", FontWeight.BOLD, 30);
		
		// l'argument passer ici signifie l'espace reservé entre un element et un autre
		VBox root = new VBox(10);
		//le padding entre l'ensemble des elements de la scene;
		root.setPadding(new Insets(25));
		root.setAlignment(Pos.CENTER);
		ImageView likeImage = new ImageView(getClass().getResource("heart.png").toString());
		ImageView dislikeImage = new ImageView(getClass().getResource("dislike.png").toString());
		//en survolant 
		ImageView likeImageHover = new ImageView(getClass().getResource("heart_hover.png").toString());
		ImageView dislikeImageHover = new ImageView(getClass().getResource("dislike_hover.png").toString());
		
		Label Label = new Label("-Compteur-");
		Label.setFont(fontLabelCpt);
		Label.setStyle("-fx-text-fill: #0B4E54");
		String res="Résultat : ";
		Label statusLabel = new Label(res+cpt);
		statusLabel.setStyle("-fx-text-fill: #0B4E54");
		Button btnLike = new Button ("J'ai gagner un point");
		
		btnLike.setFont(fontBtn);
		btnLike.setGraphic(likeImage);
		btnLike.setStyle("-fx-background-color: #C0D6E4");
		btnLike.setContentDisplay(ContentDisplay.TOP);

		Button btnDislike = new Button ("J'ai perdu un point");
		
		btnDislike.setFont(fontBtn);
		
		btnDislike.setStyle("-fx-background-color: #E66A6A");
		//btnDislike.setStyle("-fx-text-fill: white");
		
		int bntDislikeX = (int) btnLike.getLayoutX();
		btnDislike.setLayoutX(bntDislikeX+250);
		Group group = new Group();
	

		group.getChildren().add(btnLike);
		group.getChildren().add(btnDislike);
		
		btnDislike.setGraphic(dislikeImage);
		btnDislike.setContentDisplay(ContentDisplay.TOP);
		
		btnLike.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
			 
				btnLike.setGraphic(likeImageHover);
			}
			
		});
		btnLike.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
			 
				btnLike.setGraphic(likeImage);
			}
			
		});
		
		
		//btn dislike hover
		btnDislike.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
			 
				btnDislike.setGraphic(dislikeImageHover);
			}
			
		});
		btnDislike.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
			 
				btnDislike.setGraphic(dislikeImage);
			}
			
		});
		
		btnLike.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				cpt++;
				statusLabel.setText(res+cpt);
				
			}
			
		});
		btnDislike.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				if(cpt>0)
				{
					cpt--;
					statusLabel.setText(res+cpt);
				}
				
			}
			
		});
		
		
		//le calcul de la position du bouton dislike pour qu'il soit juste acoté du button like dans le meme niveau
	 
		
		
		
		root.getChildren().addAll(Label,statusLabel,group);
		 
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	

}
