package com;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class Main extends Application {
	private double zoomFactor;
	private double width;
	private double height;
    @Override
    public void start(Stage stage) throws Exception{
    	zoomFactor= 1.0;
    	
    	MenuBar menuBar = new MenuBar();
    	
    	//https://devstory.net/11125/javafx-menu
    	//https://devstory.net/11115/javafx-contextmenu
    	
    	Menu fileMenu = new Menu("Fichier");
    	
    	MenuItem newItem = new MenuItem("Nouveau");
    	MenuItem openItem = new MenuItem("Ouvrir");
    	MenuItem mergeItem = new MenuItem("Fusionner");
    	MenuItem saveItem = new MenuItem("Sauvegarder");
    	MenuItem saveInItem = new MenuItem("Sauvegarder sous");
    	MenuItem quitItem = new MenuItem("Quitter");
    	
    	fileMenu.getItems().addAll(newItem,new SeparatorMenuItem(),openItem,mergeItem,saveItem,saveInItem,quitItem);
    	
    	Menu objectMenu = new Menu("Objet");
    	Menu mapMenu = new Menu("Carte");
    	
    	menuBar.getMenus().addAll(fileMenu,objectMenu,mapMenu);
    	
    	BorderPane root = new BorderPane();
    	root.setTop(menuBar);
    	MainPanel mainPanel = new MainPanel();
    	/*
    	ScrollPane pane = new ScrollPane();
        //creating the image object
        Image image = new Image("file:image.png");
        //Creating the image view
        width = image.getWidth();
        height = image.getHeight();
        ImageView imageView = new ImageView();
        
        //Setting image to the image view
        imageView.setImage(image);
        //Setting the image view parameters
        pane.setContent(imageView);
        imageView.setPreserveRatio(true);
        
       
    	
    	
        //Adding the toggle button to the pane
        EventHandler<ZoomEvent> zoomFinished = new EventHandler<ZoomEvent>() { 
            @Override 
            public void handle(ZoomEvent e) { 
            	zoomFactor*=e.getTotalZoomFactor();
            	System.out.println(e.getTotalZoomFactor()+"  "+zoomFactor); 
            	imageView.setFitWidth(zoomFactor*width);
            	imageView.setFitHeight(zoomFactor*height);
            } 
         };  
         EventHandler<ZoomEvent> zooming = new EventHandler<ZoomEvent>() { 
             @Override 
             public void handle(ZoomEvent e) { 
             	imageView.setFitWidth(zoomFactor*width*e.getTotalZoomFactor());
             	imageView.setFitHeight(zoomFactor*height*e.getTotalZoomFactor());
             	
             } 
          };  
        imageView.setOnZoomFinished(zoomFinished);
        imageView.setOnZoom(zooming);
        
         */
    	ScrollPane scrollPane = new ScrollPane();
    	scrollPane.setContent(mainPanel);
        root.setCenter(scrollPane);
        Scene scene = new Scene(root, 595, 200, Color.BEIGE);
        
        
        stage.setTitle("Scroll Bar Example");
        stage.setScene(scene);
        
        
        
        
        
        
        stage.show();
    	
    	
    	
    }


    public static void main(String[] args) {
        launch(args);
    }
}