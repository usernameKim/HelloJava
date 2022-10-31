/**
 * dom3.js
 */

document.addEventListener('DOMContentLoaded', function() {

	document.querySelector('button').addEventListener('click', function(){
		// 아이디 조회해서 화면에서 삭제.
		let trs = document.querySelectorAll('table>tbody>tr');
		let id = document.getElementById('id').value;
		for(let i = 0; i < trs.length; i++){
			if(id == trs[i].children[0].textContent)
				trs[i].remove();
		}
	})
	
	let tableObject = {
		id: 'hong',
		titles: ["아이디", "이름", "이메일"],
		data: [{ id: 'user1', name: '홍길동', email: 'hong@email' },
		{ id: 'user2', name: '김민서', email: 'kim@email' },
		{ id: 'user3', name: '박항서', email: 'park@email' }],
		//push 하면 마지막 배열에 추가됨.
		addData: function(row){
			this.data.push(row); 
		},
		makeTable: function() {
			let table = document.createElement('table');
			let thead = this.makeHead();
			let tbody = this.makeBody();
			table.append(thead, tbody); //appendchild는 1개만 받을 수 있음
			return table;
		},
		makeHead: function() {
			let thead = document.createElement('thead');
			let tr = document.createElement('tr');
			this.titles.forEach(function(title) {
				let td = document.createElement('th');
				let txt = document.createTextNode(title);
				td.append(txt);
				tr.append(td);
			})
			thead.append(tr);
			return thead;
		},
		makeBody: function() {
			let tbody = document.createElement('tbody');
			// val, idx, ary(없으면 생략가능), function도 생략가능, 람다식 표현이랑 비슷하게
			this.data.forEach(val => {
				let tr = document.createElement('tr');
				tbody.append(tr);
				// val은 object이므로 반복문을 쓸때 for in에서 변수는 오브젝트의 필드값을 가져옴
				// object타입은 필드를 가져옴
				for (let field in val) {
					console.log(val[field]); //3번 돌겠지
					let td = document.createElement('td');
					let txt = document.createTextNode(val[field]);
					td.append(txt);
					tr.append(td);
				}
				// 삭제버튼. 클릭하면 한건 삭제.
				let btn = document.createElement('button')
				btn.setAttribute('type', 'button');
				btn.addEventListener('click', function() {
					btn.parentElement.parentElement.remove(); //btn대신 this도 가능해
				})
				let td = document.createElement('td');
				let txt = document.createTextNode('삭제');
				td.append(btn);
				btn.append(txt);
				tr.appendChild(td);
			});
			return tbody;
		},
		init: function() {
			document.getElementsByTagName('body')[0].append(this.makeTable());
		}
	}
	// 데이터 추가.
	tableObject.addData({id: 'user4', name: '황선홍', email: 'hwang@email'});
	
	tableObject.init();

}) // end of DOMContentLoaded.