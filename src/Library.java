import java.awt.*;
import java.util.Collection;
import java.lang.Math;

import static java.lang.Math.*;

public class Library
{
    
    static public double OneOnEuclidean(Point source, Point dst, double freq)
    {
        double x = - dst.x + source.x;
        double y = - dst.y + source.y;
        return 1/(hypot(x,y)+1);
    }
    static public double OneOnTaxicab (Point source, Point dst, double freq)
    {
        double x = - dst.x + source.x;
        double y = - dst.y + source.y;
        return 1/(abs(x)+abs(y)+1);
    }
    static public double CosinByTaxicab(Point source, Point dst, double freq)
    {
        double x = - dst.x + source.x;
        double y = - dst.y + source.y;
        return cos((abs(x)+abs(y))/freq);
    }
    static public double CosinByEuclidean(Point source, Point dst, double freq)
    {
        double x = - dst.x + source.x;
        double y = - dst.y + source.y;
        return cos(hypot(x,y)/freq);
    }
    static public double HalfCosinEuclidean(Point source, Point dst, double freq)
    {
        double x = - dst.x + source.x;
        double y = - dst.y + source.y;
        return max(cos(hypot(x,y)/freq),0);
    }
    static public double CosinEuclideanHalfPulse(Point source, Point dst, double freq)
    {
        double x = - dst.x + source.x;
        double y = - dst.y + source.y;
        double t = hypot(x,y)/freq;
        return  t<PI/2 ? cos(t) : 0;
    }
    static public double Exp_Euclidean(Point source, Point dst, double freq)
    {
        double x = - dst.x + source.x;
        double y = - dst.y + source.y;
        return exp(-hypot(x,y)/freq);
    }
    static public double Exp_Taxicab(Point source, Point dst, double freq)
    {
        double x = - dst.x + source.x;
        double y = - dst.y + source.y;
        return exp(-(abs(x)+abs(y))/freq);
    }
    static public double Test03(Point source, Point dst, double freq)
    {
        double x = - dst.x + source.x;
        double y = - dst.y + source.y;
        return exp(-(abs(x)+abs(y))*freq);
    }
}
