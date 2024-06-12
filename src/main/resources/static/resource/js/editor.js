const textArea = document.getElementById('textarea');
const run = document.getElementById('run');

const myCodeMirror = CodeMirror.fromTextArea(textArea, {
    value: 'print(\'hello world\')',
    lineNumbers: true,
    theme: 'dracula',
    keyMap: 'sublime',
    mode: 'python',
    autoCorrect:true,
    autoCloseBrackets: true,
    extraKeys: { "Ctrl-Space": "autocomplete" },
    smartIndent: true,
    matchBrackets: true,
    lineWrapping: true,
    indentUnit: 4,
    tabSize: 4,
});

myCodeMirror.on('change', () => {
    textArea.value=myCodeMirror.getValue();
});

//Timer
let timeLeft = 30*60;
const elem = document.getElementById('time');
const timerId = setInterval(countdown, 1000);

function countdown() {
    if (timeLeft === -1) {
        clearTimeout(timerId);
        // doSomething();
    }
    else {
        elem.innerHTML = `${Math.floor(timeLeft/60)}:${(timeLeft%60).toString().padStart(2, '0')}`;
        timeLeft--;
    }


}
