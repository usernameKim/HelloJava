package co.edu.except;

public class RectPrint {

	public static void main(String[] args) {
		int cnt = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%3d", cnt = i+1 + j*5 );
			}
			if (i % 4 == 0) {
			}
			System.out.printf("%n");
		}
	}

}//cnt = i+1 + j*5

// i가 0일때 cnt = 1
// i가 0, j가 1일때: cnt= 6 ...
// i가 1일때 cnt = 2 ...


// 그 외의 방법...
//int cnt = i+1;
//for (int i = 0; i < 5; i++) {
//	System.out.printf("%3d", cnt);
//	for (int j = 0; j < 4; j++) {
//		System.out.printf("%3d", cnt +=5);
//	}		
//}
//		
		