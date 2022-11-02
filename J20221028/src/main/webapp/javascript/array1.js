// array1.js
fetch('data/MOCK_DATA.json')
.then( result => result.json())
.then( composeFnc) //콜백함수
.catch( error => console.log(error));

function composeFnc(result =[]){
    // 급여 5000넘는 사람들만 filter 한 후에 새로운 모임만들기.
    result.filter(row => row.salary > 5000)
        .map(row =>{
            let team = {
                t_id: row.id,
                t_name: row.first_name + '/' + row.last_name
            } //object 안에서는 : 하고 , 써주셈
            team.t_mail = row.email;
            team['t_dept'] = 'Accout';
            return team;
        })
        .forEach(team => console.log(team));
}
//Array.map() => A - A' : A형태를 A'로 바꾸는 메소드!
function mappingFnc(result = []){
     let newAry = result.map(row => {
        let newObj ={}; // new Object(); //오브젝트 선언
        newObj.user_id = row.id;
        newObj.user_name = row.first_name + '-' + row.last_name;
        newObj.info = row.email;
        return newObj;
    });
    newAry.forEach(obj => console.log(obj)); // obj는 변수이름일뿐
}
// Array.filter() => 매개함수의 반환값이 true인 요소들만 모아서 새로운 배열생성.
function filterFnc(result = []){ // 만약 값이 안들어온다면..? 아무 데이터 없는 배열을 선언할거임
    // return값(배열을 만족하는) 있음
    result.filter((row, idx) => row.salary > 5000)   //새로운 배열 반환: filter(true값만)
        .forEach(row => console.log(row));

//        return idx % 2 == 0;
//    oddAry.forEach(row => console.log(row));
}

// Array.forEach() => 최종처리하는 기능 구현.
function showMain(result){
//   console.log(result);
    result.forEach((row, idx) => { //function(row)
        console.log(row);
//        if(row.gender =='Female'){
        if(idx % 2== 0){
            console.log(row.id, row.first_name, row.last_name);
        }
    });
}

function sum(a=0, b=0){ 
   return a+b;
}
console.log(sum(10)); //10만 넣음 -> Nan ->if구문 써줘 or 초기값을 0으로 설정해줘.