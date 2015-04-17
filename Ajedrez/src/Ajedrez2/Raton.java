package Ajedrez2;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Raton implements MouseListener {

    AppletAjedrez applet;
    Casilla pintada = null;
    Boolean auxpintada = false;
    Color color;
    Image imagen;
    Ficha f;
    int auxx;
    int auxy;
    
    
    public Raton(AppletAjedrez aj) {
        this.applet = aj;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = (e.getXOnScreen() - this.applet.margen + 7) / this.applet.t.tamaño;
        int y = (e.getYOnScreen() - this.applet.margen - 50) / this.applet.t.tamaño;
        auxx=x;
        auxy=y;
        try {
            if (applet.t.casillas[x][y].ficha != null & pintada == null) {
                if (applet.t.casillas[x][y].ficha.color == applet.turno) {
                    color = this.applet.t.casillas[x][y].colorCasilla(x, y);
                    this.applet.t.casillas[x][y].setColor(Color.red);
                    pintada = this.applet.t.casillas[x][y];
                    System.out.println("Casilla seleccionada: " + pintada.x + ", " + pintada.y);
                    pintada.ficha.posibilidadFichas();
                }
            } else if (applet.t.casillas[x][y].ficha == null & pintada.ficha.color == applet.turno) {
                System.out.println("Entra en mover ficha al centro");
                applet.t.casillas[x][y].setFicha(new Ficha(applet, pintada.ficha.nombre, pintada.ficha.img, pintada.ficha.color));
                pintada.ficha.posibilidadFichas();
                pintada.ficha = null;
                pintada.setColor(color);
                if (applet.turno == 0) {
                    applet.turno++;
                } else {
                    applet.turno--;
                }
                pintada = null;
            } else if (applet.t.casillas[x][y].ficha.color == applet.turno) {
                pintada.setColor(color);
                color = this.applet.t.casillas[x][y].colorCasilla(x, y);
                this.applet.t.casillas[x][y].setColor(Color.red);
                pintada = this.applet.t.casillas[x][y];
                pintada.ficha.posibilidadFichas();
            } else if (applet.t.casillas[x][y].ficha != null & applet.t.casillas[x][y].ficha.color != applet.turno) {
                if (applet.turno == 0) {
                    applet.comidas_por_blancas.addElement(applet.t.casillas[x][y].ficha.img);
                    System.out.println("Tamaño del vector blancas: " + applet.comidas_por_blancas.size());
                } else {
                    applet.comidas_por_negras.addElement(applet.t.casillas[x][y].ficha.img);
                    System.out.println("Tamaño del vector negras: " + applet.comidas_por_negras.size());
                }
                applet.t.casillas[x][y].setFicha(new Ficha(applet, pintada.ficha.nombre, pintada.ficha.img, pintada.ficha.color));
                pintada.ficha = null;
                pintada.setColor(color);
                pintada = null;
                if (applet.turno == 0) {
                    applet.turno++;
                } else {
                    applet.turno--;
                }
                System.out.println(applet.turno);
            }
        } catch (ArrayIndexOutOfBoundsException a) {
            for (int i = 0; i < applet.imagen_fondo.length; i++) {
                applet.imagen_fondo[i] = applet.getImage(applet.getCodeBase(), applet.imagenes[applet.cont]);
                applet.cont++;
                if (applet.cont == 3) {
                    applet.cont = 0;
                }
            }
        }
        this.applet.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
