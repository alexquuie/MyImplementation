//
//  main.cpp
//  Repeated DNA Testing Bit Operationg
//
//  Created by Zhongyan QIU on 9/27/15.
//  Copyright © 2015 Zhongyan QIU. All rights reserved.
//

#include <iostream>
#include <bitset>
#include <vector>
#include <unordered_map>
using namespace std;

vector<string> findRepeatedDnaSequences(string s) {
    vector<string> res;
    if(s.size()<9)return res;
    unordered_map<int,int> buffer;
    /*int mask = INT_MIN;
     bitset<32> tmpset = INT_MAX>>28;
     cout<<"0x: "<<tmpset<<endl;
     tmpset = 0x7ffffff;
     cout<<"INT_MIN>>3: "<<tmpset<<endl;
     tmpset = 'A';
     cout<<"A: "<<tmpset<<endl;*/
    bitset<32> tmpset;
    int mask = INT_MAX>>1;
    tmpset = mask;
    cout<<"mask: "<<tmpset<<endl;
    int cur = 0;
    for(int i=0;i<s.size();i++){
        if(i<9){
            cur = (cur<<3)|(s[i]&7);
            tmpset = cur;
            cout<<i<<" :"<<tmpset<<endl;
        }else{
            cur = (cur<<3)|(s[i]&7);
            cur&=mask;
            tmpset = cur;
            cout<<i<<" :"<<tmpset<<endl;
            if(buffer.find(cur)==buffer.end()){
                cout<<"idx: "<<i<<". Insert once!"<<endl;
                buffer[cur]=1;
            }
            else {
                cout<<"find one!"<<endl;
                buffer[cur]++;
            }
            
            if(buffer[cur]==1){
                cout<<"insert one!"<<endl;
                res.push_back(s.substr(i-9,10));
            }
        }
        
    }
    return res;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    /*
    bitset<32> tmpset;
    tmpset = 1<<2;
    cout<<tmpset<<endl;
    tmpset = INT_MAX<<2;
    cout<<tmpset<<endl;
    tmpset = (INT_MIN+1)<<2;
    cout<<tmpset<<endl;*/
    
    string dna = "AAAAAAAAAAA";
    vector<string> res = findRepeatedDnaSequences(dna);
    cout<<"Result size is: "<<res.size()<<endl;
    std::cout << "Hello, World!\n";
    return 0;
}
