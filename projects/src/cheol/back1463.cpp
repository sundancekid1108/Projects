/*
 * 1로만들기
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때,
 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다.
 연산을 사용하는 횟수의 최솟값을 출력하시오.

 동적 계획법의 문제...
 1~ n-1가지의 값을 이용해 계산
 *
 * */

#include <iostream>
#include <stdio.h>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;




int main(){
    int n;
    int result[1000001];

    printf("수입력 : \n");
    scanf("%d", &n);

    result[1] = 0;

    for(int i=2; i<=n; i++){
        result[i] = result[i-1]+1;
        if (i % 3 == 0)
            result[i] = min(result[i], result[i / 3] + 1);
        else if (i % 2 == 0)
            result[i] = min(result[i], result[i / 2] + 1);

    }
    //밑에서부터 n까지 올라가며 계산..


    printf("%d", result[n]);

    return 0;
}