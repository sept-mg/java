public class Coordonnee {
    private int x , y ;
    public Coordonnee(int x, int y) {
        if(x < 0 || y < 0)
            throw new IllegalArgumentException("x or y inf 0");
        
        this.x = x ;
        this.y = y ;
    }

    public Coordonnee() {
        this(0,0);
    }

    public double distance(Coordonnee b) {
        return Math.sqrt(Math.pow(b.x - x, 2) + Math.pow(b.y - y, 2));
    }

    public String toString() {
        return "(" + x + " , " + y + ")";
    }

    public boolean equals(Coordonnee c) {
        return c.x == x && c.y == y;
    }
}
