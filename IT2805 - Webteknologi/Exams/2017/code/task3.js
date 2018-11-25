// Note that month and day are 0-indexed
const today = new Date();
const christmas = new Date(2018, 11, 25);

console.log('Today: ', today);
console.log('Christmas: ', christmas);

const timeUntilChristmas = Math.floor((christmas - today) / (1000 * 60 * 60 * 24));
console.log('Days until christmas: ', timeUntilChristmas);