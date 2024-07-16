class SortColors {
  sort(arr: Array<number>) {
    let start = 0;
    let mid = 0;
    let end = arr.length - 1;

    while (start < end && mid < end) {
      if (arr[mid] === 0) {
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
