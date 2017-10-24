/**
 * Created by Alumnos on 24/10/2017.
 */
public class Contacto {
    private String nombre;
    private String direccion;
    private long telefono;

    public Contacto(String nom, String dir, long tel)
    {
        if(nom.charAt(0) >= 'a' && nom.charAt(0) <= 'z' || nom.charAt(0) >= 'A' && nom.charAt(0) <= 'z')
        {
            this.nombre = nom;
        }
        else
        {
            throw new IllegalArgumentException("Nombre no valido");
        }
        if(dir.isEmpty())
        {
            throw new IllegalArgumentException("Dirección vacia");
        }
        else
        {
            this.direccion = dir;
        }
    }
}
