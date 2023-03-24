const btnAffiche = document.getElementById('btnAffiche');
const content = document.querySelector('.content');

btnAffiche.addEventListener('click', () => {
    if (content.className == "content") {
        btnAffiche.innerHTML = "^";
    }
    else {
        btnAffiche.innerHTML = "V";
    }
    content.classList.toggle('affiche');
})
