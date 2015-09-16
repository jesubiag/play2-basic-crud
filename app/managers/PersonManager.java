package managers;

import com.avaje.ebean.Ebean;
import models.Person;

import java.util.List;

/**
 * Created by jesu on 16/09/2015.
 */
public class PersonManager {

    private static final Class<Person> ENTITY_TYPE = Person.class;

    public static List<Person> findAll() {
        return Ebean.find(ENTITY_TYPE).findList();
    }

	public static void save(Person person) {
		Ebean.save(person);
	}
}
