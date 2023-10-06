package az.ematrix.matrix154springlearning.repository;

import az.ematrix.matrix154springlearning.dao.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}