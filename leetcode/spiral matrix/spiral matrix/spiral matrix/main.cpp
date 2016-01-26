//
//  main.cpp
//  spiral matrix
//
//  Created by Zhongyan QIU on 9/10/15.
//  Copyright (c) 2015 Zhongyan QIU. All rights reserved.
//

#include <iostream>
#include <vector>
#include <map>
using namespace std;
class mycompare { // simple comparison function
public:
    bool operator()(const pair<int,int> p1,const pair<int,int> p2) { return p1.first>p2.first; } // returns x>y
};

    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        
        vector<int> res;
        int m = matrix.size();
        if(m==0)return res;
        int n = matrix[0].size();
        if(n==0)return res;
        vector<vector<bool>> visited(m,vector<bool>(n,false));
        //initial status
        int x = 0 ;
        int y = 0;
        res.push_back(matrix[0][0]);
        int xstep = 0;
        int ystep = 1;
        
        cout<<"m:"<<m<<" OK "<<"n:"<<n<<endl;
        while(true){
            if(x+xstep>=0&&x+xstep<m&&y+ystep>=0&&y+ystep<n&&!visited[x+xstep][y+ystep]){
                x+=xstep;
                y+=ystep;
                visited[x][y] = true;
                cout<<x<<" OK "<<y<<endl;
                res.push_back(matrix[x][y]);
            }else{
                if(xstep==0&&ystep==1){
                    xstep = 1;
                    ystep = 0;
                }else if(xstep==1&&ystep==0){
                    xstep = 0;
                    ystep = -1;
                }else if(xstep==0&&ystep==-1){
                    xstep = -1;
                    ystep = 0;
                }else if(xstep==-1&&ystep==0){
                    xstep = 0;
                    ystep = 1;
                }
                
                cout<<xstep<<" OK "<<ystep<<endl;
                if(x+xstep<0||x+xstep>=m||y+ystep<0||y+ystep>=n||visited[x+xstep][y+ystep])break;
            }
        }
        return res;
    }

int main(int argc, const char * argv[]) {
    // insert code here...
    vector<int> row1={2,3};
    vector<vector<int>> test1;
    test1.push_back(row1);
    vector<int> res1 = spiralOrder(test1);
    for(int i=0;i<res1.size();i++){
        cout<<res1[i]<<" ";
    }
    cout<<endl;
    std::cout << "Hello, World!\n";
    return 0;
}
