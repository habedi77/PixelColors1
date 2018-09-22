import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

class RGBColor
{
    
    public RGBColor(int r, int g, int b)
    {
        this.setAll(r, g, b);
    }
    
    public void setAll(int r, int g, int b)
    {
        this.r = Math.max(Math.min(r, 255), 0);
        this.g = Math.max(Math.min(g, 255), 0);
        this.b = Math.max(Math.min(b, 255), 0);
    }
    public void validate()
    {
        if(r > 255) r=255;
        else if( r<0) r=0;
        
        if(g > 255) g=255;
        else if( g<0) g =0;
        
        if(b  > 255) b =255;
        else if( b <0) b=0;
    }
    public Paint getColor()
    {
        return Color.rgb(r, g, b);
    }
    int r;
    int g;
    int b;
}
