import java.io.*;
import java.util.*;

public class ProcesoHijo2 {

    public static void main(String[] args) {
        try {
            // Recibir la lista de equipos y los equipos ya seleccionados del proceso principal
            InputStream is = System.in;
            ObjectInputStream ois = new ObjectInputStream(is);
            List<String> equipos = (List<String>) ois.readObject();
            Set<String> equiposSeleccionados = (Set<String>) ois.readObject();
            ois.close();

            // Seleccionar 4 equipos aleatoriamente que no hayan sido seleccionados aún
            List<String> equiposDisponibles = new ArrayList<>(equipos);
            equiposDisponibles.removeAll(equiposSeleccionados);
            Collections.shuffle(equiposDisponibles);
            List<String> equiposSeleccionadosPorHijo = equiposDisponibles.subList(0, Math.min(4, equiposDisponibles.size()));

            // Enviar los equipos seleccionados en pares de 2 al proceso principal
            for (int i = 0; i < equiposSeleccionadosPorHijo.size(); i += 2) {
                String equipo1 = equiposSeleccionadosPorHijo.get(i);
                String equipo2 = (i + 1 < equiposSeleccionadosPorHijo.size()) ? equiposSeleccionadosPorHijo.get(i + 1) : "N/A";
                System.out.println("Par de equipos seleccionados: " + equipo1 + " y " + equipo2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}