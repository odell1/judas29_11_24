import java.util.*;

public class ProcesoHijo {
    public static void main(String[] args) {
        try {
            // Leer los equipos de los argumentos
            List<String> equipos = new ArrayList<>(Arrays.asList(args));

            // Seleccionar dos equipos al azar para formar un cruce
            if (equipos.size() < 2) {
                System.err.println("Error: No hay suficientes equipos para formar un cruce.");
            } else {
                Random rand = new Random();
                List<String> equiposSeleccionados = new ArrayList<>();
                while (equiposSeleccionados.size() < 2) {
                    int index = rand.nextInt(equipos.size());
                    String equipo = equipos.get(index);
                    if (!equipo.equals("-1")) {
                        equiposSeleccionados.add(equipo);
                        equipos.set(index, "-1"); // Marcar el equipo seleccionado con -1
                    }
                }
                for (String equipo : equiposSeleccionados) {
                    System.out.println("Equipo seleccionado: " + equipo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}