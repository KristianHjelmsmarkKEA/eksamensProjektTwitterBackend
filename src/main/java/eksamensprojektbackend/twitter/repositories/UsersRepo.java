package eksamensprojektbackend.twitter.repositories;

import eksamensprojektbackend.twitter.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<User, Long> {
}
