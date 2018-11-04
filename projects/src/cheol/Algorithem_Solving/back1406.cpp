/*
 * 백준1406번 문제
 * */

#include <iostream>
#include <stdio.h>
#include <stack>
#include <string>
using namespace std;



int main(){
    stack<char> left, right;
    string s;//입력받은 문자열
    int n;//명령어 입력개수

    printf("문자입력\n");
    getline(cin, s); //문자열을 입력받는다.

    for(int i=0; i<s.size(); i++ ){
        left.push(s.at(i)); // .at(i)은 string의 특정문자 위치
    }//입력받은 문자열을 left stack에 집어넣는다.


    printf("명령어개수\n");
    scanf("%d", &n);

    for(int i=0; i<n; i++){
        char s; // 명령어
        cin >> s;

        if(s == 'L'){
            if(!left.empty()){
                right.push(left.top());
                left.pop();
            }
        }
        else if(s == 'D'){
            if(!right.empty()){
                left.push(right.top());
                right.pop();
            }


        }
        else if(s == 'B'){
            if(!left.empty()){
                left.pop();
            }
        }
        else {
            char c;
            cin >> c;
            left.push(c);
        }

    }
    while(!left.empty()){
        right.push(left.top());
        left.pop();

    }

    while(!right.empty()){
        cout<<right.top();
        right.pop();
    }
    printf("\n");
    return 0;
}