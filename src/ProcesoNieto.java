
    import java.util.*;

public class ProcesoNieto {
    public static void main(String[] args) {
        try {
            // Leer los equipos de los argumentos
            List<String> equipos = new ArrayList<>(Arrays.asList(args));
            String resultado="";
            // Seleccionar dos equipos al azar para formar un cruce
            if (equipos.size() < 2) {
                System.err.println("Error: No hay suficientes equipos para formar un cruce.");
            } else {
                Random rand = new Random();
                List<String> equiposSeleccionados = new ArrayList<>();
                while (equiposSeleccionados.size() < 2) {
                    int index = rand.nextInt(equipos.size());
                    System.out.println(index);
                    resultado = equipos.get(index);equipos.remove(index);

                  /*   if (!equipo.equals("-1")) {
                        equiposSeleccionados.add(equipo);
                        equipos.set(index, "-1"); // Marcar el equipo seleccionado con -1
                    }*/
                //    index = (index == 0) ? 1 : 0;
                 //   resultado=equipo+equipos.get(index);
                }//while
               //for (String equipo : equiposSeleccionados) {
                    //System.out.println("Equipo seleccionado: " + equipo);
                    //System.out.println("Equipos seleccionados " + resultado);
               // }
               for (String equipo : equipos) {
                    System.out.println("Eeee "+equipo);
               }//for
            }//else
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

