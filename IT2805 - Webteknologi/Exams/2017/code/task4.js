const result = document.getElementById('result');

const multiplyBy = () => {
  const number1 = document.getElementById('firstNumber');
  const number2 = document.getElementById('secondNumber');

  result.innerHTML = number1.value * number2.value;
}

const divide = () => {
  const number1 = document.getElementById('firstNumber');
  const number2 = document.getElementById('secondNumber');

  result.innerHTML = number1.value / number2.value;
}