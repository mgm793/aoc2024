import { read } from "./read.mjs";

function firstPart(lines) {
  let res = 0;
  for (const line of lines) {
    const numbers = line.split(" ");
    let isPos = false;
    let isNeg = false;
    let i = 0;
    for (i = 1; i < numbers.length; ++i) {
      const diff = numbers[i] - numbers[i - 1];
      if (diff > 0) isPos = true;
      if (diff < 0) isNeg = true;
      if (diff === 0) break;
      if (Math.abs(diff) > 3) break;
      if (isPos && isNeg) break;
    }
    if (i === numbers.length) ++res;
  }
  return res;
}

function secondPart(lines) {
  let res = 0;
  function isSafe(numbers) {
    let isPos = false;
    let isNeg = false;
    let i = 0;
    for (i = 1; i < numbers.length; ++i) {
      const diff = numbers[i] - numbers[i - 1];
      if (diff > 0) isPos = true;
      if (diff < 0) isNeg = true;
      if (diff === 0 || Math.abs(diff) > 3 || (isPos && isNeg)) {
        return i - 1;
      }
    }
    return -1;
  }
  for (const line of lines) {
    const numbers = line.split(" ");
    let errorFound = false;
    const isSafeStart = isSafe(numbers);
    if (isSafeStart === -1) {
      ++res;
      continue;
    }
    let i = 0;
    for (i = 0; i < numbers.length; ++i) {
      const newArr = [...numbers];
      newArr.splice(i, 1);
      const safe = isSafe(newArr);
      if (errorFound && !safe) break;
      if (!safe) errorFound = true;
    }
    if (i === numbers.length) ++res;
  }
  return res;
}

(function main() {
  const file = read("input_2.txt");
  const lines = file.split("\n");
  console.log(firstPart(lines));
  console.log(secondPart(lines));
})();
