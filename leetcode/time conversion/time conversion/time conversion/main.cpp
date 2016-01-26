//
//  main.cpp
//  time conversion
//
//  Created by Zhongyan QIU on 10/15/15.
//  Copyright © 2015 Zhongyan QIU. All rights reserved.
//

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include<string>
#include <algorithm>
using namespace std;
void timeConversion(string time12){
    if(time12=="12:00:00AM")cout<<"00:00:00"<<endl;
    else if(time12=="12:00:00PM")cout<<"12:00:00"<<endl;
    else{
        int n = time12.length();
        if(time12[n-2]=='A'){
            string f = time12.substr(0,2);
            int tmpv = stoi(f);
            if(tmpv==12)
            f = "00";
            time12[0]=f[0];
            time12[1]=f[1];
            cout<<time12.substr(0,n-2)<<endl;
        }else{
            string f = time12.substr(0,2);
            int tmpv = stoi(f);
            tmpv+=12;
            f = to_string(tmpv);
            time12[0]=f[0];
            time12[1]=f[1];
            cout<<time12.substr(0,n-2)<<endl;
        }
    }
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    string time;
    time ="12:00:00AM";
    timeConversion(time);
    time ="12:00:00PM";
    timeConversion(time);
    time ="11:05:45PM";
    timeConversion(time);
    time ="07:05:45AM";
    timeConversion(time);
    time ="12:05:45AM";
    timeConversion(time);
    time ="07:05:45AM";
    timeConversion(time);
    return 0;
}
