package pc1;
import java.util.logging.Logger;

public class RegistrApp {
    private Entities entities;
    private String nombreProfesor;
    private String semestre;
    private String codigo;
    private String idioma;
    private String curso;
    private String seccion;
    private String semana;
    private String fecha;
    private String horarioInicio;
    private String horarioFin;
    private String tipo;
    private String link;

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getCurso() {
        return curso;
    }

    public String getSeccion() {
        return seccion;
    }

    public String getSemana() {
        return semana;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public String getHorarioFin() {
        return horarioFin;
    }

    public String getTipo() {
        return tipo;
    }

    public String getLink() {
        return link;
    }

    public RegistrApp(String nombre) {
        this.nombreProfesor = nombre;
        this.semestre = "";
        this.codigo = "";
        this.idioma= "";
        this.curso= "";
        this.seccion= "";
        this.semana= "";
        this.fecha= "";
        this.horarioInicio= "";
        this.horarioFin= "";
        this.tipo= "";
        this.link= "";
    }

    public boolean getDescription(String description) throws Exception {
        String[] splited_1 = description.split("\\s*,\\s*");

        if(splited_1[0].matches("(.*)-(.*)") && splited_1[0].length() ==7) {
            this.semestre = splited_1[0];
        } else {
            return false;
        }


        if(splited_1[1].length() ==6) {
            this.codigo = splited_1[1];
        } else {
            return false;
        }

        if(splited_1[2].matches("ES") || splited_1[2].matches("EN")) {
            this.idioma = splited_1[2];
        } else {
            return false;
        }

        this.curso = splited_1[3];
        this.seccion = splited_1[4];

        if(splited_1[5].matches("Semana(.*)")) {
            this.semana = splited_1[5];
        } else {
            return false;
        }

        if(splited_1[7].matches("(.*)/(.*)") && splited_1[7].length() == 5) {
            this.fecha = splited_1[7];
        } else {
            return false;
        }

        String[] splited_2 = splited_1[8].split("-");
        if(splited_2[0].matches("(.*):(.*)") && splited_2[0].length() == 5 && splited_2[1].matches("(.*):(.*)") && splited_2[1].length() == 5) {
            this.horarioInicio = splited_2[0];
            this.horarioFin = splited_2[1];
        } else {
            return false;
        }

        if(splited_1[9].matches("Laboratorio") || splited_1[9].matches("Teoria")) {
            this.tipo = splited_1[9];
        } else {
            return false;
        }

        return true;
    }

    public String notificate() throws Exception {
        if(this.nombreProfesor != "" && this.semestre != ""  && this.codigo != "" && this.idioma != "" && this.curso != ""
            && this.seccion != "" && this.semana != "" && this.fecha != "" && this.horarioInicio != "" && this.horarioFin != ""
            && this.tipo != "" && this.link != "") {
            entities.notificate(this.nombreProfesor);
            return "Profesor: " + this.nombreProfesor + " registro correctamente.";
        } else {
            throw new Exception("Profesor no se registro correctamente");
        }

    }

    public boolean getLink(String url) throws Exception {
        if(url.matches("https://utec.zoom.us/rec/share/(.*)")) {
            this.link = url;
            return true;
        } else {
            return false;
        }
    }
}
