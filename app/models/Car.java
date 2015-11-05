package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by jesu on 23/10/2015.
 */
 @Entity
public class Car extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Constraints.Required
	private String name;

	private String description;

	@Constraints.Min(0)
	private Float kilometers;

	private String color;

	public Car() {}

	public Car(Long id, String name, String description, Float kilometers, String color) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.kilometers = kilometers;
		this.color = color;
	}

	public static Finder<Long,Car> find = new Finder<Long,Car>(Long.class, Car.class);

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

	public Float getKilometers() {
		return kilometers;
	}

	public void setKilometers(Float kilometers) {
		this.kilometers = kilometers;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
