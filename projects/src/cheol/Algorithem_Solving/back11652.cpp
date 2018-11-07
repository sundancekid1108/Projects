/*
 * 백준 11652
 * https://www.acmicpc.net/problem/11652
 * 준규는 숫자 카드 N장을 가지고 있다. 숫자 카드에는 정수가 하나 적혀있는데, 적혀있는 수는 -262보다 크거나 같고, 262보다 작거나 같다.

준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오. 만약, 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다.
  *
  * */

#include <iostream>
#include <stdio.h>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int main(){
    int N;
    int ans_count = 1;
    int count = 1;
    long long number;
    vector<long long> vec; // 2^64라서 long long 사용

    printf("수입력 : ");
    scanf("%d", &N);

    for (int i=0; i<N; i++){
        scanf("%lld", &number);
        vec.push_back(number);

    } // 벡터에 입력받음..

    sort(vec.begin(), vec.end()); //벡터 정렬시켜줌

    //정렬시켜주고.. 카운트해야함.
    long long answer = vec[0];

    for(int i=1; i< N; i++){
        if(vec[i] == vec[i-1]){
            count += 1;
        }

        else count = 1;

        if(ans_count < count){
            ans_count = count;
            answer = vec[i];
        }
    }


    printf("%lld, %d", answer, ans_count);


    return 0;
}