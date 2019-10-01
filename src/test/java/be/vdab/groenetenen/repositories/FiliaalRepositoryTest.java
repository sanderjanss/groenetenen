package be.vdab.groenetenen.repositories;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Sql("/insertFiliaal.sql")
public class FiliaalRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final String FILIALEN = "filialen";
    @Autowired
    private FiliaalRepository repository;
    @Autowired
    private EntityManager manager;
    private long idVanTestFiliaal() {
        return super.jdbcTemplate.queryForObject(
                "select id from filialen where naam='test'", Long.class);
    }
    @Test
    public void delete() {
        long id = idVanTestFiliaal();
        int aantalFilialen = super.countRowsInTable(FILIALEN);
        repository.deleteById(id);
        manager.flush();
        assertEquals(aantalFilialen - 1, super.countRowsInTable(FILIALEN));
        assertEquals(0, super.countRowsInTableWhere(FILIALEN, "id=" + id));
    }

}
