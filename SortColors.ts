class SortColors {
  bruteForce(arr: Array<number>) {
    let count0 = 0;
    let count1 = 0;
    let count2 = 0;

    arr.forEach((num) => {
      if (num === 0) count0++;
      if (num === 1) count1++;
      if (num === 2) count2++;
    });

    for (let i = 0; i < count0; i++) {
      arr[i] = 0;
    }

    for (let i = count0; i < count0 + count1; i++) {
      arr[i] = 1;
    }

    for (let i = count0 + count1; i < arr.length; i++) {
      arr[i] = 2;
    }
  }

  sort(arr: Array<number>) {
    let start = 0;
    let mid = 0;
    let end = arr.length - 1;

    while (start <= end && mid <= end) {
      if (arr[mid] === 1) {
        mid += 1;
      } else if (arr[mid] == 0) {
        let temp = arr[mid];
        arr[mid] = arr[start];
        arr[start] = temp;
        start += 1;
        mid += 1;
      } else {
        let temp = arr[mid];
        arr[mid] = arr[end];
        arr[end] = temp;
        end -= 1;
      }
    }
  }
}
