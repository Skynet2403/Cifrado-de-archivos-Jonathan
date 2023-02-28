package Codificar_descodificar;

/**
 *
 * @author Hp Gamer
 */
public class Descodificar {

    public static String paso2(String x) {
        int mitad = (int) (x.length() / 2);
        String guardar = "";
        char temp;
        guardar = x.substring(0, mitad);
        x = x.substring(mitad, x.length());
        for (int i = 0; i < x.length(); i++) {
            temp = x.charAt(i);
            if (temp >= 64 && temp <= 90 | temp >= 96 && temp <= 122) {
                temp = (char) (x.charAt(i) + 1);
                guardar = guardar + temp;
            } else {
                guardar = guardar + temp;
            }
        } 
        return invertir(guardar);
    }

    public static String invertir(String x) {
        char temp;
        String cad = "";
        for (int i = 0; i < x.length(); i++) {
            temp = x.charAt(i);
            cad = temp + cad;
        }
        return paso1_decifrar(cad);
    }

    public static String paso1_decifrar(String x) {
        char temp;
        String cad = "";
        for (int i = 0; i < x.length(); i++) {
            temp = x.charAt(i);
            if (temp >= 65 && temp <= 93 | temp >= 97 && temp <= 125) {
                temp = (char) (x.charAt(i) - 3);
                cad = cad + temp;
            } else {
                cad = cad + temp;
            }
        }
        return cad;
    }
}
