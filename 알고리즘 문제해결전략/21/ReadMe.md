vector indexing
---
vector<int> slice(vector<int>e, int a,int b)
{
  return vector<int>(e.begin()+a,e.begin+b); // b는 포함되지 않는다.
}
