const registerButton = document.querySelector(".account-button");

registerButton.onclick = () => {
    const accountInput = document.querySelectorAll(".account-input");

    let user = {
        lastName: accountInput[0].value,
        firstName: accountInput[1].value,
        email: accountInput[2].value,
        password: accountInput[3].value
    }
    
    //JSON.stringify() -> js 객체를 JSON문자열로 변환
    //JON.parse()      -> JSON 문자열을 js객체로 변환

    $.ajax({
        async: false,                       //필수
        type: "post",                       //필수
        url: "/api/account/register",       //필수
        contentType: "application/json",    //전송데이터가 json인 경우
        data: JSON.stringify(user),         //전송할 데이터가 있으면    
        dataType: "json",                   //json 외 text 등을 사용할 수 있지만 json
        success: (response, textStatus, request) => {            //성공시에 실행될 메소드
            console.log(response);
            const successURI = request.getResponseHeader("Location");
            location.replace(successURI + "?email=" + response.data);
        },
        error: (error) => {             //실패시 실행될 메소드
            console.log(error.responseJSON.data);
            loadErrorMessage(error.responseJSON.data)
        }
    });
}

function loadErrorMessage(errors){
    const errorList = document.querySelector(".errors")
    const errorMsgs = document.querySelector(".error-msgs");
    const errorArray = Object.values(errors)


    errorMsgs.innerHTML = "";

    
    errorArray.forEach(error => {
        errorMsgs.innerHTML += `
            <li>${error}</li>
        `;
    });

    errorList.classList.remove("errors-invisible")
}