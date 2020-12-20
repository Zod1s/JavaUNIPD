import java.util.Random;
public class Player{
    String name;
    int[] diceThrows;
    int score;

    public Player(String name){
        this.name = name;
        diceThrows = new int[3];
        score = 0;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public void turn(){
        Random random = new Random(10 * System.currentTimeMillis());
        for (int i = 0; i < 3; i++){
            diceThrows[i] = 1 + random.nextInt(6);
        }
    }

    public int[] sortDice(){
        int a = diceThrows[0];
        int b = diceThrows[1];
        int c = diceThrows[2];
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        int med = -1;
        if (max == a) med = Math.max(b, c);
        else if (max == b) med = Math.max(a, c);
        else if (max == c) med = Math.max(a, b);
        int[] sorted = {min, med, max};
        return sorted;
    }

    public void addPoint(){
        score++;
    }

    public void resetScore(){
        score = 0;
    }

    public String toString(){
        return name + " " + diceThrows[0] + " " + diceThrows[1] + " " + diceThrows[2];
    }
}
