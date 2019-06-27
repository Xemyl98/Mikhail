package model.repos;

import org.springframework.data.repository.CrudRepository;
import ui.User;

public interface IUserRepo extends CrudRepository<User, Integer> {
}
