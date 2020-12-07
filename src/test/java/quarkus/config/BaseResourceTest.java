package quarkus.config;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.test.junit.callback.QuarkusTestMethodContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.transaction.Transactional;


public class BaseResourceTest extends BaseTest {

    @Inject
    private Instance<PanacheRepositoryBase<?,?>> repositories;

    @Transactional
    @BeforeEach
    public void beforeEach() {
        repositories.forEach(PanacheRepositoryBase::deleteAll);
    }

//    @AfterEach
    public void afterEach(QuarkusTestMethodContext context) {

    }
}
