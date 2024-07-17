class MaximumSubarraySum {
  arr: Array<number>;
  n: number;

  constructor(arr: Array<number>) {
    this.arr = arr;
    this.n = arr.length;
  }

  bruteForce() {
    let maxSum = -Infinity;

    for (let i = 0; i < this.n; i++) {
      let sum = 0;
      for (let j = i; j < this.n; j++) {
        sum += this.arr[j];
        maxSum = Math.max(maxSum, sum);
      }
    }

    return maxSum;
  }

  better() {
    let maxSum = -Infinity;
    let sum = 0;
    this.arr.forEach((num) => {
      sum += num;
      maxSum = Math.max(sum, maxSum);
      if (sum < 0) {
        sum = 0;
      }
    });

    return maxSum;
  }
}
