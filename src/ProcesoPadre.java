    
    import java.io.*;
    import java.util.*;
    
    public class ProcesoPadre {
        public static void main(String[] args) {
            try {
                // Leer los equipos de los argumentos
                List<String> equipos = new ArrayList<>(Arrays.asList(args));
    
                // Lista para almacenar los procesos
                List<ProcessBuilder> procesos = new ArrayList<>();
    
                for (int i = 0; i < 2; i++) {
                    // Construir el comando con 4 equipos como argumentos
                    List<String> command = new ArrayList<>();
                    command.add("java");
                    command.add("ProcesoNieto");
                    for (int j = 0; j < 4; j++) {
                        String equipo = equipos.get(i * 4 + j);
                        command.add(equipo);
                        equipos.set(i * 4 + j, "-1"); // Marcar el equipo seleccionado con -1
                    }
    
                    ProcessBuilder pb = new ProcessBuilder(command);
                    pb.redirectErrorStream(true);
                    procesos.add(pb);
                }
    
                File directorio = new File("C:\\Users\\lledo\\Downloads\\29_11_24\\judas29_11_24\\bin");
    
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }