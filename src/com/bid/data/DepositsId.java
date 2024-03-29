package com.bid.data;

// Generated 2010-1-13 1:54:57 by Hibernate Tools 3.2.4.GA

/**
 * DepositsId generated by hbm2java
 */
public class DepositsId implements java.io.Serializable {

	private long itemId;
	private String userName;

	public DepositsId() {
	}

	public DepositsId(long itemId, String userName) {
		this.itemId = itemId;
		this.userName = userName;
	}

	public long getItemId() {
		return this.itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DepositsId))
			return false;
		DepositsId castOther = (DepositsId) other;

		return (this.getItemId() == castOther.getItemId())
				&& ((this.getUserName() == castOther.getUserName()) || (this
						.getUserName() != null
						&& castOther.getUserName() != null && this
						.getUserName().equals(castOther.getUserName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getItemId();
		result = 37 * result
				+ (getUserName() == null ? 0 : this.getUserName().hashCode());
		return result;
	}

}
