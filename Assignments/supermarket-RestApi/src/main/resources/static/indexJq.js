$(document).ready(function(){
  $("button").click(function(){
    $("#demo").load("http://localhost:8080/api/markets");
  });
});
$(document).ready(function(){
  $("button").click(function(){
  var id=$("#demo1").val();
    $("#demo1").load("http://localhost:8080/api/market/"+id);
  });
});
$(document).ready(function(){
  $("button").click(function(){
  var name=$("#demo2").val();
    $("#demo2").load("http://localhost:8080/api/market/name/"+name);
  });
});
$(document).ready(function(){
  $("button").click(function(){
    $("#demo3").load("https://api.nasa.gov/planetary/apod?api_key=Fux70xmXXs8UmWsxF9CPok3jroXdGoPWRxY14G9v");
  });
});