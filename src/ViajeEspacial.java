import java.util.Scanner;
import java.util.Random;

public class ViajeEspacial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        
        String[] planetas = {"Mercurio", "Venus", "Tierra", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno"};
        double[] distancias = {57.9, 108.2, 149.6, 227.9, 778.5, 1432.0, 2867.0, 4515.0};
        
        
        String[] naves = {"Apollo X", "Voyager Plus", "StarExpedition", "GalaxyRover", "CosmicPioneer"};
        double[] velocidades = {60000, 75000, 100000, 150000, 200000}; // velocidades en km/h
        
       
        String[][] eventos = {
          
            {"Se ha detectado una lluvia de meteoritos en el camino.", 
             "Cambiar la ruta para evitarlos", "Has evitado los meteoritos con éxito, pero has usado más combustible y tiempo.",
             "Activar escudos y continuar", "Los escudos han resistido, pero han sufrido daños.",
             "Intentar maniobrar entre los meteoritos", "Maniobra exitosa. ¡Buen trabajo piloto!"},
            
            {"Falla en el sistema de soporte vital.",
             "Realizar reparaciones de emergencia", "Reparación exitosa, pero has perdido tiempo valioso.",
             "Reducir el consumo y redistribuir recursos", "La tripulación está incómoda pero segura.",
             "Activar sistemas de respaldo", "Los sistemas de respaldo funcionan correctamente."},
            
            {"Una tormenta solar se aproxima.", 
             "Cambiar curso para evitarla", "Has evitado la tormenta, pero has usado más combustible.",
             "Activar escudos de radiación", "Los escudos han protegido la nave, pero consumieron mucha energía.",
             "Apagar sistemas no esenciales", "Has minimizado daños, pero algunos sistemas necesitarán reparación."},
            
            {"Se ha detectado una anomalía gravitacional.",
             "Utilizar la anomalía para aumentar velocidad", "¡Golpe de suerte! Has ganado velocidad.",
             "Rodear la anomalía con precaución", "Has evitado riesgos, pero has perdido algo de tiempo.",
             "Lanzar sonda para investigar", "La sonda ha recopilado datos valiosos para futuros viajes."},
            
            {"Uno de los motores auxiliares presenta fallas.",
             "Realizar reparación en el espacio", "Reparación exitosa. Continúas a velocidad normal.",
             "Operar con los motores restantes", "Continúas a velocidad reducida.",
             "Realizar reinicio del sistema", "El reinicio ha solucionado el problema temporalmente."}
        };
        
        System.out.println("¡Bienvenido recluta al Viaje Espacial!");
        System.out.println("Desde la Tierra, ¿a qué planeta desea viajar?");
        
        
        for (int i = 0; i < planetas.length; i++) {
            if (!planetas[i].equals("Tierra")) {
                System.out.println((i + 1) + ". " + planetas[i]);
            }
        }
        
       
        int opcionPlaneta = 0;
        boolean seleccionValidaPlaneta = false;
        
        while (!seleccionValidaPlaneta) {
            System.out.print("Ingrese el número del planeta deseado: ");
            try {
                opcionPlaneta = Integer.parseInt(scanner.nextLine());
                if (opcionPlaneta >= 1 && opcionPlaneta <= planetas.length && !planetas[opcionPlaneta - 1].equals("Tierra")) {
                    seleccionValidaPlaneta = true;
                } else {
                    System.out.println("Opción inválida. Por favor, seleccione un número de la lista.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
        
        String planetaElegido = planetas[opcionPlaneta - 1];
        
        
        System.out.println("\nSeleccione la nave espacial para su viaje a " + planetaElegido + ":");
        for (int i = 0; i < naves.length; i++) {
            System.out.println((i + 1) + ". " + naves[i] + " (Velocidad: " + velocidades[i] + " km/h)");
        }
        
       
        int opcionNave = 0;
        boolean seleccionValidaNave = false;
        
        while (!seleccionValidaNave) {
            System.out.print("Ingrese el número de la nave deseada: ");
            try {
                opcionNave = Integer.parseInt(scanner.nextLine());
                if (opcionNave >= 1 && opcionNave <= naves.length) {
                    seleccionValidaNave = true;
                } else {
                    System.out.println("Opción inválida. Por favor, seleccione un número de la lista.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
        
        String naveElegida = naves[opcionNave - 1];
        double velocidadNave = velocidades[opcionNave - 1];
        
       
        System.out.println("\nUsted ha seleccionado viajar a " + planetaElegido + " en la nave " + naveElegida + ".");
        System.out.print("¿Confirma su selección? (s/n): ");
        String confirmacion = scanner.nextLine().toLowerCase();
        
        if (confirmacion.equals("s") || confirmacion.equals("si") || confirmacion.equals("sí")) {
           
            int tierraIndex = 2; 
            double distanciaTierra = distancias[tierraIndex];
            double distanciaPlaneta = distancias[opcionPlaneta - 1];
            double distanciaViaje = Math.abs(distanciaPlaneta - distanciaTierra);
            
            
            double horasViaje = (distanciaViaje * 1000000) / velocidadNave;
            double diasViaje = horasViaje / 24;
            
            System.out.println("\n¡Viaje confirmado a " + planetaElegido + " en la nave " + naveElegida + "!");
            System.out.println("Distancia a recorrer: " + distanciaViaje + " millones de kilómetros.");
            System.out.println("Velocidad de la nave: " + velocidadNave + " km/h");
            System.out.println("Duración estimada del viaje: " + String.format("%.1f", diasViaje) + " días.");
            
            if (diasViaje > 365) {
                double aniosViaje = diasViaje / 365;
                System.out.println("Equivalente a aproximadamente " + String.format("%.1f", aniosViaje) + " años.");
            }
            
            System.out.println("\nPreparando para el despegue...");
            esperar(3);
            System.out.println("¡Despegue exitoso! Iniciando viaje.");
            esperar(2);
            
            
            int progreso = 0;
            int numEventos = 3 + random.nextInt(3); 
            int[] puntosEvento = new int[numEventos];
            
            
            for (int i = 0; i < numEventos; i++) {
                
                int min = (i * 100) / numEventos;
                int max = ((i + 1) * 100) / numEventos - 5;
                puntosEvento[i] = min + random.nextInt(max - min);
            }
            
            while (progreso <= 100) {
                
                mostrarBarraProgreso(progreso);
                System.out.println(" " + progreso + "% completado");
                
                
                for (int i = 0; i < numEventos; i++) {
                    if (progreso == puntosEvento[i]) {
                        
                        int eventoIndex = random.nextInt(eventos.length);
                        String[] eventoActual = eventos[eventoIndex];
                        
                        System.out.println("\n¡ALERTA! " + eventoActual[0]);
                        System.out.println("Opciones disponibles:");
                        System.out.println("1. " + eventoActual[1]);
                        System.out.println("2. " + eventoActual[3]);
                        System.out.println("3. " + eventoActual[5]);
                        
                        int decision = 0;
                        while (decision < 1 || decision > 3) {
                            System.out.print("Seleccione una opción (1-3): ");
                            try {
                                decision = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Por favor, ingrese un número válido.");
                            }
                        }
                        
                      
                        System.out.println("\n" + eventoActual[decision * 2]);
                        esperar(3);
                    }
                }
                
                progreso += 1;
                esperar(0.1); 
            }
            
           
            System.out.println("\n¡Felicidades! Ha llegado con éxito a " + planetaElegido + ".");
            System.out.println("Iniciando secuencia de aterrizaje...");
            esperar(3);
            System.out.println("Aterrizaje exitoso en " + planetaElegido + ".");
            System.out.println("Gracias por viajar con Corporación Espacial Interestelar.");
            
        } else {
            System.out.println("Viaje cancelado. ¡Esperamos verlo pronto en otra aventura espacial!");
        }
        
        scanner.close();
    }
    
   
    private static void mostrarBarraProgreso(int progreso) {
        System.out.print("[");
        for (int i = 0; i < 50; i++) {
            if (i < progreso / 2) {
                System.out.print("=");
            } else {
                System.out.print(" ");
            }
        }
        System.out.print("]");
    }
    
    
    private static void esperar(double segundos) {
        try {
            Thread.sleep((long)(segundos * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}