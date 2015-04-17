package AjedrezHectorPiqueras;

import java.awt.Image;

public class Ficha {

    AppletAjedrez applet;
    String nombre;
    int color;
    Image img;
    Casilla p, s;
    int x, y;

    public Ficha(AppletAjedrez applet, String nombre, Image img, int color) {
        this.applet = applet;
        this.nombre = nombre;
        this.img = img;
        this.color = color;
    }

    public void moverFichas(Casilla p, Casilla s) {
        this.p = p;
        this.s = s;
        s.ficha = p.ficha;
        applet.repaint();
    }
}
