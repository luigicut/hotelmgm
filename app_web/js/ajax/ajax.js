function loadPageProva() {
  
  //var IDprogetto = document.getElementsByClassName("progetto");
  
  //console.log('IDprogetti:', IDprogetto);
  //console.log('id: ', IDprogetto[id-1].attributes[1].nodeValue);
  //var ID = IDprogetto[id-1].attributes[1].nodeValue;
  
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("page-wrapper").innerHTML = this.responseText;
    }
  };
  
  xhttp.open("GET", "/pages/prova.html", true);
  xhttp.send();
  
}