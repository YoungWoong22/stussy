
class ImportApi {
    #IMP = null;

    constructor() {
        this.#IMP = window.IMP;
        IMP.init("{imp00508123}"); 
        this.addPaymentEvent;
    }

    addPaymentEvent() {
        document.querySelector(".payment-button").onclick = () =>{
            this.requestPay();
        }
    }
    

    requestPay() {
        const pdtName = document.querySelector(".product-name").textContent;
        const pdtPrice = document.querySelector(".product-price").textContent;
        const email = document.querySelector(".principal-email").value;
        const name = document.querySelector(".principal-name").value;
        const zoneCode = document.querySelector(".address-zonecode").value;
        const addressAll = document.querySelector(".address-all").value;
        const addressDetail = document.querySelector(".address-detail").value;
        const address = addressAll + " " + addressDetail;
        const phone = document.querySelector(".phone-number").value;

            function requestPay() {
                // IMP.request_pay(param, callback) 결제창 호출
                IMP.request_pay({ 
                    pg: "kakopay",                                      // 카카오페이로변경
                    pay_method: "card",                                 //결제수단
                    merchant_uid: "PRODUCT-" + new Date().getTime(),    //상품아이디 는 시간에따라 들어가게 했음
                    name: pdtName,                                      //상품명               
                    amount: pdtPrice,                                   //결제할금액
                    buyer_email: email,
                    buyer_name: name,
                    buyer_tel: phone,
                    buyer_addr: address,
                    buyer_postcode: "zoneCode"
                }, function (rsp) { // callback
                    if (rsp.success) {

                    } else {
                    
                    }
                });
            }
    }

}



window.onload = () => {
    AddressApi.getInstance().addAddressButtonEvent();
    new ImportApi();
}