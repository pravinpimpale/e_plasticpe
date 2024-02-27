package com.e_plasticpe.entity;

public class WalletData {

	private Wallet wallet;
	private String key;

	public WalletData(Wallet wallet, String key) {
		this.wallet = wallet;
		this.key = key;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "WalletData [wallet=" + wallet + ", key=" + key + "]";
	}

}
