package AjedrezHectorPiqueras;

import java.awt.Color;

public class Casilla {

    Color c;
    int x, y;
    Ficha ficha;
    String color;

    Casilla(int x, int y) {
        this.x = x;
        this.y = y;
        if ((x + y) % 2 == 0) {
            c = new Color(255, 255, 255);
        } else {
            c = new Color(0, 0, 0);
        }
    } 

    public void setColor(Color c) {
        this.c = c;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Ficha getficha() {
        return this.ficha;
    }
    
    public Color colorCasilla(int x, int y){
        if ((x + y) % 2 == 0) {
            return Color.white;
        } else {
            return Color.black;
        }
    }
    
}
