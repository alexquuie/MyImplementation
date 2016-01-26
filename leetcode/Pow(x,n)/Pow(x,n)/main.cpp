//
//  main.cpp
//  Pow(x,n)
//
//  Created by Zhongyan QIU on 9/15/15.
//  Copyright (c) 2015 Zhongyan QIU. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;
double recur(double x, int idx,vector<double> &mem, vector<bool> &visited){
    if(!visited[idx]){
        int preidx = idx/2;
        double pre = recur(x, preidx, mem, visited);
        int posidx = idx - preidx;
        double pos = recur(x, posidx, mem, visited);
        visited[idx]  = true;
        mem[idx] = pre*pos;
    }
    return mem[idx];
}
double myPow(double x, int n) {
    if(x==0)return 0;
    int idx = abs(n);
    vector<double> mem(idx,x);
    vector<bool> visited(idx,false);
    mem[0] = 1;
    visited[0] = true;
    visited[1] = true;
    double res = recur(x, idx, mem, visited);
    return n>0?res:1.0/res;
}
int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    cout<<myPow(8.88023, -3)<<endl;
    return 0;
}
