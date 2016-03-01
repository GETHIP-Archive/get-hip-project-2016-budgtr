package io.waldstein.gethip.budgtr.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * Customer entity bean.
 */
@XmlRootElement
@Entity
@Table(name = "transaction")
public class Transaction extends Model {

	@Id
	public long id;
	
	@Column (length = 100)
	public Timestamp date;
	
	@Column (length = 1000)
	public long userId;

	// TODO: figure out mapping
	public Category category;
	
	@Column(length = 1000)
	public long amountInCents;
	
	@Column(length = 1000)
	public String description;
	
	@Column(length = 1000)
	public String payee;
	
	public User user;

	
	
	@Version
	Long version;

	@CreatedTimestamp
	Timestamp whenCreated;

	@UpdatedTimestamp
	Timestamp whenUpdated;

	/**
	 * 
	 * 
	 * @param userId
	 */
	public Transaction(long user){
		super();
		User createuser = User.find.where().idEq(user).findUnique();
		this.userId = createuser.id;
	}

	/**
	 * Convenience Finder for 'active record' style. Finder is public static
	 * class in com.avaje.ebean.Model
	 */
	public static final Finder<Long, Transaction> find = new Finder<>(Transaction.class);
	
	
}