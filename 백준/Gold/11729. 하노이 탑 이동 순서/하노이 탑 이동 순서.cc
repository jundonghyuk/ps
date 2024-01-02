#include <bits/stdc++.h>
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0)

using namespace std;

void hanoi (int n, vector<pair<int,int>> & v, int from, int via, int to) {
	if(n == 1) {
		v.push_back({from,to});
		return ;
	}
	
	hanoi(n-1,v,from,to,via);
	v.push_back({from,to});
	hanoi(n-1,v,via,from,to);
}
int main(){
	fastio;
	int n;
	cin >> n;
	vector<pair<int,int>> v;
	hanoi(n,v,1,2,3);
	cout << v.size() << '\n';
	for(int i = 0; i < v.size(); i++){
		cout << v[i].first << ' '<<v[i].second << '\n';
	}
	return 0;
}