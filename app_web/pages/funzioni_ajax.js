//Funzione per la gestione asincrona AJAX
function xmlhttpPost(strURL) {
             var xmlHttpReq = false;
             var self = this;
             
			 if (window.XMLHttpRequest) {self.xmlHttpReq = new XMLHttpRequest();}
                                   else if (window.ActiveXObject) {self.xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");}

             self.xmlHttpReq.open('POST', strURL, true);
             self.xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
             self.xmlHttpReq.send(recuperaValore());
 
/* Valuto lo stato della richiesta */
             self.xmlHttpReq.onreadystatechange = function() {
                                                  if (self.xmlHttpReq.readyState == 4) {aggiornaPagina(self.xmlHttpReq.responseText);}
                                                             }
}


/*Questa funzione recupera i dati dal form.*/
function recuperaValore() {
            var form = document.forms['form'];
            var nome = form.nome.value;
            valore = 'nome=' + escape(nome);
return valore;
}


/*Questa funzione viene richiamata dall'oggetto xmlHttpReq per l'aggiornamento asincrono dell'elemento risultato*/
function aggiornaPagina(stringa){
document.getElementById("page-wrapper").innerHTML = stringa;
}

