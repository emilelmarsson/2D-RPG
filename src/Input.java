import org.lwjgl.input.Keyboard;

public class Input{
	public static void update(){
		while(Keyboard.next()){
			if(Main.state == State.Game){
				if(Keyboard.getEventKey() == Keyboard.KEY_UP)
					Main.player.setUp(Keyboard.getEventKeyState());
				if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT)
					Main.player.setRight(Keyboard.getEventKeyState());
				if(Keyboard.getEventKey() == Keyboard.KEY_DOWN)
					Main.player.setDown(Keyboard.getEventKeyState());
				if(Keyboard.getEventKey() == Keyboard.KEY_LEFT)
					Main.player.setLeft(Keyboard.getEventKeyState());
			}
		}
	}
}