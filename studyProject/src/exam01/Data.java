package exam01;

import java.util.ArrayList;

public class Data {
	private String bankName;
	private String accName;
	private int accNumber;
	private String phoneNumber;
	private int money;
	private ArrayList<String> history;
	
	public Data(String msg){
		
		String[] token = msg.split(",");
		
		this.accNumber = Integer.parseInt(token[0]); 
		this.accName = token[1];
		this.bankName = token[2];
		this.phoneNumber = token[3]; 
	}
	
	public Data(int newAcc, String msg){ //계좌 등록
		String[] token = msg.split(",");
		
		this.accNumber = Integer.parseInt(token[0]); 
		this.accName = token[1];
		this.bankName = token[2];
		this.phoneNumber = token[3]; 
		this.money = 0;
		this.history = new ArrayList<String>();
	}
	
	
	@Override
	public String toString() {
		return "계좌이름 : "+accName+", 계좌번호 : "+accNumber+", 은행이름 : "+bankName+", 은행전화 : "+phoneNumber
				+", 잔액 : "+money;
	}
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public int getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money += money;
	}

	public ArrayList getHistory() {
		return history;
	}

	public void setHistory(ArrayList history) {
		this.history = history;
	}
	
	
	
}