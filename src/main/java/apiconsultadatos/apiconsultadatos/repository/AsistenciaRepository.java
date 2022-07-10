package apiconsultadatos.apiconsultadatos.repository;

import apiconsultadatos.apiconsultadatos.model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {

    Asistencia findByCodPersona(int id);
}
