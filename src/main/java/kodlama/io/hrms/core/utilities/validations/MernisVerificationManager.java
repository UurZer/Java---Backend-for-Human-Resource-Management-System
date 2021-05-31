package kodlama.io.hrms.core.utilities.validations;

public class MernisVerificationManager<T> implements MernisVerificationService<T> {

	@Override
	public boolean checkIfRealPerson(T entity) {
		return true;
	}

}
