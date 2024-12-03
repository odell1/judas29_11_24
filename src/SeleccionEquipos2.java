import java.io.*;
import java.util.*;

public class SeleccionEquipos2 {

    private static final List<String> equipos = Collections.synchronizedList(new ArrayList<>(Arrays.asList(
        "Los Patitos Feos FC", "Los Gatos Voladores", "Los Pingüinos Furiosos", "Los Dragones Dormilones",
        "Los Canguros Saltarines", "Los Tiburones Bailarines", "Los Elefantes Equilibristas", "Los Monos Traviesos",
        "Los Osos Bailarines", "Los Delfines Cantores", "Los Rinocerontes Rápidos", "Los Camaleones Camuflados",
        "Los Cerdos Voladores", "Los Leones Rugientes", "Los Pandas Pícaros", "Los Zorros Astutos"
    )));
    private static final Set<String> equiposSeleccionados = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
        Process[] procesos = new Process[4];

        for (int i = 0; i < procesos.length; i++) {
            try {
                ProcessBuilder pb = new ProcessBuilder("/usr/lib/jvm/jdk-21.0.2+13/bin/java", "ProcesoHijo2");
                pb.redirectErrorStream(true);
                File directorio = new File("/home/lledo/Descargas/judas29_11_24-main/bin/");
                pb.directory(directorio);
                procesos[i] = pb.start();

                // Enviar la lista de equipos y los equipos ya seleccionados al proceso hijo
                OutputStream os = procesos[i].getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(os);

                oos.writeObject(equipos);
                oos.writeObject(equiposSeleccionados);
                oos.close();

                // Capturar la salida del proceso hijo
                InputStream is = procesos[i].getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line;
                int equiposDevueltos = 0;
                while ((line = reader.readLine()) != null && equiposDevueltos < 4) {
                    System.out.println("Salida del proceso hijo: " + line);
                    if (line.startsWith("Equipo seleccionado: ")) {
                        String equipo = line.substring("Equipo seleccionado: ".length());
                        equiposSeleccionados.add(equipo);
                        equiposDevueltos++;
                    }
                }

                procesos[i].waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
