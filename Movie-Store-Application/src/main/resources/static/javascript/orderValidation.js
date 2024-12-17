document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("form");
    const firstNameInput = document.getElementById("firstName");
    const lastNameInput = document.getElementById("lastName");
    const emailInput = document.getElementById("email");
    const addressInput = document.getElementById("address");
    const cityInput = document.getElementById("city");
    const cardNumberInput = document.getElementById("cardNumber");

    form.addEventListener("submit", (event) => {
        let isValid = true;
        let firstName_error = document.querySelector('#firstName_error');
        let lastName_error = document.querySelector('#lastName_error');
        let email_error = document.querySelector('#email_error');
        let address_error = document.querySelector('#address_error');
        let city_error = document.querySelector('#city_error');
        let cardNumber_error = document.querySelector('#cardNumber_error');
        let anyError = document.getElementById("anyError");

        if(!/^\s*[A-Z]/.test(firstNameInput.value)){
            isValid = false;
            firstNameInput.classList.add("error");
            firstName_error.innerText = 'First name should start with uppercase';
        } else {
            firstNameInput.classList.remove("error");
            firstName_error.innerText = '';
        }

        if(!/^\s*[A-Z]/.test(lastNameInput.value)){
            isValid = false;
            lastNameInput.classList.add("error");
            lastName_error.innerText = 'Last name should start with uppercase';
        } else {
            lastNameInput.classList.remove("error");
            lastName_error.innerText = '';
        }

        if (!emailInput.value.includes("@")) {
            isValid = false;
            emailInput.classList.add("error");
            email_error.innerText = 'Email should contain "@"';
        } else {
            emailInput.classList.remove("error");
            email_error.innerText = '';
        }

        if (!/\d/.test(addressInput.value)) {
            isValid = false;
            addressInput.classList.add("error");
            address_error.innerText = 'Address should have a number';
        } else {
            addressInput.classList.remove("error");
            address_error.innerText = '';
        }

        if (!/^\s*[A-Z]/.test(cityInput.value)) {
            isValid = false;
            cityInput.classList.add("error");
            city_error.innerText = 'City should start with uppercase';
        } else {
            cityInput.classList.remove("error");
            city_error.innerText = '';
        }

        if (!/^\d{16}$/.test(cardNumberInput.value)) {
            isValid = false;
            cardNumberInput.classList.add("error");
            cardNumber_error.innerText = 'Card number should have 16 digits';
        } else {
            cardNumberInput.classList.remove("error");
            cardNumber_error.innerText = '';
        }

        if (!isValid) {
            event.preventDefault();
            anyError.innerText = "Correct all errors in order to submit.";
        } else {
            anyError.innerText = '';
        }
    });
});