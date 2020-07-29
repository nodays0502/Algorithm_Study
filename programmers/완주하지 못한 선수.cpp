#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    sort(participant.begin(),participant.end());
    sort(completion.begin(),completion.end());
    int i;
    for(i =0;i<completion.size();i++)
    {
        if( participant[i] != completion[i]){break;}
    }
    return participant[i];
}
/*string solution(vector<string> participant, vector<string> completion) {
    vector<string>::iterator it;
    for(int j =0;j<completion.size();j++)
    {
        bool ok = false;
         for(it=participant.begin();it<participant.end();it++){
            if(*it == completion[j]) {ok = true;participant.erase(it); break;}
        }
        if(!ok) {break;}
    }
    return participant[0];
}*/
