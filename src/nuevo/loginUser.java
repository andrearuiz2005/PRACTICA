/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nuevo;

import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author ar466
 */

public class loginUser {
    private String usuario;
    private String password;
    private int puntos;
    private String fechaIngreso;
    private boolean activo;
    private static String[] usuarios = new String[100];
    private static String[] contraseñas = new String[100];
    private static int[] puntosArr = new int[100];
    private static String[] fechasIngreso = new String[100];
    private static boolean[] activos = new boolean[100];
    private static int count = 0;

    public loginUser() {
    }

    public loginUser(String user, String password) {
        this.usuario = user;
        this.password = password;
        this.puntos = 0;
        this.fechaIngreso = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        this.activo = true;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public boolean isActivo() {
        return activo;
    }

    public boolean ingreso(String usuario, String password) {
    boolean userFound = false;
    for (int i = 0; i < count; i++) {
        if (usuarios[i].equalsIgnoreCase(usuario)) {
            userFound = true;
            if (contraseñas[i].equals(password)) {
                String message = "Bienvenido " + usuario;
                System.out.println(message);
                JOptionPane.showMessageDialog(null, message);
                return true; 
            } else {
                String message = "Contraseña incorrecta";
                System.out.println(message);
                JOptionPane.showMessageDialog(null, message);
                return false;
            }
        }
    }
    if (!userFound) {
        String message = "Nombre de usuario o contraseña no válidos";
        System.out.println(message);
        JOptionPane.showMessageDialog(null, message);
        return false;
    }
    return false; 
}
    public boolean crearUsuario(String usuario, String password) {
        if (usuario.length() == 0 || password.length() != 5) {
            JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña no válidos. La contraseña debe tener exactamente 5 caracteres numericos.");
            return false;
        }

        for (int i = 0; i < count; i++) {
            if (usuarios[i].equalsIgnoreCase(usuario)) {
                JOptionPane.showMessageDialog(null, "El usuario ya existe, favor elegir otro Nombre de Usuario");
                return false;
            }
        }

        if (count < usuarios.length) {
            usuarios[count] = usuario;
            contraseñas[count] = password;
            puntosArr[count] = 0;
            fechasIngreso[count] = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            activos[count] = true;
            count++;
            JOptionPane.showMessageDialog(null, "Usuario Registrado");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden registrar más usuarios.");
            return false;
        }
    }
    public String[] obtenerOponentesDisponibles() {
        int countOponentes = 0;
        for (int i = 0; i < count; i++) {
            if (!usuarios[i].equalsIgnoreCase(usuario) && activos[i]) {
                countOponentes++;
            }
        }

        String[] oponentesDisponibles = new String[countOponentes];
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (!usuarios[i].equalsIgnoreCase(usuario) && activos[i]) {
                oponentesDisponibles[index++] = usuarios[i];
            }
        }
        return oponentesDisponibles;
    }

    public String obtenerUsuarioLogueado() {
        return usuario;
    }
}