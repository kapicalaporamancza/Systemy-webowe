const p1 = document.getElementById("result")
const p2 = document.getElementById("result2")

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

function itemFunction() {
    p2.innerHTML += `<br>` + document.images.item(0).id + `<br>` + document.links.item(2).innerHTML

    p2.innerHTML += `<br><br>` + document.forms.namedItem("form2").id + `<br>` + document.links.namedItem("Wydział chemiczny").href
}

document.getElementById("mainHeader").addEventListener('click', collections)
document.getElementById("img1").addEventListener('click', itemFunction)