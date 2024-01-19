import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Agenda {

    private final ArrayList<Contacto> agenda = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        int opcion;

        do {
            opcionesPrincipales();
            System.out.println("\nSeleccione una de las siguientes opciones (1 - 6).");

            opcion = validarOpcion();

            switch (opcion) {
                case 1:
                    System.out.println("1: Todos los contactos.\n");
                    printAllContactos();
                    break;
                case 2:
                    System.out.println("2: Agregar contacto.");
                    agregarContacto();
                    break;
                case 3:
                    System.out.println("3: Buscar contacto.");
                    buscarContacto();
                    break;
                case 4:
                    System.out.println("4: Actualizar contacto.");
                    actualizarContacto();
                    break;
                case 5:
                    System.out.println("5: Eliminar contacto.");
                    eliminarContacto();
                    break;
                case 6:
                    borrarConsola();
                    salirDelMenu();
                    break;
                default:
                    borrarConsola();
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    private String validarNumero(String numero) {
        String regex = "^[1-9][0-9]{10}$";

        while (numero == null || numero.isEmpty() || !numero.matches(regex)) {
            if (numero == null || numero.isEmpty()) {
                System.out.println("El campo número no puede ir vacío");
            } else if (!numero.matches(regex)) {
                System.out.println("El campo número no cumple con los requisitos");
            }

            System.out.print("Ingrese un número válido de 11 dígitos: ");
            numero = scanner.nextLine();
        }

        return numero;
    }

    private String validarNombre(String nombre) {
        while (nombre.isEmpty()) {
            System.out.println("El campo nombre no puede ir vacío");
            System.out.print("Ingrese un nombre: ");
            nombre = scanner.nextLine();
        }
        return nombre;
    }

    private void agregarContacto() {
        scanner.nextLine();
        String nombre;
        String numero;

        do {
            System.out.print("Ingrese el nombre del Contacto: ");
            nombre = validarNombre(scanner.nextLine());
            System.out.print("Ingrese el número del Contacto: ");
            numero = validarNumero(scanner.nextLine());

            Contacto contacto = new Contacto();
            contacto.setNombre(nombre);
            contacto.setNumero(numero);

            agenda.add(contacto);

            System.out.print("¿Desea agregar otro contacto? (Sí/No): ");
        } while (scanner.nextLine().equalsIgnoreCase("Si"));

        borrarConsola();
    }

    private void printAllContactos() {
        if (!agenda.isEmpty()) {
            for (Contacto contacto : agenda) {

                System.out.println(contacto.toString());
            }
            System.out.println("-----------------------------");
        } else {
            System.out.println("La agenda aún está vacía");
        }
    }

    private void borrarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private void salirDelMenu() {
        System.out.println("Saliendo del programa. ¡Hasta luego!");
    }

    private void opcionesPrincipales() {
        System.out.println("\nOpciones disponibles\n" +
                "1: Todos los contactos.\n" +
                "2: Agregar contacto.\n" +
                "3: Buscar contacto.\n" +
                "4: Actualizar contacto.\n" +
                "5: Eliminar contacto.\n" +
                "6: Salir");
    }

    private int validarOpcion() {
        int opc;
        while (true) {
            try {
                opc = scanner.nextInt();
                if (opc > 0 && opc < 7) {
                    return opc;
                } else {
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero.");
                scanner.nextLine();
            }
        }
    }

    private void buscarContacto() {
        scanner.nextLine();
        System.out.print("Ingrese el término de búsqueda: ");
        String terminoBusqueda = scanner.nextLine().toLowerCase();

        int coincidencias = 0;

        for (Contacto contacto : agenda) {
            if (contacto.getNombre().toLowerCase().contains(terminoBusqueda)) {
                coincidencias++;
            }
        }

        if (coincidencias > 0) {
            System.out.println("Número total de coincidencias parciales: " + coincidencias);

            System.out.println("Lista de coincidencias:");
            for (Contacto contacto : agenda) {
                if (contacto.getNombre().toLowerCase().contains(terminoBusqueda)) {
                    System.out.println(contacto);
                }
            }
            System.out.println("-----------------------------");
        } else {
            System.out.println("No se encontraron coincidencias parciales para el término de búsqueda: " + terminoBusqueda);
        }

        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        borrarConsola();
    }

    private void actualizarContacto() {
        scanner.nextLine();
        System.out.print("Ingrese el nombre del contacto a actualizar: ");
        String nombreActualizar = scanner.nextLine().toLowerCase();

        boolean contactoEncontrado = false;

        for (Contacto contacto : agenda) {
            if (contacto.getNombre().toLowerCase().equals(nombreActualizar)) {
                contactoEncontrado = true;
                System.out.println("Contacto encontrado. Ingrese los nuevos datos:");


                System.out.print("Nuevo nombre: ");
                String nuevoNombre = validarNombre(scanner.nextLine());
                System.out.print("Nuevo número: ");
                String nuevoNumero = validarNumero(scanner.nextLine());

                contacto.setNombre(nuevoNombre);
                contacto.setNumero(nuevoNumero);

                System.out.println("Contacto actualizado correctamente.");
                break;
            }
        }

        if (!contactoEncontrado) {
            System.out.println("No se encontró ningún contacto con el nombre: " + nombreActualizar);
        }

        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        borrarConsola();
    }

    private void eliminarContacto() {
        scanner.nextLine();
        System.out.print("Ingrese el nombre del contacto a eliminar: ");
        String nombreEliminar = scanner.nextLine().toLowerCase();

        boolean contactoEncontrado = false;

        for (Contacto contacto : agenda) {
            if (contacto.getNombre().toLowerCase().equals(nombreEliminar)) {
                contactoEncontrado = true;
                System.out.println("Contacto encontrado. ¿Está seguro de que desea eliminar este contacto? (Sí/No): ");
                String respuesta = scanner.nextLine();

                if (respuesta.equalsIgnoreCase("Si")) {
                    agenda.remove(contacto);
                    System.out.println("Contacto eliminado correctamente.");
                } else {
                    System.out.println("Operación de eliminación cancelada.");
                }

                break;
            }
        }

        if (!contactoEncontrado) {
            System.out.println("No se encontró ningún contacto con el nombre: " + nombreEliminar);
        }

        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        borrarConsola();
    }

}
