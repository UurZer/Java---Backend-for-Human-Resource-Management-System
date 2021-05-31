package kodlama.io.hrms.core.utilities.validations;

public interface MernisVerificationService<T> {
	public boolean checkIfRealPerson(T entity);
}
