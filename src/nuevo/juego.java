/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nuevo;

import javax.swing.JOptionPane;

/**
 *
 * @author ar466
 */
public class juego {
    private String jugador1;
    private String jugador2;
    private boolean jugador1Activo;
    private boolean jugador2Activo;

    public juego() {
        this.jugador1 = Usuarios.getUsername(1);
        this.jugador1Activo = true;
        this.jugador2 = null;
        this.jugador2Activo = false;
    }

    public void iniciarJuego() {
        // Seleccionar oponente
        String[] oponentesDisponibles = Usuarios.getActiveAccounts();
        if (oponentesDisponibles.length < 1) {
            JOptionPane.showMessageDialog(null, "No hay suficientes jugadores para iniciar el juego.");
            return;
        }

        String jugador2 = seleccionarOponente(oponentesDisponibles);
        if (jugador2 != null) {
            this.jugador2 = jugador2;
            this.jugador2Activo = true;
            JOptionPane.showMessageDialog(null, "Juego iniciado entre " + jugador1 + " y " + jugador2);
        } else {
            JOptionPane.showMessageDialog(null, "No hay oponentes disponibles. No se puede comenzar la partida.");
        }
    }

    private String seleccionarOponente(String[] oponentesDisponibles) {
        return (String) JOptionPane.showInputDialog(
            null,
            "Selecciona un oponente:",
            "Seleccionar Oponente",
            JOptionPane.PLAIN_MESSAGE,
            null,
            oponentesDisponibles,
            oponentesDisponibles[0]
        );
    }

    public void retirar(String jugador) {
        if (jugador.equalsIgnoreCase(jugador1)) {
            confirmarRetiro(jugador1, jugador2);
        } else if (jugador.equalsIgnoreCase(jugador2)) {
            confirmarRetiro(jugador2, jugador1);
        } else {
            JOptionPane.showMessageDialog(null, "Jugador no encontrado.");
        }
    }

    private void confirmarRetiro(String jugadorQueSeRetira, String jugadorContrario) {
        int confirm = JOptionPane.showConfirmDialog(null, jugadorQueSeRetira + ", ¿estás seguro de que quieres retirarte?", "Confirmar Retiro", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (jugadorQueSeRetira.equalsIgnoreCase(jugador1)) {
                jugador1Activo = false;
            } else if (jugadorQueSeRetira.equalsIgnoreCase(jugador2)) {
                jugador2Activo = false;
            }

            JOptionPane.showMessageDialog(null, jugadorQueSeRetira + " se ha retirado. " + jugadorContrario + " gana el juego.");
        }
    }
      public boolean validarParaIniciarJuego() {
        String[] oponentesDisponibles = Usuarios.getActiveAccounts();
        return oponentesDisponibles.length > 0;
    }
}
