import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Main{
	public static State state;
	
	public static Player player;
	
	public static void main(String args[]){
		createWindow();
		
		init();
		
		while(!Display.isCloseRequested()){
			render();
			
			update();
		}
		
		destroy();
	}
	
	public static void render(){
		glClear(GL_COLOR_BUFFER_BIT);
		
		player.render();
	}
	
	public static void update(){
		player.update();
		
		Input.update();
		
		Display.update();
		
		Display.sync(60);
	}
	
	public static void createWindow(){
		try{
			Display.setDisplayMode(new DisplayMode(Screen.WIDTH, Screen.HEIGHT));
			Display.setTitle(Screen.TITLE);
			Display.create();
		}catch(LWJGLException e){
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
	}
	
	public static void init(){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Screen.WIDTH, Screen.HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		state = State.Game;
		
		player = new Player(50, 50);
	}
	
	public static void destroy(){
		Display.destroy();
		System.exit(0);
	}
}