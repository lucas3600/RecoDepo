package com;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle; 
public class MainPanel extends Group{
	private Image map;
	private ArrayList<CircleMemory> circles;
	private double imageWidth;
	private double imageHeight;
	private double zoomFactor;
	
	
	public MainPanel() {
		super();
		zoomFactor = 1.0;
		circles = new ArrayList<CircleMemory>();
		
		//ScrollPane pane = new ScrollPane();
	    //creating the image object
	    Image image = new Image("file:image.png");
	    //Creating the image view
	    imageWidth = image.getWidth();
	    imageHeight = image.getHeight();
	    ImageView imageView = new ImageView();
	    
	    //Setting image to the image view
	    imageView.setImage(image);
	    //Setting the image view parameters
	    //pane.setContent(imageView);
	    imageView.setPreserveRatio(true);
	    
	    //this.getChildren().add(pane);
	    this.getChildren().add(imageView);
	    //Adding the toggle button to the pane
        EventHandler<ZoomEvent> zoomFinished = new EventHandler<ZoomEvent>() { 
            @Override 
            public void handle(ZoomEvent e) { 
            	zoomFactor*=e.getTotalZoomFactor();
            	//System.out.println(e.getTotalZoomFactor()+"  "+zoomFactor); 
            	imageView.setFitWidth(zoomFactor*imageWidth);
            	imageView.setFitHeight(zoomFactor*imageHeight);
            	fitCircles(zoomFactor);
            } 
         };  
         EventHandler<ZoomEvent> zooming = new EventHandler<ZoomEvent>() { 
             @Override 
             public void handle(ZoomEvent e) { 
             	imageView.setFitWidth(zoomFactor*imageWidth*e.getTotalZoomFactor());
             	imageView.setFitHeight(zoomFactor*imageHeight*e.getTotalZoomFactor());
             	fitCircles(zoomFactor*e.getTotalZoomFactor());
             } 
          };  
        imageView.setOnZoomFinished(zoomFinished);
        imageView.setOnZoom(zooming);
        
        EventHandler<MouseEvent> mouseClicked = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				addCircle(e.getX()/zoomFactor,e.getY()/zoomFactor);
				fitCircles(zoomFactor);
			}
        	
        };
        this.setOnMouseClicked(mouseClicked);
	}
	public void fitCircles(double factor) {
		for(CircleMemory c : circles) {
			c.setRadius(c.getIniRadius()*factor);
			c.setCenterX(factor*c.getIniX());
			c.setCenterY(factor*c.getIniY());
		}
	}
	public void addCircle(double x,double y) {
		CircleMemory circle = new CircleMemory(x,y,50);
		circle.setFill(Color.DARKSLATEBLUE); 
	    circle.setStroke(Color.BLACK);
	    circles.add(circle);
	    this.getChildren().add(circle);
	}

}
