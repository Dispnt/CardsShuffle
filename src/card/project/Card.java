package card.project;

public class Card {
	public String flower;
	public String number;
	public String imgPath;
	public String cardName;
	public boolean ifShuffled = false;
	
	public Card(String flower, String number) {
		super();
		this.number = number;
		this.flower = flower;
	}

	public Card() {
		super();
	}

}


