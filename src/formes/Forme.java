package formes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 * 
 * @author LEJEUNE Clement
 *
 */
public abstract class Forme {

	double x1;
	double y1;
	double x2;
	double y2;
	Color colorBordure;
	Color colorFill; 
	double width=3;
	
	
	



	public Forme(double x1,double y1,double x2,double y2,Color colorBordure,Color colorFill) {
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		this.colorBordure = colorBordure;
		this.colorFill=colorFill;
	}
	
	public double getWidth() {
		return width;
	}



	public void setWidth(double width) {
		this.width = width;
	}

	
	
	public Color getColorFill() {
		return colorFill;
	}

	public void setColorFill(Color colorFill) {
		this.colorFill = colorFill;
	}

	public Color getColorBordure() {
		return colorBordure;
	}



	public void setColorBordure(Color colorBordure) {
		this.colorBordure = colorBordure;
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
