//백준 10799


#include <stdio.h>
#include <iostream>
#include <string>
#include <stack>
using namespace std;



int main() {
    string metal_stick;
    stack<char> laser_stack;
    int result = 0;

    getline(cin, metal_stick); // 입력받기


    //입력받은 string을 하나씩 stack에 넣으며 조건에 맞을때 빼고 result에 추가
    for (int i = 0; i < metal_stick.size(); i++) {
        if (metal_stick[i] == '(') {
            laser_stack.push(metal_stick[i]);
        } else {
            laser_stack.pop();
            if (metal_stick[i - 1] == '(') {
                result = result + metal_stick.size();
            } else {
                result += 1;
            }

        }
    }

    printf("%d", result);

    return 0;
}