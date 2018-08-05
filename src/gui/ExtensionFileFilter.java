package gui;

/**
 * Permite filtrar el tipo de archivos por su extensión.
 * 
 * 25/06/2012 - 25 de junio del 2012.
 * 
 * @author José Cols, Larisa Méndez.
 */
public class ExtensionFileFilter extends javax.swing.filechooser.FileFilter {

    private String description;
    private String extensiones[];

    /**
     * Crea un nuevo filtro para una sola extensión.
     * 
     * @param description Descripción a mostrar.
     * @param extension Extensión permitida.
     */
    public ExtensionFileFilter(String description, String extension) {
        this(description, new String[]{extension});
    }

    /**
     * Crea un nuevo filtro para varias extensiones.
     * 
     * @param description Descripción a mostrar.
     * @param extensiones Extensiones permitidas.
     */
    public ExtensionFileFilter(String description, String extensiones[]) {
        if (description == null) {
            this.description = extensiones[0];
        } else {
            this.description = description;
        }
        this.extensiones = (String[]) extensiones.clone();
        toLower(this.extensiones);
    }

    /**
     * Convierte todos los caracteres de todas las cadenas de un arreglo en minúscula.
     * 
     * @param arreglo Arreglo cuyas cadenas se desean en minúsculas.
     */
    private void toLower(String arreglo[]) {
        for (int i = 0, n = arreglo.length; i < n; ++i) {
            arreglo[i] = arreglo[i].toLowerCase();
        }
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean accept(java.io.File file) {
        if (file.isDirectory()) {
            return true;
        } else {
            String path = file.getAbsolutePath().toLowerCase();
            for (int i = 0, n = extensiones.length; i < n; i++) {
                String extension = extensiones[i];
                if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) {
                    return true;
                }
            }
        }
        return false;
    }
}