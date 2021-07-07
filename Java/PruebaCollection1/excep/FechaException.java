package repasoExamenes.exCOLLECTION.excep;

public class FechaException extends Exception {

	public FechaException() {
		super("La fecha no puede ser posterior a la fecha actual");
	}
}
