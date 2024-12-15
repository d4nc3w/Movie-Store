document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("form");
    const titleInput = document.getElementById("title");
    const directorInput = document.getElementById("director");
    const priceInput = document.getElementById("price");
    const descriptionInput = document.getElementById("description");

    form.addEventListener("submit", (event) => {
        let isValid = true;
        let title_error = document.querySelector('#title_error');
        let director_error = document.querySelector('#director_error');
        let price_error = document.querySelector('#price_error');
        let description_error = document.querySelector('#description_error');
        let anyError = document.getElementById("anyError");

        if(titleInput.value.length < 2){
            isValid = false;
            titleInput.classList.add("error");
            title_error.innerText = 'Title should have at least 2 characters';

        } else {
            titleInput.classList.remove("error");
            title_error.innerText = '';
        }

        if(!/^\s*[A-Z]/.test(directorInput.value)){
            isValid = false;
            directorInput.classList.add("error");
            director_error.innerText = 'Director should start with uppercase';

        } else {
            directorInput.classList.remove("error");
            director_error.innerText = '';
        }

        if(parseFloat(priceInput.value) <= 0){
            isValid = false;
            priceInput.classList.add("error");
            price_error.innerText = 'Price cannot be equal to 0';

        } else {
            priceInput.classList.remove("error");
            price_error.innerText = '';
        }

        if((descriptionInput.value.trim().length < 10)){
            isValid = false;
            descriptionInput.classList.add("error");
            description_error.innerText = 'Description should have at least 10 characters';

        } else {
            descriptionInput.classList.remove("error");
            description_error.innerText = '';
        }

        if (!isValid) {
            event.preventDefault();
            anyError.innerText = "Correct all errors in order to submit.";
        } else {
            anyError.innerText = "";
        }

    });
});