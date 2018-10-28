#include <iostream>
#include <stdio.h>

using namespace std;

int main(){
    int number = 0;
    scanf("%d", &number);

    for(int i=0; i < number; i++){
       for(int j=0; j<i; j++){
           printf(" ");
       }
       for(int k = number; k>i; k--){
           printf("*");
       };
       printf("\n");

    };
    return 0;
}