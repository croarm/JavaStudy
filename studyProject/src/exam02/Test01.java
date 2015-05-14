package exam02;

public class Test01 {

	public static void main(String[] args) {
		int[][] arr={
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
				{1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1}, 
				{1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1}, 
				{1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1}, 
				{1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}, 
				{1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}, 
				{1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1}, 
				{1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1}, 
				{1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1}, 
				{1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1}, 
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1} 
		};
		
		System.out.println(search(arr));
	}
	public static boolean search(int[][] arr){
		boolean result;
		boolean loop = true;
		int pointX = 1;
		int pointY = 1;
		
		int[][] tempArr={
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1} 
		};
		
		while(loop == true){
			if(arr[pointY][pointX] == 0){
				tempArr[pointY][pointX] = 0;
				if(arr[pointY][pointX+1] == 0){
					pointX++;
				}else if(arr[pointY+1][pointX] == 0){
					pointY++;
				}else if(arr[pointY][pointX-1] == 0){
					pointX--;
				}else if(arr[pointY-1][pointX] == 0){
					pointY--;
				}
			}
			
		}
		
		
		
		return result=true;
	}
}
