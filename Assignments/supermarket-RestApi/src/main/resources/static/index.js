function loadDoc() {
    const xmlhttp = new XMLHttpRequest();
    xmlhttp.onload = function() {
      const myObj = JSON.parse(this.responseText);
      let text = "<table border='1'>"
      text+="<tr><th>"+ "Id" + "</th><th>" + "StoreName" + "</th><th>" + "Owner" + "</th><th>" + "Address" + "</th>";
      for (let x in myObj) {
        text += "<tr><td>" + myObj[x].id +"</td><td>"+ myObj[x].storeName +"</td><td>" + myObj[x].storeOwner.storeOwner
                + "</td><td>"+ myObj[x].address +"</td></tr>";
      }
      text += "</table>"
      document.getElementById("demo").innerHTML = text;
    }
    xmlhttp.open("GET", "http://localhost:8080/api/markets");
   xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send();
}

function loadDoc1() {
     var id=document.getElementById("idvalue").value;
    const xmlhttp = new XMLHttpRequest();
    xmlhttp.onload = function() {
      const myObj = JSON.parse(this.responseText);
      let text = "<table border='1'>"
      text+="<tr><th>"+ "Id" + "</th><th>" + "StoreName" + "</th><th>" + "Owner" + "</th><th>" + "Address" + "</th>";
      for (let x in myObj) {
        text += "<tr><td>" + myObj[x].id +"</td><td>"+ myObj[x].storeName +"</td><td>" + myObj[x].storeOwner.storeOwner
        + "</td><td>"+ myObj[x].address +"</td></tr>";
      }
      text += "</table>"
      document.getElementById("demo1").innerHTML = text;
    }
    xmlhttp.open("GET", "http://localhost:8080/api/market/"+id);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send();
}

function loadDoc2() {
     var name=document.getElementById("idstr").value;
    const xmlhttp = new XMLHttpRequest();
    xmlhttp.onload = function() {
      const myObj = JSON.parse(this.responseText);
      let text = "<table border='1'>"
      text+="<tr><th>"+ "Id" + "</th><th>" + "StoreName" + "</th><th>" + "Owner" + "</th><th>" + "Address" + "</th>";
      for (let x in myObj) {
        text += "<tr><td>" + myObj[x].id +"</td><td>"+ myObj[x].storeName +"</td><td>" + myObj[x].storeOwner.storeOwner
                + "</td><td>"+ myObj[x].address +"</td></tr>";
      }
      text += "</table>"
      document.getElementById("demo2").innerHTML = text;
    }
    xmlhttp.open("GET", "http://localhost:8080/api/market/name/"+name);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send();
}

function loadDoc3() {
  const xhttp = new XMLHttpRequest();
   xhttp.onload = function() {
    document.getElementById("demo3").innerHTML = this.responseText;
  }
  xhttp.open("GET", "https://api.nasa.gov/planetary/apod?api_key=Fux70xmXXs8UmWsxF9CPok3jroXdGoPWRxY14G9v",true);
  xhttp.send();
}



//function loadDoc() {
//  const xhttp = new XMLHttpRequest();
//  xhttp.onload = function() {
//    document.getElementById("demo").innerHTML = this.responseText;
//  }
//  xhttp.open("GET", "http://localhost:8080/api/markets",true);
//  xhttp.send();
//}

//function loadDoc1() {
//   var id=document.getElementById("idvalue").value;
//   const xhttp = new XMLHttpRequest();
//   xhttp.onload = function() {
//    document.getElementById("demo1").innerHTML = this.responseText;
//  }
//   xhttp.open("GET", "http://localhost:8080/api/market/"+id,true);
//   xhttp.send();
//}
//
//function loadDoc2() {
//    var name=document.getElementById("idstr").value;
//  const xhttp = new XMLHttpRequest();
//   xhttp.onload = function() {
//    document.getElementById("demo2").innerHTML = this.responseText;
//  }
//  xhttp.open("GET", "http://localhost:8080/api/market/name/"+name,true);
//  xhttp.send();
//}
//
//function loadDoc3() {
//  const xhttp = new XMLHttpRequest();
//   xhttp.onload = function() {
//    document.getElementById("demo3").innerHTML = this.responseText;
//  }
//  xhttp.open("GET", "https://api.nasa.gov/planetary/apod?api_key=Fux70xmXXs8UmWsxF9CPok3jroXdGoPWRxY14G9v",true);
//  xhttp.send();
//}