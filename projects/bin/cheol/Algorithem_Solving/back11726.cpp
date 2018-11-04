/*
 * 백준 11726
 * https://www.acmicpc.net/problem/11726
 * 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는
 * 방법의 수를 구하는 프로그램을 작성하시오.
 * 생각보다 쉽다. 종이에 하나씩 써서 규칙을 구해 풀었다.
 *
 * */

#include <iostream>
#include <stdio.h>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;




int main(){
    int n, result[1001];


    printf("수입력 : \n");
    scanf("%d", &n);

    result[1] = 1;
    result[2]= 2;

    for(int i=3; i<=n; i++){
        result[i] = (result[i-1] + result[i-2])%10007;
    }
    printf("%d", result[n]);


    return 0;
}