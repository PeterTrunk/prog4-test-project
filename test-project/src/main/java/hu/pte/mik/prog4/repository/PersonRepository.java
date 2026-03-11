package hu.pte.mik.prog4.repository;

import hu.pte.mik.prog4.model.Person;

import java.util.List;

public class PersonRepository implements ClientRepository<Person>{
    private final DataSource dataSource = DataSource.getInstance();

    @Override
    public List<Person> listAll() {
        return this.dataSource.getAllPeople();
    }

    @Override
    public void save(Person client) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Person findById(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
