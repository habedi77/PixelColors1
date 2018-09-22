import java.util.Collection;
import java.util.LinkedList;

import javafx.scene.canvas.GraphicsContext;

public class Pixl
{
    
    final int len;
    final int jump;
    final int width;
    RGBColor[][] colorGrid;
    LinkedList<Source> sources;
    GraphicsContext gc;
    
    Evolve ev;
    
    public Pixl()
    {
        this(30, 16, 5);
    }
    
    public Pixl(int len, int jump, int w)
    {
        System.out.println("len: "+len+" jump: "+jump+" w: "+w);
        width = w;
        this.len = len;
        this.jump = jump;
        colorGrid = new RGBColor[len][len];
        sources = new LinkedList<>();
        for (int row = 0; row < len; row++)
            for (int col = 0; col < len; col++)
                colorGrid[col][row] = new RGBColor(0, 0, 0);
    
        ev = new Evolve();
        
        
    }
    
    public void setGc(GraphicsContext gc)
    {
        this.gc = gc;
    }
    
    /**
     * applies colorGrid to Shape Grid
     */
    public void applyColor()
    {
        //		gc.
        for (int y = 0; y < len; y++)
        {
            for (int x = 0; x < len; x++)
            {
                gc.setFill(colorGrid[x][y].getColor());
                gc.fillRect(x * width, y * width,  width,  width);
                //				shapeGrid[col][row].setFill(colorGrid[col][row].getColor());
            }
        }
    }
    
    public void randomColor(int min,int max)
    {
        //		int a;
        int r, g, b;
        for (int row = 0; row < len; row++)
        {
            for (int col = 0; col < len; col++)
            {
                //				a = ((int) (Math.random() * (255 / jump))) * (jump);
                r = ((int) (Math.random() * (255 / jump))) * (jump);
                g = ((int) (Math.random() * (255 / jump))) * (jump);
                b = ((int) (Math.random() * (255 / jump))) * (jump);
                colorGrid[col][row].setAll(r, g, b);
            }
        }
    }
    
    public void createSources(int n,int offset)
    {
        sources.clear();
        for (int i = 0; i < n; i++)
        {
    
            int x = (int) (Math.random() * (len - 2)) + 1;
            int y = (int) (Math.random() * (len - 2)) + 1;
            int r = ((int) (Math.random() * (255-offset) ))+ offset;
            int g = ((int) (Math.random() * (255-offset) ))+ offset;
            int b = ((int) (Math.random() * (255-offset) ))+ offset;
            sources.add(new Source(x,y,r,g,b) );
            //			System.out.printf("Source %d: %d:%d\n", i, x, y);
        }
    }
    public void createSources(Collection<Source> scs)
    {
        sources.clear();
        sources.addAll(scs);
    }
    public void create(int n,int offset, double amp,double freq, CalculationMode mode)
    {
        createSources(n,offset);
        ev.set(len, len, colorGrid, sources);
        ev.init(n);
        ev.tick(amp,freq,mode);
    }
    private boolean isSource(int x, int y)
    {
        for (Source source : sources)
        {
            if (source.pos.x == x && source.pos.y == y)
            {
                return true;
            }
        }
        return false;
    }
    
}
