package apiconsultadatos.apiconsultadatos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "asistencia")
public class Asistencia {

    @Id
    @Column(name = "cod_asistencia")
    private int codAsistencia;

    @Column(name = "cod_persona")
    private int codPersona;

    private Date entrada;

    private String estado;

    private String obs;
}
