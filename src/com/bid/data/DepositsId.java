package com.bid.data;

// Generated 2010-1-10 18:44:40 by Hibernate Tools 3.2.4.GA

/**
 * DepositsId generated by hbm2java
 */
public class DepositsId implements java.io.Serializable {

	private String userName;
	private int itemId;

	public DepositsId() {
	}

	public DepositsId(String userName, int itemId) {
		this.userName = userName;
		this.itemId = itemId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DepositsId))
			return false;
		DepositsId castOther = (DepositsId) other;

		return ((this.getUserName() == castOther.getUserName()) || (this
				.getUserName() != null
				&& castOther.getUserName() != null && this.getUserName()
				.equals(castOther.getUserName())))
				&& (this.getItemId() == castOther.getItemId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserName() == null ? 0 : this.getUserName().hashCode());
		result = 37 * result + this.getItemId();
		return result;
	}

}
