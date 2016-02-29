package io.waldstein.gethip.budgtr.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

@XmlRootElement
@Entity
@Table(name = "user")
public class User extends Model {

	@Id
	public Long id;
	
	public String firstName;
	
	public String lastName;
	
	public String email;
	
	public String password;
	
	public List<Transaction> transactions;

	public List<Goal> goals;
	
	@Version
	Long version;

	@CreatedTimestamp
	Timestamp whenCreated;

	@UpdatedTimestamp
	Timestamp whenUpdated;
	
	public void id(long id){
		this.id = id;
	}

	public void firstName(String firstName){
		this.firstName = firstName;
	}

	public void lastName(String lastName){
		this.lastName = lastName;
	}

	public void email(String email){
		this.email = email;
	}

	public void password(String password){
		this.password = password;
	}
	public static final Finder<Long, User> find = new Finder<>(User.class);
	
	public User(){
		super();
	}
}
