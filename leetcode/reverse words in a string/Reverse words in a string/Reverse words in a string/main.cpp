//
//  main.cpp
//  Reverse words in a string
//
//  Created by Zhongyan QIU on 9/29/15.
//  Copyright © 2015 Zhongyan QIU. All rights reserved.
//

#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

void reverseWords(string &s) {
    bool word = false;
    int startIdx = 0;
    int endIdx = 0;
    int i = 0;
    while(i<s.size()){
        if(s[i]!=' '){
            if(word)endIdx++;
            else{
                startIdx = i;
                endIdx = i;
                word = true;
            }
        }else{
            if(word){
                word = false;
                reverse(s.begin()+startIdx,s.begin()+endIdx+1);
                cout<<"s:"<<startIdx<<" e: "<<endIdx;
            }
        }
        i++;
    }
    if(word){
        reverse(s.begin()+startIdx,s.begin()+endIdx+1);
        cout<<"s:"<<startIdx<<" e: "<<endIdx;
    }
    reverse(s.begin(),s.end());
    
    i = 0;
    while(i<s.size()){
        if(s[i]==' ')s.erase(s.begin()+i);
        else break;
    }
    while(s.back()==' '){
        s.pop_back();
    }
    i=0;
    bool space = false;
    while(i<s.size()){
        if(s[i]==' '&&space){
            s.erase(s.begin()+i);
        }else if(s[i]==' '){
            space = true;
            i++;
        }else{
            space = false;
            i++;
        }
        
    }
    
}

int main(int argc, const char * argv[]) {
    // insert code here...
    string s = "hi!";
    reverseWords(s);
    cout<<s<<endl;
    std::cout << "Hello, World!\n";
    return 0;
}
