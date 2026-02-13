import java.util.*;

public class AlumnoMain {
    public static void main(String[] args) {
        Map<String, List<Double>> alumnos = new HashMap<>();
        List<Map.Entry<String, Double>> ordenada = new ArrayList<>();
        Map<String, Double> medias = new HashMap<>();

        Scanner input = new Scanner(System.in);
        int menu;

        do {
            System.out.println("---MENÚ---");
            System.out.println("1. Crear alumno.");
            System.out.println("2. Registrar nota.");
            System.out.println("3. Listar alumnos y sus notas.");
            System.out.println("4. Mostrar alumnos y medias.");
            System.out.println("5. Mostrar medias ORDENADAS.");
            System.out.println("6. Mostrar el alumno con la media más alta.");
            System.out.println("7. Lista de alumnos APROBADOS.");
            System.out.println("0. Salir.");
            menu = input.nextInt();
            input.nextLine();

            switch (menu) {
                case 1:
                    System.out.println("Ingrese alumno: ");
                    String nombre = input.nextLine();

                    if (alumnos.containsKey(nombre)) {
                        System.out.println("Alumno ya existe.");
                    }  else {
                        alumnos.put(nombre, new ArrayList<>()); //Crear una lista de notas para el alumno
                    }
                    GuardarAlumno.guardar(alumnos); //Guardar los datos en el archivo binario
                    break;
                case 2:
                    System.out.println("Ingrese alumno del que va a introducir la nota: ");
                    nombre = input.nextLine();

                    System.out.println("Ingresa la nota: ");
                    double nota = input.nextDouble();

                    if (alumnos.containsKey(nombre)) {
                        alumnos.get(nombre).add(nota); //Añadir la nota a la lista
                    } else {
                        System.out.println("el alumno no existe.");
                    }
                    GuardarAlumno.guardar(alumnos);
                    break;
                case 3:
                    System.out.println("---Lista de alumnos y notas---");
                    LeerAlumno.leer();
                    break;
                case 4:
                    System.out.println("---Medias de Alumnos---");
                    medias = MetodosMedia.mostrarMedias(alumnos); //Guardar las medias el map declarado al principio --> Lo que retorna el método de mostrar medias
                    break;
                case 5:
                    ordenada = MetodosMedia.mostrarListaOrdenada(alumnos); //Lo mismo que en el case 4
                    break;
                case 6:
                    MetodosMedia.mostrarMediaMasAlta(ordenada); //Tomar el list y aplicarle el método
                    break;
                case 7:
                    MetodosMedia.mostrarAprobados(new ArrayList<>(medias.entrySet()));
                    break;
                case 0:
                    System.out.println("Salir.");
                    break;
                default:
                    System.out.println("Opción no valida.");
                    break;
            }
        } while (menu != 0);
    }
}
