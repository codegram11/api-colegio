package apiconsultadatos.apiconsultadatos.service.impl;

import apiconsultadatos.apiconsultadatos.exception.EstudianteException;
import apiconsultadatos.apiconsultadatos.model.Asistencia;
import apiconsultadatos.apiconsultadatos.model.Estudiante;
import apiconsultadatos.apiconsultadatos.repository.AsistenciaRepository;
import apiconsultadatos.apiconsultadatos.repository.EstudianteRepository;
import apiconsultadatos.apiconsultadatos.service.DatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IDatosServiceImpl implements DatosService {

    @Autowired
    AsistenciaRepository asistenciaRepository;

    @Autowired
    EstudianteRepository estudianteRepository;


    @Override
    public Estudiante consultarDatosEstudiante(Long id) throws EstudianteException {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        if (!estudiante.isPresent()) {
            System.out.println("Estudiante Encontrado");
            throw new EstudianteException(EstudianteException.NotFoundException(String.valueOf(id)));
        } else {
            return estudianteRepository.findById(id).get();
        }
    }

    @Override
    public Asistencia marcarAsistencia(Asistencia asistencia) {
        /*Tranformacionde fecha*/

        return asistenciaRepository.save(asistencia);
    }

    @Override
    public Asistencia consultaAsistencia(Integer id) {
        return asistenciaRepository.findByCodPersona(id);
    }
}
