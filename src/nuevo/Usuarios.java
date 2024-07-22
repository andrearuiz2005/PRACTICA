package nuevo;

import javax.swing.JOptionPane;
import java.time.LocalDateTime;

public class Usuarios {
    private static String[] Passwords = new String[100];    
    private static String[] Usernames = new String[100];
    private static boolean[] Actives = new boolean[100];
    private static LocalDateTime[] Dates = new LocalDateTime[100];
    private static String[] Historial = new String[100];
    private static int[] Points = new int[100];
    private static int Player1 = 0;
    private static int Player2 = 0;

    private static boolean isUsernameValid(String Username) {

        for (int i = 0; i < Username.length(); i++) {

            if (Usernames[i] != null) {

                if (Usernames[i].equals(Username)) return false;

            }

        }

        return true;
    }

    public static boolean addUser(String Username, String Pass) {

        for (int i = 0; i < Usernames.length; i++) {

            if (Usernames[i] == null) {

                if (isUsernameValid(Username) && Pass.length() == 5) {
                    Usernames[i] = Username;
                    Passwords[i] = Pass;
                    Points[i] = 0;
                    Actives[i] = true;
                    Dates[i] = LocalDateTime.now();

                    return true;
                } else return false;

            }

        }

        return false;
    }

    public static boolean isAccountActive(String Username) {

        for (int i = 0; i < Usernames.length; i++) {

            if (Usernames[i] != null) {

                if (Usernames[i].equals(Username)) {

                    return Actives[i];

                }

            }

        }

        return false;
    }

    public static boolean setPlayer1(String Username, String Pass) {

        for (int i = 0; i < Usernames.length; i++) {

            if (Usernames[i] != null) {

                if (Usernames[i].equals(Username) && Passwords[i].equals(Pass)) {

                    Player1 = i;
                    return true;

                }

            }

        }

        return false;
    }

    public static boolean setPlayer2(String Username) {

        for (int i = 0; i < Usernames.length; i++) {

            if (Usernames[i] != null) {

                if (Usernames[i].equals(Username) && i != Player1) {

                    Player2 = i;
                    return true;

                }

            }

        }

        return false;
    }

    public static String[] getActiveAccounts() {
        String[] Users;
        int UsersActive = 0;

        for (int i = 0; i < Usernames.length; i++) {

            if (Usernames[i] != null) {

                if (Actives[i] && i != Player1) {

                    UsersActive++;

                }

            }

        }
        Users = new String[UsersActive];

        for (int i = 0, User = 0; i < Usernames.length; i++) {

            if (Usernames[i] != null) {

                if (Actives[i] && i != Player1) {

                    Users[User] = Usernames[i];
                    User++;

                }

            }

        }

        return Users;
    }

    public static String Ranking() {
        String Ranking = "";
        String[] RankingUsers;
        int[] RankingPositions;
        int lastPos = 0;

        int Cant = 0;
        for (int i = 0; i < 100; i++) {

            if (Usernames[i] != null && Actives[i]) {
                Cant++;
            }

        }
        RankingPositions = new int[Cant];
        RankingUsers = new String[Cant];

        for (int i = 0, pos = 0; i < 100; i++) {
            
            if (Usernames[i] != null && Actives[i]) {
                RankingPositions[pos] = Points[i];
                RankingUsers[pos] = Usernames[i]; 

                pos++;
            }

        }

        int RankingAux;
        String UserAux;
        for (int i = 0; i < Cant - 1; i++) {

            for (int j = 0; j < Cant - i - 1; j++) {

                if (RankingPositions[j] > RankingPositions[j + 1]) {

                    RankingAux = RankingPositions[j];
                    RankingPositions[j] = RankingPositions[j + 1];
                    RankingPositions[j + 1] = RankingAux;

                    UserAux = RankingUsers[j];
                    RankingUsers[j] = RankingUsers[j + 1];
                    RankingUsers[j + 1] = UserAux;
                }

            }

        }

        for (int i = Cant - 1; i >= 0; i--) {
            Ranking += (i + 1) + ". " + RankingUsers[i] + " - " + RankingPositions[i] + "\n";
        }

        return Ranking;
    }

    public static void addHistorial(String msg) {

        for (int i = 0; i < 100; i++) {

            if (Historial[i] == null) {

                Historial[i] = msg;
                break;

            }

        }

    }

    public static String getHistorial(){
        String Hist = "\tHistorial de " + Usernames[Player1];

        for (int i = 0; i < 100; i++) {

            if (Historial[i] != null) {

                if (Historial[i].contains(Usernames[Player1].toUpperCase())) {

                    Hist += "\n" + Historial[i];
    
                }

            }

        }

        return Hist;
    }

    public static void addPoints(int Player) {
        Points[(Player == 1) ? Player1 : Player2] += 2;
    }

    public static String getUsername(int Player) {
        return Usernames[(Player == 1) ? Player1 : Player2];
    }

    public static String getPassword(int Player) {
        return Passwords[(Player == 1) ? Player1 : Player2];
    }

    public static boolean ChangePass() {
        try {

            String neoPass = JOptionPane.showInputDialog(null, "Contraseña actual: " + Passwords[Player1] + ".\nIngrese la nueva contraseña que desea: ", "Cambiar contraseña", JOptionPane.INFORMATION_MESSAGE);

            if (neoPass.length() == 5) {
                Passwords[Player1] = neoPass;

                return true;                
            }

        } catch (Exception e){}
        return false;
    }

    public static boolean DeactivateAccount() {
        try {

            int Ans = JOptionPane.showConfirmDialog(null, "Desea desactivar la cuenta, "+Usernames[Player1]+"?", "Desactivar cuenta", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

            if (Ans == JOptionPane.YES_OPTION) {
                Actives[Player1] = false;
                return true;
            }

        } catch (Exception e) {}

        return false;
    }

    public static int getPuntos(int Player) {
        return Points[(Player == 1) ? Player1 : Player2];
    }

}