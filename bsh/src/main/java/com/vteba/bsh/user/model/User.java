package com.vteba.bsh.user.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 用户实体类
 * 
 * @author iyinlei@126.com
 * @date 2016年5月10日 下午12:30:22
 */
@Entity
@Table(name = "user")
public class User {

	@Id
//	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "ACTIVITIESSCOPE_SEQ")
//	@GeneratedValue(generator = "sequenceGenerator", strategy = GenerationType.SEQUENCE)
//	@Column(name = "id", unique = true, nullable = false, precision = 10, scale = 0)
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "update_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
