package bean;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "animation")
public class Animation {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Integer id; 

private String name =null; 

private String description=null; 
private Integer nbPlace; 

private String type=null; 

@OneToMany(mappedBy="animation")
private Collection<Program> programs = new ArrayList<>();


public Animation(String name, String description,String type,  Integer nbPlace) {
	super();
	this.name = name;
	this.description = description;
	this.nbPlace = nbPlace;
	this.type = type;
}


public Animation() {
 
}
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

 
public Collection<Program> getPrograms() {
	return programs;
}

public void setPrograms(Collection<Program> programs) {
	this.programs = programs;
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

public int getNbPlace() {
	return nbPlace;
}

public void setNbPlace(int nbPlace) {
	this.nbPlace = nbPlace;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}


}
