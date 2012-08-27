package com.tangotab.dao.pojo;

public class AmbReferences implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer rid;
	private Integer aid;
	private Integer userId;

	public AmbReferences() {

	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}