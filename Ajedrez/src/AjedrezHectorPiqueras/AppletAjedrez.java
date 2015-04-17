package AjedrezHectorPiqueras;

import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Vector;

public class AppletAjedrez extends Applet {

    Tablero t;
    int margen = 40;
    private Image imagenDB;
    private Graphics gDB;
    
    String imagenes[] = new String[3];
    Image imagen_fondo[] = new Image[1];
    Image img[] = new Image[12];
    int turno=0;
    Raton raton = new Raton(this);
    Font fuente = new Font("Monospaced", Font.BOLD, 12);
    int cont=1;
    Vector comidas_por_negras = new Vector();
    Vector comidas_por_blancas = new Vector();
    
    @Override
    public void init() {
        System.out.println("*****Siempre comienza la partida las fichas blancas.******");
        System.out.println("*****Si se quiere cambiar el fondo, pulsar fuera del tablero.******");
        
        imagenes[0] = "imagenesAjedrez/fondo2.jpg";
        imagenes[1] = "imagenesAjedrez/fondo3.jpg";
        imagenes[2] = "imagenesAjedrez/fondo4.jpg";
        imagen_fondo[0] = getImage(getCodeBase(), imagenes[0]);
        
        t = new Tablero(this);
        img[0] = getImage(getCodeBase(), "imagenesAjedrez/torre_negro.png");
        img[1] = getImage(getCodeBase(), "imagenesAjedrez/torre_blanco.png");
        img[2] = getImage(getCodeBase(), "imagenesAjedrez/caballo_negro.png");
        img[3] = getImage(getCodeBase(), "imagenesAjedrez/caballo_blanco.png");
        img[4] = getImage(getCodeBase(), "imagenesAjedrez/alfil_negro.png");
        img[5] = getImage(getCodeBase(), "imagenesAjedrez/alfil_blanco.png");
        img[6] = getImage(getCodeBase(), "imagenesAjedrez/rey_negro.png");
        img[7] = getImage(getCodeBase(), "imagenesAjedrez/rey_blanco.png");
        img[8] = getImage(getCodeBase(), "imagenesAjedrez/reina_negro.png");
        img[9] = getImage(getCodeBase(), "imagenesAjedrez/reina_blanco.png");
        img[10] = getImage(getCodeBase(), "imagenesAjedrez/peon_negro.png");
        img[11] = getImage(getCodeBase(), "imagenesAjedrez/peon_blanco.png");

        t.casillas[0][0].setFicha(new Ficha(this, "torre", img[0], 1));
        t.casillas[1][0].setFicha(new Ficha(this, "caballo", img[2], 1));
        t.casillas[2][0].setFicha(new Ficha(this, "alfil", img[4], 1));
        t.casillas[3][0].setFicha(new Ficha(this, "rey", img[6], 1));
        t.casillas[4][0].setFicha(new Ficha(this, "reina", img[8], 1));
        t.casillas[5][0].setFicha(new Ficha(this, "alfil", img[4], 1));
        t.casillas[6][0].setFicha(new Ficha(this, "caballo", img[2],1));
        t.casillas[7][0].setFicha(new Ficha(this, "torre", img[0], 1));
        t.casillas[0][1].setFicha(new Ficha(this, "peon", img[10], 1));
        t.casillas[1][1].setFicha(new Ficha(this, "peon", img[10], 1));
        t.casillas[2][1].setFicha(new Ficha(this, "peon", img[10], 1));
        t.casillas[3][1].setFicha(new Ficha(this, "peon", img[10], 1));
        t.casillas[4][1].setFicha(new Ficha(this, "peon", img[10], 1));
        t.casillas[5][1].setFicha(new Ficha(this, "peon", img[10], 1));
        t.casillas[6][1].setFicha(new Ficha(this, "peon", img[10], 1));
        t.casillas[7][1].setFicha(new Ficha(this, "peon", img[10], 1));
        t.casillas[0][6].setFicha(new Ficha(this, "peon", img[11], 0));
        t.casillas[1][6].setFicha(new Ficha(this, "peon", img[11], 0));
        t.casillas[2][6].setFicha(new Ficha(this, "peon", img[11], 0));
        t.casillas[3][6].setFicha(new Ficha(this, "peon", img[11], 0));
        t.casillas[4][6].setFicha(new Ficha(this, "peon", img[11], 0));
        t.casillas[5][6].setFicha(new Ficha(this, "peon", img[11], 0));
        t.casillas[6][6].setFicha(new Ficha(this, "peon", img[11], 0));
        t.casillas[7][6].setFicha(new Ficha(this, "peon", img[11], 0));
        t.casillas[0][7].setFicha(new Ficha(this, "torre", img[1], 0));
        t.casillas[1][7].setFicha(new Ficha(this, "caballo", img[3], 0));
        t.casillas[2][7].setFicha(new Ficha(this, "alfil", img[5], 0));
        t.casillas[3][7].setFicha(new Ficha(this, "rey", img[7], 0));
        t.casillas[4][7].setFicha(new Ficha(this, "reina", img[9], 0));
        t.casillas[5][7].setFicha(new Ficha(this, "alfil", img[5], 0));
        t.casillas[6][7].setFicha(new Ficha(this, "caballo", img[3], 0));
        t.casillas[7][7].setFicha(new Ficha(this, "torre", img[1], 0));
        this.addMouseListener(raton);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {
        System.out.println("*****El juego se ha acabado.*****");
    }

    @Override
    public void paint(Graphics g) {
        t.pintar_imagen_fondo(g);
        t.pintar_tablero(g);
        t.pintar_fichas(g);
        t.pintar_turno(g);
        t.pintar_fichas_comidas_por_blancas(g);
        t.pintar_fichas_comidas_por_negras(g);
    }

    @Override
    public void update(Graphics g) {
        if (imagenDB == null) {
            imagenDB = createImage(getWidth(), getHeight());
            gDB = imagenDB.getGraphics();
        }
        gDB.setColor(getBackground());
        gDB.fillRect(0, 0, getWidth(), getHeight());
        gDB.setColor(getForeground());
        paint(gDB);
        g.drawImage(imagenDB, 0, 0, this);
    }
}
