package co.edu.variable;

public class GetMaxVal {
	public static void main(String[] args) {
		int[] randomAry = new int[5]; // 5개담을 공간을 만듬 randaomAry는 주소.
		randomAry[0] = (int) (Math.random() * 100) + 1; // 0 ~ 1 사이의 임의수 생성. [0]은 정수.random실수타입이라 오류
		randomAry[1] = (int) (Math.random() * 100) + 1; // 자바에서는 int를 써줘야함.
		randomAry[2] = (int) (Math.random() * 100) + 1;
		randomAry[3] = (int) (Math.random() * 100) + 1;
		randomAry[4] = (int) (Math.random() * 100) + 1;

		int maxVal = 0; // 배열요소 중 가장 큰값을 저장.
		for (int i = 0; i < 5; i++) {
			System.out.println(randomAry[i]);
//			 maxVal 변수에 두 값을 비교해서 큰값을 담기.
			if(randomAry[i] > maxVal) {
				maxVal = randomAry[i];									
			}			
//			for(int j=0; j<randomAry.length; i++){
//			if(maxVal < randomAry[j]){
//			maxVal = randomAry[j]
//			}
//		}
			int maxVal2 = 100;
			for(int j =0; j <5; j++) {
				System.out.println(randomAry[j]);
			if (randomAry[j] < maxVal2) {
				maxVal2 = randomAry[j];
				}
			}
			System.out.println("생성된 배열의 임의의 값중 최소값 =>" + maxVal2);
		}
		
	}
}
