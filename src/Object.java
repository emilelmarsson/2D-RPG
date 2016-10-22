
public abstract class Object{
	Point p;
	double speed;
	
	int health;
	
	public Object(Point p){
		this.p = new Point(p);
	}
	
	abstract void render();
	
	abstract void update();
}
