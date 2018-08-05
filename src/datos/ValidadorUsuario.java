package datos;

import java.util.regex.Pattern;

/**
 * Realiza la validación de los datos ingresados por un usuario al momento
 * de registrarse o al actualizar su perfil.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class ValidadorUsuario {

    public ValidadorUsuario() {
    }

    /**
     * El correo debe ser de la forma "nombre@dominio.terminacion.(terminacion adicional)".
     * Por ejemplo: josecolsg@gmail.com. Puede tener punto, guion y/o guion bajo, sin embargo
     * estos no deben estar ni al inicio ni al ginal del nombre del correo.
     * 
     * @param correo Cadena a verificar.
     * @return Resultado de la comprobación.
     */
    public static boolean validarCorreo(String correo) {
        Pattern patron = Pattern.compile("^[a-z0-9]+([\\.\\-\\_][a-z0-9]+){0,}@[a-z]{1,64}\\.[a-z]{2,6}(\\.[a-z]{2})?$");
        return patron.matcher(correo).matches();
    }

    /**
     * El nombre sólo puede contener caracteres de la A a la Z, en mayúscula o en minúscula.
     * Además no pueden haber más de tres nombres en el campo.
     * 
     * @param texto Cadena a verificar.
     * @return Resultado de la comprobación.
     */
    public static boolean validarNombre(String texto) {
        Pattern patron = Pattern.compile("^[a-zA-Z]+(\\s[a-zA-Z]+){0,2}?$");
        return patron.matcher(texto).matches();
    }

    /**
     * El nickname puede contener tanto caracteres como números. Además de puntos, guiones y 
     * guiones bajos.
     * 
     * @param nickname Cadena a verificar.
     * @return Resultado de la comprobación.
     */
    public static boolean validarNickname(String nickname) {
        Pattern patron = Pattern.compile("^[a-z0-9]+([\\.\\-\\_][a-z0-9]+){0,}?$");
        return patron.matcher(nickname).matches()
                && !"invitado".equals(nickname)
                && !"computador".equals(nickname);
    }
}
