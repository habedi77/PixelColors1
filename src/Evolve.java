import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedList;

import static java.lang.Math.hypot;

public class Evolve
{
    RGBColor[][] grid;
    LinkedList<Source> sources;
    int Xs,Ys;
    private int dx,dy;
    
    /**
     * works in [x][y] mode
     * @param xs no of pixels in X axis
     * @param ys no of pixels in Y axis
     * @param refGrid
     * @param refSc
     */
    public void set(int xs, int ys, RGBColor[][] refGrid, Collection <Source> refSc)
    {
        grid = refGrid;
        Xs=xs;
        Ys=ys;
        sources = new LinkedList<>();
        sources.addAll(refSc);
    }
    protected boolean isSource(int x, int y)
    {
        for (Source source : sources)
            if (source.pos.x == x && source.pos.y == y)
                return true;
        return false;
    }
    public void init(int n)
    {
        for(int x=0;x<Xs;x++)
            for (int y  = 0; y < Ys; y++)
                grid[x][y].setAll(0,0,0);
    }
    
    /**
     * reevaluates grid
     */
    public void tick(double amp,double freq,CalculationMode mode)
    {
        double p;
        int r,g,b;
        
        for(int x=0;x<Xs;x++)
        {
            for (int y = 0; y < Ys; y++)
            {
                r = g = b = 0;
                for (Source src:sources)
                {
                    p = getPower(src.pos, new Point(x, y),amp,freq,mode);
                    r += src.rgb.r * p;
                    g += src.rgb.g * p;
                    b += src.rgb.b * p;
                    //                    System.out.println(p);
                }
                grid[x][y].setAll(r,g,b);
            }
        }
    }
    
    /**
     * gives intensity of a source from dst ( 1.0 - 0.0 )
     * @param source
     * @return
     */
    public double getPower(Point source, Point dst, double amp,double freq,CalculationMode mode)
    {
        try
        {
            double res = (double) Library.class.getMethod(mode.getName(),
                                                          Point.class,Point.class,
                                                          double.class).invoke(null,source, dst,freq);
            return res*amp;
        }
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    
    

    
    
}
