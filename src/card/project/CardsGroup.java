package card.project;

public class CardsGroup {
	public static void init() {
		String flower[] = new String[] {"♥","♠","♦","♣"};
		String number[] = new String[] {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		
		for(int i=0;i<Data.allcards.length;i++) {
			Data.allcards[i]=new Card();
		} //清空顺便初始化数组
		
		int currentCard = 0;
		for (int i=0 ;i<flower.length;i++) {
			for (int j=0;j<number.length;j++) {
				String cardNumberandFlower = flower[i]+number[j];
//				System.out.println(cardNumberandFlower);
				Data.allcards[currentCard].flower = flower[i];
				Data.allcards[currentCard].number = number[j];
				Data.allcards[currentCard].imgPath = "./cardimg/"+cardNumberandFlower+".gif";
				Data.allcards[currentCard].cardName = cardNumberandFlower;
		        currentCard++;
		     }
		}  
	}
	
	public static class shuffle implements Runnable {
		private Player currentShufflePlayer;
		private Card[] allcards;
		public shuffle(Player player) {
			this.currentShufflePlayer = player;
			this.allcards = Data.allcards;
		}
		public void run() {
			Card currentShuffleCards[] = new Card[17]; 
			for(int i=0;i<currentShuffleCards.length;i++) {
				currentShuffleCards[i]=new Card();
			} //数组容器内元素实例化
			for (int i = 0; i < currentShuffleCards.length;) {
	            int cardNumber = (int) (Math.random() * 52);	//1)使用java类包中的Math.Random()方法进行随机处理
	            if (!allcards[cardNumber].ifShuffled) {
	            	currentShuffleCards[i] = allcards[cardNumber];
	                allcards[cardNumber].ifShuffled = true;
	                i++;
	            	}
			}
			
			sort(currentShuffleCards);
			currentShufflePlayer.cardsOnHand = currentShuffleCards;
            
		}
	}
	
	public static void sort(Card CardsGroup[]) {
		for(int i=0;i<CardsGroup.length-1;i++)
        {
            for(int j=0;j<CardsGroup.length-1-i;j++)
            {
                
            	if(Data.numberWeight.get(CardsGroup[j].flower).compareTo(Data.numberWeight.get(CardsGroup[j+1].flower))>0)
                {
                    Card temp=CardsGroup[j];
                    CardsGroup[j]=CardsGroup[j+1];
                    CardsGroup[j+1]=temp;
                    
                }
            	if(Data.numberWeight.get(CardsGroup[j].number).compareTo(Data.numberWeight.get(CardsGroup[j+1].number))>0)
                {
                    Card temp=CardsGroup[j];
                    CardsGroup[j]=CardsGroup[j+1];
                    CardsGroup[j+1]=temp;
                }
                
            }
        }	//俩冒泡
		
	}
}
