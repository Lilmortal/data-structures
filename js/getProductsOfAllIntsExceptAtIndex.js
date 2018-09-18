const { performance } = require("perf_hooks");

function getProductsOfAllIntsExceptAtIndexLegacy(elements) {
  const result = [];
  for (let i = 0; i < elements.length; i++) {
    let product = 1;
    for (let j = 0; j < elements.length; j++) {
      if (typeof i !== "number" && typeof j !== "number") {
        console.error("Needs to be a number");
        break;
      }

      if (i !== j) {
        product *= elements[j];
      }
    }
    result.push(product);
  }

  return result;
}

function getProductsOfAllIntsExceptAtIndex(elements) {
  const result = [];
  const memoised = [];

  let product = 0;

  for (let i = 0; i < elements.length; i++) {
    if (typeof i !== "number") {
      console.error("Needs to be a number");
      break;
    }

    if (memoised[i] === undefined && memoised[i - 1] !== undefined) {
      memoised[i] = memoised[i - 1] * elements[i - 1];
    } else {
      memoised[i] = 1;
    }

    product *= memoised[i];
    result[i] = product;
  }

  for (let i = elements.length - 1; (i = 0); i--) {
    if (typeof i !== "number") {
      console.error("needs to be a number");
      break;
    }

    if (memoised[i] === undefined) {
      memoised[i - 1] = memoised[i] * elements[i];
    }

    console.log(memoised[i], memoised[i - 1]);
    product *= memoised[i];
    result[i] = product;
  }

  return result;
}

const elements = process.argv.slice(2);

const t0 = performance.now();
const legacyResult = getProductsOfAllIntsExceptAtIndexLegacy(elements);
const t1 = performance.now();

console.log("Time taken to run legacy: ", t1 - t0);

const p0 = performance.now();
const result = getProductsOfAllIntsExceptAtIndex(elements);
console.log(result);
const p1 = performance.now();

console.log("Time taken to run: ", p1 - p0);

if (legacyResult === result) {
  console.log("Correct result.");
} else {
  console.log("Incorrect result.");
}
