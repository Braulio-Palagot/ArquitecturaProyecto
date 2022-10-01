package arquitecturaproyecto;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class ArquitecturaProyecto {
    public static void main(String[] args) {
        final principal frmPrincipal = new principal();
        frmPrincipal.setExtendedState(MAXIMIZED_BOTH);
        
        frmPrincipal.setVisible(true);   
    }
}
