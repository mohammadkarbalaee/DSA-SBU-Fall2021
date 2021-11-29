let A = [10,9,8,7,6,5,4,3,2,1,0];

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
