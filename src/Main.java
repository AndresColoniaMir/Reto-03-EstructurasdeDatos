import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        // Array
        int[] Array = {3, 5, 6, 7, 8};
        // Inserción
        Array[2] = 34;
        // Borrado
        Array[1] = 0;
        // Ordenacion
        System.out.println("Antes del orden: " + Arrays.toString(Array));
        Arrays.sort(Array);
        System.out.println("Despues del orden: " + Arrays.toString(Array));

        // ArrayList
        ArrayList<Integer> ArrayList = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 6));
        System.out.println("ArrayList: " + ArrayList);
        // Inserción
        ArrayList.add(4);
        System.out.println("ArrayList después de agregar el 4: " + ArrayList);
        // Borrado
        ArrayList.remove(Integer.valueOf(2));
        System.out.println("ArrayList después de el segundo elemento: " + ArrayList);
        // Update
        ArrayList.set(2, 9);
        System.out.println("ArrayList después de la actualización del tercer elemento: " + ArrayList);
        // Ordenacion
        Collections.sort(ArrayList);
        System.out.println("ArrayList después de la ordenación: " + ArrayList);

        LinkedList<Integer> ListaEnlasada = new LinkedList<>();
        */
        Agenda miAgenda = new Agenda();
        miAgenda.menu();
    }
}