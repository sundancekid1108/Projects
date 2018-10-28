/*
 * 백준 2750
 * */

#include <iostream>
#include <stdio.h>
#include <vector>
#include <string>
using namespace std;



int main(){
    int n;
    int temp;

    printf("개수입력\n");
    scanf("%d", &n);
    int *array = new int[n];

    for(int i=0; i < n; i++){
        scanf("%d", &array[i]);

    }

    for(int i=0; i<n-1; i++){
        for(int j= i+1; j<n; j++){
            if(array[i]> array[j]){
                temp =array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }

    for(int j=0; j<n; j++){
        printf("%d", array[j]);
    }



    return 0;
}