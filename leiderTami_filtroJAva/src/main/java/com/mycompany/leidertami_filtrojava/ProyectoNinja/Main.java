package com.mycompany.leidertami_filtrojava.ProyectoNinja;

import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.ConexionBD;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.habilidad.Habilidad;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.habilidad.HabilidadDAO;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.ninja.Ninja;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.ninja.NinjaDAO;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.ninja.RangoNinja;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.vista.NinjaHabilidadView;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.mision.Mision;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.mision.MisionDAO;
import com.mycompany.leidertami_filtrojava.ProyectoNinja.modelo.misionNinja.MisionNinja;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NinjaDAO ninjaDAO = new NinjaDAO();
        MisionDAO misionDAO = new MisionDAO(ninjaDAO);
        HabilidadDAO habilidadDAO = new HabilidadDAO();
        NinjaHabilidadView view = new NinjaHabilidadView(misionDAO, ninjaDAO);
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        try {
            while (opcion != 7) {
                System.out.println("Menu:");
                System.out.println("1. Listar ninjas con habilidades");
                System.out.println("2. Mostrar las misiones disponibles para el rango de un ninja en específico");
                System.out.println("3. Crear un ninja");
                System.out.println("4. Crear una habilidad");
                System.out.println("5. Marcar una mision como completada");
                System.out.println("6. Asignar una mision a un ninja");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opcion: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        List<Ninja> ninjas = ninjaDAO.listarNinjas();
                        List<Habilidad> habilidades = habilidadDAO.listarHabilidades();
                        view.listarNinjasConHabilidades(ninjas, habilidades);
                        break;
                        case 2:
                        System.out.println("Ingrese el rango del ninja:");
                        String rangoConsulta = scanner.next();
                        List<Mision> misionesConsulta = misionDAO.obtenerMisionesDisponiblesParaNinja(rangoConsulta); 
                        view.mostrarMisionesDisponiblesParaNinja(rangoConsulta, misionesConsulta); 
                        break;
                    case 3:
                        System.out.println("Ingrese el nombre del ninja:");
                        String nombreNinjaCrear = scanner.next();
                        System.out.println("Ingrese el rango del ninja (A, B o C):");
                        RangoNinja rangoNinja = RangoNinja.valueOf(scanner.next().toUpperCase());
                        System.out.println("Ingrese la aldea del ninja:");
                        String aldeaNinja = scanner.next();
                        ninjaDAO.crearNinja(new Ninja(nombreNinjaCrear, rangoNinja, aldeaNinja));
                        System.out.println("Ninja creado exitosamente.");
                        break;
                    case 4:
                        System.out.println("Ingrese el nombre de la habilidad:");
                        String nombreHabilidad = scanner.next();
                        System.out.println("Ingrese la descripcion de la habilidad:");
                        String descripcionHabilidad = scanner.next();
                        habilidadDAO.crearHabilidad(new Habilidad(nombreHabilidad, descripcionHabilidad));
                        System.out.println("Habilidad creada exitosamente.");
                    break;
                    case 5:
                    //ATENICON : funciona si se le inserta el id 3 del ninja y el id 3 de la mision ya que asi estan en los insert
                        System.out.println("Ingrese el ID del ninja que ha completado la mision:");
                        int idNinjaCompletado = scanner.nextInt();
                        System.out.println("Ingrese el ID de la mision que ha completado:");
                        int idMisionCompletada = scanner.nextInt();
                        MisionNinja misionNinjaCompletada = new MisionNinja(idNinjaCompletado, idMisionCompletada, null, null);
                        boolean resultado = ConexionBD.marcarMisionComoCompletada(misionNinjaCompletada);
                        if (resultado) {
                            System.out.println("La mision ha sido marcada como completada.");
                        } else {
                            System.out.println("No se ha podido marcar la mision como completada.");
                        }
                        break;
                    case 6:
                    //ATENICON : funciona si se le inserta el id 4 del ninja y el id 4 de la mision ya que asi estan en los insert
                        System.out.println("Ingrese el ID del ninja al que se le va a asignar la mision:");
                        int idNinjaAsignado = scanner.nextInt();
                        System.out.println("Ingrese el ID de la mision que se le va a asignar:");
                        int idMisionAsignada = scanner.nextInt();
                        MisionNinja misionNinjaAsignada = new MisionNinja(idNinjaAsignado, idMisionAsignada, null, null);
                        boolean resultadoAsignar = ConexionBD.asignarMision(misionNinjaAsignada);
                        if (resultadoAsignar) {
                            System.out.println("La mision ha sido asignada al ninja.");
                        } else {
                            System.out.println("No se ha podido asignar la mision al ninja.");
                        }
                        break;
                    case 7:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opcion no valida. Intente de nuevo.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error en la aplicacion: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
