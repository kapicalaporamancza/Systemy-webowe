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

function fun3() {
    let p = document.getElementById("p1")
    p.innerHTML = "paragraph"
    const s1 = prompt("Enter number:")
    if (parseInt(s1) > 0 && parseInt(s1) <= 20) {
        let n = 1

        while (n <= s1) {
            p.innerHTML += `<br> ${n}`
            n++
        }
    } else {
        alert("Your number must be bigger than 0 and smaller than 20")
        fun3()
    }
}
let b2 = document.getElementById("but2")
var b1 = document.getElementById("but1")
const b3 = document.getElementById("but3")

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
document.addEventListener("click", randomNum)

b3.addEventListener("click", fun3)