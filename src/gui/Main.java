package gui;

import com.nilo.plaf.nimrod.NimRODLookAndFeel;
import com.nilo.plaf.nimrod.NimRODTheme;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Main del juego.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class Main {

    public static void main(String[] args) {
        //Configuración gráfica de los componentes.
        NimRODTheme nt = new NimRODTheme();
        nt.setPrimary1(new Color(0xC21500));
        nt.setPrimary2(new Color(0xC21500));
        nt.setPrimary3(new Color(0xC21500));
        nt.setSecondary1(new Color(0x520000));
        nt.setSecondary2(new Color(0x5C0000));
        nt.setSecondary3(new Color(0x560703));
        nt.setWhite(new Color(0x750000));
        nt.setBlack(new Color(0xFFE0E0));
        NimRODLookAndFeel tema = new NimRODLookAndFeel();
        NimRODLookAndFeel.setCurrentTheme(nt);
        try {
            UIManager.setLookAndFeel(tema);
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Look and feel no soportado.");
        }
        PantallaPrincipal principal = new PantallaPrincipal();        
        principal.setVisible(true);
    }
}
