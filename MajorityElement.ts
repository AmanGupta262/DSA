class MajorityElement {
  bruteForce(arr: Array<number>) {
    let frequentNum;
    let maxCount = 0;

    for (let i = 0; i < arr.length; i++) {
      let count = 0;
      for (let j = i; j < arr.length; j++) {
        if (arr[i] === arr[j]) {
          count++;
        }
      }
      if (count > maxCount) {
        maxCount = count;
        frequentNum = arr[i];
      }
    }

    maxCount = 0;
    arr.forEach((num) => {
      if (num === frequentNum) {
        maxCount++;
      }
    });

    return maxCount > Math.floor(arr.length / 2) ? frequentNum : -1;
  }

  better(arr: Array<number>) {
    const count = new Map<number, number>();
    let frequentNum: number = -Infinity;
    let max = 0;

    arr.forEach((num) => {
      if (!count.has(num)) {
        count.set(num, 0);
      }
      const totalCount = count.get(num)! + 1;
      if (totalCount > max) {
        max = totalCount;
        frequentNum = num;
      }
      count.set(num, totalCount);
    });

    return max > Math.floor(arr.length / 2) ? frequentNum : -1;
  }

  best(arr: Array<number>) {
    let count = 0;
    let frequentNum = arr[0];

    arr.forEach((num) => {
      if (count === 0) {
        frequentNum = num;
      }
      if (num === frequentNum) {
        count++;
      } else {
        count--;
      }
    });

    count = 0;
    arr.forEach((num) => {
      if (num === frequentNum) {
        count++;
      }
    });

    return count > Math.floor(arr.length / 2) ? frequentNum : -1;
  }
}
