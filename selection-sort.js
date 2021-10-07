let A = [1,598,36,9,0,1,66,12,8,79,262];

for (let i = 0; i < A.length - 1; i++) {
    let leastIndex = i;
    for (let j = i; j < A.length; j++) {
        if (A[j] < A[leastIndex]){
            leastIndex = j;
        }
    }
    [A[i],A[leastIndex]] = [A[leastIndex],A[i]]
}

console.log(A);
