#include <bits/stdc++.h>
using namespace std;

struct edge {
    int x, y, z;  
};

const int maxN = 4000;
vector<edge> e;
int parent[maxN], sze[maxN];
int n, m;

void makeSet() {
    for (int i = 1; i <= n; ++i) {
        parent[i] = i;
        sze[i] = 1;
    }
}

int find(int u) {
    if (u == parent[u]) return u;
    return (parent[u] = find(parent[u]));
}

bool Union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b) return false;
    if (sze[a] < sze[b]) swap(a, b);
    sze[a] += sze[b];
    parent[b] = a;
    return true;
}

void input() {
    cin >> n >> m;
    
    for (int i = 0; i < m; ++i) {
        int a, b, c; cin >> a >> b >> c;
        e.push_back({a, b, c});
    }
}

void Kruskal() {
    vector<edge> MST;
    int d = 0;
    
    sort(begin(e), end(e), [](edge a, edge b) {
        return a.z < b.z;
    });
    
    for (auto a : e) {
        if (MST.size() == n - 1) break;
        if (Union(a.x, a.y)) { 
            MST.push_back(a);
            d += a.z;
        }
    }
    
    cout << d;
}

int main() {
    input();
    makeSet();
    Kruskal();
    return 0;
}

