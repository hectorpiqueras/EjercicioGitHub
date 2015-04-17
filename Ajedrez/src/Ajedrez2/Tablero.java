package Ajedrez2;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Vector;

public class Tablero {

    private final int N = 8;
    Casilla casillas[][];
    AppletAjedrez applet;
    private final int margen;
    int tamaño;

    Tablero(AppletAjedrez applet) {
        this.applet = applet;
        casillas = new Casilla[N][N];
        margen = applet.margen;
        tamaño = (menor(applet.getWidth(), applet.getHeight()) - margen * 2) / N;
        crear_casillas();
    }

    void crear_casillas() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                casillas[i][j] = new Casilla(i, j);
            }
        }
    }

    int menor(int x, int y) {
        if (x < y) {
            return x;
        } else {
            return y;
        }
    }
    
    void pintar_imagen_fondo(Graphics g, Image imagenes_fondo[]){
        for(int i=0; i<imagenes_fondo.length;i++){
            g.drawImage(imagenes_fondo[i], 0, 0, applet.getWidth(), applet.getHeight(), applet);
        }
    }

    void pintar_tablero(Graphics g) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                g.setColor(casillas[i][j].c);
                g.fillRect(margen + i * tamaño, margen + j * tamaño, tamaño, tamaño);
            }
        }
    }

    void pintar_fichas(Graphics g) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (casillas[i][j].getficha() != null) {
                    g.drawImage(this.casillas[i][j].ficha.img, margen + this.casillas[i][j].x * tamaño, margen + this.casillas[i][j].y * tamaño, tamaño, tamaño, applet);
                }
            }
        }
    }

    void pintar_fichas_comidas_por_negras(Graphics g, Vector comidas_por_negras) {
        for (int i = 0; i < comidas_por_negras.size(); i++) {
            g.drawImage((Image) comidas_por_negras.elementAt(i), (margen + tamaño * N) + (i * tamaño - (i * 30)), margen, tamaño - 30, tamaño - 20, applet);
        }
    }

    void pintar_fichas_comidas_por_blancas(Graphics g, Vector comidas_por_blancas) {
        for (int i = 0; i < comidas_por_blancas.size(); i++) {
            g.drawImage((Image) comidas_por_blancas.elementAt(i),(margen + tamaño * N) + (i * tamaño - (i * 30)) , (margen + tamaño * 8) - tamaño, tamaño - 30, tamaño - 20, applet);
        }
    }
}
