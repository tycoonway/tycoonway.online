package com.gltv.bigwig.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="bigwig_rank")
public class BigWigRank implements Serializable {
	
	
//	@Column(name = "id")
//    private Long id;
	@Id
	@Column(name = "address")
    private String address;

	@Column(name = "speed")
    private String speed;

	@Column(name = "level")
    private Long level;

    private static final long serialVersionUID = 1L;
    
    public BigWigRank() {
		super();
	}
    
    
    public BigWigRank(String address, String speed, Long level) {
		super();
		this.address = address;
		this.speed = speed;
		this.level = level;
	}

//	public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}



	public Long getLevel() {
		return level;
	}


	public void setLevel(Long level) {
		this.level = level;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BigWigRank [address=" + address + ", speed=" + speed + ", level=" + level + "]";
	}

	
	
}