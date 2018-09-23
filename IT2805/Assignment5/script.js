/* Using const for constants, let for other variables. */

/* Part 2 */
console.log('PART 2');

// Declares variable i and logs numbers 1 to 20.
for (let i = 1; i < 21; i++) {
    console.log(i);
}

/* Part 3 */
console.log('PART 3');

const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20];

// Traversing the array
for (let i = 0; i < numbers.length; i++) {
    // If divisible by 3, log 'eple'
    if (numbers[i] % 3 === 0) {

        // If divisible by 5 aswell, log 'eplekake'
        if (numbers[i] % 5 === 0) {
            console.log("eplekake");
        } else {
            console.log("eple");
        }

    // If divisible by 5 and not 3
    } else if (numbers[i] % 5 === 0) {
        console.log("kake");

    } else {
        console.log(numbers[i]);
    }
}

/* Part 4 */
// Grabs the element and sets innerText.
document.getElementById("title").innerText = "Hello, JavaScript";

/* Part 5 */
// Grab the element with id 'magic'
const magic = document.getElementById("magic");

// Display: none;
function changeDisplay () {
    magic.style.display = "none";
}

// Display: block; Visibility: hidden;
function changeVisibility () {
    magic.style.visibility = "hidden";
    magic.style.display = "block;"
}

// Display: block; Visibility: visible;
function reset () {
    magic.style.display = "block";
    magic.style.visibility = "visible";
}

/* Part 6 */
const technologies = [
    'HTML5',
    'CSS3',
    'JavaScript',
    'Python',
    'Java',
    'AJAX',
    'JSON',
    'React',
    'Angular',
    'Bootstrap',
    'Node.js'
];

// Grabs the list
const techList = document.getElementById("tech");

// Loops through technologies
for (let i = 0; i < technologies.length; i++) {
    // Create a list item
    const item = document.createElement("li");
    
    // Set innertext from technologies[]
    item.innerText = technologies[i];

    // Append item to techList
    techList.appendChild(item);
}

/*
// Alternative solution
for (let i = 0; i < technologies.length; i++) {
    techList.innerHTML += "<li>" + technologies[i] + "</li>";
}
*/

