import static org.lwjgl.opengl.GL11.*;

public class Player extends Object{
	private boolean UP = false, DOWN = false, LEFT = false, RIGHT = false;
	
	private int width, height;
	
	public Player(int width, int height){
		super(new Point(Screen.WIDTH / 2 - width / 2, Screen.HEIGHT / 2 - height / 2));
		
		this.width = width;
		this.height = height;
		
		health = 100;
		speed = 5;
	}

	public void render(){
		glColor3f(1.0f, 0.0f, 0.0f);
		glBegin(GL_TRIANGLES);
			glVertex2f(p.getX(), p.getY());
			glVertex2f(p.getX() + width, p.getY());
			glVertex2f(p.getX() + width, p.getY() + height);
			
			glVertex2f(p.getX(), p.getY());
			glVertex2f(p.getX(), p.getY() + height);
			glVertex2f(p.getX() + width, p.getY() + height);
		glEnd();
	}

	public void update(){
		if(Main.state == State.Game){
			if(UP){
				int dy = p.getY() - (int) speed;
				if(dy >= 0)
					p.setY(dy);
				else
					p.setY(0);
			}if(DOWN){
				int dy = p.getY() + (int) speed;
				if(dy + height <= Screen.HEIGHT)
					p.setY(dy);
				else
					p.setY(Screen.HEIGHT - height);
			}if(LEFT){
				int dx = p.getX() - (int) speed;
				if(dx >= 0)
					p.setX(dx);
				else
					p.setX(0);
			}if(RIGHT){
				int dx = p.getX() + (int) speed;
				if(dx + width <= Screen.WIDTH)
					p.setX(dx);
				else
					p.setX(Screen.WIDTH - width);
			}
		}
	}
	
	public void setUp(boolean UP){
		this.UP = UP;
	}
	
	public void setDown(boolean DOWN){
		this.DOWN = DOWN;
	}
	
	public void setLeft(boolean LEFT){
		this.LEFT = LEFT;
	}
	
	public void setRight(boolean RIGHT){
		this.RIGHT = RIGHT;
	}
}