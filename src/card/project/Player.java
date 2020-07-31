package card.project;

public class Player {
	public Card cardsOnHand[];
	public String name;
	public int CardPointX;
	public int CardPointY;
	
	public Player(String name, int cardPointX, int cardPointY) {
		super();
		this.name = name;
		CardPointX = cardPointX;
		CardPointY = cardPointY;
	}



	public String showCards() {

		String cardtoShow = "";
		for(int i=cardsOnHand.length-1;i>=0;i--) {
			cardtoShow = cardtoShow + cardsOnHand[i].cardName + "\0";
		}
		return cardtoShow;
	}
}
