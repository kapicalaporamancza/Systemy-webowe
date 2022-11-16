const div1 = document.getElementById("div1");
function addElement() {
    const newDiv = document.createElement("div");
    const newContent = document.createTextNode("Div ceated with createElement and createTextNode methods");
    newDiv.appendChild(newContent);

    document.body.insertBefore(newDiv, div1);
}

document.getElementById("mainHeader").addEventListener('click', addElement)

const b1 = document.getElementById("but1")
b1.onclick = () => {
    const newDiv = document.createElement("div");
    newDiv.style.marginTop = "10px"
    const newContent = document.createTextNode("Div ceated with createElement and createTextNode methods");
    newDiv.appendChild(newContent);

    div1.replaceChild(newDiv, document.getElementById("secondChild"))
    div1.removeChild(document.getElementById("thirdChild"))
}

const b2 = document.getElementById("but2")
b2.onclick = () => {
    const listItem = document.getElementById("item");
    let li = document.createElement('li');
    li.appendChild(document.createTextNode("item added"))
    listItem.parentNode.appendChild(li)
}