package de.buw.se4de;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.google.common.base.Objects;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;


class OnlineTest extends JFrame implements ActionListener
{
	
	//questions 
	Questions myQuestions = new Questions();
	int limitQuestions = myQuestions.getQuestions().size() / 8;
	
	
	
	JLabel l, l_quiz, l_numQuestion,l_headline, l_correctAnswer, l_lives;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	String current_quiz;
	int count=0,current=1,x=1,y=1,now=0,current_correct=0, lives = 3;
	int m[]=new int[10];	
	OnlineTest(String s)
	{
		super(s);
		l=new JLabel();
		l_quiz = new JLabel();
		l_numQuestion = new JLabel();
		l_headline=new JLabel();
		l_correctAnswer = new JLabel();
		l_lives = new JLabel();
		add(l_quiz);
		add(l);
		add(l_numQuestion);
		add(l_headline);
		add(l_correctAnswer);
		add(l_lives);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("End Game");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		
		set();
		l_headline.setText("<html><span style='font-size:14px'>Quiz Challenge</html>");
		l_lives.setText("<html> lives: "+ lives+"</html>");
		l_headline.setBounds(30,30,200,25);
		l_quiz.setBounds(30,60,400,30);
		l_lives.setBounds(400,60,100,30);
		l_numQuestion.setBounds(550,60,100,30);
		l.setBounds(30,70,650,90);
		l_correctAnswer.setBounds(500,320,100,30);
		

		for(int i=0,j=0;i<=120;i+=40,j++) {
			jb[j].setBounds(50,145+i,450,30);
		}
		
		b1.setBounds(30,320,100,30);
		b2.setBounds(200,320,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(800,450);
	}
	public void actionPerformed(ActionEvent e)
	{
		
			
		if(e.getSource()==b1)
		{
			if(check()) {
				count=count+1;
			}else {
				lives=lives-1;
			}
			
			l_lives.setText("<html> lives: "+ lives+"</html>");
				
			current++;
			set();	
			if(current==limitQuestions || lives ==0)
			{
				b1.setEnabled(false);
				b2.setText("End Game");
				l_lives.setText("<html> lives: Game Over </html>");
			}
		}
		
		
		
		if(e.getActionCommand().equals("End Game"))
		{
			if(current==limitQuestions)
				b2.setText("End Game");
			setVisible(false);
			setVisible(true);
		}

		 
		
		
		if(e.getActionCommand().equals("End Game"))
		{
			if(check())
				count=count+1;
			current++;
			JOptionPane.showMessageDialog(this,"correct ans="+count);
			System.exit(0);
		}
	}
	
	void set()
	{
		jb[4].setSelected(true);
		System.out.println(current);
		
		ArrayList question_data  = new ArrayList(myQuestions.getQuestions().get(Integer.toString(current)));

		if(current <= limitQuestions && lives !=0) {		
			
		
			l.setText("<html>"+(String) question_data .get(2) +"</html>");
			jb[0].setText("<html>" +(String) question_data.get(3)+"</html>");jb[1].setText("<html>"+(String) question_data .get(4)+"</html>");jb[2].setText("<html>"+(String) question_data .get(5)+"</html>");jb[3].setText("<html>"+(String) question_data .get(6)+"</html>");
			
			
			switch((String) question_data .get(0)){    
			case "1":    
				current_quiz = "Machine Learning";
			  break;  //optional  
			case "2":    
				current_quiz ="Software Engineering";   
			 break;  //optional  
			
			default:     
				current_quiz = "Artificial Intelligence";  
			}    
			
			l_quiz.setText("<html> Topic: "+ current_quiz+"</html>");
			l_numQuestion.setText("<html>"+"Question :"+current+ "/"+ limitQuestions  +"</html>");
			l_correctAnswer.setText("<html> Correct Answers: "+ count+"</html>");
			
		   
		}
		
		
	}
	boolean check()
	{
		ArrayList question_data  = new ArrayList(myQuestions.getQuestions().get(Integer.toString(current)));
		if(current <= limitQuestions) {
			for(int i=0;i<=3;i++) {
				if(Objects.equal(question_data.get(3+i), question_data.get(7)))
					current_correct = i;
			}
			System.out.println(current_correct);
			return(jb[current_correct].isSelected());}
		return false;
	}
	public static void main(String s[])
	{
		new OnlineTest("Online Test Of Java");
	}


}
