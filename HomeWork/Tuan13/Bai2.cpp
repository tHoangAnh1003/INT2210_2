#include <bits/stdc++.h>
using namespace std;

const int maxN = 4000;
typedef pair<int, int> ii;

int n, m, s;
vector<ii> adj[maxN];
bool taken[maxN];

void input() {
    cin >> n >> m;
    for (int i = 0; i < m; ++i) {
        int x, y, w; cin >> x >> y >> w;
        adj[x].push_back({y, w});
        adj[y].push_back({x, w});
    }
    cin >> s;
}

void Prim(int s) {
    priority_queue<ii, vector<ii>, greater<ii>> q;
    int d = 0;
    q.push({0, s});
    
    while (!q.empty()) {
        ii t = q.top(); q.pop();
        int dinh = t.second, trongSo = t.first;
        
        if (!taken[dinh]) {
            taken[dinh] = true;
            d += trongSo;
            
            for (ii e : adj[dinh]) {
                int y = e.first, w = e.second;
                if (!taken[y]) {
                    q.push({w, y});
                }
            }
        }
    }
    cout << d << '\n';
}

int main() {
    input();
    Prim(s);
    return 0;
}
