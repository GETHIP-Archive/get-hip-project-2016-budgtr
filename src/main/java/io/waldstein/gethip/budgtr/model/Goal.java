package io.waldstein.gethip.budgtr.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import com.avaje.ebean.Model.Finder;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

@XmlRootElement
@Entity
@Table(name = "goal")
public class Goal {
 
	public String categoryId;
	
	public long amountInCents;
	
	public Timestamp endDate;

	public String userId;
	
	@Id
	public long id;

	@Version
	Long version;

	@CreatedTimestamp
	Timestamp whenCreated;

	@UpdatedTimestamp
	Timestamp whenUpdated;

	
	public static final Finder<Long, Goal> find = new Finder<>(Goal.class);
}
