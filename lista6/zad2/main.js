const p1 = document.getElementById("result");
function collections() {
    p1.innerHTML += `<br>`
    for (const image of document.images) {
        p1.innerHTML += image.src + `<br>`
    }
    p1.innerHTML += `<br>`
    for (const link of document.links) {
        p1.innerHTML += link.href + `<br>`
    }
    p1.innerHTML += `<br>`
    for (const form of document.forms) {
        p1.innerHTML += form.id + `<br>`
    }
}

document.getElementById("mainHeader").addEventListener('click', collections)

// const b1 = document.getElementById("but1")
// b1.onclick = () => {
//     const newDiv = document.createElement("div");
//     newDiv.style.marginTop = "10px"
//     const newContent = document.createTextNode("Div ceated with createElement and createTextNode methods");
//     newDiv.appendChild(newContent);

//     div1.replaceChild(newDiv, document.getElementById("secondChild"))
//     div1.removeChild(document.getElementById("thirdChild"))
// }

// const b2 = document.getElementById("but2")
// b2.onclick = () => {
//     const listItem = document.getElementById("item");
//     let li = document.createElement('li');
//     li.appendChild(document.createTextNode("item added"))
//     listItem.parentNode.appendChild(li)
// }