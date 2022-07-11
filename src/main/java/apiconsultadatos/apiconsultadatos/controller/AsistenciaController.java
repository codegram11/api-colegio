package apiconsultadatos.apiconsultadatos.controller;

import apiconsultadatos.apiconsultadatos.exception.EstudianteException;
import apiconsultadatos.apiconsultadatos.model.Asistencia;
import apiconsultadatos.apiconsultadatos.model.Estudiante;
import apiconsultadatos.apiconsultadatos.service.DatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDateTime;

import java.util.Date;

import java.util.Optional;


@RestController
@RequestMapping(value = "/api-asistencia")
public class AsistenciaController {

    @Autowired
    DatosService service;

    //localhost:8080/api-asistencia/consulta/{id}
    @GetMapping("/consulta/{id}")
    public ResponseEntity<?> consultarAsistencia(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(service.consultaAsistencia(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/consultaEstudiante/{id}")
    public ResponseEntity<?> consultarEstudiante(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(service.consultarDatosEstudiante(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/marcarAsistencia/{id}")
    public ResponseEntity<?> marcarAsistencia(Asistencia asistencia, @PathVariable("id") Long id) {
        try {
            Optional<Estudiante> estudiante= Optional.of(service.consultarDatosEstudiante(id));
            if(estudiante.isPresent()) {
                Date myDate = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
                String fecha=new SimpleDateFormat("yy/MM/dd HH:mm:ss").format(myDate);
                asistencia.setCodPersona((int) estudiante.get().getCodAlumno());
                asistencia.setEntrada(formatter.parse(fecha));

                if (validarFecha()){
                    asistencia.setEstado("P");
                }else {
                    asistencia.setEstado("R");
                }
               service.marcarAsistencia(asistencia);

                System.out.println(estudiante.get().getMaterno() + " " + estudiante.get().getPaterno());
                return new ResponseEntity<>(estudiante, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (EstudianteException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean validarFecha(){
        LocalDateTime locaDate = LocalDateTime.now();
        int hours  = locaDate.getHour();
        int minutes = locaDate.getMinute();
        int seconds = locaDate.getSecond();
        if (hours<=8){
            return true;
        }else {
            return false;
        }
    }
}
