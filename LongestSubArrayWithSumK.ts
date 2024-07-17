class LongestSubArrayWithSumK {
  bruteForce(arr: Array<number>, k: number) {
    let maxLength = 0;
    for (let i = 0; i < arr.length; i++) {
      let sum = 0;
      for (let j = i; j < arr.length; j++) {
        sum += arr[j];
        if (sum === k && j - i + 1 > maxLength) {
          maxLength = j - i + 1;
        }
      }
    }

    return maxLength;
  }

  // best if array contains -ve numbers & zeroes
  better(arr: Array<number>, k: number) {
    const prefixSum = new Map<number, number>();

    let maxLen = 0;
    let sum = 0;

    for (let i = 0; i < arr.length; i++) {
      sum += arr[i];

      if (sum === k) {
        maxLen = Math.max(i + 1, maxLen);
      }

      let rem = sum - k;

      if (prefixSum.has(rem)) {
        maxLen = Math.max(maxLen, i - prefixSum.get(rem)!);
      }

      if (!prefixSum.has(sum)) {
        prefixSum.set(sum, i);
      }
    }

    return maxLen;
  }

  best(arr: Array<number>, k: number) {
    let i = 0;
    let j = 0;

    let maxLen = 0;
    let sum = arr[0];

    while (j < arr.length) {
      while (sum > k && i <= j) {
        sum -= arr[i];
        i++;
      }
      if (sum === k) {
        maxLen = Math.max(maxLen, j - i + 1);
      }

      j++;
      if (j < arr.length) {
        sum += arr[j];
      }
    }

    return maxLen;
  }
}
