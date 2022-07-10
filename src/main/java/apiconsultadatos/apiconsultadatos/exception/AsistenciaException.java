package apiconsultadatos.apiconsultadatos.exception;

public class AsistenciaException extends Exception{

    private static final long serialVersionUID=1L;


    public AsistenciaException(String message) {
        super(message);
    }

    public static String NotFoundException(String id){
        return "Estudiante con "+id+" no exite";
    }

    public static String estudianteAlreadyExists(){
        return "Estudiante con given name already exists";
    }
}
