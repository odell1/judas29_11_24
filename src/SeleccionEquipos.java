import java.io.*;
import java.util.*;

public class SeleccionEquipos {

    public static void main(String[] args) {
        List<String> equipos = new ArrayList<>(Arrays.asList(
            "Los Patitos Feos FC", "Los Gatos Voladores", "Los Pingüinos Furiosos", "Los Dragones Dormilones",
            "Los Canguros Saltarines", "Los Tiburones Bailarines", "Los Elefantes Equilibristas", "Los Monos Traviesos",
            "Los Osos Bailarines", "Los Delfines Cantores", "Los Rinocerontes Rápidos", "Los Camaleones Camuflados",
            "Los Cerdos Voladores", "Los Leones Rugientes", "Los Pandas Pícaros", "Los Zorros Astutos"
        ));

        // Reordenar aleatoriamente la lista de equipos
        Collections.shuffle(equipos);

        // Lista para almacenar los procesos
        List<ProcessBuilder> procesos = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            // Construir el comando con 4 equipos como argumentos
            List<String> command = new ArrayList<>();
            command.add("java");
            command.add("ProcesoHijo");
            for (int j = 0; j < 4; j++) {
                String equipo = equipos.get(i * 4 + j);
                command.add(equipo);
                equipos.set(i * 4 + j, "-1"); // Marcar el equipo seleccionado con -1
            }

            ProcessBuilder pb = new ProcessBuilder(command);
            pb.redirectErrorStream(true);
            procesos.add(pb);
        }
        File directorio=new File(".\\bin");
        // Ejecutar los procesos
        for (ProcessBuilder pb : procesos) {
            try {
                pb.directory(directorio);
                Process process = pb.start();

                // Capturar la salida del proceso hijo
                InputStream is = process.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Salida del proceso hijo: " + line);
                }

                process.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}