// Grab items on page
// Function made to practice arrow functions
const grabElement = id => document.getElementById(id);

const inputField = grabElement('inputField');
const button = grabElement('addItem');
const taskList = grabElement('taskList');
const status = grabElement('completed');

const tasks = [];
let completedTasks = 0;

// Simplifies list item creation
const createListEntry = text => {
  const element = document.createElement('li');
  element.appendChild(createCheckboxItem(text));

  return element;
}

// Creates the following HTML <label><input type='checkbox'>text</label>
const createCheckboxItem = text => {
  const element = document.createElement('label');
  
  // Create checkBox element
  const checkBox = document.createElement('input');
  checkBox.type = 'checkbox';
  checkBox.onclick = () => isCompleted(checkBox);
  
  element.appendChild(checkBox);
  element.appendChild(document.createTextNode(text));

  return element;
}

// Creates and object and renders UI
const addTask = () => {
  tasks.push({
    description: inputField.value,
    createdAt: new Date().getTime(),
    html: createListEntry(inputField.value)
  });

  updateUI();
}

const updateUI = () => {
  inputField.value = '';
  for (let task of tasks) {
    taskList.insertBefore(task.html, taskList.firstChild);
  }

  updateCompletedTasks();
}

// If a task is checked, update both UI and counter.
const isCompleted = (me) => {
  if (me.checked) {
    completedTasks++;
    me.parentElement.style.textDecoration = 'line-through';
  } else {
    completedTasks--;
    me.parentElement.style.textDecoration = 'none';
  }

  updateCompletedTasks();
}

// Render the sentence displaying how many tasks are completed
const updateCompletedTasks = () => status.innerText = completedTasks + '/' + tasks.length + ' tasks completed';

// Allows user to hit enter to add task
inputField.onkeydown = event => {
  if (event.keyCode === 13) {
    addTask();
  }
};