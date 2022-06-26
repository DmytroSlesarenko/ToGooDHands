const btn = document.getElementById("summary");

btn.addEventListener("click", function () {
    const category = document.querySelectorAll(".category");
    const quantity = document.querySelector(".quantity");
    const summaryCategory = document.getElementById("quantity-category");

    if (quantity.value < 5) {
        summaryCategory.innerText = quantity.value + " worki - ";
    } else {
        summaryCategory.innerText = quantity.value + " worków - ";
    }
    category.forEach(function (item) {
        if (item.checked) {
            summaryCategory.innerText = summaryCategory.innerText + item.title + "; "
        }
    })

    const institution = document.querySelectorAll(".institution");
    const summaryInstitution = document.getElementById("institution");

    institution.forEach(function (item) {
        if (item.checked) {
            summaryInstitution.innerText = "Dla fundacji \"" + item.title + "\"";
        }
    })

    const street = document.querySelector(".street").value;
    const city = document.querySelector(".city").value;
    const postCode = document.querySelector(".postCode").value;
    const phone = document.querySelector(".phone").value;
    const summaryStreet = document.getElementById("address-phone");

    const liStreet = document.createElement("LI");
    liStreet.innerText = street;
    summaryStreet.appendChild(liStreet);
    const liCity = document.createElement("LI");
    liCity.innerText = city;
    summaryStreet.appendChild(liCity);
    const liPostCode = document.createElement("LI");
    liPostCode.innerText = postCode;
    summaryStreet.appendChild(liPostCode);
    const liPhone = document.createElement("LI");
    liPhone.innerText = phone;
    summaryStreet.appendChild(liPhone);


    const date = document.querySelector(".date").value;
    const time = document.querySelector(".time").value;
    const comment = document.querySelector(".comment").value;
    const summaryDateTimeComment = document.getElementById("date-time-description");

    const liDate = document.createElement("LI");
    liDate.innerText = date;
    summaryDateTimeComment.appendChild(liDate);
    const liTime = document.createElement("LI");
    liTime.innerText = time;
    summaryDateTimeComment.appendChild(liTime);
    const liComment = document.createElement("LI");
    if (comment !== "") {
        liComment.innerText = comment;
    } else {
        liComment.innerText = "Brak uwag";
    }
    summaryDateTimeComment.appendChild(liComment);
})

const btnBack = document.getElementById("back");

btnBack.addEventListener("click", function () {
    const summaryStreet = document.getElementById("address-phone");
    summaryStreet.replaceChildren();
    const summaryDateTimeComment = document.getElementById("date-time-description");
    summaryDateTimeComment.replaceChildren();
})

