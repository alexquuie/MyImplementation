//
//  main.cpp
//  Pointer size
//
//  Created by Zhongyan QIU on 10/8/15.
//  Copyright © 2015 Zhongyan QIU. All rights reserved.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    // insert code here...
    char s[] = "12345";
    char *p= "1234566656";
    char a[] = {'a','b','c','d','f'};
    cout<<sizeof(s)<<" "<<sizeof(p)<<" "<<sizeof(*p)<<endl;
    cout<<sizeof(a)<<endl;
    std::cout << "Hello, World!\n";
    return 0;
}
