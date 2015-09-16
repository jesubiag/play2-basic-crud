package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Person extends Model {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;

	@Constraints.Required
	private String name;

	private String description;

	@Constraints.Min(0) @Constraints.Max(120)
	private Integer age;

	private Date birthday;

	public Person() {}

	public Person(Long id, String name, String description, Integer age, Date birthday) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.age = age;
		this.birthday = birthday;
	}

	public static Finder<Long,Person> find = new Finder<Long,Person>(Long.class, Person.class);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}