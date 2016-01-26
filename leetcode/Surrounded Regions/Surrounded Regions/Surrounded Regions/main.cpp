//
//  main.cpp
//  Surrounded Regions
//
//  Created by Zhongyan QIU on 9/21/15.
//  Copyright © 2015 Zhongyan QIU. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;
void dfs(vector<vector<char>>& board,vector<vector<bool>> &visited,int x,int y){
    if(visited[x][y]==true||board[x][y]=='X')return;
    int m = board.size();
    int n = board[0].size();
    visited[x][y]=true;
    if(x-1>=0)dfs(board,visited,x-1,y);
    if(y-1>=0)dfs(board,visited,x,y-1);
    if(x+1<board.size())dfs(board,visited,x+1,y);
    if(y+1<board[0].size())dfs(board,visited,x,y+1);
}

void solve(vector<vector<char>>& board) {
    int m = board.size();
    if(m<=2)return;
    int n = board[0].size();
    if(n<=2)return;
    vector<vector<bool>> visited(m,vector<bool>(n,false));
    
    for(int i=0;i<m;i++){
        dfs(board,visited,i,0);
        dfs(board,visited,i,n-1);
    }
    for(int i=1;i<n-1;i++){
        dfs(board,visited,0,i);
        dfs(board,visited,m-1,i);
    }
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(!visited[x][y]&&board[i][j] == 'O')
                board[i][j] = 'X';
        }
    }
}
int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
