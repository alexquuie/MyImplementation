//
//  main.cpp
//  binary_search
//
//  Created by Zhongyan QIU on 9/11/15.
//  Copyright (c) 2015 Zhongyan QIU. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;
bool binarySearch(vector<int> array, int Size, int key, int& location)
{
    int low = 0, high = Size - 1, midpoint = 0;
    while (low <= high)
    {
        midpoint = low + (high - low)/2;
        if (key== array[midpoint])
        {
            location = midpoint;
            return true;
        }
        else if (key< array[midpoint])
            high = midpoint - 1;
        else
            low = midpoint + 1; //when key is > array[midpoint]
    }
    return false;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    vector<int> test1 = {1,1};
    int location = 0;
    cout<<binarySearch(test1, 2, 0, location)<<endl;
    cout<<location<<endl;
    vector<int> test2 = {1};
    cout<<binarySearch(test2, 2, 0, location)<<endl;
    cout<<location<<endl;
    
    cout<<binarySearch(test2, 2, 2, location)<<endl;
    cout<<location<<endl;
    std::cout << "Hello, World!\n";
    return 0;
}
