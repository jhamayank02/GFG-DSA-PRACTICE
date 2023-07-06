#include<bits/stdc++.h>

// USING BINARY SEARCH
// Time complexity O(nlogn) || Space complexity O(n)
int longestIncreasingSubsequence(int arr[], int n)
{
   vector<int> temp;

    int len = 0;
    temp.push_back(arr[0]);
    len++;

    for(int i=1; i<n; i++){
        if(arr[i] > temp.back()){
            temp.push_back(arr[i]);
            len++;
        }
        else{
            int ind = lower_bound(temp.begin(),temp.end(),arr[i])-temp.begin();
            temp[ind] = arr[i];
        }
    }

    return len;

}
