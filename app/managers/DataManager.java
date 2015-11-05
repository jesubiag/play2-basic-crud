package managers;

import com.avaje.ebean.Ebean;

import java.util.Collection;
import java.util.List;

/**
 * Created by jesu on 23/10/2015.
 */
public class DataManager<T> {

	protected final Class<T> ENTITY_TYPE;

	public DataManager(Class<T> cls) {
		ENTITY_TYPE = cls;
	}

	public <TID> T get(TID id) {
		return Ebean.find(ENTITY_TYPE, id);
	}

	public List<T> getAll() {
		return Ebean.find(ENTITY_TYPE).findList();
	}

	public T save(T entity) {
		Ebean.save(entity);
		return entity;
	}

	public <TID> void delete(TID id) {
		Ebean.delete(ENTITY_TYPE, id);
	}

	public <TID> void deleteAll(Collection<TID> ids) {
		Ebean.delete(ENTITY_TYPE, ids);
	}

}
