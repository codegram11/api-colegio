package apiconsultadatos.apiconsultadatos.service;


import apiconsultadatos.apiconsultadatos.exception.EstudianteException;
import apiconsultadatos.apiconsultadatos.model.Asistencia;
import apiconsultadatos.apiconsultadatos.model.Estudiante;

public interface DatosService {

    /*Consultar datos de estudiante*/
    Estudiante consultarDatosEstudiante(Long id) throws EstudianteException;

    /*Insertar asistencia de estudiante*/
    Asistencia marcarAsistencia(Asistencia asistencia);

    /*Consultar Asistencia de estudiante*/
    Asistencia consultaAsistencia(Integer id);


}
