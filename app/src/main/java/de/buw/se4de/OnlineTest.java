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
	
	
	
	JLabel l, l_quiz;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	String current_quiz;
	int count=0,current=1,x=1,y=1,now=0,current_correct=0;
	int m[]=new int[10];	
	OnlineTest(String s)
	{
		super(s);
		l=new JLabel();
		l_quiz = new JLabel();
		add(l_quiz);
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Result");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,10,650,90);
		l_quiz.setBounds(450,40,450,20);
		
		for(int i=0,j=0;i<=120;i+=40,j++) {
			jb[j].setBounds(50,120+i,450,30);
		}
		
		b1.setBounds(100,340,100,30);
		b2.setBounds(270,340,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(700,450);
	}
	public void actionPerformed(ActionEvent e)
	{
		
			
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==limitQuestions)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		
		
		
		if(e.getActionCommand().equals("Result"))
		{
			//JButton bk=new JButton("Bookmark"+x);
			//bk.setBounds(480,20+30*x,100,30);
			//add(bk);
			//bk.addActionListener(this);
			//m[x]=current;
			//x++;
			//current++;
			//set();	
			if(current==limitQuestions)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		/*
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		} */
		 
		
		
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			//System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this,"correct ans="+count);
			System.exit(0);
		}
	}
	
	void set()
	{
		jb[4].setSelected(true);
		System.out.println(current);
		
		ArrayList question_data  = new ArrayList(myQuestions.getQuestions().get(Integer.toString(current)));

		if(current <= limitQuestions) {		
			
		
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
			
			l_quiz.setText(current_quiz);  
		
		}
		
		//l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=120;i+=40,j++) {
			jb[j].setBounds(50,90+i,450,30);
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
