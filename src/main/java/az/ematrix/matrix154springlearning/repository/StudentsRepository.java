package az.ematrix.matrix154springlearning.repository;

import az.ematrix.matrix154springlearning.dao.PersonDao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends CrudRepository<PersonDao, Long> {

    ArrayList<PersonDao> findAllByIdGreaterThan(int a);

    @Query(value = "SELECT * FROM person WHERE id > :minId", nativeQuery = true)
    List<PersonDao> findProductsAbovePriceNative(@Param("minId") int minId);
}
