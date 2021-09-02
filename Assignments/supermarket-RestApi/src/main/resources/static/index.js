//$(document).ready(function(){
//  $("button").click(function(){
//    $("#demo").load("http://localhost:8080/api/markets");
//  });
//});
//$(document).ready(function(){
//  $("button").click(function(){
//  var id=$("#demo1").val();
//    $("#demo1").load("http://localhost:8080/api/market/"+id);
//  });
//});
//$(document).ready(function(){
//  $("button").click(function(){
//  var name=$("#demo2").val();
//    $("#demo2").load("http://localhost:8080/api/market/name/"+name);
//  });
//});
//$(document).ready(function(){
//  $("button").click(function(){
//    $("#demo3").load("https://api.nasa.gov/planetary/apod?api_key=Fux70xmXXs8UmWsxF9CPok3jroXdGoPWRxY14G9v");
//  });
//});

function loadDoc() {
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
    document.getElementById("demo").innerHTML = this.responseText;
  }
  xhttp.open("GET", "http://localhost:8080/api/markets",true);
  xhttp.send();
}

function loadDoc1() {
   var id=document.getElementById("idvalue").value;
   const xhttp = new XMLHttpRequest();
   xhttp.onload = function() {
    document.getElementById("demo1").innerHTML = this.responseText;
  }
   xhttp.open("GET", "http://localhost:8080/api/market/"+id,true);
   xhttp.send();
}

function loadDoc2() {
    var name=document.getElementById("idstr").value;
  const xhttp = new XMLHttpRequest();
   xhttp.onload = function() {
    document.getElementById("demo2").innerHTML = this.responseText;
  }
  xhttp.open("GET", "http://localhost:8080/api/market/name/"+name,true);
  xhttp.send();
}

function loadDoc3() {
<!--    var name=document.getElementById("idstr").value;-->
  const xhttp = new XMLHttpRequest();
   xhttp.onload = function() {
    document.getElementById("demo3").innerHTML = this.responseText;
  }
  xhttp.open("GET", "https://api.nasa.gov/planetary/apod?api_key=Fux70xmXXs8UmWsxF9CPok3jroXdGoPWRxY14G9v",true);
  xhttp.send();
}