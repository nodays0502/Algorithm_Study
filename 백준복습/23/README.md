priority_queue<T, Container, Compare>
---
cmp함수가 bool cmp(int t, int u) {return t>u;}라면
q.top()은 작은 값이 나온다
less<int>일시 제일 큰 값이 top이다.
greater<int>일시 제일 작은 값이 top이다.
