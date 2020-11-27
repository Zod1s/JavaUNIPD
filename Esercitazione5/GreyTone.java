import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/* Usare costruttore e metodi della classe SimpleImage
   (fate riferimento alla classe per la descrizione):

public SimpleImage(String filename)
public int height() 
public int width() 
public Color get(int i, int j) 
public void set(int i, int j, Color c)

*/

public class GreyTone{
    public static void main(String args[]) throws IOException{
        if (args.length != 2){
            System.out.println("Usage: java DecodeImage inputFileName outputFileName");
            System.exit(0);     
        }
        
        //Creo oggetto SimpleImage con l'immagine di input
        // ricordarsi che le immagini sono griglie di pixel
        // l'asse x e' la larghezza
        // l'asse y l'altezza
        // (0,0) e' l'angolo in alto a sinistra
        SimpleImage image = new SimpleImage(args[0]);
        //per ogni pixel in posizione x,y
        
        for (int x = 0; x < image.width(); x++){
            for (int y = 0; y < image.height(); y++){
                // Acquisisco il colore del pixel e lo salvo
                // in una var. riferimento a un oggetto Color           
                Color color = image.get(x,y);
            
                //Acquisisco i singoli colori e li salvo in varibili int
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                int c = (r + g + b) / 3;
                //Modifico i colori
                //Creo un nuovo colore con questi valori RGB
                Color newColor = new Color(c,c,c);
                //Metto il nuovo colore nell'immagine in pos (x,y)
                image.set(x,y,newColor);
            }
        }
        //Saving the modified image
        image.save(args[1]);
        System.out.println("Done...");
    }
}
