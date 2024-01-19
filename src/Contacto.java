public class Contacto {

    private String Nombre;

    private String numero;

    public Contacto() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "-----------------------------\n" +
                "Contacto: " + Nombre + "\n" +
                "Numero: " + numero;
    }
}
