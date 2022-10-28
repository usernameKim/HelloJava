// object.js

let obj = {
    user_id: "hong",
    user_name: "Hongkildong",
    user_age: 20,
    hobbies: ['독서', '낮잠', '자전거'],
    show_info: function(){
        return 'id: ' + this.user_id + ', name: ' + this.user_name + 
                ', age: ' +this.user_age;
    }
}

console.log('id: '+ obj.user_id);
console.log('name: '+ obj["user_name"]);
let field = "user_age"; 
console.log('age: '+ obj[field]);
console.log('첫째 취미: '+ obj.hobbies[0]);
console.log('홍의 정보' + obj.show_info());

// 객체생성.
function Person(name, age){
    this.name = name;
    this.age = age;

    this.showInfo = function(){
        return '이름은 ' + this.name + ', 나이는' + this.age;
    }
}

let p1 = new Person('홍길동', 20)
let p2 = new Person('김유신', 21)
let p3 = new Person('박명수', 22)

const persons = [p1, p2, p3];
for(let i=0; i<persons.length; i++){
    console.log(persons[i].showInfo());
}

function person(name){
    this.name = name; //윈도우객체(가장상위)
}

person('김민수');
console.log(this);