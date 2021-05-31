package kodlama.io.hrms.core.utilities.validations;

public interface EmailVerificationService<T> {
	public boolean checkIfRealEmail(T entity);
}
