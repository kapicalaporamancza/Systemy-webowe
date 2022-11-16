const f1 = document.getElementById("background");
const f2 = document.getElementById("text");
const f3 = document.getElementById("font");

function bckgrndFun() {
    document.body.style.backgroundColor = f1.value
}

function txtFun() {
    document.body.style.color = f2.value
}

function fntFun() {
    document.body.style.fontFamily = f3.value
}

document.getElementById("backgroundSubmit").addEventListener('click', bckgrndFun)
document.getElementById("textSubmit").addEventListener('click', txtFun)
document.getElementById("fontSubmit").addEventListener('click', fntFun)
