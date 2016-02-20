package io.waldstein.gethip.budgtr.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

@XmlRootElement
@Entity
@Table(name = "user")
public class User extends Model {

	@Id
	public Long id;
	
	@Column(length = 100)
	public String firstName;
	
	@Column(length = 100)
	public String lastName;
	
	@Column(length = 100)
	public String email;
	
	@Column(length = 100)
	public String password;
	
	@OneToMany
	public Set<Transaction> transactions;
	
	@Version
	Long version;

	@CreatedTimestamp
	Timestamp whenCreated;

	@UpdatedTimestamp
	Timestamp whenUpdated;
	
	public static final Finder<Long, User> find = new Finder<>(User.class);
	
	public void save(){
		Ebean.save(this);
	}
}
