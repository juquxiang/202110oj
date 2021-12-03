#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define N 600
vector<string> toPost(string s){
	stack<char> sta;
	string one;      // 可能是两位数
	vector<string> post;
	for(char& i:s){
		if(i>='0' && i<='9')
			one += i;
		else{
			if(one.size()){
				post.push_back(one);
				one="";
			}

			if(i=='(') sta.push(i);
			else if(i==')'){
				while(sta.top()!='('){
					post.push_back(string(1,sta.top()));
					sta.pop();
				}
				sta.pop();
			}
			else if(i=='+' || i=='-'){
				while(sta.size() && sta.top()!='('){
					post.push_back(string(1,sta.top()));
					sta.pop();
				}

				sta.push(i);
			}

			else if(i=='*' || i=='/'){
				while(sta.size() && (sta.top()=='*' || sta.top() == '/') ){
					post.push_back(string(1,sta.top()));
					sta.pop();
				}

				sta.push(i);
			}


		}
	}
	if(one.size()) post.push_back(one); // 别忘了检查one 可能还有值没存
	while(sta.size()){
		post.push_back(string(1,sta.top()));
		sta.pop();
	}

	return post;
}
int main(){
    string a,b;
    // fstream f;
    // f.open("print.txt",ios::in);
    while(cin>>a){
        b=b+a;
    }
    for(auto y:toPost(b))cout<<y<<" ";

}