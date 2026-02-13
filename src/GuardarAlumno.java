import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

public class GuardarAlumno {
    public static void guardar (Map<String, List<Double>> alumnos) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("alumnos.dat"))){
            out.writeObject(alumnos);
            System.out.println("Datos guardados.");
        } catch (IOException e){
            System.out.println("Error al guardar los alumnos --> " + e.getMessage());
        }
    }
}
