<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<h1>Hello Controller</h1>
<h1>Hello Controller</h1>

<button class="testBtn" data-bno="4">Ajax Test</button>
<ul class="Ul">

</ul>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>
    document.querySelector(".testBtn").addEventListener("click", (e)=>{
        e.stopPropagation()
        e.preventDefault()

        const bno = parseInt(e.target.getAttribute("data-bno"))

        ajaxTest()

    },false)

    async function ajaxTest(){

        const obj={
            name:"choigd",
            age:"19",
        }

        const res = await axios.get('/rest/test/33',{params: obj})

        const list = res.data

        let str=""
        for(let i=0; i< list.length; i++){
            str +=`<li>\${list[i]}</li>`
        }
        console.log(str)
        document.querySelector(".Ul").innerHTML = str

    }

</script>
</body>
</html>
