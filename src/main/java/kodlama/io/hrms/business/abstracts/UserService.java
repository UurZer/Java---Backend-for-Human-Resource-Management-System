package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.User;



public interface UserService  {
	DataResult<List<User>> getAll();
	Result Delete(User user);
	Result Add(User user);
}
