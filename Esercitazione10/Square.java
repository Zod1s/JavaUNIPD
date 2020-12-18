import java.awt.Rectangle;
public class Square extends Rectangle{
    public Square(int x, int y, int side){
        super(x - (side / 2), y - (side / 2), side, side);
    }

    public int getArea(){
        int s = (int)getWidth();
        return s * s;
    }

    public void setSize(int w, int h){
        if (w != h) throw new IllegalArgumentException();
        else super.setSize(w, w);
    }

    public void setSize(int w){
        super.setSize(w, w);
    }

    public String toString(){
        return super.toString();
    }
}
