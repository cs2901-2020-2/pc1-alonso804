package pc1;

import jdk.nashorn.internal.ir.EmptyNode;

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

    public RegistrApp(String nombre) {
        nombreProfesor = nombre;

        semestre = "";
        codigo = "";
        idioma= "";
        curso= "";
        seccion= "";
        semana= "";
        fecha= "";
        horarioInicio= "";
        horarioFin= "";
        tipo= "";
        link= "";
    }

    public void getDescription(String description) throws Exception {
        String[] splited_1 = description.split("\\s*,\\s*");

        if(splited_1[0].matches("(.*)-(.*)") && splited_1[0].length() ==7) {
            this.semestre = splited_1[0];
        } else {
            throw new Exception("Error");
        }

        if(splited_1[1].length() ==6) {
            this.codigo = splited_1[1];
        } else {
            throw new Exception("Error");
        }

        if(splited_1[2] == "ES" || splited_1[2] == "EN") {
            this.idioma = splited_1[2];
        } else {
            throw new Exception("Error");
        }

        this.curso = splited_1[3];
        this.seccion = splited_1[4];

        if(splited_1[5].matches("Semana(.*)")) {
            this.semana = splited_1[5];
        } else {
            throw new Exception("Error");
        }

        if(splited_1[7].matches("(.*)/(.*)") && splited_1[7].length() == 5) {
            this.fecha = splited_1[7];
        } else {
            throw new Exception("Error");
        }

        String[] splited_2 = splited_1[8].split("-");
        if(splited_2[0].matches("(.*):(.*)") && splited_2[0].length() == 5 && splited_2[1].matches("(.*):(.*)") && splited_2[1].length() == 5) {
            this.horarioInicio = splited_2[0];
            this.horarioFin = splited_2[1];
        } else {
            throw new Exception("Error");
        }

        if(splited_1[9] == "Laboratorio" || splited_1[9] == "Teoria") {
            this.tipo = splited_1[9];
        } else {
            throw new Exception("Error");
        }
    }

    public String notificate(){
        if(this.nombreProfesor != "" && this.semestre != ""  && this.codigo != "" && this.idioma != "" && this.curso != ""
            && this.seccion != "" && this.semana != "" && this.fecha != "" && this.horarioInicio != "" && this.horarioFin != ""
            && this.tipo != "" && this.link != "") {
            entities.notificate(this.nombreProfesor);
            return "Profesor: " + this.nombreProfesor + " registro correctamente.";
        }
    }

    public void getLink(String url) throws Exception {
        if(url.matches("https://utec.zoom.us/rec/share/(.*)")) {
            this.link = url;
        } else {
            throw new Exception("Error");
        }

    }
}
