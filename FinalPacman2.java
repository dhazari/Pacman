import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class FinalPacman2 extends JPanel implements KeyListener,Runnable
{
	private float angle;
	private int x;
	private int y;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int x3;
	private int y3;
	private int x4;
	private int y4;
	private int x5;
	private int points=0;
	private JFrame frame;
	private Thread t;
	private boolean gameOn;
	private Polygon poly;
	private Polygon poly1;
	private Polygon poly2;
	private Polygon poly3;
	private Polygon poly4;
	private Polygon poly5;
	private Polygon poly6;
	private Polygon poly7;
	private Polygon poly8;
	private Polygon poly9;
	private Font extra;
	private int deaths;
	private ArrayList<Polygon> polyList=new ArrayList<Polygon>();
	private Color color;
	private boolean right=false;
	private boolean left=false;
	private boolean up=false;
	private boolean down=false;
	private ArrayList<Minion> minionList;
	private ArrayList<Dots> DotsList;
	private ArrayList<Dots> DotList;

	public FinalPacman2()
	{
		frame=new JFrame();
		x=420;
		y=310;
		x1=180;
		y1=308;
		x2=315;
		y2=308;
		x3=565;
		y3=308;
		x4=680;
		y4=308;
		deaths=3;
		gameOn=true;
		setArea();
		frame.addKeyListener(this);
		extra=new Font("STSong",Font.BOLD,60);
		frame.add(this);
		frame.setSize(800,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		t=new Thread(this);
		t.start();
	}

	public void setArea()
	{
		poly= new Polygon();
		poly.addPoint(115,330);
		poly.addPoint(115,260);
		poly.addPoint(155,260);
		poly.addPoint(155,235);
		poly.addPoint(115,235);
		poly.addPoint(115,200);
		poly.addPoint(155,200);
		poly.addPoint(155,175);
		poly.addPoint(115,175);
		poly.addPoint(115,105);
		poly.addPoint(730,105);
		poly.addPoint(730,175);
		poly.addPoint(690,175);
		poly.addPoint(690,200);
		poly.addPoint(730,200);
		poly.addPoint(730,235);
		poly.addPoint(690,235);
		poly.addPoint(690,260);
		poly.addPoint(730,260);
		poly.addPoint(730,330);

		poly1= new Polygon();
		poly1.addPoint(110,335);
		poly1.addPoint(110,255);
		poly1.addPoint(150,255);
		poly1.addPoint(150,240);
		poly1.addPoint(110,240);
		poly1.addPoint(110,195);
		poly1.addPoint(150,195);
		poly1.addPoint(150,180);
		poly1.addPoint(110,180);
		poly1.addPoint(110,100);
		poly1.addPoint(735,100);
		poly1.addPoint(735,180);
		poly1.addPoint(695,180);
		poly1.addPoint(695,195);
		poly1.addPoint(735,195);
		poly1.addPoint(735,240);
		poly1.addPoint(695,240);
		poly1.addPoint(695,255);
		poly1.addPoint(735,255);
		poly1.addPoint(735,335);

		poly2= new Polygon();
		poly2.addPoint(140,305);
		poly2.addPoint(140,285);
		poly2.addPoint(155,285);
		poly2.addPoint(155,305);

		poly3= new Polygon();
		poly3.addPoint(705,130);
		poly3.addPoint(690,130);
		poly3.addPoint(690,150);
		poly3.addPoint(705,150);

		poly4= new Polygon();
		poly4.addPoint(140,150);
		poly4.addPoint(140,130);
		poly4.addPoint(155,130);
		poly4.addPoint(155,150);

		poly5= new Polygon();
		poly5.addPoint(705,285);
		poly5.addPoint(690,285);
		poly5.addPoint(690,305);
		poly5.addPoint(705,305);

		poly6= new Polygon();
		poly6.addPoint(665,305);
		poly6.addPoint(565,305);
		poly6.addPoint(565,130);
		poly6.addPoint(665,130);

		poly7= new Polygon();
		poly7.addPoint(440,305);
		poly7.addPoint(540,305);
		poly7.addPoint(540,130);
		poly7.addPoint(440,130);

		poly8= new Polygon();
		poly8.addPoint(415,305);
		poly8.addPoint(315,305);
		poly8.addPoint(315,130);
		poly8.addPoint(415,130);

		poly9= new Polygon();
		poly9.addPoint(180,305);
		poly9.addPoint(290,305);
		poly9.addPoint(290,130);
		poly9.addPoint(180,130);

		polyList.add(poly2);
		polyList.add(poly3);
		polyList.add(poly4);
		polyList.add(poly5);
		polyList.add(poly6);
		polyList.add(poly7);
		polyList.add(poly8);
		polyList.add(poly9);

		DotsList=new ArrayList<Dots>();
		x5 = 130;
		for(int i=700; i<316; i+=10)
			DotsList.add(new Dots(x5,i));
		DotList=DotsList;

		minionList=new ArrayList<Minion>();
		minionList.add(new Minion(x1,y1,20,poly,polyList));
		minionList.add(new Minion(x2,y2,20,poly,polyList));
		minionList.add(new Minion(x3,y3,20,poly,polyList));
		minionList.add(new Minion(x4,y4,20,poly,polyList));
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		//Dots.add(g);

		g2d.setColor(Color.BLACK);
		g2d.fillRect(0,0,800,500);

		if(gameOn)
		{
			g2d.setColor(Color.BLACK);
			g2d.fill(poly);
			g2d.setColor(new Color(24,24,255));
			g2d.setStroke(new BasicStroke(2));
			g2d.draw(poly1);
			g2d.draw(poly);
			for(Polygon p:polyList)
				g2d.draw(p);

			g2d.setColor(Color.WHITE);
			g2d.fillOval(x,y,20,20);
			g2d.setColor(Color.YELLOW);
			g2d.fillOval(x,y,20,20);
			g2d.setColor(Color.CYAN);
			g2d.drawRect(x,y,20,20);

			for(int i=0; i<deaths; i++)
			{
				g2d.setColor(Color.YELLOW);
				if (i==0)
				{
					g2d.fillOval(35,430,20,20);
				}
				if (i==1)
				{
					g2d.fillOval(65,430,20,20);
				}
				if (i==2)
				{
					g2d.fillOval(95,430,20,20);
				}
			}

			for(int a=0; a<minionList.size(); a++)
			{
				if(a==0)
				{
					g2d.setColor(Color.RED);
					g2d.fillRect(minionList.get(a).getX(),minionList.get(a).getY(),20,20);
				}
				if(a==1)
				{
					g2d.setColor(new Color(51,255,255));
					g2d.fillRect(minionList.get(a).getX(),minionList.get(a).getY(),20,20);
				}
				if(a==2)
				{
					g2d.setColor(new Color(255,153,204));
					g2d.fillRect(minionList.get(a).getX(),minionList.get(a).getY(),20,20);
				}
				if(a==3)
				{
					g2d.setColor(new Color(255,204,51));
					g2d.fillRect(minionList.get(a).getX(),minionList.get(a).getY(),20,20);
				}
			}
		}
		else
		{
			g2d.setColor(Color.WHITE);
			g2d.setFont(extra);
			g2d.drawString("Game Over",300,250);
		}
	}
	public void run()
	{
		while(true)
		{
			if(gameOn)
			{
				boolean moveOk=true;
				for(Polygon p:polyList)
				{
					if(right)
					{
						if(!poly.contains(new Rectangle(x+2,y,20,20)) || p.intersects(new Rectangle(x+2,y,20,20)))
							moveOk=false;
					}
					if(left)
					{
						if(!poly.contains(new Rectangle(x-2,y,20,20)) || p.intersects(new Rectangle(x-2,y,20,20)))
							moveOk=false;
					}
					if(up)
					{
						if(!poly.contains(new Rectangle(x,y-2,20,20)) || p.intersects(new Rectangle(x,y-2,20,20)))
							moveOk=false;
					}
					if(down)
					{
						if(!poly.contains(new Rectangle(x,y+2,20,20)) || p.intersects(new Rectangle(x,y+2,20,20)))
							moveOk=false;
					}
				}

				if(moveOk)
				{
					if(right)
					{
						if((y<=235 && y>=200) && (x>=700 && x<=730))
							x=115;
						x+=1;
					}
					if(left)
					{
						if((y<=235 && y>=200) && (x>=115 && (x<=140)))
							x=710;
						x-=1;
					}
					if(up)
						y-=1;
					if(down)
						y+=1;
				}

				/*Ellipse2D.Double circle=new Ellipse2D.Double(x,y,20,20);
				for(int i=0; i<DotList.size(); i++)
				{
					if(circle.intersects(new Rectangle(Dotlist.get(i).getX(),Dotlist.get(i).getY(),10,10)))
					{
						DotList.remove(i);
						points++;
					}
				}*/

				for(Minion b:minionList)
				{
					b.move();
					Ellipse2D.Double circle=new Ellipse2D.Double(x,y,20,20);
					if(circle.intersects(new Rectangle(b.getX(),b.getY(),b.getSize(),b.getSize())))
					{
						x=420;
						y=310;
						deaths--;
						if(deaths==0 || DotList.size()==0)
						{
							gameOn=false;
						}
						minionList=new ArrayList<Minion>();
						minionList.add(new Minion(x1,y1,20,poly,polyList));
						minionList.add(new Minion(x2,y2,20,poly,polyList));
						minionList.add(new Minion(x3,y3,20,poly,polyList));
						minionList.add(new Minion(x4,y4,20,poly,polyList));
					}
				}
			}
			try
			{
				t.sleep(10);
			}
			catch(InterruptedException e)
			{

			}
			repaint();
		}
	}

	public void keyPressed(KeyEvent ke)
	{

		if(ke.getKeyCode()==39)
		{
			right=true;
			up=false;
			down=false;
			left=false;
		}

		else if(ke.getKeyCode()==37)
		{
			right=false;
			up=false;
			down=false;
			left=true;
		}
		else if(ke.getKeyCode()==38)
		{
			right=false;
			up=true;
			down=false;
			left=false;
		}

		else if(ke.getKeyCode()==40)
		{
			right=false;
			up=false;
			down=true;
			left=false;
		}
		else if(ke.getKeyCode()==32)
				gameOn=true;
	}

	public void keyReleased(KeyEvent ke)
	{

	}

	public void keyTyped(KeyEvent ke)
	{
	}

	public static void main(String args[])
	{
		FinalPacman2 app=new FinalPacman2();
	}
}