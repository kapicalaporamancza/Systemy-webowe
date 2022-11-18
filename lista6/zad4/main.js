"use strict";
document.addEventListener("mousemove", onMouseMove);
document.addEventListener("mousedown", onMouseDown);
document.addEventListener("mouseover", onMouseOver);
document.addEventListener("mouseout", onMouseOut);
document.addEventListener("keypress", onKeyPress);
document.addEventListener("keydown", onKeyDown);
var box = document.getElementById("box");
box.addEventListener("mouseover", onMouseOverBox);
box.addEventListener("mouseout", onMouseOutBox);
var output = document.getElementById("output");


function onMouseMove(e)
{
    output.innerHTML = "Mouse move";
    restOfData(e);

}

function onMouseDown(e)
{
    output.innerHTML = "Mouse down";
    restOfData(e);

}

function onMouseOver(e)
{
    output.innerHTML = "Mouse over";
    restOfData(e);

}

function onMouseOut(e)
{
    output.innerHTML = "Mouse out";
    restOfData(e);
}

function onKeyPress(e)
{
    output.innerHTML = "Key pressed";
    restOfData(e);
}

function onKeyDown(e)
{
    output.innerHTML = "Key down";
    restOfData(e);
}

function onMouseOverBox(e)
{
    box.innerHTML = "Mouse over box";
}

function onMouseOutBox(e)
{
    box.innerHTML = "Mouse out box";
}


function restOfData(e)
{
    if (e.altKey != undefined)
    {
        output.innerHTML += "<br>Alt key: " + e.altKey + "<br>";
        output.innerHTML += "Ctrl key: " + e.ctrlKey + "<br>";
        output.innerHTML += "Shift key: " + e.shiftKey + "<br>";
    }
    if (e.keyCode != undefined)
    {
        output.innerHTML += "Key code: " + e.keyCode + "<br>";
    }
    if (e.clientX != undefined)
    {
        output.innerHTML += "Client x: " + e.clientX + "<br>";
        output.innerHTML += "Client y: " + e.clientY + "<br>";
        output.innerHTML += "Screen x: " + e.screenX + "<br>";
        output.innerHTML += "Screen y: " + e.screenY + "<br>";
    }
}
