import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
public class Dots
{
	private int x;
	private int y;

	public Dots(int xv, int yv)
	{
		x=xv;
		y=yv;
	}

	public void add(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;

		g2d.setColor(Color.ORANGE);
		g2d.fillOval(x,y,10,10);
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
}