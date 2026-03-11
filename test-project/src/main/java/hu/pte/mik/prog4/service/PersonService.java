package hu.pte.mik.prog4.service;


import hu.pte.mik.prog4.model.Person;
import org.apache.log4j.Logger;

import java.util.Objects;

public class PersonService implements ClientService<Person> {

    private static final Logger LOGGER = Logger.getLogger(PersonService.class.toString());

    @Override
    public void pay(Person client) {
        LOGGER.info(Objects.toString(client));
    }

    @Override
    public void receiveService(Person client) {
        LOGGER.info("Receive service as a person: " + client);
    }
}
