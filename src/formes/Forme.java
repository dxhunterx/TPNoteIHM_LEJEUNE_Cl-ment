package formes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 * forme abstraite, classe meres des autre forme
 * @author LEJEUNE Clement
 *
 */
public abstract class Forme {

	//coordonne de la souris quand on clique
	double x1;
	double y1;
	//coordonne de la souris quand on relache
	double x2;
	double y2;
	//couleur de la bordure
	Color colorBordure;
	//couleur du remplissage
	Color colorFill; 
	//taille de l'epaisseur de la bordure
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

	//deplace la forme
	public void translate(double dx, double dy) {
		this.x1+=dx;
		this.y1+=dy;
		this.x2+=dx;
		this.y2+=dy;
	}
	//renvoie un clone de notre forme
	public abstract Forme clone();

	//draw notre forme
	public abstract void draw(GraphicsContext gc);
	
	//renvoie true si les coordonne passe en parametre son dans la zone de detection de la forme
	public abstract boolean touche(double x,double y);
		

}
