const textArea = document.getElementById("textarea");
const run = document.getElementById("run");
const reset = document.getElementById("reset");
const submit = document.getElementById("submit");
const test = document.getElementById("test");
const output = document.getElementById("result");
const process = document.getElementById("process");
console.log(test.value);
str = `
def exce(i, j):
    result = None
    try:
      result = i==j
    except Exception:
      result = False
    return result
    
def test_case():
    test = ${test.value}
    result = ${output.value}
    score =  sum([exce(i, j) for i,j in zip(test, result)])
    return score 
try:    
  res=(test_case())
except Exception: 
  res = 0
`;
localStorage.setItem("process", str);

const myCodeMirror = CodeMirror.fromTextArea(textArea, {
  value: "",
  lineNumbers: true,
  theme: "dracula",
  keyMap: "sublime",
  mode: "python",
  autoCorrect: true,
  autoCloseBrackets: true,
  extraKeys: { "Ctrl-Space": "autocomplete" },
  smartIndent: true,
  matchBrackets: true,
  lineWrapping: true,


});
const initialCode = myCodeMirror.getValue();

myCodeMirror.on("change", () => {
  textArea.value = myCodeMirror.getValue();
  // localStorage.setItem(JSON.stringify("code", myCodeMirror.getValue()));
});
reset.addEventListener("click", () => {
  myCodeMirror.value = initialCode;
  textArea.value = myCodeMirror.getValue();
});
//Timer
let timeLeft = 5 * 60;
const elem = document.getElementById("time");
const timerId = setInterval(countdown, 1000);

function countdown() {
  if (timeLeft === -1) {
    clearTimeout(timerId);
    // doSomething();
    submit.click();
  } else {
    elem.innerHTML = `${Math.floor(timeLeft / 60)}:${(timeLeft % 60)
      .toString()
      .padStart(2, "0")}`;
    timeLeft--;
  }
}

// console.log(output)
