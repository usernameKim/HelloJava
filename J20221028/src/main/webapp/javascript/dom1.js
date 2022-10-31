/**
 * dom활용해서 페이지 생성
 */
 
 document.addEventListener('DOMContentLoaded', function(){
	let show = document.getElementById('show');
	//DOMContentLoaded 제일마지막에 실행
	
    let form = document.createElement('form'); 
// id.
    let txt = document.createTextNode('ID:'); //form하위에 있는 요소
    let input = document.createElement('input');
    input.setAttribute('type', 'text')  //두번째는 값을 넣음
    input.setAttribute('id', 'id');
    let br = document.createElement('br');
    form.appendChild(txt); //부모요소에 append
    form.appendChild(input);
    form.appendChild(br);
    show.appendChild(form);
// name.
	txt = document.createTextNode('Name');
	input = document.createElement('input');
	input.setAttribute('type', 'text')
	input.setAttribute('id', 'name');
	br = document.createElement('br');
	form.appendChild(txt);
	form.appendChild(input);
	form.appendChild(br);

	show.appendChild(form);
// Phone.
	txt = document.createTextNode('Phone');
	input = document.createElement('input');
	input.setAttribute('type', 'text')
	input.setAttribute('id', 'phone');
	br = document.createElement('br');
	form.appendChild(txt);
	form.appendChild(input);
	form.appendChild(br);
	show.appendChild(form);
// 전송.
	input = document.createElement('input');
	input.setAttribute('type', 'submit');
	input.setAttribute('value','전송');
	form.appendChild(input);
	show.appendChild(form);
})
