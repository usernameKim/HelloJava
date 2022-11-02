// covid.js

window.onload = function () {
    console.log('win');
    // request url.
    let url =
        'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&returnType=JSON&serviceKey=i4nbKclGfuZkK28%2F8jpHPhUTCcwQRKj7FLqEd%2BMySW1SU8Yj6ryJ0%2BQqLJNefRb70eXs3wsCWrPOaS%2BuSAJiBA%3D%3D';

    fetch(url)
        .then(result => result.json())
        .then(showList)
        .catch(error => console.log(error));

    document.querySelector('#findBtn').addEventListener('click', findCenterList);
}
let titles = {
    id: '센터아이디',
    centerName: '센터명',
    facilityName: '기관명',
    phoneNumber: '연락처',
    lat: '위도',
    lng: '경도'

};
let data; //다른곳에서도 사용하려고


function showList(result) {
    // 타이틀 생성부분.
    makeHead();

    // body 영역 생성. 데이터 초기화.
    console.log(result);
    data = result.data;

    // option 태그 생성.
    makeOption(data);

    let selectedCity = data.filter(center => center.sido == '서울특별시');
    makeList(selectedCity);
}

function makeOption(ary = []) {
    // select태그 생성. 중복값 제외(서울특별시, 대전광역시, 인천광역시, 경기도...)
    let sidoAry = [];
    ary.forEach(center => {
        // data에 있는 센터정보와 sidoAry에 있는 센터정보를 비교.
        // sidoAry에 값이 있으면 no, sidoAry에 값이 없으면 추가.
        if (sidoAry.indexOf(center.sido) == -1) { 
            sidoAry.push(center.sido);
        }
    });
    // option태그 생성. sidoAry값을 option안에 넣어줌.
    let cityList = document.getElementById('city')
    sidoAry.forEach(sido => {
        let option = document.createElement('option');
        option.value = sido;
        option.textContent = sido;
        cityList.append(option);
    });

}

function findCenterList() {
    let searchKey = document.querySelector('#city').value;
    let searchAry = data.filter(center => center.sido == searchKey);
    makeList(searchAry);
}

function makeList(ary = []) {
    // 화면에 tr이 있으면 tr삭제.
    document.querySelectorAll('#list>tr').forEach(tr => tr.remove());
    let list = document.getElementById('list');
    ary.forEach(center => {
        list.append(makeTr(center));
    });
}

function makeTr(row = {}) { //object
    let tr = document.createElement('tr');
    tr.setAttribute('lng', row.lng);
    tr.setAttribute('lat', row.lat);
    tr.setAttribute('facilityName', row.facilityName );
    tr.addEventListener('click', openInfoWindow);
    // td생성.
    for (let field in titles) {
        let td = document.createElement('td');
        let txt = document.createTextNode(row[field]);
        td.appendChild(txt);
        tr.appendChild(td);
    }
    return tr;
}

function openInfoWindow(e){
    console.log(e.target.parentElement); //tr을 찾고싶음: tr lng, lat
    let lng = e.target.parentElement.getAttribute('lng');
    let lat = e.target.parentElement.getAttribute('lat');
    let facilityName = e.target.parentElement.getAttribute('facilityName');

    window.location.href = 'infoWindow.html?x=' + lng + '&y=' + lat + '&facilityName=' +facilityName ;
}
function makeHead() {
    // 타이틀.
    let tr = document.createElement('tr');
    for (let title in titles) {
        let th = document.createElement('th');
        let txt = document.createTextNode(titles[title]);
        th.appendChild(txt);
        tr.appendChild(th);
    }
    document.getElementById('title').append(tr);
}