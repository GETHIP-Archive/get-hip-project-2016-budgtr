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

	/**
	 * Convenience Finder for 'active record' style. Finder is public static
	 * class in com.avaje.ebean.Model
	 */
	public static final Finder<Long, Transaction> find = new Finder<>(Transaction.class);

	@Id
	Long id;

	@Version
	Long version;

	@CreatedTimestamp
	Timestamp whenCreated;

	@UpdatedTimestamp
	Timestamp whenUpdated;

	@Column(length = 100)
	public String name;

	@Column(length = 1000)
	String comments;
}