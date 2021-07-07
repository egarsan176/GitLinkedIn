package repasoExamenes.exCOLLECTION.excep;

public class ETipoException extends Exception {
	public ETipoException() {
		super("El tipo introducido debe ser FOTOVOLTAICO, TERMICO, HIBRIDO.");
	}
}
