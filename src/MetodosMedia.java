import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetodosMedia {
    //Método para calcular la media
    public static double calcularMedia(List<Double> notas) {
        double suma = 0;
        int totalNotas = notas.size();
        for (Double nota : notas) {
            suma += nota;
        }
        if (totalNotas == 0) {
            return 0;
        } else {
            return suma / totalNotas; //dividir entre el número de notas
        }
    }

    //Método para mostrar las medias de todos los alumnos --> Toma la lista de alumnos y sus notas
    public static Map<String, Double> mostrarMedias(Map<String, List<Double>> alumnos) {
        Map<String, Double> notasMedia = new HashMap<>(); //Crear un map para guardar las medias
        for (String nombre : alumnos.keySet()) {
            notasMedia.put(nombre, calcularMedia(alumnos.get(nombre))); //Guardar las medias calculadas con el método
        }

        for (var entry : notasMedia.entrySet()) { //Mostrar las notas llamando al método de calcular medias
            System.out.println("Alumno: " + entry.getKey() + " - Nota Media: " + String.format("%.2f", entry.getValue()));
        }
        return notasMedia; //Devolver el map que se usará más adelante
    }

    //Método para mostrar las medias ordenadas
    /*public static void mostrarMediaOrdenada(Map<String, List<Double>> lista){
        Map<String, Double> medias = new HashMap<>();
        for (String nombre : lista.keySet()) {
            medias.put(nombre, calcularMedia(lista.get(nombre)));
        }

        List<Map.Entry<String, Double>> listaOrdenada = new ArrayList<>(medias.entrySet());
        listaOrdenada.sort(Map.Entry.comparingByValue());

        System.out.println("\n---Lista de medias ordenada---");
        for(var entry : listaOrdenada){
            System.out.println("Alumno: " + entry.getKey() + " - Nota Media: " + String.format("%.2f", entry.getValue()));
        }
    }*/

    //**mejor hacer que devuelva la lista para meterlo al otro método en vez de hacer 50 nuevas

    //Método para mostrar lista de medias ordenada --> Este recoge lo que haya retornado el método de mostrar medias
    public static List<Map.Entry<String, Double>> mostrarListaOrdenada(Map<String, List<Double>> lista) {
        Map<String, Double> medias = new HashMap<>();
        for (String nombre : lista.keySet()) {
            medias.put(nombre, calcularMedia(lista.get(nombre)));
        }

        List<Map.Entry<String, Double>> listaOrdenada = new ArrayList<>(medias.entrySet());
        listaOrdenada.sort(Map.Entry.comparingByValue());

        System.out.println("\n---Lista de medias ordenada---");
        for (var entry : listaOrdenada) {
            System.out.println("Alumno: " + entry.getKey() + " - Nota Media: " + String.format("%.2f", entry.getValue()));
        }
        return listaOrdenada; //Devuelve la lista, que luego servirá para el siguiente método
    }

    //Método para mostrar la media más alta --> Toma la lista de medias ordenadas
    public static void mostrarMediaMasAlta(List<Map.Entry<String, Double>> listaOrdenada) {
        Map.Entry<String, Double> mejorAlumno = listaOrdenada.getLast();

        System.out.println("\n---Alumno con la nota más alta---");
        System.out.println("Alumno: " + mejorAlumno.getKey() + " - Nota: " + String.format("%.2f", mejorAlumno.getValue()));
    }

    //Método para mostrar aprobados --> Toma el map del principio de mostrar media
    public static void mostrarAprobados(List<Map.Entry<String, Double>> notasMedia) {
        for (Map.Entry<String, Double> entry : notasMedia) {
            String nombre = entry.getKey();
            Double nota = entry.getValue();

            if (nota >= 5) {
                System.out.println(nombre + ": " + String.format("%.2f", nota) + " - APROBADO.");
            } else {
                System.out.println(nombre + ": " + String.format("%.2f", nota) + " - NO APROBADO.");
            }
        }
    }
}