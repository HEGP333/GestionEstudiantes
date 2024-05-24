import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author (Heidelberg Gelvez - 1152394)
 */
public class Gestion
{
    private List<Estudiante> estudiantes;
    
    public static void main(String [] args){
        Gestion gestion = new Gestion();
        
        Estudiante estudiante1 = new Estudiante("Pedro", "Lizcano", 19, "1152561");
        Estudiante estudiante2 = new Estudiante("Juan", "Fuentes", 18, "1152562");
        Estudiante estudiante3 = new Estudiante("Maria", "Martínez", 21, "1152563");
        Estudiante estudiante4 = new Estudiante("Jose", "Pérez", 19, "1152564");
        
        gestion.añadirEstudiante(estudiante1);
        gestion.añadirEstudiante(estudiante2);
        gestion.añadirEstudiante(estudiante3);
        gestion.añadirEstudiante(estudiante4);
        
        gestion.listarEstudiantes();
        
    }
    
    public Gestion(){
        estudiantes = new ArrayList<>();
    }
    
    public void añadirEstudiante(Estudiante estudiante){
        estudiantes.add(estudiante);
    }
    
    public void listarEstudiantes(){
        System.out.println("Estudiantes: ");
        for(int i = 0; i < estudiantes.size(); i++){
            System.out.println("");
            System.out.println("Nombre  : " +estudiantes.get(i).getNombre());
            System.out.println("Apellido: " +estudiantes.get(i).getApellido());
            System.out.println("Edad    : " +estudiantes.get(i).getEdad());
            System.out.println("Codigo  : " +estudiantes.get(i).getCodigo());
        }
    }
    
    public void buscarEstudiante(String buscarCodigo){
        boolean estudianteEncontrado = false;
        for(int i = 0; i < estudiantes.size(); i++){
            if(buscarCodigo == estudiantes.get(i).getCodigo()){
                System.out.println("");
                System.out.println("Nombre  : " +estudiantes.get(i).getNombre());
                System.out.println("Apellido: " +estudiantes.get(i).getApellido());
                System.out.println("Edad    : " +estudiantes.get(i).getEdad());
                System.out.println("Codigo  : " +estudiantes.get(i).getCodigo());
                estudianteEncontrado = true;
            }
        }
        if(estudianteEncontrado == false){
            System.out.println("");
            System.out.println("El estudiante con código " +buscarCodigo +" no existe");
        }
    }
    
}
