fetch('./MemberListServlet')
    .then(result => result.json())
    .then(userGroupFnc) 
    .catch(error => console.log(error));

function listShow(data = []){
    data.forEach(member => {
        if(member.responsibility == 'admin')
        console.log(member);
    })
    
    //교수님 
    let userGroup =[];
    data.forEach(member =>{
        if(member.responsibility == 'user')
            userGroup.push(member);
    })
    
    // filter를 사용
    userGroup = data.filter(member => member.responsibility =='user');

    userGroup.forEach(row => console.log(row));

}

    // 권한 user인 사람들만 userGroup.
function userGroupFnc(data = []){
    data.filter((row) => row.responsibility =='user')
    .forEach(row => console.log(row));
}

    
