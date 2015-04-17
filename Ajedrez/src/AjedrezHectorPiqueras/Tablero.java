package AjedrezHectorPiqueras;

import java.awt.Graphics;
import java.awt.Image;

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

    void pintar_imagen_fondo(Graphics g) {
        for (int i = 0; i < applet.imagen_fondo.length; i++) {
            g.drawImage(applet.imagen_fondo[i], 0, 0, applet.getWidth(), applet.getHeight(), applet);
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

    void pintar_fichas_comidas_por_negras(Graphics g) {
        int contNegras = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (applet.comidas_por_negras.size() > contNegras) {
                    g.drawImage((Image) applet.comidas_por_negras.elementAt(contNegras), (margen + tamaño * N) + (j * tamaño), margen + i * tamaño, tamaño - 30, tamaño - 20, applet);
                    contNegras++;
                }
            }
        }
    }

    void pintar_fichas_comidas_por_blancas(Graphics g) {
        int contBlancas = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (applet.comidas_por_blancas.size() > contBlancas) {
                    g.drawImage((Image) applet.comidas_por_blancas.elementAt(contBlancas), (margen+tamaño*N) + (j*tamaño), tamaño*N-i*tamaño, tamaño - 30, tamaño - 20, applet);
                    contBlancas++;
                }
            }
        }
    }

    void pintar_turno(Graphics g) {
        g.setFont(applet.fuente);
        if (applet.turno == 0) {
            g.drawString("Turno: Blancas", margen, margen / 2);
        } else {
            g.drawString("Turno: Negras", margen, margen / 2);
        }
    }
}
