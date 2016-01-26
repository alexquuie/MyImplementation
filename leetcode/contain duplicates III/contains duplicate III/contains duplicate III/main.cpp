//
//  main.cpp
//  contains duplicate III
//
//  Created by Zhongyan QIU on 10/4/15.
//  Copyright © 2015 Zhongyan QIU. All rights reserved.
//

#include <iostream>
#include<map>
using namespace std;
int main(int argc, const char * argv[]) {
    // insert code here...
    
    
    
    map<int,int> buffer;
    buffer.insert(pair<int,int>(2,0));
    buffer.insert(pair<int,int>(3,1));
    buffer.insert(pair<int,int>(4,2));
    buffer.insert(pair<int,int>(5,3));
    buffer.insert(pair<int,int>(6,4));
    map<int,int>::iterator it_low = buffer.lower_bound(3);
    map<int,int>::iterator it_up = buffer.lower_bound(6);
    
    map<int,int> tmp(it_low,it_up);
    //cout << "lower_bound at position " << (it_low- buffer.begin()) <<endl;
   // cout << "upper_bound at position " << (it_up - buffer.begin()) <<endl;
    cout<<tmp.size()<<endl;
    return 0;
}
