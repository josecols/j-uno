package juego;

import javax.swing.ImageIcon;

/**
 * Permite agrupar la información que se relaciona a un usuario registrado.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class Usuario {

    public static final String ACTIVADO = "activado";
    public static final String DESACTIVADO = "desactivado";
    protected String nombre;
    protected String apellido;
    protected ImageIcon avatar;
    private String email;
    private String nickname;
    private String clave;
    private String estado;

    public Usuario() {
    }

    /**
     * Crea un nuevo usuario con los valores dados.
     * 
     * @param nombre Nombre del usuario.
     * @param apellido Apellido del usuario.
     * @param nickname Nombre de usuario.
     */
    public Usuario(String nombre, String apellido, String nickname) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
    }

    /**
     * Crea un nuevo usuario con todos los valores dados.
     * 
     * @param nombre Nombre del usuario.
     * @param apellido Apellido del usuario.
     * @param email Correo electrónico del usuario.
     * @param avatar Imagen de perfil del usuario.
     * @param nickname Nombre de usuario.
     * @param clave Clave asociada.
     * @param estado Estado de activación, puede ser ACTIVADO o DESACTIVADO.
     */
    public Usuario(String nombre, String apellido, String email, ImageIcon avatar, String nickname, String clave, String estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.avatar = avatar;
        this.nickname = nickname;
        this.clave = clave;
        this.estado = estado;
    }

    //Getters y Setters.
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ImageIcon getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageIcon avatar) {
        this.avatar = avatar;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
