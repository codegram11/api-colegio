package apiconsultadatos.apiconsultadatos.repository;

import apiconsultadatos.apiconsultadatos.model.Asistencia;
import apiconsultadatos.apiconsultadatos.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {


}
