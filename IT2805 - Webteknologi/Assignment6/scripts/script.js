const tax = document.getElementById("taxID");       // Grabs tax field.
const wealth = document.getElementById("wealthID"); // Grabs wealth field.
const income = document.getElementById("incomeID"); // Grabs income field.

function calculateTax() {
  // Set tax.value equal to the calculation of tax
  tax.value = (0.35 * income.value) + (0.25 * wealth.value)
}