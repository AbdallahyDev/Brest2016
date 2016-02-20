package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id; 
 
	@Column(name="idAnimation", nullable =false,insertable=true , updatable =false)
	Integer idAnimation;
	
	@Column(name="idTicket", nullable =false,insertable=true , updatable =false)
	Integer idTicket ;
 
public Reservation() {
 
}

public Integer getIdTicket() {
	return idTicket;
}

public void setIdTicket(Ticket ticket) {
	this.idTicket = ticket.getId();
}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdAnimation() {
		return idAnimation;
	}

	public void setIdAnimation( Program program ) {
		this.idAnimation = program.getId();
	}

 
	
	
}
