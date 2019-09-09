import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
public class Minion
{
	private int x;
	private int y;
	private int size;
	private int dire;
	private Polygon area;
	private ArrayList<Polygon> polyList;
	private int currentDirection;
	ArrayList<Integer> moveList;
	int count=0;

	public Minion(int xv, int yv, int sv, Polygon av, ArrayList<Polygon> pl)
	{
		x=xv;
		y=yv;
		size=sv;
		area=av;
		polyList=pl;
		dire=(int)(Math.random()*2);
	}

	public void move()
	{
		currentDirection=dire;
		boolean moveRight=true, moveLeft=true, moveDown=true, moveUp=true;
		for(Polygon p:polyList)
		{
			if(!area.contains(new Rectangle(x+2,y,20,20)) || p.intersects(new Rectangle(x+2,y,20,20)))
				moveRight=false;
			if(!area.contains(new Rectangle(x-2,y,20,20)) || p.intersects(new Rectangle(x-2,y,20,20)))
				moveLeft=false;
			if(!area.contains(new Rectangle(x,y-2,20,20)) || p.intersects(new Rectangle(x,y-2,20,20)))
				moveUp=false;
			if(!area.contains(new Rectangle(x,y+2,20,20)) || p.intersects(new Rectangle(x,y+2,20,20)))
				moveDown=false;
		}

		moveList=new ArrayList<Integer>();

		if(moveRight)
			moveList.add(0);
		if(moveLeft)
			moveList.add(1);
		if(moveUp)
			moveList.add(2);
		if(moveDown)
			moveList.add(3);

		if(Math.random()*100<95)
		{
			if(currentDirection<moveList.size() && moveList.get(currentDirection)==0)
			{
				if((y<=235 && y>=200) && (x>=700 && x<=730))
					x=115;
				x+=2;
			}
			if(currentDirection<moveList.size() && moveList.get(currentDirection)==1)
			{
				if((y<=235 && y>=200) && (x>=115 && (x<=140)))
					x=710;
				x-=2;
			}
			if(currentDirection<moveList.size() && moveList.get(currentDirection)==2)
				y-=2;
			if(currentDirection<moveList.size() && moveList.get(currentDirection)==3)
				y+=2;

		}
		else
		{
			dire=(int)(Math.random() * moveList.size());
			if(moveList.get(dire)==0)
			{
				if((y<=235 && y>=200) && (x>=700 && x<=730))
					x=115;
				x+=2;
			}
			if(moveList.get(dire)==1)
			{
				if((y<=235 && y>=200) && (x>=115 && (x<=140)))
					x=710;
				x-=2;
			}
			if(moveList.get(dire)==2)
				y-=2;
			if(moveList.get(dire)==3)
				y+=2;
		}
	}
	public void setY(int a)
	{
		y+=a;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public int getSize()
	{
		return size;
	}
	public Polygon getArea()
	{
		return area;
	}
}