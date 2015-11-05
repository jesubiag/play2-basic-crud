package managers;

import models.Person;

/**
 * Created by jesu on 16/09/2015.
 */
public class PersonManager extends DataManager<Person> {

    private static PersonManager instance;

    private PersonManager() {
        super(Person.class);
    }

    public static PersonManager instance() {
        if ( instance == null ) instance = new PersonManager();
        return instance;
    }

}
