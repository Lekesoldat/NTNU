/* Canvas 1 */
const canvas1 = document.getElementById('canvas1');
const c1 = canvas1.getContext('2d');

c1.fillStyle = "rgb(0,204,153)";
c1.lineWidth = "2";

// Outer Square
c1.beginPath();
c1.moveTo(10, 5);
c1.lineTo(10, 90);
c1.lineTo(100, 90);
c1.lineTo(100, 5);
c1.closePath();
c1.stroke();

// UL to BR
c1.beginPath();
c1.moveTo(10, 5);
c1.lineTo(100, 90);
c1.closePath();
c1.stroke();

// UR to BL
c1.beginPath();
c1.moveTo(100, 5);
c1.lineTo(10, 90);
c1.closePath();
c1.stroke();

// Mid vertical
c1.beginPath();
c1.moveTo(55, 5);
c1.lineTo(55, 90);
c1.closePath();
c1.stroke();

// Circle
c1.beginPath();
c1.arc(55, 47.5, 43, 0, 2 * Math.PI, false);
c1.closePath();
c1.stroke();



/* Canvas 2 */
const canvas2 = document.getElementById('canvas2');
const c2 = canvas2.getContext('2d');

c2.fillStyle = "red";
c2.lineWidth = "2";
c2.strokeStyle = "red";

// Left testicle
c2.beginPath();
c2.arc(30, 70, 10, 0, 2 * Math.PI, false);
c2.closePath();
c2.stroke();

// Right testicle
c2.beginPath()
c2.arc(50, 70, 10, 0, 2 * Math.PI, false);
c2.closePath();
c2.stroke();

// Left shaft
c2.beginPath();
c2.moveTo(30, 60);
c2.lineTo(30, 30);
c2.closePath();
c2.stroke();

// Right shaft
c2.beginPath();
c2.moveTo(50, 60);
c2.lineTo(50, 30);
c2.closePath();
c2.stroke();

// Tip
c2.beginPath();
c2.arc(40, 30, 10, 0, Math.PI, true);
c2.closePath();
c2.stroke();

// Split
c2.beginPath();
c2.moveTo(40, 20);
c2.lineTo(40, 30);
c2.stroke();

/* Canvas 3 */
const sun = new Image();
const moon = new Image();
const earth = new Image();
function init() {
  sun.src = 'https://mdn.mozillademos.org/files/1456/Canvas_sun.png';
  moon.src = 'https://mdn.mozillademos.org/files/1443/Canvas_moon.png';
  earth.src = 'https://mdn.mozillademos.org/files/1429/Canvas_earth.png';
  window.requestAnimationFrame(draw);
}

function draw() {
  const ctx = document.getElementById('canvas3').getContext('2d');

  ctx.globalCompositeOperation = 'destination-over';
  ctx.clearRect(0, 0, 300, 300); // clear canvas

  ctx.fillStyle = 'rgba(0, 0, 0, 0.4)';
  ctx.strokeStyle = 'rgba(0, 153, 255, 0.4)';
  ctx.save();
  ctx.translate(150, 150);

  // Earth
  const time = new Date();
  ctx.rotate(((2 * Math.PI) / 60) * time.getSeconds() + ((2 * Math.PI) / 60000) * time.getMilliseconds());
  ctx.translate(105, 0);
  ctx.fillRect(0, -12, 40, 24); // Shadow
  ctx.drawImage(earth, -12, -12);

  // Moon
  ctx.save();
  ctx.rotate(((2 * Math.PI) / 6) * time.getSeconds() + ((2 * Math.PI) / 6000) * time.getMilliseconds());
  ctx.translate(0, 28.5);
  ctx.drawImage(moon, -3.5, -3.5);
  ctx.restore();

  ctx.restore();

  ctx.beginPath();
  ctx.arc(150, 150, 105, 0, Math.PI * 2, false); // Earth orbit
  ctx.stroke();

  ctx.drawImage(sun, 0, 0, 300, 300);

  window.requestAnimationFrame(draw);
}

init();


/* Canvas 4 */
const canvas4 = document.getElementById('canvas4');
const c4 = canvas4.getContext('2d');


// Body
// Setup styling
c4.fillStyle = "purple";
c4.lineWidth = "2";
c4.strokeStyle = "purple";

c4.beginPath();
c4.moveTo(20, 160);
c4.lineTo(60, 175);
c4.lineTo(150, 175);
c4.lineTo(180, 160);
c4.closePath();
c4.fill();
c4.stroke();

// Pole
// Setup Styling
c4.strokeStyle = "red";

c4.beginPath();
c4.moveTo(100, 160);
c4.lineTo(100, 30);
c4.closePath();
c4.stroke();

// Left flag
c4.fillStyle = "orange";
c4.strokeStyle = "orange";

c4.beginPath();
c4.moveTo(45, 150);
c4.lineTo(90, 130);
c4.lineTo(90, 35);
c4.closePath();
c4.fill();
c4.stroke();

// Right Flag
c4.fillStyle = "blue";
c4.strokeStyle = "blue";

c4.beginPath();
c4.moveTo(110, 35);
c4.lineTo(110, 150);
c4.lineTo(160, 150);
c4.closePath();
c4.fill();
c4.stroke();


/* Canvas 5 */
const canvas5 = document.getElementById('canvas5');
const c5 = canvas5.getContext('2d');

c5.strokeStyle = "black";

// VP
c5.beginPath();
c5.arc(50, 50, 50, 0, Math.PI * 2, true);
c5.closePath();
c5.stroke();

// VN
c5.fillStyle = "red";

c5.beginPath();
c5.arc(50, 50, 10, 0, Math.PI * 2, true);
c5.closePath();
c5.fill();
c5.stroke();


// HP
c5.beginPath();
c5.arc(150, 50, 50, 0, Math.PI * 2, true);
c5.closePath();
c5.stroke();

// HN
c5.fillStyle = "red";

c5.beginPath();
c5.arc(150, 50, 10, 0, Math.PI * 2, true);
c5.closePath();
c5.fill();
c5.stroke();

c5.beginPath();
c5.moveTo(200, 50);
c5.lineTo(215, 45);
c5.lineTo(220, 50);
c5.stroke();

// Smiley in frame
const canvas6 = document.getElementById('canvas6');
const c6 = canvas6.getContext('2d');

c6.strokeStyle = "black";
c6.fillStyle = "black";

// Frame
c6.rect(10, 10, 200, 200);
c6.stroke();

c6.beginPath();
c6.arc(110, 110, 100, 0, Math.PI * 2, true);
c6.closePath();
c6.stroke();

c6.beginPath();
c6.arc(110, 110, 70, 0, Math.PI, false);
c6.stroke();

c6.beginPath();
c6.arc(70, 70, 20, 0, Math.PI * 2, true);
c6.closePath();
c6.stroke();

c6.beginPath();
c6.arc(150, 70, 20, 0, Math.PI * 2, true);
c6.closePath();
c6.stroke();

// Random test
const addLines = () => {
  const element = document.getElementById('linesGoHere');
  let i = 0;
  while (i < 10) {
    element.innerHTML += `<br> tallet er ${i++}`;
  }
}