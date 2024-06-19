import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author (Heidelberg Gelvez - 1152394)
 */
public class Gestion
{
    private List<Estudiante> estudiantes;
    
    public Gestion(){
        estudiantes = new ArrayList<>();
    }
    
    public List getEstudiantes(){
        return estudiantes;
    }
    
    public void añadirEstudiante(Estudiante estudiante){
        estudiantes.add(estudiante);
    }
    
}
