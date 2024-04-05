// (C) OntoOO Inc 2000

var heartBeatInterval = 10000; // i.e. 10 seconds
var page = document.location.pathname; // the page currently visited

page = page.substring(1 + page.lastIndexOf('/'));
if ( 0 < page.indexOf("html") ) { 
   page = page.substring(0, -5 + page.length);
} else { 
  var idx = page.indexOf('.');
  if ( 0 <= idx ) page = page.substring(1 + idx); 
  }


// to avoid a reply from a cache...
function getRandom() {
	var max_random = 32000
 	return Math.floor(max_random * Math.random());
}

// Assume that the callcenter has a KClient servlet that takes 3 args 
var cnt = 0;
function doBeat() {
    cnt++;
    document.images['contact'].src =
          "/hcknl/servlet/patient.KClient?random=" + getRandom() +
    	  "&page=" + page +
    	  "&counter=" + cnt;

}
var win1 = null; 
function doContact() {
     	win1 = open(
          "/hcknl/servlet/cc.KChatInvitation",
	  "popUp",
	  "resizable=1,scrollbars=1,height=250,width=500"
	);
     	win1.focus();
}
function beatError() {
      if ( null == win1 ) doContact();
      setTimeout("doBeat()", heartBeatInterval);
}                   
function beatSuccess() {
      setTimeout("doBeat()", heartBeatInterval);
}  
        
document.writeln(
	"<img src='" + 
        "/hcknl/servlet/patient.KClient?random=" + getRandom() + 
        "&page=" + page +
        "&counter=0' " + 
        "height='1' width='1' border='0' name='contact' " + 
        "onLoad='beatSuccess()' onError='beatError()' >"
);










