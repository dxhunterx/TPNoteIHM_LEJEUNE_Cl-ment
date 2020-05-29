package formes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Forme {

	double x1;
	double y1;
	double x2;
	double y2;
	Color color;
	double width=3;
	
	
	



	public Forme(double x1,double y1,double x2,double y2,Color color) {
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		this.color = color;
	}
	
	public double getWidth() {
		return width;
	}



	public void setWidth(double width) {
		this.width = width;
	}

	
	
	public Color getColor() {
		return color;
	}



	public void setColor(Color color) {
		this.color = color;
	}


	public void translate(double dx, double dy) {
		this.x1+=dx;
		this.y1+=dy;
		this.x2+=dx;
		this.y2+=dy;
	}
	
	public abstract Forme clone();

	public abstract void draw(GraphicsContext gc);
	
	public abstract boolean touche(double x,double y);
		

}
