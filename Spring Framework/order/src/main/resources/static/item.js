/*
* item/list.html
* */
const $checkboxes = $("input[type='checkbox']");
const $table = $("#cart");
const $pay = $("input#pay");
const names = ["itemNumber", "itemName", "itemCount"]

$checkboxes.on("click", function(){

    //체크박스 인덱스
    let index = $checkboxes.index($(this));
    console.log(index);
    //메인테이블 tr안의 td정보들 가져온 값
    let $tds = $(this).closest("tr").children();
    console.log($tds);

    let text = "";
    //체크박스 체크 시 해당상품 번호,이름,개수입력창 생성 후 만들어 놓기만한 #cart 테이블에 추가
    if($(this).is(":checked")){
        text += `<tr id="` + index + `">`;
        text += `<td><input value="` + $tds.eq(1).text() + `" readonly></td>`;
        text += `<td><input value="` + $tds.eq(2).text() + `" readonly></td>`;
        text += `<td><input placeholder="개수"></td>`;
        text += `</tr>`;
        $table.append(text);
    }else{
        //체크 헤제 시 위에서 마지막으로 클릭한 순서대로 tr 삭제
        $table.find("tr").remove("#" + index);
    }
});

//결제하기 클릭 시
$pay.on("click", function(){
    // console.log($table.find("tr input"))
    $table.find("tr input").each(function(i, input){
        console.log(input)
        $(input).attr("name", "orders[" + parseInt(i / 3) + "]." + names[i % 3]);
    });

    // document.payForm.submit();
});






















