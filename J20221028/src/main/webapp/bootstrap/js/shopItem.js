// shopItem.js

fetch('../ShopItemListServlet')
.then( result => result.json())
.then( itemListShow)
.catch( err => console.error(err));

function itemListShow(result){
    console.log(result);
    result.forEach(item => {
        makeItemDiv(item)
    })
}

function makeItemDiv(item ={}){
    console.log(item);
    let template = document.querySelector('#template>div');
    let good = template.cloneNode(true); // true -> 하위요소도 출력, good-> 템플릿을 가져온 것
    good.querySelector('h5').textContent = item.itemName;
    good.querySelector('img.card-img-top').src = '../images/' + item.image; 
    good.querySelector('span.text-muted').textContent = item.originPrice;
    good.querySelector('span.text-muted').nextSibling.textContent = " " + item.salePrice; // 동생요소찾기(span태그의 그다음요소)

    // review
    let review = item.likeIt; //4.5
    let a = Math.floor(review); //온쪽.
    let b = review -a; // 0, .5 등이 나옴..(반쪽)
    for(let i=0; i<a; i++){
        let div = document.createElement('div');
        div.className = 'bi-star-fill'; // <div class ='bi-star-fill'>
       
        good.querySelector('div.d-flex').append(div);
    }
    if(b){
        let div = document.createElement('div');
        div.className = 'bi-star-half'; // <div class ='bi-star-fill'>
        good.querySelector('div.d-flex').append(div);
    }
    // 목록.
    let parent = document.querySelector('section.py-5>div>div');
    parent.append(good);
    console.log(good);

    //카트에 담기
    let badge = good.querySelector('span.badge').textContent;
    document.querySelector('a.btn').addEventListener('click', addFunc()); 
    function addFunc(){
        
    }
}