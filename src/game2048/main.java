package game2048;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map m = new Map(4, 4);
		m.printMap();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		boolean gameContinue = true;
		while (!input.equals("q") && gameContinue) {			
			try {
				System.out.print("\nEnter something: ");
				input = br.readLine();
				
				int dir = GameConst.DIRECTION_NONE;
				if (input.equals("l"))
					dir = GameConst.DIRECTION_LEFT;
				else if (input.equals("r"))
					dir = GameConst.DIRECTION_RIGHT;
				else if (input.equals("u"))
					dir = GameConst.DIRECTION_UP;
				else if (input.equals("d"))
					dir = GameConst.DIRECTION_DOWN;
				
				if (dir != GameConst.DIRECTION_NONE) {
					m.updateMap(dir);
					
					gameContinue = m.update();
					
					m.printMap();
				}
					
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		
		System.out.println("END GAME");
	}
	
	

}
