package young;

import java.util.Scanner;

/**
 * 문제 번호 : 2745
 * 문제 제목 : 진법 변환
 * 작 성 자 : Ryan Yun
 * 
 * 문제 내용 : B 진법 수 N이 주어진다. 이 수를 10 진법으로 바꿔 출력하는 프로그램을 작성하시오.
 * 10 진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 
 * 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
 * 
 * A: 10, B: 11, ..., F: 15, ..., Y: 34, Z:35
 * 
 * 입    력 : 첫째 줄에 N과 B가 주어진다. (2 <= B <= 36)
 * B진법 수 N을 10진법으로 바꾸면, 항상 10억보다 작거나 같다.
 * 
 * 출    력 : 첫째 줄에 B진법 수 N을 10진법으로 출력한다.
 *
 */
public class baekjoon_2745 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] line = input.nextLine().split(" ");
		
		String n = line[0];	// B진법인 수 N
		int b = Integer.valueOf(line[1]); // B진법의 B
	    int result = 0;
	    
	    for(int i = 0; i < n.length(); i++) {
	    	char number = n.charAt(i);
	    	if('0' <= number && number <= '9') {  		  // 숫자가 0~9 사이일 때 
	    		result = result * b + (number - '0'); 
	    	} else {
	    		result = result * b + (number - 'A' + 10); // 숫자가 10 이상일 때 
	    	}
	    }
	    
	    System.out.println(result);
	    input.close();
	}
}
