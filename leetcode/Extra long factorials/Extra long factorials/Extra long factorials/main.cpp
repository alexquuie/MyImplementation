//
//  main.cpp
//  Extra long factorials
//
//  Created by Zhongyan QIU on 10/14/15.
//  Copyright © 2015 Zhongyan QIU. All rights reserved.
//
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <climits>
#include <algorithm>
#include <cstdint>
#include <string>
using namespace std;

void print_uint128(unsigned __int128 n){
    if (n == 0) {
        return;
    }
    print_uint128(n/10);
    putchar(n%10+0x30);
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int n = 30;
    //cin>>n;
    vector<unsigned __int128> buffer(n+1,1);
    for(int i=1;i<=n;i++){
        buffer[i] *= buffer[i-1]*i;
    }
    //if(buffer[n]>LLONG_MAX)cout<<LLONG_MAX<<endl;
    //else
    print_uint128(buffer[n]);
    return 0;
}