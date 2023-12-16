#include <bits/stdc++.h>
using namespace std;

const int maxN = 5000;
const int INF = (int)1e9;
typedef pair<int, int> ii;

vector<ii> adj[maxN];
int n, m, s; 


void Dijkstra(int s) {
    priority_queue<ii, vector<ii>, greater<ii>> q;
    vector<int> d(n + 1, INF);
    d[s] = 0;
    q.push({0, s});
    
    while (!q.empty()) {
        ii t = q.top(); q.pop();
        int dis = t.first, u = t.second;
        
        if (dis > d[u]) continue;
        
        for (ii e : adj[u]) {
            int v = e.first, w = e.second;
            if (d[v] > d[u] + w) {
                d[v] = d[u] + w;
                q.push({d[v], v});
            }
        }
    }
    
    for (int i = 1; i <= n; ++i) {
        if (i == s) continue;
        if (d[i] == INF) cout << -1 << ' ';
        else cout << d[i] << ' ';
    }
    cout << "\n";
}

int main() {
    int t; cin >> t;
    for (int i = 0; i < t; ++i) {
        cin >> n >> m;
        for (int i = 0; i < m; ++i) {
            int x, y, z; cin >> x >> y >> z;
            adj[x].push_back({y, z});
            adj[y].push_back({x, z});
        }
        cin >> s;
        Dijkstra(s);
        for (int i = 1; i <= n; ++i) {
            adj[i].clear();
        }
    }
}
