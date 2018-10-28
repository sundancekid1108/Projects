#include <iostream>
#include <stdio.h>
#include <algorithm>
#include <stack>
using namespace std;

int fibo(int n){
    int result=0;
    if(n<2){
        return n;

    }
    else{
        return fibo(n-1) + fibo(n-2);

    }

}

int main(){
    int input;
    scanf("%d", &input);

    int a =0;
    int b = 1;
    int sum = 0;

    if(input == 0){
        printf("0");

    }
    else if(input == 1){
        printf("1");
    }
    else {
        for(int i = 1; i < input; i++){
            sum = a + b;
            a = b;
            b = sum;

        }
        printf("%d\n", sum);
    }

    printf("%d", fibo(input));





    return 0;
}

