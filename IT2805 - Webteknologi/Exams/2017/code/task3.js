// Note that month is 0-indexed
const today = new Date();
const christmas = new Date(2018, 11, 24);

console.log('Today: ', today);
console.log('Christmas: ', christmas);

const timeUntilChristmas = Math.ceil((christmas - today) / (1000 * 60 * 60 * 24));
console.log('Days until christmas: ', timeUntilChristmas);
