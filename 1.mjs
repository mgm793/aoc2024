import { read } from "./read.mjs";

function firstPart(file) {
  let res = 0;
  const lines = file.split("\n");
  const firstArr = [];
  const secondArr = [];
  for (const line of lines) {
    const splittedLine = line.split(" ");
    const [first, second] = [
      splittedLine[0],
      splittedLine[splittedLine.length - 1],
    ];
    if (first === "") continue;
    firstArr.push(first);
    secondArr.push(second);
  }
  firstArr.sort((a, b) => a - b);
  secondArr.sort((a, b) => a - b);
  for (let i = 0; i < firstArr.length; ++i) {
    res += Math.abs(secondArr[i] - firstArr[i]);
  }
  return res;
}

function secondPart(file) {
  let res = 0;
  const lines = file.split("\n");
  const firstArr = [];
  const secondArr = [];
  for (const line of lines) {
    const splittedLine = line.split(" ");
    const [first, second] = [
      splittedLine[0],
      splittedLine[splittedLine.length - 1],
    ];
    if (first === "") continue;
    firstArr.push(+first);
    secondArr.push(+second);
  }
  for (const firstVal of firstArr) {
    const similarity = secondArr.filter((val) => val === firstVal).length;
    if (similarity) console.log(similarity);
    res += firstVal * similarity;
  }
  return res;
}

(function main() {
  const file = read("input_1.txt");
  //console.log(firstPart(file));
  console.log(secondPart(file));
})();
