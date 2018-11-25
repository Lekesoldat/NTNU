const canvas = document.getElementById('myCanvas');
const context = canvas.getContext('2d');

/* The boat */
context.fillStyle = "rgb(0,204,153)";
context.lineWidth = "2";
context.beginPath();

// Top left corner
context.moveTo(25, 160);

// Bottom left
context.lineTo(70, 180);

// Bottom right
context.lineTo(150, 180);

// Top right
context.lineTo(175, 160);

// Finnish off top line
context.closePath();

// Set line stroke
context.stroke();

// Fill boat with color
context.fill();


/* Pole */
context.beginPath();
context.lineWidth = 5;

// Center at boat, top of line
context.moveTo(100, 160);

// Set height
context.lineTo(100, 50);
context.stroke();


/* Left sail */
context.beginPath();
context.fillStyle = "rgb(255,255,0)";

// Top
context.moveTo(96, 50);

// Bottom left
context.lineTo(50, 155);

// Bottom right
context.lineTo(90, 140);
context.fill();


/* Right sail */
context.beginPath();

// Top
context.moveTo(104, 50);

// Right
context.lineTo(160, 150);

// Left
context.lineTo(110, 150);
context.fill();
