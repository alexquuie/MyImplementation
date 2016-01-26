//
//  main.cpp
//  divide two integers
//
//  Created by Zhongyan QIU on 9/15/15.
//  Copyright (c) 2015 Zhongyan QIU. All rights reserved.
//

#include <iostream>
#include <climits>
#include <bitset>
using namespace std;
int divide(int dividend, int divisor) {
    if (divisor == 0 || (dividend == INT_MIN && divisor == -1)) return INT_MAX;
    long m = labs(dividend), n = labs(divisor), res = 0;
    long sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
    if (n == 1) return m * sign;
    bitset<32> kset;
    bitset<32> mset;
    while (m >= n) {
        long k = n;
        int i = 0;
        cout<<"Assign value"<<endl;
        while (k <= m) {
            mset = m;
            cout<<"m: "<<m<<" mset:"<<mset<<endl;
            kset = k;
            cout<<"k: "<<k<<" kset:"<<kset<<endl;

            m -= k;
            k <<= 1;
            res += 1 << i;
            kset = res;
            cout<<"res: "<<res<<" res_set:"<<kset<<endl;

            ++i;
        }
    }
    return (res * sign);
}

int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    
    cout<<divide(21137,5)<<endl;
    return 0;
}
