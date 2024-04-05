// (C) OntoOO Inc 2002

heartBeatInterval = 10000; // i.e. 10 seconds
page=document.location.pathname; // the page currently visited

win1 = null; 
function doContact() {
     	win1 = open(
          "/hck/servlet/cc.KChatInvitation",
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
        
// Assume that the callcenter has a KClient servlet that takes 3 args 
cnt = 0;
function doBeat() {
    cnt++;
    document.images['contact'].src =
          "/hck/servlet/patient.KClient?page=" + page +
    	  "&counter=" + cnt;
}

document.writeln(
	"<img src='/hck/servlet/patient.KClient?page=" + page +
        "&counter=0' " + 
        "height='1' width='1' border='0' name='contact' " + 
        "onLoad='beatSuccess()' onError='beatError()' >"
);





