package io.waldstein.gethip.budgtr.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

	@ManyToOne
	public User user;

	public Date date;

	@Column(length = 100)
	public String payee;

	// TODO: figure out mapping
	public Category category;
	
	@Column(length = 100)
	public String userId;

	public long amountInCents;

	@Column(length = 1000)
	public String description;
	
	@Id
	public Long id;
	
	@Version
	Long version;

	@CreatedTimestamp
	Timestamp whenCreated;

	@UpdatedTimestamp
	Timestamp whenUpdated;

	// TODO: add constructor that takes user argument
	
	/**
	 * Convenience Finder for 'active record' style. Finder is public static
	 * class in com.avaje.ebean.Model
	 */
	public static final Finder<Long, Transaction> find = new Finder<>(Transaction.class);
	
	
}