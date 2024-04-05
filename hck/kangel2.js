// (C) OntoOO Inc 2000

// server = "";
// server = "http://localhost:8000"; 
// server = "http://localhost:8080"; // for development
// server = "http://www.kaiser.org:8080"; // using a callcenter there
heartBeatInterval = 10000; // i.e. 10 seconds
page=document.location.pathname; // the page currently visited

// to avoid a reply from a cache...
function getRandom() {
	var max_random = 32000
 	return Math.floor(max_random * Math.random());
}

// Assume that the callcenter has a KClient servlet that takes 3 args 
cnt = 0;
function doBeat() {
    cnt++;
    document.images['contact'].src =
    // document.images[0].src =	
    //    server +
          "/hck/servlet/patient.KClient?random=" + getRandom() +
	  "&page=" + page +
	  "&counter=" + cnt;
}
win1 = null; 
function doContact() {
     	win1 = open(
     //   server + "/servlet/KChatInvitation",
          "/hck/servlet/cc.KChatInvitation",
	  "popUp",
	  "resizable=1,scrollbars=1,height=250,width=500"
	);
     	win1.focus();
}
function beatError() {
       if ( null == win1) doContact();
       setTimeout("doBeat()", heartBeatInterval);
}                   
function beatSuccess() {
      setTimeout("doBeat()", heartBeatInterval);
}  
        
document.writeln(
     "<img src='" + // server +
     "/hck/servlet/patient.KClient?random=" + getRandom() + 
           "&page=" + page +
           "&counter=0' " + 
           "height='1' width='1' border='0' name='contact' " + 
           "onLoad='beatSuccess()' onError='beatError()' >"
);




