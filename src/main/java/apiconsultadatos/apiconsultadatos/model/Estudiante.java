package apiconsultadatos.apiconsultadatos.model;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "alumno")
public class Estudiante {

    @Id
    @Column(name = "cod_alumno")
    private long codAlumno;

    private String paterno;

    private String materno;

    @Column(name = "nombres")
    private String nombre;

    private String convalidacion;

    private String obs;







}
