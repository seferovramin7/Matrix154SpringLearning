package az.ematrix.matrix154springlearning.repository;

import az.ematrix.matrix154springlearning.dao.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, Long> {
}

