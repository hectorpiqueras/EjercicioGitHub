package Ajedrez2;

import java.awt.Color;
import java.awt.Image;

public class Ficha {

    AppletAjedrez applet;
    String nombre;
    int color;
    Image img;
    Casilla p, s;
    int x, y;
    Color c1, c2, colorcasilla;
    Casilla pintadac1 = null;
    Casilla pintadac2 = null;

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

    public void posibilidadFichas() {
        switch (nombre) {
            case "peon":
                fichaPeon();
                break;
            case "torre":
                fichaTorre();
                break;
            case "caballo":
                fichaCaballo();
                break;
            case "alfil":
                fichaAlfil();
                break;
            case "rey":
                fichaRey();
                break;
            case "reina":
                fichaReina();
                break;
        }
    }

    public void fichaPeon() {
        System.out.println("Estoy dentro de las posibilidades del peón.");
        if (applet.turno == 0) {
            if (applet.t.casillas[applet.raton.auxx][applet.raton.auxy].y == 6 & pintadac1 == null & pintadac2 == null) {
                //Fila peones blancos
                System.out.println("Este es el if de la fila 6 para los peones blancos.");
                c1 = this.applet.t.casillas[applet.raton.auxx][applet.raton.auxy].colorCasilla(applet.raton.auxx, applet.raton.auxy + 1);
                System.out.println("Color de la casilla siguiente a la seleccionada: " + c1);
                pintadac1 = this.applet.t.casillas[applet.raton.auxx][applet.raton.auxy - 1];
                System.out.println("" + pintadac1.x + ", " + pintadac1.y);
                c2 = this.applet.t.casillas[applet.raton.auxx][applet.raton.auxy].colorCasilla(applet.raton.auxx, applet.raton.auxy + 2);
                System.out.println("Color de la casilla siguiente siguiente a la seleccionada: " + c2);
                pintadac2 = this.applet.t.casillas[applet.raton.auxx][applet.raton.auxy - 2];
                System.out.println("" + pintadac2.x + ", " + pintadac2.y);
                for (int i = 0; i < 2; i++) {
                    applet.raton.auxy--;
                    applet.t.casillas[applet.raton.auxx][applet.raton.auxy].setColor(Color.GREEN);
                }
            } else if (pintadac1 != null & pintadac2 != null) {
                System.out.println("Cambia el color a las casillas a donde puede mover el peon.");
                pintadac1.setColor(c1);
                pintadac2.setColor(c2);
                pintadac1 = null;
                pintadac2 = null;
            }
        } else if (applet.turno == 1) {
            if (applet.t.casillas[applet.raton.auxx][applet.raton.auxy].y == 1 & pintadac1 == null & pintadac2 == null) {
                //Fila peones negros
                c1 = this.applet.t.casillas[applet.raton.auxx][applet.raton.auxy].colorCasilla(applet.raton.auxx, applet.raton.auxy + 1);
                System.out.println("Color de la casilla siguiente a la seleccionada: " + c1);
                pintadac1 = this.applet.t.casillas[applet.raton.auxx][applet.raton.auxy + 1];
                System.out.println("" + pintadac1.x + ", " + pintadac1.y);
                c2 = this.applet.t.casillas[applet.raton.auxx][applet.raton.auxy].colorCasilla(applet.raton.auxx, applet.raton.auxy + 2);
                System.out.println("Color de la casilla siguiente siguiente a la seleccionada: " + c2);
                pintadac2 = this.applet.t.casillas[applet.raton.auxx][applet.raton.auxy + 2];
                System.out.println("" + pintadac2.x + ", " + pintadac2.y);
                for (int i = 0; i < 2; i++) {
                    applet.raton.auxy++;
                    applet.t.casillas[applet.raton.auxx][applet.raton.auxy].setColor(Color.GREEN);
                }
            } else if (pintadac1 != null & pintadac2 != null) {
                System.out.println("Cambia el color a las casillas a donde puede mover el peon.");
                pintadac1.setColor(c1);
                pintadac2.setColor(c2);
                pintadac1 = null;
                pintadac2 = null;
            }
        }
    }

    public void fichaTorre() {
        System.out.println("Estoy dentro de las posibilidades de la torre.");
    }

    public void fichaCaballo() {
        System.out.println("Estoy dentro de las posibilidades del caballo.");
    }

    public void fichaAlfil() {
        System.out.println("Estoy dentro de las posibilidades del alfil.");
    }

    public void fichaRey() {
        System.out.println("Estoy dentro de las posibilidades del rey.");
    }

    public void fichaReina() {
        System.out.println("Estoy dentro de las posibilidades de la reina.");
    }
}
