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

// Assume that the callcenter has a KClient servlet that takes 
// as arguments page and counter

cnt = 0;
function checkImage() {
    width = document.images['contact'].width;
    if ( 1 < width  && null == win1 ) doContact();
    cnt++;
    // alert("cnt: " + cnt + " width: " + width);
    document.images['contact'].src =
          "/hck/servlet/patient.KClient?" + 
	  "page=" + page + "&counter=" + cnt;
    setTimeout("checkImage()", heartBeatInterval);
}

document.writeln(
     "<img src='" + 
           "/hck/servlet/patient.KClient?" + 
           "page=" + page + "&counter=0' " + 
           "border='0' name='contact' >");

checkImage();



