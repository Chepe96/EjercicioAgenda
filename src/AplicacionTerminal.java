import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Created by Alumnos on 24/10/2017.
 */
public class AplicacionTerminal {

    private  Agenda agenda;

    public  AplicacionTerminal()
    {
        agenda = new Agenda();
    }

    public void demo()
    {
        Contacto c1 = new Contacto(  "JoseLuis",  "UASLP",  1451548451 );
        Contacto c2 = new Contacto(  "Raul",  "UASLP2",  1451565478 );
        Contacto c3 = new Contacto(  "Liñan",  "UASLP3",  1451595135 );
        Contacto c4 = new Contacto(  "Omar",  "UASLP4",  1451535789 );
        Contacto c5 = new Contacto(  "Fran",  "UASLP5",  1451550837 );

        this.agenda.agregaContacto(c1);
        this.agenda.agregaContacto(c2);
        this.agenda.agregaContacto(c3);
        this.agenda.agregaContacto(c4);
        this.agenda.agregaContacto(c5);
        //this.agenda.imprimeTodo();
    }

    public void entradaUsuario()
    {
        Scanner entrada = new Scanner(System.in);
        String opcion = "";
        do {
            try {
                System.out.println("Opciones: agregar - guardar - cargar - contar - eliminar - imprimir - terminar");
                opcion = entrada.nextLine();
                switch (opcion) {
                    case "agregar":
                        agregar(entrada);
                        break;
                    case "cargar":
                        cargar(entrada);
                        break;
                    case "contar":
                        contar();
                        break;
                    case "eliminar":
                        eliminar(entrada);
                        break;
                    case "guardar":
                        guardar(entrada);
                    case "imprimir":
                        agenda.imprimeTodo();
                        break;
                }
            }
            catch (IllegalArgumentException ex)
                {
                    System.out.println("no valido");
                    opcion = "";
                }
            catch (NullPointerException ex)
            {
                System.out.println("no valido");
                opcion = "";
            }
            catch (InputMismatchException ex) {
                System.out.println("Elemento no valido");
                opcion = "";
            }catch (FileNotFoundException ex){
                System.out.println("El archivo no existe");
                opcion = "";
            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println(e.getMessage());
                opcion = "";
            } catch (ExcepcionContactos ex) {
                System.out.println(ex.getMessage());
                opcion = "";
            }
        } while (opcion != "terminar");
    }

    private void contar() {
        System.out.println("Actualmente tienes " + agenda.numContactos());
    }

    private void eliminar(Scanner entrada) {
        System.out.print("Telefeno del contacto a eliminar: ");
        long telEliminar = entrada.nextLong();
        agenda.eliminarContacto(telEliminar);
    }

    private void cargar(Scanner entrada) throws FileNotFoundException {
        System.out.print("Nombre del archivo: ");
        String nomArch = entrada.nextLine();
        agenda.cargar(nomArch);
    }

    private void guardar(Scanner entrada) throws IOException
    {
        System.out.print("Nombre del archivo: ");
        String nomArchivo = entrada.nextLine();
        agenda.guardar(nomArchivo);
    }

    private void agregar(Scanner entrada)
    {
        System.out.println("Agregar un contacto nuevo");
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Direccion: ");
        String direccion = entrada.nextLine();
        System.out.print("Telefono: ");
        long telefono = entrada.nextLong();
        Contacto nuevo = new Contacto(nombre, direccion, telefono);
        this.agenda.agregaContacto(nuevo);
    }



    public static void main(String[] args)
    {
        AplicacionTerminal aplicacion = new AplicacionTerminal();

        aplicacion.demo();
        aplicacion.entradaUsuario();
    }
}
