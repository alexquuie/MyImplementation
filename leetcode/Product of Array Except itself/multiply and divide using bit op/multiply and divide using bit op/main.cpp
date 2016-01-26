//
//  main.cpp
//  multiply and divide using bit op
//
//  Created by Zhongyan QIU on 9/22/15.
//  Copyright © 2015 Zhongyan QIU. All rights reserved.
//

#include <iostream>
#include <bitset>
using namespace std;
/*
int divide(int a,int b){
    int res = 0;
    while(b){
        if(b&1)a>>=1;
        b>>=1;
    }
    return a;
}
int multip(int a,int b){
    int res = 0;
    while(b!=0){
        //cout<<"flag: "<<(b&1)<<endl;
        if(b&1)res+=a;
        a<<=1;
        //cout<<"a: "<<a<<endl;
        b>>=1;
        //cout<<"b: "<<b<<endl;
    }
    return res;
}
*/
int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    int n=137;
    bitset<32> tmpset(n);
    cout<<tmpset<<endl;
    tmpset = -n;
    cout<<tmpset<<endl;
    tmpset = n&-n;
    cout<<tmpset<<endl;
    /*
    cout<<divide(10222,637)<<endl;
    cout<<10222/637<<endl;
    cout<<divide(10,3)<<endl;
    cout<<divide(1,4)<<endl;
    cout<<multip(3,2)<<endl;
    cout<<multip(4,5)<<endl;
    cout<<multip(32,167)<<endl;
    cout<<32*167<<endl;
    cout<<multip(11,2)<<endl;*/
    return 0;
}
