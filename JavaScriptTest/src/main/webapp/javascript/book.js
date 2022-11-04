// book.js

// fetch('../BookListServlet')
// .then( result => result.json())
// .then( itemListShow)
// .catch( err => console.error(err));

document.addEventListener('DOMContentLoaded', domLoadedFunc);

function domLoadedFunc() {
    let data = `[{"book_code":"P12301285","book_name":"이것이 자바다","author":"홍성문","press":"신흥출판사","price":"25,000"},
                {"book_code":"P12301285","book_name":"이것이 자바다","author":"홍성문","press":"신흥출판사","price":"25,000"},
                {"book_code":"P12301285","book_name":"이것이 자바다","author":"홍성문","press":"신흥출판사","price":"25,000"},
                {"book_code":"P12301285","book_name":"이것이 자바다","author":"홍성문","press":"신흥출판사","price":"25,000"},
                {"book_code":"P12301285","book_name":"이것이 자바다","author":"홍성문","press":"신흥출판사","price":"25,000"}
				]`;
    let obj = {}
    let result = JSON.parse(data); 
    console.log(result);
    
    //table
    let show = document.getElementById('show');  // div
    let table = document.createElement('table');
    show.appendChild(table);
    // thead
    let thead = document.createElement('thead');
    let tr = document.createElement('tr');
    let titles = ['ck' ,'도서코드', '도서명', '저자', '출판사', '가격', '삭제'];
    for (let title of titles) {
        if(title == 'ck'){
            let td = document.createElement('th');
            let checkbox = document.createElement('input');
            checkbox.setAttribute('type', 'checkbox'); 
            checkbox.addEventListener('change', function () {
            document.querySelectorAll('#show input[type="checkbox"]') 
            .forEach(function (check) { 
                check.checked = checkbox.checked; 
            }); 
        })
            td.appendChild(checkbox);
            tr.appendChild(td);
            thead.appendChild(tr);
            table.appendChild(thead);
        }else{
            let td = document.createElement('td');
            let checkbox = document.createElement('input');
            checkbox.setAttribute('type', 'checkbox'); 
            td.appendChild(checkbox);
                
            let idTag = document.createElement('th');
            let idTxt = document.createTextNode(title); 
            idTag.appendChild(idTxt);
            tr.appendChild(idTag);
        }   
    }
        
    // 체크박스 생성
    let td = document.createElement('th');
    let checkbox = document.createElement('input');
    checkbox.setAttribute('type', 'checkbox'); 
    //checkbox.addEventListener('change', function () {
        // document.querySelectorAll('#show input[type="checkbox"]') 
        //     .forEach(function (check) { 
        //         check.checked = checkbox.checked; 
        //     }); 
    //   })
        td.appendChild(checkbox);
        tr.appendChild(td);
        thead.appendChild(tr);
        table.appendChild(thead);

    //tbody
    let tbody = document.createElement('tbody');
    table.appendChild(tbody);
    let fields = ['book_code', 'book_name', 'author', 'press', 'price'];
    for (let obj of result) {
        let tr = makeTr(obj);
        tbody.appendChild(tr);
    } // end of for (let obj of result) 

    // 추가 버튼에 이벤트 등록
    document.querySelector('button[type="button"]').addEventListener('click', addFunc);

    function addFunc() {
        console.log('저장버튼....')
        let bCode = document.getElementById('book_code').value;
        let bName = document.getElementById('book_name').value;
        let at = document.getElementById('author').value;
        let ps = document.getElementById('press').value;
        let pr = document.getElementById('price').value;
        
        let check = bCode && bName && at && ps && price
        if (!check) {
            alert('입력항목 확인');
            return;
        }
        let newRow = {
            book_code: bCode,
            book_name: bName,
            author: at,
            press: ps,
            price: pr,
        }
        document.querySelector('#show>table>tbody').appendChild(makeTr(newRow));
        makeTr(newRow);
    }
    // 선택삭제버튼에 이벤트 등록.
    document.querySelectorAll('button[type="button"]')[1].addEventListener('click', choiceRemoveFunc);
    function choiceRemoveFunc() {
        console.log('test');
        let trs = document.querySelectorAll('#show>table>tbody>tr');
        for (let i = 0; i < trs.length; i++) {
            if (trs[i].children[6].firstElementChild.checked == true) {
                trs[i].remove();
            }
        }
    }
    function makeTr(row) {
        // 데이터 건수만큼 반복.
        let tr = document.createElement('tr');
        tr.addEventListener('mouseover', function () {
            this.style.backgroundColor = 'yellow'; 
        });

        tr.addEventListener('mouseout', function () {
            this.style.backgroundColor = null; 
        });
        tr.addEventListener('click', showDetailFunc);
        for (let field of fields) {
            // 보여줄 항목만큼 반복.
            let td = document.createElement('td');
            let txt = document.createTextNode(row[field]) 
            td.appendChild(txt);
            tr.appendChild(td);
        }
    
    // 삭제버튼. <td><button>삭제</button></td>
        let td1 = document.createElement('td');
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
        td.style.textAlign = 'center'
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
    //    this.style.backgroundColor = 'yellow'; //this->tr
        console.log(this.children[1].textContent); //tr태그의 td값 보여줌
        document.getElementById('bCode').value = this.children[0].textContent;
        document.getElementById('bName').value = this.children[1].textContent;
        document.getElementById('author').value = this.children[2].textContent;
        document.getElementById('press').value = this.children[3].textContent;
        document.getElementById('price').value = this.children[4].textContent;
    }      
}

