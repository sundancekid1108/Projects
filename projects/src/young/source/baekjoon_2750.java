package young.source;

import java.util.Scanner;

/**
 * 문제 번호 : 2750번
 * 문제 제목 : 수 정렬하기
 * 작 성 자 : Ryan Yun
 * 
 * 문제 내용 : N 개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 
 * 입    력 : 첫째 줄에 수의 개수 N(1 <= N <= 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다.
 * 이 수는 절대값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 * 
 * 출    력 : 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 * 
 * 퀵 정렬
 * 1. 리스트 안에 있는 한 요소를 선택한다. 이렇게 고른 원소를 피벗(pivot)이라고 한다.
 * 2. 피벗을 기준으로 피벗보다 작은 요소들은 모두 피벗의 왼쪽으로 옮겨지고 피벗보다 큰 요소들은 모두 피벗의 오른쪽으로 옮겨진다.
 * (피벗을 중심으로 왼쪽 : 피벗보다 작은 요소들, 오른쪽 : 피벗보다 큰 요소들)
 * 3. 피벗을 제외한 왼쪽 리스트와 오른쪽 리스트를 다시 정렬한다.
 * 
 */
public class baekjoon_2750 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt(); // 수의 개수 N
		int[] arr = new int[n]; // 수의 개수만큼 배열 크기 지정
		
		// 수의 개수만큼 배열에 수 저장
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		// 퀵 정렬하기
		quickSort(arr, 0, arr.length-1);
		
		// 정렬된 수 출력하기
		for(int j = 0; j < n; j++) {
			System.out.println(arr[j]);
		}
		
		scan.close();
	}

	// 오름차순 퀵 정렬 (낮은 수에서 높은 수로 올라감)
	public static void quickSort(int[] arr, int left, int right) {
		int l = left, r = right, temp;
		int pivot = arr[(left + right) / 2]; // 정렬할 수들의 가운데 값을 피벗(pivot)으로 지정
		while (l <= r) {
			// 분할
			while(arr[l] < pivot)  // 피벗보다 크면 정렬 
				l++;
			while(arr[r] > pivot)  // 피벗보다 작으면 정렬 
				r--;
			if(l <= r) {	// 분할을 통해 나눠진 리스트를 정렬 
				temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
				l++;
				r--;
			}
		}
		// 분할이 끝난 뒤 순환을 통해 정렬
	    if(left < r) quickSort(arr, left, r);
	    if(l < right) quickSort(arr, l, right);
	}
}
