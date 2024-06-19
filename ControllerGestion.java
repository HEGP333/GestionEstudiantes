import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.List;

public class ControllerGestion {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnLimpiarBuscar;

    @FXML
    private Button btnLimpiarBuscarResultado;

    @FXML
    private Button btnLimpiarLista;

    @FXML
    private Button btnLimpiarRegistro;

    @FXML
    private Button btnMostrar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Label lblApellido;

    @FXML
    private Label lblBuscar;

    @FXML
    private Label lblCodigoBuscar;

    @FXML
    private Label lblCodigoRegistro;

    @FXML
    private Label lblEdad;

    @FXML
    private Label lblGestion;

    @FXML
    private Label lblLista;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblRegistro;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtCodigoBuscar;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextArea txtLista;

    @FXML
    private TextField txtNombre;
    
    @FXML
    private TextField txtRegistro;

    @FXML
    private TextArea txtResultadoBuscar;
    
    private Gestion gestion;
    private Estudiante estudiante;
    
    @FXML
    void registrarEstudiante(ActionEvent event) {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String edad = txtEdad.getText();
        String codigo = txtCodigo.getText();
        if (!nombre.isEmpty() && !apellido.isEmpty() && !edad.isEmpty() && !codigo.isEmpty()) {
            if (!validarCodigo(codigo)) {
                Estudiante estudiante = new Estudiante(nombre, apellido, edad, codigo);
                gestion.añadirEstudiante(estudiante);
                txtRegistro.setText("El estudiante fue registrado con éxito");
                mostrarLista(event);
            }
            else txtRegistro.setText("El código " + codigo + " ya está registrado");
        }
        else txtRegistro.setText("Rellene todos los campos");
    }
    
    private boolean validarCodigo(String codigo) {
        List<Estudiante> estudiantes = gestion.getEstudiantes();
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
    
    @FXML
    void limpiarRegistro(ActionEvent event) {
        txtNombre.clear();
        txtApellido.clear();
        txtEdad.clear();
        txtCodigo.clear();
        txtRegistro.clear();
    }

    @FXML
    void buscarEstudiante(ActionEvent event) {
        String codigoBuscar = txtCodigoBuscar.getText();
        List<Estudiante> estudiantes = gestion.getEstudiantes();
        boolean estudianteEncontrado = false;
        for (Estudiante estudiante : estudiantes) {
            if (codigoBuscar.equals(estudiante.getCodigo())) {
                StringBuilder resultado = new StringBuilder();
                resultado.append("Nombre: ").append(estudiante.getNombre()).append("\n");
                resultado.append("Apellido: ").append(estudiante.getApellido()).append("\n");
                resultado.append("Edad: ").append(estudiante.getEdad()).append("\n");
                resultado.append("Codigo: ").append(estudiante.getCodigo()).append("\n");
                
                txtResultadoBuscar.setText(resultado.toString());
                estudianteEncontrado = true;
                break;
            }
        }
        if (!estudianteEncontrado) {
            txtResultadoBuscar.setText("El estudiante con el código " + codigoBuscar + " no está registrado");
        }
    }

    @FXML
    void limpiarBusqueda(ActionEvent event) {
        txtCodigoBuscar.clear();
    }
    
    @FXML
    void limpiarResultado(ActionEvent event) {
        txtResultadoBuscar.clear();
    }

    @FXML
    void mostrarLista(ActionEvent event) {
        StringBuilder lista = new StringBuilder();
        List<Estudiante> estudiantes = gestion.getEstudiantes();
        for (Estudiante estudiante : estudiantes) {
            lista.append("Nombre: ").append(estudiante.getNombre()).append("\n");
            lista.append("Apellido: ").append(estudiante.getApellido()).append("\n");
            lista.append("Edad: ").append(estudiante.getEdad()).append("\n");
            lista.append("Codigo: ").append(estudiante.getCodigo()).append("\n\n");
        }
        txtLista.setText(lista.toString());
    }
    
    @FXML
    void limpiarLista(ActionEvent event) {
        txtLista.clear();
    }

    @FXML
    void initialize() {
        assert btnBuscar != null : "fx:id=\"btnBuscar\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert btnLimpiarBuscar != null : "fx:id=\"btnLimpiarBuscar\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert btnLimpiarBuscarResultado != null : "fx:id=\"btnLimpiarBuscarResultado\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert btnLimpiarLista != null : "fx:id=\"btnLimpiarLista\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert btnLimpiarRegistro != null : "fx:id=\"btnLimpiarRegistro\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert btnMostrar != null : "fx:id=\"btnMostrar\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert btnRegistrar != null : "fx:id=\"btnRegistrar\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert lblApellido != null : "fx:id=\"lblApellido\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert lblBuscar != null : "fx:id=\"lblBuscar\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert lblCodigoBuscar != null : "fx:id=\"lblCodigoBuscar\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert lblCodigoRegistro != null : "fx:id=\"lblCodigoRegistro\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert lblEdad != null : "fx:id=\"lblEdad\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert lblGestion != null : "fx:id=\"lblGestion\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert lblLista != null : "fx:id=\"lblLista\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert lblNombre != null : "fx:id=\"lblNombre\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert lblRegistro != null : "fx:id=\"lblRegistro\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert txtApellido != null : "fx:id=\"txtApellido\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert txtCodigo != null : "fx:id=\"txtCodigo\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert txtCodigoBuscar != null : "fx:id=\"txtCodigoBuscar\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert txtEdad != null : "fx:id=\"txtEdad\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert txtLista != null : "fx:id=\"txtLista\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        assert txtResultadoBuscar != null : "fx:id=\"txtResultadoBuscar\" was not injected: check your FXML file 'VistaGestionEstudiantes.fxml'.";
        
        gestion = new Gestion();
    }

}
