<html>
<body>
<h2>The XMLHttpRequest Object</h2>

<div id="demo">
<p>Let AJAX change this text.</p>
<button type="button" onclick="loadDoc()">Change Content</button>
</div>

<script>
function loadDoc() {
  const xhttp = new XMLHttpRequest();

  xhttp.open("GET", "test.txt",true);
  xhttp.send();
   xhttp.onload = function() {
    document.getElementById("demo").innerHTML = this.responseText;
  }
}
</script>
</body>
</html>
