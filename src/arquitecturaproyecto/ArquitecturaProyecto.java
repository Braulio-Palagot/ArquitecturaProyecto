package arquitecturaproyecto;

import static java.awt.Frame.MAXIMIZED_BOTH;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ArquitecturaProyecto {
    
    public static void main(String[] args) {
        final loginRegistro frmLogin = new loginRegistro();
        frmLogin.setExtendedState(MAXIMIZED_BOTH);
        frmLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        frmLogin.setVisible(true);
    }
    
}
