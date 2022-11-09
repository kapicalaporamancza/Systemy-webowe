function addToTen() {
    const s1 = prompt("Enter number:")
    const n1 = parseInt(s1)
    let res = n1 + 10
    document.getElementById("result").innerHTML = `10 + ${s1} = ${res}`
}

function deletePage() {
    alert("WARNING! This action will delete all existing HTML")
    document.writeln("Page after writeln() method")
}

function randomNum() {
    let n1 = Math.random()
    let f1 = parseFloat(n1) * 100
    f1 = Number((f1).toFixed(2))
    let f2 = Math.floor(f1)
    document.getElementById("randNum").innerHTML = `The number is: ${f1}<br>The floor is: ${f2}`
}
const b2 = document.getElementById("but2")
const b1 = document.getElementById("but1")

function buttonCol() {
    b1.style.backgroundColor = "blue"
}

b1.onclick = () => {
    addToTen()
}

b2.onclick = () => {
    deletePage()
}

b1.addEventListener("mouseover", buttonCol)
// b1.addEventListener("mouseout", b1.style.backgroundColor = " #d6d6c2")
document.addEventListener("click", randomNum)