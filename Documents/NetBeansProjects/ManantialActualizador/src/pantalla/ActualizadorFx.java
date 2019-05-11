/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantalla;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class ActualizadorFx extends Application {
    WebEngine webEngine;
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
		Scene scene = new Scene(root, 650, 480, Color.WHITE);

		BorderPane border = new BorderPane();
		WebView mapWebView = new WebView();
		mapWebView.setMinHeight(100.0);
		mapWebView.setMaxWidth(540);
		webEngine = mapWebView.getEngine();
		
		Button button1 = new Button("Google");
		button1.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				webEngine.load("http://www.google.com");
			}
		});
		
		Button button2 = new Button("Oracle");
		button2.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				webEngine.load("http://www.oracle.com");
				
			}
		});
		
		border.setCenter(mapWebView);
		border.setLeft(button1);
		border.setRight(button2);

		root.getChildren().add(border);

		primaryStage.setScene(scene);
		primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
