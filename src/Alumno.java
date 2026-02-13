public class Alumno {
    private String nombre;
    private double nota;

    public Alumno(double nota, String nombre) {
        this.nota = nota;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
