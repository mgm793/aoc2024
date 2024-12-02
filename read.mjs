import fs from "node:fs";

export function read(fileName) {
  return fs.readFileSync(fileName, "utf8");
}
