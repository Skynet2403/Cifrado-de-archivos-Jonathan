package Codificar_descodificar;

/**
 *
 * @author Hp Gamer
 */
 public class Codificar {
     
    public static String paso1(String x){
        char temp;
        String cad = "";
        for (int i = 0; i < x.length(); i++) {
            temp = x.charAt(i);
            if (temp >= 65 && temp <= 90 | temp >= 97 && temp <= 122) {
                temp = (char) (x.charAt(i)+3);
                cad = cad + temp;
            } else {
                cad = cad + temp;
            }
        }
        return paso2invertir(cad);
    }
    
    public static String paso2invertir(String x){
        char temp;
        String cad = "";
        for (int i = 0; i < x.length(); i++) {
            temp = x.charAt(i);
            cad = temp + cad;
        }
        
        return paso2mitadrestar(cad);
        
    }
    
     public static String paso2mitadrestar(String x){
        int mitad = (int)(x.length()/2);
        String guardar = "";
        char temp;
        guardar = x.substring(0, mitad);
        x= x.substring(mitad, x.length());
         for (int i = 0; i < x.length(); i++) {
             temp = x.charAt(i);
            if (temp >= 65 && temp <= 90 | temp >= 97 && temp <= 122) {
                temp = (char) (x.charAt(i)-1);
                guardar = guardar + temp;
            } else {
                guardar = guardar + temp;
            }
         }
        return guardar;
     }
}
