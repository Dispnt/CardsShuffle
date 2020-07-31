package card.project;

import java.util.HashMap;


public class Data {
	public static HashMap<String, String> numberWeight = new HashMap<String, String>(){{  
	      put("A","P");  put("♠","A");
	      put("2","Q");  put("♦","B");
	      put("3","E");  put("♣","C");
	      put("4","F");  put("♥","D"); //搜过才知道原来花色有大小
	      put("5","G");  
	      put("6","H");  
	      put("7","I");  
	      put("8","J"); 
	      put("9","K");
	      put("10","L");
	      put("J","M");
	      put("Q","N");
	      put("K","O");
	      
	}};

	public static Card allcards[] = new Card[52];
	public static Player[] player = new Player[3];

	
	
	public static void showEveryoneCards() {
		for(int i=0;i<Data.player.length;i++) {
			System.out.println("玩家"+(i+1)+"的牌是:"+player[i].showCards());
		}
	}
	}
	
	
	
	
	
	
	
	

