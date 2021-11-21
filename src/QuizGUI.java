import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/***
 * 
 * @author Michelle Alexander
 */
public class QuizGUI extends JFrame implements ActionListener{

	JLabel label;
	JRadioButton radioButtons[] = new JRadioButton[5];
	JButton buttonNext, buttonResult;
	ButtonGroup buttonGroup;
	int count = 0;
	int current = 0;
	int x =1;
	int y =1;
	int now = 0;
	int[] m = new int[10];
	
	QuizGUI(String s){
		super(s);
		label = new JLabel();
		add(label);
		buttonGroup = new ButtonGroup();
		for(int i=0; i<5; i++) {
			radioButtons[i] = new JRadioButton();
			add(radioButtons[i]);
			buttonGroup.add(radioButtons[i]);
		}
		buttonNext = new JButton("Next");
		buttonResult = new JButton("Result");
		buttonResult.setVisible(false);
		buttonResult.addActionListener(this);
		buttonNext.addActionListener(this);
		add(buttonNext);
		add(buttonResult);
		setData();
		label.setBounds(30,40,450,20);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButtons[0].setBounds(50, 80, 450, 20);
		radioButtons[1].setBounds(50, 110, 200, 20);
		radioButtons[2].setBounds(50, 140, 200, 20);
		radioButtons[3].setBounds(50, 170, 200, 20);
		buttonNext.setBounds(100, 240, 100, 30);
		buttonResult.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
		
	}
	
	public void setData() {
		radioButtons[4].setSelected(true);
		if(current==0) {
			label.setText("Q1: Cxu mi povas _______ kukon por tagmangxo");
			radioButtons[0].setText("mangxas");
			radioButtons[1].setText("mangxi");
			radioButtons[2].setText("mangxo");
			radioButtons[3].setText("mangxis");
		}
		if(current==1) {
			label.setText("Q2: Kiel oni diras 'It is raining in the city'?");
			radioButtons[0].setText("Pluvos en la urbo");
			radioButtons[1].setText("Negxas en la urbo");
			radioButtons[2].setText("Negxas en la urba");
			radioButtons[3].setText("Pluvas en la urbo");
		}
		if(current==2) {
			label.setText("Q3: jhjhjhjhjhjhjhjh");
			radioButtons[0].setText("mangxas");
			radioButtons[1].setText("mangxi");
			radioButtons[2].setText("mangxo");
			radioButtons[3].setText("mangxis");
		}
		if(current==3) {
			label.setText("Q4: kszjgnfbksjgfnbkjsf  akdgjbnksjgnb kajdnfvkjandfb jdjdjd jdaisa");
			radioButtons[0].setText("mangxas");
			radioButtons[1].setText("mangxi");
			radioButtons[2].setText("mangxo");
			radioButtons[3].setText("mangxis");
		}
		label.setBounds(30,40,450,20);
		for(int i=0,j=0; i<=90; i+=30,j++) {
			radioButtons[j].setBounds(50,80+i,200,20);
		}
	}
	
	public boolean checkAnswer() {
		if(current==0) {
			return radioButtons[1].isSelected();
		}
		if(current==1) {
			return radioButtons[3].isSelected();
		}
		if(current==2) {
			return radioButtons[3].isSelected();
		}
		if(current==3) {
			return radioButtons[2].isSelected();
		}
		return false;
	}
	
	public static void main(String[] args) {
		new QuizGUI("Quiz");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buttonNext) {
			if(checkAnswer()) {
				count++;
			}
			current++;
			setData();
			if(current==4) {
				buttonNext.setEnabled(false);
				buttonResult.setVisible(true);
				buttonResult.setText("Result");
			}
		}
		
		if(e.getActionCommand().equals("Result")) {
			if(checkAnswer()) {
				count++;
			}
			current++;
			JOptionPane.showMessageDialog(this, "Correct Answers: " + count);
			System.exit(0);
		}
	}
	
	

}
