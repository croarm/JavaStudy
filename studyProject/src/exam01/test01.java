package exam01;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class test01 {

	static ArrayList<Data> list = new ArrayList<Data>();
	static ArrayList<String> tempArray;
	
	static boolean state = true;
	static int input;
	static String temp;
	static int temp2;
	static int money;
	static int result = 0;

	public static void main(String[] args) {
		//Scanner scan = new Scanner(System.in);

		System.out.println("은행에 오신것을 환영합니다.");

		do {

			System.out.println("원하시는 업무를 선택하세요");
			System.out.println("1.계좌 등록\n2.계좌 목록\n3.계좌 정보 수정\n4.계좌 정보 삭제\n"
					+ "5.입출금\n6.거래내역");

			System.out.print(">");
			input = Integer.parseInt(inputString());

			switch (input) {
			case 1 : //계좌등록
				System.out.println("계정 등록");
				System.out.print(">");
				list.add(new Data(1, inputString()));
				break;
			case 2 : //계좌 목록 출력
				for (Data output : list) {
					System.out.println(output);
				}
				break;
			case 3 : //정보 수정
				temp2 = searchAcc();

				System.out.println("계정 정보 = "+list.get(temp2)+"\n>");
				list.set(temp2, new Data(inputString()));

				break;
			case 4 : //계좌 삭제
				temp2 = searchAcc();


				System.out.println("계정 정보 = "+list.get(temp2));
				if(0 == list.get(temp2).getMoney()){
					System.out.print("정말 삭제하시겠습니까? (y/n) ");
					if(inputString().equalsIgnoreCase("y")){
						list.remove(temp2);
						System.out.println("삭제되었습니다.");
					}else{
						System.out.println("취소되었습니다.");
					}
				}else{
					System.out.println("잔액이 있다면 삭제할 수 없습니다.");
				}

				break;
			case 5 : //입출금
				
				SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
				String str = sd.format(new Date()); 
				
				System.out.print("원하시는 업무를 선택하세요 (입금(1)/출금(2)) >");
				temp = inputString();
				if(temp.equals("1")){ // 입금
					temp2 = searchAcc();

					if(temp2 != -1){
						System.out.print("금액 > ");
						input = Integer.parseInt(inputString());
						list.get(temp2).setMoney(input);
						
						tempArray = list.get(temp2).getHistory(); //해당 계좌의 history
						
						tempArray.add("+" + input + ","+str);
						list.get(temp2).setHistory(tempArray);
						
					}else{
						System.out.println("없는 계좌입니다.");
					}

				}else if(temp.equals("2")){ // 출금
					temp2 = searchAcc();

					if(temp2 != -1){
						System.out.print("금액 > ");
						input = Integer.parseInt(inputString());
						if(input < list.get(temp2).getMoney()){
							list.get(temp2).setMoney(list.get(temp2).getMoney()-input);
												
							tempArray = list.get(temp2).getHistory(); //해당 계좌의 history
							tempArray.add("-" + input + ","+str);
							list.get(temp2).setHistory(tempArray);
							
						}else{
							System.out.println("잔액이 부족합니다.");
						}
					}else{
						System.out.println("없는 계좌입니다.");
					}
				}
				break;
			case 6 : //거래내역
				temp2 = searchAcc();

				tempArray = list.get(temp2).getHistory();
				for(int i = 0;i<tempArray.size();i++){
					System.out.println(tempArray.get(i));
				}
				break;
			case 7 : //파일 저장
				temp2 = searchAcc();
				if(temp2 != -1){
					
					try{
						String fileName = "test.csv";
						BufferedWriter writer = new BufferedWriter(
								new OutputStreamWriter(
										new FileOutputStream(fileName),"MS949"));
						writer.write("계좌번호,계좌이름,은행이름,은행전화\r\n");
						String accInfo = list.get(temp2).getAccNumber()+","+
										list.get(temp2).getAccName()+","+
										list.get(temp2).getBankName()+","+
										list.get(temp2).getPhoneNumber()+"\r\n";
						writer.write(accInfo);
						tempArray = list.get(temp2).getHistory();
						for(int i = 0;i<tempArray.size();i++){
							writer.write(tempArray.get(i)+"\r\n");
						}
						writer.close();
						
					}catch(IOException e){
						e.printStackTrace();
					}
				}else{
					System.out.println("없는 계좌입니다.");
				}
				break;
			default: System.out.println("잘못 입력하셨습니다. 종료합니다.");
				state = false;
				break;
			}

		} while(state = true);
	}
	
	public static int searchAcc(){

		System.out.println("계좌번호 입력");
		System.out.print(">");
		temp2 = Integer.parseInt(inputString());
		for(int i=0;i<list.size();i++){
			if(temp2 == (list.get(i).getAccNumber())){
				result = i;
			}else{
				result = -1;
			}
		}
		
		return result;
	}

	public static String inputString(){
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
}
