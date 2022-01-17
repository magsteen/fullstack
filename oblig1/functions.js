let counter = 0;
let counterResult = document.getElementById("counter-result");

let visible = false;
let peekButton = document.getElementById("peek");
let peekResult = document.getElementById("peek-result");

const randomWords = ["omission", "leak", "polite", "opponent", "family"]
let ranNode = document.getElementById("ran-arr");
let ranResult = document.getElementById("random-result");

let count = () => {
    counterResult.textContent++;
}

let toggleContent = () => {
    if (peekResult.style.visibility == "visible") {
        peekResult.style.visibility = "hidden";
        peekButton.textContent = "Show";
    }
    else {
        peekResult.style.visibility = "visible";
        peekButton.textContent = "Hide";
    }
} 

function getRandomInteger(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
}

let getRanWord = () => {
    ranResult.textContent = randomWords[getRandomInteger(0, randomWords.length)]
}