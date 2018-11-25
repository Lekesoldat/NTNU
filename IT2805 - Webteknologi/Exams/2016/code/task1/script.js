const num1 = document.getElementById('num1');
const num2 = document.getElementById('num2');
const answer = document.getElementById('answer');

const calculate = () => {
  if (num1.value === num2.value) {
    answer.innerText = 'The numbers are equal.';
  } else {
    const largest = Math.max(num1.value, num2.value);
    const smallest = Math.min(num1.value, num2.value);
    answer.innerText = `${ smallest } is smaller than ${ largest }`;
  }
}