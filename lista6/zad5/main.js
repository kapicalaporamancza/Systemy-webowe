"use strict";
document.getElementById("reset").addEventListener("click", confirmReset);
document.getElementById("submit").addEventListener("click", confirmSubmit);

function confirmReset() {
    return confirm("Are you sure you want to reset the form?");
}

function confirmSubmit() {
    return confirm("Are you sure you want to submit the form?");
}


//add focus and blur event to all input elements, this will be used to to show help text
var inputs = document.getElementsByTagName("input");
for (var i = 0; i < inputs.length; i++) {
    inputs[i].addEventListener("focus", showHelp);
    inputs[i].addEventListener("blur", hideHelp);
}

function showHelp() {
    var helpText = this.nextElementSibling;
    helpText.style.display = "inline";
}

function hideHelp() {
    var helpText = this.nextElementSibling;
    helpText.style.display = "none";
}
