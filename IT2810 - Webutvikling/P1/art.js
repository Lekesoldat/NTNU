const backgroundColors = [
  "#FF6633",
  "#FFB399",
  "#FF33FF",
  "#FFFF99",
  "#00B3E6",
  "#E6B333",
  "#3366E6",
  "#999966",
  "#99FF99",
  "#B34D4D",
  "#80B300",
  "#809900",
  "#E6B3B3",
  "#6680B3",
  "#66991A",
  "#FF99E6",
  "#CCFF1A",
  "#FF1A66",
  "#E6331A",
  "#33FFCC",
  "#66994D",
  "#B366CC",
  "#4D8000",
  "#B33300",
  "#CC80CC",
  "#66664D",
  "#991AFF",
  "#E666FF",
  "#4DB3FF",
  "#1AB399",
  "#E666B3",
  "#33991A",
  "#CC9999",
  "#B3B31A",
  "#00E680",
  "#4D8066",
  "#809980",
  "#E6FF80",
  "#1AFF33",
  "#999933",
  "#FF3380",
  "#CCCC00",
  "#66E64D",
  "#4D80CC",
  "#9900B3",
  "#E64D66",
  "#4DB380",
  "#FF4D4D",
  "#99E6E6",
  "#6666FF",
];

// Apply random background
$("#randomBackground").click(() => {
  const color =
    backgroundColors[Math.floor(Math.random() * backgroundColors.length)];

  // SVG
  $("#svgBackground").get(0).setAttribute("fill", color);

  // Canvas
  backgroundColor = color;
});

// Pause / unpause SVG animations
let isPlaying = true;
$("#svgChameleon").click(() => {
  if (isPlaying) {
    $("#svgChameleon").get(0).pauseAnimations();
  } else {
    $("#svgChameleon").get(0).unpauseAnimations();
  }

  isPlaying = !isPlaying;
});

// Disco mode
let disco = null;
$("#discoBackground").click(() => {
  $("#discoBackgroundDiv").hide();
  $("#stopDiscoBackground").show();

  clearInterval(main);
  main = setInterval(() => {
    draw();
  }, 1);

  disco = setInterval(() => {
    const color =
      backgroundColors[Math.floor(Math.random() * backgroundColors.length)];

    // SVG
    $("#svgBackground").get(0).setAttribute("fill", color);

    // Canvas
    backgroundColor = color;
  }, 100);
});

// Stop disco mode
$("#stopDiscoBackground").click(() => {
  $("#discoBackgroundDiv").show();
  $("#stopDiscoBackground").hide();
  clearInterval(disco);

  clearInterval(main);
  main = setInterval(() => {
    draw();
  }, 36);
});

// Hover action
let mood = "happy";
$("#canvasChameleon").mousemove((event) => {
  if (
    event.offsetX < 420 &&
    event.offsetX > 180 &&
    event.offsetY > 95 &&
    event.offsetY < 300
  ) {
    mood = "sad";
  } else {
    mood = "happy";
  }
});

// Canvas drawing
const canvas = $("#canvasChameleon").get(0);
const ctx = canvas.getContext("2d");

const colors = [
  "#05E4D9",
  "#086DAC",
  "#040757",
  "#ECEA00",
  "#FE8208",
  "#AA021B",
  "#FB3AC6",
  "#7E056D",
];

// Background
let backgroundColor = "aliceblue";

const drawBackground = () => {
  ctx.fillStyle = backgroundColor;
  ctx.fillRect(0, 0, canvas.width, canvas.height);
};

const drawSmiley = () => {
  ctx.fillStyle = "black";
  ctx.fillRect(30, 10, 15, 15);
  ctx.fillRect(60, 10, 15, 15);
  ctx.fillRect(25, 55, 55, 15);

  if (mood === "happy") {
    ctx.fillRect(15, 50, 15, 15);
    ctx.fillRect(75, 50, 15, 15);
  } else {
    ctx.fillRect(15, 60, 15, 15);
    ctx.fillRect(75, 60, 15, 15);
  }
};

const drawHead = (color) => {
  ctx.fillStyle = color;
  ctx.beginPath();
  ctx.arc(300, 95, 40, 0, 2 * Math.PI);
  ctx.fill();
};

const drawBody = (color) => {
  ctx.fillStyle = color;
  ctx.beginPath();
  ctx.rect(250, 150, 100, 100);
  ctx.fill();
};

const drawLine = (color, size, startX, startY, endX, endY) => {
  ctx.strokeStyle = color;
  ctx.lineWidth = size;
  ctx.beginPath();
  ctx.moveTo(startX, startY);
  ctx.lineTo(endX, endY);
  ctx.stroke();
  ctx.closePath();
};

const rotateBody = (rotation) => {
  ctx.save();
  ctx.beginPath();

  ctx.translate(300, 200);
  ctx.rotate((rotation * Math.PI) / 180);

  ctx.rect(-50, -50, 100, 100);
  ctx.fillStyle = "black";
  ctx.fill();

  ctx.restore();
};

let rotation = 0;
// Draw everything on the screen
const draw = () => {
  ctx.clearRect(0, 0, canvas.width, canvas.height);
  drawBackground();

  drawHead(colors[i]);

  drawSmiley();

  // Left leg
  drawLine(colors[i], 10, 275, 250, 275, 300);

  // Right leg
  drawLine(colors[i], 10, 325, 250, 350, 300);

  // Left arm
  drawLine("black", 10, 255, 200, 180, 150);

  // Right arm
  drawLine("black", 10, 345, 200, 420, 150);

  // Body and it's rotation
  rotateBody(rotation);
  rotation = (rotation + 1) % 360;
};

let main = null;
main = setInterval(() => {
  draw();
}, 36);

// Change color index
let i = 0;
setInterval(() => {
  i = (i + 1) % colors.length;
}, 1250);
