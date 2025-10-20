package net.salesianos.Procesos;

public class CentroMedico {

    // Lista de especialidades que coinciden con los archivos creados en /docs
    private static final String[] ESPECIALIDADES = {
            "cardiologia", "medicina_general", "podologia", "psicologia"
    };

    // Ruta donde están guardados los archivos .txt
    private static final String DATOS_PACIENTES = "src/net/salesianos/docs/";

    public static void main(String[] args) {
        System.out.println("Centro médico - Número de pacientes con cita\n");

        // Este int guarda el total de pacientes de todas las especialidades
        int totalGlobal = 0;

        // Recorremos todas las especialidades
        for (String especialidad : ESPECIALIDADES) {

            // Construimos la ruta completa del archivo (por ejemplo: src/net/salesianos/docs/cardiologia.txt)
            String ruta = DATOS_PACIENTES + especialidad + ".txt";

            // Llamamos al método que cuenta los pacientes
            int contadorCitas = contarPacientes(ruta);

            // Si el archivo se leyó correctamente
            if (contadorCitas >= 0) {
                System.out.printf("%-10s : %d pacientes%n", especialidad.toUpperCase(), contadorCitas);
                // utilice un %-10s esto es para la separacion de texto como de espacio por asi decirli
                totalGlobal += contadorCitas; // Sumar al total global
            } else {
                // Si hubo error al leer el archivo
                System.out.printf("%-10s : Error al leer el archivo%n", especialidad.toUpperCase());
            }
        }

        // Mostrar el total de pacientes al final del nuestro centro medico
        System.out.println("\n=====================");
        System.out.println("Total de pacientes con cita: " + totalGlobal);
    }

    /**
     * Método que cuenta las líneas de un fichero (una por paciente).
     * Devuelve -1 si hay error al leer el archivo.
     */
    public static int contarPacientes(String rutaArchivo) {
        int contador = 0;

        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(rutaArchivo))) {
            // Leer línea por línea y contar
            while (br.readLine() != null) {
                contador++;
            }
            return contador;
        } catch (Exception e) {
            return -1; // Si hay error (por ejemplo, archivo no encontrado)
        }
    }
}
