/*
 * 백준 11656
 *
 * 접미사 배열은 문자열 S의 모든 접미사를 사전순으로 정렬해 놓은 배열이다.

baekjoon의 접미사는 baekjoon, aekjoon, ekjoon, kjoon, joon, oon, on, n 으로 총 8가지가 있고, 이를 사전순으로 정렬하면, aekjoon, baekjoon, ekjoon, joon, kjoon, n, on, oon이 된다.

문자열 S가 주어졌을 때, 모든 접미사를 사전순으로 정렬한 다음 출력하는 프로그램을 작성하시오.
 * */

#include <iostream>
#include <stdio.h>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;


int main(){
    int n;
    string s;
    string *str;


    printf("문자입력\n");
    getline(cin, s);

    str = new string[s.length()]; // 문자열 배열 생성 동적 배열

    for(int i=0; i< s.length(); i++){
        str[i] = s.substr(i, s.length()); //문자열 s의 i 부터 s.length()까지를 temp[i]에 저장
    }
    printf("정렬전\n");

    for(int i=0; i<s.length(); i++){
        cout<<str[i]<<endl;
    }

    sort(str, str+(s.length()));

    printf("정렬후\n");

    for(int i=0; i<s.length(); i++){
        cout<<str[i]<<endl;
    }

  return 0;
}