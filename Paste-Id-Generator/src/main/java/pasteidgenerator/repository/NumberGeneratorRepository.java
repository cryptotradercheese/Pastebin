package pasteidgenerator.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class NumberGeneratorRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public long nextVal() {
        return entityManager
                .createQuery("SELECT NEXTVAL('number_generator')", long.class)
                .getSingleResult();
    }
}
