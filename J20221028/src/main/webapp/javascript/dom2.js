// dom2.js

document.addEventListener('DOMContentLoaded', domLoadedFunc); //로딩후 function실행

function domLoadedFunc() {
    let data = `[{"id":1,"first_name":"Mathilde","last_name":"Brogi","email":"mbrogi0@artisteer.com","gender":"Female","salary":6393},
				{"id":2,"first_name":"Kleon","last_name":"Mauger","email":"kmauger1@netlog.com","gender":"Male","salary":6573},
				{"id":3,"first_name":"Kinna","last_name":"Palmby","email":"kpalmby2@house.gov","gender":"Female","salary":4760},
				{"id":4,"first_name":"Kasey","last_name":"Cherm","email":"kcherm3@skype.com","gender":"Agender","salary":7796}
				]`; //데이터를 주고받기 위해 json형태를 씀.

    let obj = {}
    let result = JSON.parse(data); // json형태의 data를 =>js의 object로, 배열임
    console.log(result);
	

    // 확장for.
    // table
    let show = document.getElementById('show');  // div
    let table = document.createElement('table');
    show.appendChild(table);
    // thead
    let thead = document.createElement('thead');
    let tr = document.createElement('tr');
    let titles = ['아이디', '이름', '이메일', '성별', '급여', '삭제'];
    for (let title of titles) {
        let idTag = document.createElement('th');
        let idTxt = document.createTextNode(title); // <th>아이디</th>
        idTag.appendChild(idTxt);
        tr.appendChild(idTag);
    }
    // checkbox 생성
    let td = document.createElement('th');
    let checkbox = document.createElement('input');
    checkbox.setAttribute('type', 'checkbox'); //input 속성이 체크박스
    checkbox.addEventListener('change', function () {
        document.querySelectorAll('#show input[type="checkbox"]') //#show input[type="checkbox"]'-> div안의 check
            .forEach(function (check) {  // cks는 체크박스의 하위 체크박스들
                check.checked = checkbox.checked; //상위의 체크박스가 체크되면 하위도 체크
            }); 
       

    })

    td.appendChild(checkbox);
    tr.appendChild(td);
    thead.appendChild(tr);
    table.appendChild(thead);

    // tbody
    let tbody = document.createElement('tbody');
    table.appendChild(tbody);
    let fields = ['id', 'first_name', 'email', 'gender', 'salary'];
    for (let obj of result) {

        let tr = makeTr(obj);
        tbody.appendChild(tr);
    } // end of for (let obj of result) 

    ///////////////////////////////////  event /////////////////////////////////////////
    // 추가 버튼에 이벤트 등록
    document.querySelector('button[type="button"]').addEventListener('click', addFunc);

    function addFunc() {
        console.log('추가버튼....')
        let id = document.getElementById('id').value;
        let fn = document.getElementById('fname').value;
        let ln = document.getElementById('lname').value;
        let em = document.getElementById('email').value;
        let sa = document.getElementById('salary').value;
        let gn = document.getElementById('gender').value;

        let check = id && fn && em && sa && gn
        if (!check) {
            alert('입력항목 확인');
            return;
        }

        let newRow = {
            id: id,
            first_name: fn,
            last_nmae: ln,
            email: em,
            salary: sa,
            gender: gn
        }
        document.querySelector('#show>table>tbody').appendChild(makeTr(newRow));
        makeTr(newRow);
    }


    // 수정버튼에 이벤트 등록.
    document.querySelectorAll('button[type="button"]')[1].addEventListener('click', updateFunc);

    function updateFunc() { //#show -> div
        let trs = document.querySelectorAll('#show>table>tbody>tr');
        let id = document.getElementById('id').value; //id요소에 접근하는 함수

        for (let i = 0; i < trs.length; i++) {
            if (id == trs[i].children[0].textContent) {
                trs[i].children[4].textContent = document.getElementById('salary').value;
                trs[i].children[3].textContent = document.getElementById('gender').value;
                trs[i].children[2].textContent = document.getElementById('email').value;
                trs[i].children[1].textContent = document.getElementById('fname').value;
            }
        }
    }
    // 선택삭제버튼에 이벤트 등록.
    document.querySelectorAll('button[type="button"]')[2].addEventListener('click', choiceRemoveFunc);
    function choiceRemoveFunc() {
        console.log('test');
        let trs = document.querySelectorAll('#show>table>tbody>tr');
        for (let i = 0; i < trs.length; i++) {
            // firstElementChild -> input태그
            if (trs[i].children[6].firstElementChild.checked == true) {
                trs[i].remove();

            }
        }
    }

    function makeTr(row) {
        // 데이터 건수만큼 반복.
        let tr = document.createElement('tr');
        tr.addEventListener('mouseover', function () {
            this.style.backgroundColor = 'yellow'; //마우스가 빠져나오면 원래대로
        });

        tr.addEventListener('mouseout', function () {
            this.style.backgroundColor = null; //마우스가 빠져나오면 원래대로
        });
        tr.addEventListener('click', showDetailFunc);
        for (let field of fields) {
            // 보여줄 항목만큼 반복.
            let td = document.createElement('td');
            let txt = document.createTextNode(row[field]) //obj의 각 필드id, name, email...을 가져옴
            td.appendChild(txt);
            tr.appendChild(td);


        }
        // 삭제버튼. <td><button>삭제</button></td>
        let td = document.createElement('td');
        let btn = document.createElement('button');
        btn.addEventListener('click', function () {
            console.log(this); //누르면 콘솔에 <button>삭제</button> 출력됨
            this.parentElement.parentElement.remove(); //누르면 버튼 삭제가 아니고 부모요소인 td삭제 -> 부모요소 tr삭제됨
        });
        let txt = document.createTextNode('삭제');
        td.appendChild(btn);
        btn.appendChild(txt);
        tr.appendChild(td);

        // 체크박스
        td = document.createElement('td');
        td.style.textAlign = 'center';
        let check = document.createElement('input');

        //check -> true, 체크 안하면 false.
        check.addEventListener('change', function () {
            console.log(this.checked);
        })
        check.setAttribute('type', 'checkbox')
        td.appendChild(check);
        tr.appendChild(td);


        return tr;


    } // end of makeTr()

    function showDetailFunc() {
        this.style.backgroundColor = 'yellow'; //this->tr
        console.log(this.children[1].textContent); //tr태그의 td값 보여줌
        document.getElementById('id').value = this.children[0].textContent;
        document.getElementById('fname').value = this.children[1].textContent;
        document.getElementById('email').value = this.children[2].textContent;
        document.getElementById('gender').value = this.children[3].textContent;
        document.getElementById('salary').value = this.children[4].textContent;
        //td의 하위요소가 textnode라서 texetcontent값을 씀 -> 이름을 가져옴

        //		console.log(this.firstElementChild) // console에 td를 보여줌
        //		console.log(this.lastElementChild) // 버튼 태그를 보여줌
    }


} // end of domLoadedFunc()