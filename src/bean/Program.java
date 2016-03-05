package bean;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "program")
public class Program {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Integer id; 

Integer day; 
Integer startTime; 
Integer endTime;

@ManyToOne 
@JoinColumn(name="idAnimation")
Animation animation ;

@Column(name="idAnimation", nullable =false,insertable=false , updatable =false)
Integer idAnimation; 

@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.ALL}
		)
@JoinTable(name = "reservation", joinColumns = { 
		@JoinColumn(name = "idAnimation", nullable = false, updatable = false) }, 
		inverseJoinColumns = { @JoinColumn(name = "idTicket",  
				nullable = false, updatable = false) })
	private Collection<Ticket> ticketReserved = new ArrayList<>();


Integer nbVisitor= 0; 

public Program() {
 
}


public Program(Integer day, Integer startTime, Integer endTime) {
	super();
	this.day = day;
	this.startTime = startTime;
	this.endTime = endTime;
}


public Collection<Ticket> getTicketReserved() {
	return ticketReserved;
}


public void setTicketReserved(Collection<Ticket> ticketReserved) {
	this.ticketReserved = ticketReserved;
}


public Integer getNbVisitor() {
	return nbVisitor;
}


public void setNbVisitor(Integer nbVisitor) {
	this.nbVisitor = nbVisitor;
}

public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public Integer getDay() {
	return day;
}

public void setDay(Integer day) {
	this.day = day;
}


public Integer getStartTime() {
	return startTime;
}


public void setStartTime(Integer startTime) {
	this.startTime = startTime;
}


public Integer getEndTime() {
	return endTime;
}


public void setEndTime(Integer endTime) {
	this.endTime = endTime;
}


public Integer getIdAnimation() {
	return idAnimation;
}


public void setIdAnimation(Integer idAnimation) {
	this.idAnimation = idAnimation;
}


public Animation getAnimation() {
	return animation;
}


public void setAnimation(Animation animation) {
	this.animation = animation;
}


 public int getFreePlace(){
	 
	 return animation.getNbPlace() - nbVisitor; 
 }

}
