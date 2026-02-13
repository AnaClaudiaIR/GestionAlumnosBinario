import java.io.ObjectOutputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LeerAlumno {
    public static void leer(){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("alumnos.dat"))){
            Map<String, List<Double>> alumnos = (Map<String, List<Double>>) in.readObject();
            for(String key : alumnos.keySet()){
                System.out.println(key + " --> " + alumnos.get(key));
            }
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Error al leer el archivo --> "+e.getMessage());
        }
    }
}

