import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	OnlineTest(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
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
		}
	
		if(e.getActionCommand().equals("Result"))
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
		if(current==0)
		{
			l.setText("Question 1:  Which of the following is linear data structure");
			jb[0].setText("trees");jb[1].setText("graphs");jb[2].setText("arrays");jb[3].setText("none of these");	
		}
		if(current==1)
		{
			l.setText("Question 2: Which of the following is non-linear data structure");
			jb[0].setText("arrays");jb[1].setText("linked list");jb[2].setText("stacks");jb[3].setText("none of these");
		}
		if(current==2)
		{
			l.setText("Question 3: Which package is directly available to our class without importing it");
			jb[0].setText("swing");jb[1].setText("applet");jb[2].setText("net");jb[3].setText("lang");
		}
		if(current==3)
		{
			l.setText("Question 4: String class is defined in which package");
			jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");
		}
		if(current==4)
		{
			l.setText("Question 5: Queue is based on which principle");
			jb[0].setText("FIFO");jb[1].setText("LIFO");jb[2].setText("POP");jb[3].setText("NONE");
		}
		if(current==5)
		{
			l.setText("Question 6: Which notation is used to find the complexity of an algorithm");
			jb[0].setText("Asymptotic notation");jb[1].setText("Big oh notation");jb[2].setText("omega notation");jb[3].setText("none of these");
		}
		if(current==6)
		{
			l.setText("Question 7: Which one among these is not a class ");
			jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");jb[3].setText("Button");
		}
		if(current==7)
		{
			l.setText("Question 8: which one among these is not a function of Object class");
			jb[0].setText("toString");jb[1].setText("finalize");jb[2].setText("equals");jb[3].setText("getDocumentBase");		
		}
		if(current==8)
		{
			l.setText("Question 9: Data Structure that allows fast search within an ordered sequence of elements is called");
			jb[0].setText("skiplist");jb[1].setText("list");jb[2].setText("array");jb[3].setText("none of above");
		}
		if(current==9)
		{
			l.setText("Question 10: Data Structure that allows fast search within an ordered sequence of elements is called");
			jb[0].setText("primitive");jb[1].setText("non primitive");jb[2].setText("identifier");jb[3].setText("none");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[2].isSelected());
		if(current==1)
			return(jb[3].isSelected());
		if(current==2)
			return(jb[3].isSelected());
		if(current==3)
			return(jb[0].isSelected());
		if(current==4)
			return(jb[0].isSelected());
		if(current==5)
			return(jb[0].isSelected());
		if(current==6)
			return(jb[1].isSelected());
		if(current==7)
			return(jb[3].isSelected());
		if(current==8)
			return(jb[0].isSelected());
		if(current==9)
			return(jb[1].isSelected());
		return false;
	}
	public static void main(String s[])
	{
		new OnlineTest("Online Test");
	}


}
