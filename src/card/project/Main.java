package card.project;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class Main extends JFrame {
	private JPanel p;
	private JLabel lbPlayerOne,lbPlayerTwo,lbPlayerThree;
	private JButton btnShuffle,btnShowCards;
	
	JLabel[][] lbCardPlayer =new JLabel[3][17];
	public Main() {
		super("打牌伐？");
		
		Data.player[0] = new Player("小红",350,50);
		Data.player[1] = new Player("小王",780,50);
		Data.player[2] = new Player("小江",550,300);	//三个玩家


		CardsGroup.init();	//牌初始化
		
		
		CardsGroup.shuffle ShufflePlayer1CardFirstTime = new CardsGroup.shuffle(Data.player[0]);
		CardsGroup.shuffle ShufflePlayer2CardFirstTime = new CardsGroup.shuffle(Data.player[1]);
		CardsGroup.shuffle ShufflePlayer3CardFirstTime = new CardsGroup.shuffle(Data.player[2]);
		new Thread(ShufflePlayer1CardFirstTime,"1").start();
		new Thread(ShufflePlayer2CardFirstTime,"2").start();
		new Thread(ShufflePlayer3CardFirstTime,"3").start();
		
		
		p = new JPanel();
		btnShuffle = new JButton("洗牌");
		btnShowCards = new JButton("对称");
		lbPlayerOne = new JLabel("玩家1牌");
		lbPlayerTwo = new JLabel("玩家2牌");
		lbPlayerThree = new JLabel("玩家3牌");

		
	    p.setLayout(null);
	    btnShuffle.setBounds(500, 200, 60, 25);
	    btnShowCards.setBounds(250, 200, 60, 25);
	    lbPlayerOne.setBounds(30, 150, 700, 25);
	    lbPlayerTwo.setBounds(525, 150, 700, 25);
	    lbPlayerThree.setBounds(250, 400, 700, 25);
	    
		

	    for(int i=0;i<=2;i++) {
			int CardPointX = Data.player[i].CardPointX;
			for (int j = 0; j <= 16; j++) {
				lbCardPlayer[i][j] = new JLabel(new ImageIcon("./images/"+ Data.player[i].cardsOnHand[j].cardName +".gif"));
				lbCardPlayer[i][j].setBounds(CardPointX, Data.player[i].CardPointY, 71, 96);
				CardPointX = CardPointX -20;
				p.add(lbCardPlayer[i][j]);
			}
		}
		
	    
		this.setSize(900,500);
		this.add(p);
		p.add(btnShuffle);
		p.add(btnShowCards);
		p.add(lbPlayerOne);
		p.add(lbPlayerTwo);
		p.add(lbPlayerThree);
		
		
		Data.showEveryoneCards();
		lbPlayerOne.setText(Data.player[0].showCards());
		lbPlayerTwo.setText(Data.player[1].showCards());
		lbPlayerThree.setText(Data.player[2].showCards());

		
		btnShuffle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				CardsGroup.init();
				
				
				CardsGroup.shuffle ShufflePlayer1Card = new CardsGroup.shuffle(Data.player[0]);
				CardsGroup.shuffle ShufflePlayer2Card = new CardsGroup.shuffle(Data.player[1]);
				CardsGroup.shuffle ShufflePlayer3Card = new CardsGroup.shuffle(Data.player[2]);
				new Thread(ShufflePlayer1Card,"1").start();
				new Thread(ShufflePlayer2Card,"2").start();
				new Thread(ShufflePlayer3Card,"3").start();
				
				for(int i=0;i<=2;i++) {
					for (int j = 0; j <= 16; j++) {
						p.remove(lbCardPlayer[i][j]);
					}
				}
				
				for(int i=0;i<=2;i++) {
					int CardPointX = Data.player[i].CardPointX;
					for (int j = 0; j <= 16; j++) {
						lbCardPlayer[i][j] = new JLabel(new ImageIcon("./images/"+ Data.player[i].cardsOnHand[j].cardName +".gif"));
						lbCardPlayer[i][j].setBounds(CardPointX, Data.player[i].CardPointY, 71, 96);
						CardPointX = CardPointX -20;
						p.add(lbCardPlayer[i][j]);
					}
				}
				
				for(int i=0;i<50;i++) {System.out.println(" ");}//这也算是清屏了...
				Data.showEveryoneCards();
				lbPlayerOne.setText(Data.player[0].showCards());
				lbPlayerTwo.setText(Data.player[1].showCards());
				lbPlayerThree.setText(Data.player[2].showCards());
				
				p.setVisible(false);
				p.setVisible(true);
			}
		});
		
		btnShowCards.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "一左一右好看点\nf18011433虞佳健");
			}
		});
		
		
	}
	
	
	public static void main(String args[]) {
		
		
		Main guiFrame = new Main();
		guiFrame.setLocationRelativeTo(null);
		guiFrame.setVisible(true);
		
	}

}
