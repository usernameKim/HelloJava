/**
 *  object2.js
 */
 
 document.addEventListener('DOMContentLoaded', function(){
	// document.getElementById('show').innerHTML = '<p>Hello, World</p>';
	let data = `[{"id":1,"first_name":"Mathilde","last_name":"Brogi","email":"mbrogi0@artisteer.com","gender":"Female","salary":6393},
{"id":2,"first_name":"Kleon","last_name":"Mauger","email":"kmauger1@netlog.com","gender":"Male","salary":6573},
{"id":3,"first_name":"Kinna","last_name":"Palmby","email":"kpalmby2@house.gov","gender":"Female","salary":4760},
{"id":4,"first_name":"Kasey","last_name":"Cherm","email":"kcherm3@skype.com","gender":"Agender","salary":7796},
{"id":5,"first_name":"Eloise","last_name":"Daulby","email":"edaulby4@goo.gl","gender":"Female","salary":7063},
{"id":6,"first_name":"Gianna","last_name":"Shoute","email":"gshoute5@jugem.jp","gender":"Female","salary":5003},
{"id":7,"first_name":"Bernadine","last_name":"Ianetti","email":"bianetti6@aol.com","gender":"Female","salary":4871},
{"id":8,"first_name":"Leontyne","last_name":"Lakin","email":"llakin7@topsy.com","gender":"Genderfluid","salary":9400},
{"id":9,"first_name":"Franchot","last_name":"Yokel","email":"fyokel8@tuttocitta.it","gender":"Male","salary":6169},
{"id":10,"first_name":"Salvatore","last_name":"Klaffs","email":"sklaffs9@tamu.edu","gender":"Male","salary":2818}]`;

// json 타입 => javascript 오브젝트.

let result = JSON.parse(data);
console.log(result);

// for(String str : personList){}
// <ul><li>obj</li>li>obj</li>li>obj</li></ul>
// <div id ="show"></div>
const fields = ['id', 'first_name', 'email', 'salary'];
let tableTag = document.createElement('table');

for(row of result){
	tableTag.appendChild(makeTr(row));
}

document.getElementById('show').appendChild(tableTag);

function makeTr(obj){
	let trTag = document.createElement('tr');
	let str = '';
	for(field of fields){
		str += `${field}: ${obj[field]} `;	
	}
	let txt = document.createTextNode(str);
	trTag.appendChild(txt);
	
	return trTag;
}

function makeList(obj){
	let liTag = document.createElement('li');
	let str = '';
	for(field of fields){
		str += `${field}: ${obj[field]} `;
	}
	let txt = document.createTextNode(str);
	liTag.appendChild(txt);
	
	return liTag;
}
});
 