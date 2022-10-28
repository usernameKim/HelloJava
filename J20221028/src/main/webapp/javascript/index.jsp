<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<script src="object.js"></script>
</head>
<body>
    <form action="index.html" onsubmit="submitFunc()"> 
        id: <input type="text" id="uid" value="user1"><br>
        pw: <input tyep="password" id="upw" value="1234"><br>
        <input type="submit" value="로그인">
    </form>

    <div id="show"></div>

    <script>
        function saveFncc(){
        // document.write('<p>Hello, World</p>')
        // DOM 요소생성.
        let pTag = document.createElement('p'); // <p></p>
        let txt = document.createTextNode('Hello, World');
        pTag.appendChild(txt); // <p>Hello, World</p>
        console.log(pTag);

        let show = document.getElementById('show');
        show.appendChild(pTag);
        console.log(show);
        }

        function submitFunc(){
            event.preventDefault(); // form 기본 기능 차단
            console.log('submitFunc() call.');

            // 엘리먼트 선택하는데 id속성으로 엘리먼트를 선택.
            let id = document.getElementById('uid').value;
            let pw = document.getElementById('upw').value;

            let pTag = document.createElement('p');
            let txt = document.createTextNode('id는 ' + id + ', 비번은 ' + pw);
            pTag.appendChild(txt);

            pTag.onclick = function(){
                log.console(this.remove()); //p 태그 자신.
            }

            document.getElementById('show').appendChild(pTag);
        }
    </script>
</body>
</html>