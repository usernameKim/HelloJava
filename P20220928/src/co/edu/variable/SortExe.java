package co.edu.variable;

public class SortExe {
	public static void main(String[] args) {
		int[] numAry = { 34, 21, 12, 9 };
		
		//반복적인 처리.
//		numAry = {12, 21, 34}
		// 케이스 : n1 > n2 > n3 =>
		// 케이스 : n1 < n2 > n3 =>
		//1) 4개 -> 3번비교, 2번비교, 1번비교.
		for(int j=0; j <numAry.length -1; j++) {
			for (int i=0; i < numAry.length -1; i++) {
				if(numAry[i] > numAry[i + 1]) { //i :0 첫번째 위치> 두번째 위치 비교
					int temp =0;
					temp = numAry[i];
					numAry[i] = numAry[i + 1];
					numAry[i + 1] = temp;
				}
			}
		}
//		// 1. 0번과 1번 비교
//		if(numAry[0] > numAry[1]) { // 34 > 21
//			int temp = numAry[0];	//34
//			numAry[0] = numAry[1];  // 21
//			numAry[1] = temp;  // 34   -->21 34 12 
//		}
//		for(int n : numAry) {
//			System.out.print(n + " ");
//		} //2. 1번과 2번 비교
//		if(numAry[1] > numAry[2]) { // 21 > 12
//			int temp = numAry[1];	//21
//			numAry[1] = numAry[2];  // 12
//			numAry[2] = temp;  // 21
//		}
//		for(int n : numAry) {
//			System.out.print(n + " "); 
//		}// 3. 2번과 3번 비교
//		if(numAry[2] > numAry[3]) { // 21 > 12
//			int temp = numAry[2];	//21
//			numAry[2] = numAry[3];  // 12
//			numAry[3] = temp;  // 21
//		}
//		//2)
//		if(numAry[0] > numAry[1]) { // 34 > 21
//			int temp = numAry[0];	//34
//			numAry[0] = numAry[1];  // 21
//			numAry[1] = temp;  // 34
//		}
//		
//		//3)순서출력
		for(int n : numAry) {
			System.out.print(n + " "); //print -> 라인 없이 출력
		}
	}
}
