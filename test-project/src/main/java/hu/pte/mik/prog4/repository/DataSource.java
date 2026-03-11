package hu.pte.mik.prog4.repository;

import hu.pte.mik.prog4.model.Client;
import hu.pte.mik.prog4.model.Company;
import hu.pte.mik.prog4.model.Person;
import hu.pte.mik.prog4.service.IdProvider;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataSource {
    private static final DataSource DATA_SOURCE = new DataSource();

    private final IdProvider idProvider = IdProvider.getInstance();
    private final  List<Client> dataList;

    private DataSource () {
        this.dataList = this.createDummyList()
                .stream()
                .map(this::convertToClient)
                .collect(Collectors.toList());

    }

    public static DataSource getInstance() {
        return DATA_SOURCE;
    }

    private List<String[]> createDummyList() {
        List<String[]> dummyList = new ArrayList<>();
        dummyList.add(new String[]{"P", "Pista", "address01", "22234TA"});
        dummyList.add(new String[]{"C", "Google", "Google's address", "2434234234234"});
        dummyList.add(new String[]{"P", "Linus", "address02", "432440TA"});
        dummyList.add(new String[]{"C", "Oracle", "Oracle's address", "1231232142342"});
        dummyList.add(new String[]{"P", "Tom", "address03", "534554TA"});
        dummyList.add(new String[]{"C", "Suit", "Suit's address", "4564352353"});
        dummyList.add(new String[]{"P", "Jerry", "address04", "534543TA"});
        dummyList.add(new String[]{"C", "OTP", "OTP's address", "53453453453534"});

        return dummyList;
    }


    private Client convertToClient(String[] array) {
        return switch (array[0]) {
            case "P" -> new Person(this.idProvider.nextId(), array[1], array[2], array[3]);
            case "C" -> new Company(this.idProvider.nextId(), array[1], array[2], array[3]);
            default -> throw new RuntimeException("Unknown client type: " + array);
        };
    }

    public List<Person> getAllPeople() {
        return this.dataList.stream()
                .filter(client -> client instanceof Person)
                .map(client -> (Person)client)
                .collect(Collectors.toList());
    }

    public List<Company> getAllCompany() {
        return this.dataList.stream()
                .filter(client -> client instanceof Company)
                .map(client -> (Company)client)
                .collect(Collectors.toList());
    }
}
