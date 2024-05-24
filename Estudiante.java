
/**
 * 
 * @author (Heidelberg Gelvez - 1152394)
 */
public class Estudiante
{
    private String nombre;
    private String apellido;
    private int edad;
    private String codigo;
    
    public Estudiante (String nombre, String apellido, int edad, String codigo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.codigo = codigo;
    }
    
    public String getNombre (){
        return nombre;
    }
    
    public String getApellido (){
        return apellido;
    }
    
    public int getEdad (){
        return edad;
    }
    
    public String getCodigo (){
        return codigo;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
}
