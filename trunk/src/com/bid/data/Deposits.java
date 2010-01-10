package com.bid.data;

// Generated 2010-1-10 18:44:40 by Hibernate Tools 3.2.4.GA

/**
 * Deposits generated by hbm2java
 */
public class Deposits implements java.io.Serializable {

	private DepositsId id;
	private Double moneyFrozen;

	public Deposits() {
	}

	public Deposits(DepositsId id) {
		this.id = id;
	}

	public Deposits(DepositsId id, Double moneyFrozen) {
		this.id = id;
		this.moneyFrozen = moneyFrozen;
	}

	public DepositsId getId() {
		return this.id;
	}

	public void setId(DepositsId id) {
		this.id = id;
	}

	public Double getMoneyFrozen() {
		return this.moneyFrozen;
	}

	public void setMoneyFrozen(Double moneyFrozen) {
		this.moneyFrozen = moneyFrozen;
	}

}