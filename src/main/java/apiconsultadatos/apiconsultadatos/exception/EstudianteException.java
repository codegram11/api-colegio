package apiconsultadatos.apiconsultadatos.exception;


public class EstudianteException extends Exception{

    private static final long serialVersionUID=1L;


    public EstudianteException(String message) {
        super(message);
    }

    public static String NotFoundException(String id){
        return "Custome with "+id+" not found";
    }

    public static String CustomerAlreadyExists(){
        return "Customer with given name already exists";
    }
}
