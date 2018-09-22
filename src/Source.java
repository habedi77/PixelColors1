import java.awt.*;

public class Source
{
    public Point pos;
    RGBColor rgb;
    public Source(Point p,RGBColor col)
    {
        pos = p;
        rgb = col;
    }
    public Source(int x,int y,int r,int g,int b)
    {
        pos = new Point(x,y);
        rgb= new RGBColor(r,g,b);
    }
}
