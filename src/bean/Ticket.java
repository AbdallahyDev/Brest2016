package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {	
	

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)	
//@Column(name="ticketId")
Integer ticketId;

String lastName=null;     
String firstName=null;


@ManyToMany(fetch = FetchType.LAZY, mappedBy = "ticketReserved")
private Collection<Program> animationReserved = new ArrayList<>();

public Ticket() {
}


public Ticket(String lastName, String firstName) {
	super();
	this.lastName = lastName;
	this.firstName = firstName;
}



public Collection<Program> getAnimationReserved() {
	return animationReserved;
}


public void setAnimationReserved(Collection<Program> animationReserved) {
	this.animationReserved = animationReserved;
}


public void setTicketId(Integer id) {
	this.ticketId = id;
}

public int getTicketId() {
	return ticketId;
}
 
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
	


}
