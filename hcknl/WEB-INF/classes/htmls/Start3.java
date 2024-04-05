// (C) OntoOO Inc 2004 Mar
package htmls;

import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.util.*; 
 
public class Start3 extends HttpServlet { 
   public void doGet (HttpServletRequest req, 
                      HttpServletResponse res) 
       throws ServletException, IOException { 
     call(res); 
} 
 
static public void call(HttpServletResponse res) 
    throws IOException { 
    res.setContentType("text/html"); 
    ServletOutputStream out = res.getOutputStream(); 
    String str = 


"<html>  \n"  +
"<head>  \n"  +
"   <title>  \n"  +
"Set up new user 3  \n"  +
"   </title>  \n"  +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"/hcknl/hckStyle.css\" /><link rel=\"shortcut icon\" href=\"/hcknl/favicon.ico\" type=\"image/x-icon\" /></head>  \n"  +
"<script language=\"JavaScript\">  \n"  +
"function isNumberString (InString) {  \n"  +
"   if (0==InString.length) return (false);  \n"  +
"   var RefString='1234567890';  \n"  +
"   for (Count=0; Count<InString.length; Count++) {  \n"  +
"      TempChar = InString.charAt(Count);  \n"  +
"      if (-1 == RefString.indexOf(TempChar)) return (false);  \n"  +
"   }  \n"  +
"   return (true);  \n"  +
"}  \n"  +
"function checkFields(form) {  \n"  +
"   lng = form.illnesses.length;  \n"  +
"   // alert('lng: ' + lng);  \n"  +
"   for (i = 0; i<lng; i++) {   \n"  +
"      if ( form.illnesses[i].checked ) {  \n"  +
"         val = form.illnesses[i].value;  \n"  +
"	 // alert('val: ' + val + ' i: ' + i);  \n"  +
"	 expr = 'form.' + val;  \n"  +
"	 //alert('expr: ' + expr);  \n"  +
"	 val2 = (eval(expr)).value;  \n"  +
"	 // alert('val2: ' + val2);  \n"  +
"	 if ( 4 != val2.length ) {  \n"  +
"	    alert('Provide year for: ' + val);  \n"  +
"	    return;  \n"  +
"	 }  \n"  +
"	 isNumber = isNumberString(val2);  \n"  +
"	 if ( 1 != isNumber  ) {  \n"  +
"	    alert('Provide year for: ' + val);  \n"  +
"	    return;  \n"  +
"	 }  \n"  +
"	 number = parseInt(val2);  \n"  +
"        theDate = new Date(); theYear = theDate.getFullYear();  \n"  +
"	 if ( number < 1900 || theYear < number ) {  \n"  +
"	    alert('Provide year for: ' + val);  \n"  +
"	    return;  \n"  +
"	 }  \n"  +
"      }   \n"  +
"  }   \n"  +
"  form.submit();  \n"  +
"}  \n"  +
"</script>  \n"  +
"  \n"  +
"<body>  \n"  +
"<font color=\"#850a0a\">  \n"  +
"  \n"  +
"<h1 align=\"center\">  \n"  +
"   <font color=\"#1C5540\" size=\"4\">  \n"  +
"OK, Here the 3rd Set of Questions  \n"  +
"   </font>  \n"  +
"</h1>  \n"  +
"  \n"  +
"<form method=\"post\" name=\"diseases\" action=\"/hcknl/servlet/patient.Setup3\">  \n"  +
"<table border=\"1\">  \n"  +
"<tr>  \n"  +
"  <td><b>Illnesses:</b></td>  \n"  +
"</tr>  \n"  +
"<tr>  \n"  +
"  <td colspan=\"3\">Check which apply & add year of illness</td>  \n"  +
"</tr>  \n"  +
"<tr><td>asthma / reversible lung disease: narrowing of the airways due to inflammation  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"asthma\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"asthma\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>cystitis / infection of the bladder  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"cystitis\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"cystitis\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>cancer / impaired enlarged disfunctional cells that divide more rapidly than normal   \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"cancer\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"cancer\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>chicken pox / pneumonia caused by chickenpox viral infection  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"chickenpox\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"chickenpox\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>diabetes / a family of diseases defined by increased urine production  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"diabetes\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"diabetes\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>emphysema / irreversible enlargement of airspace in the lungs resulting in decreased elastic recoil  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"emphysema\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"emphysema\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>cholelithiasis / gallstone in the gallbladder  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"cholelithiasis\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"cholelithiasis\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>glaucoma / abnormal high pressure inside the eye that can damage the optic nerve  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"glaucoma\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"glaucoma\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>gonorrhea / infection of the genitouri tract  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"gonorrhea\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"gonorrhea\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>gout / metabolic deficiency causing urate deposits producing painful arthritis joints  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"gout\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"gout\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>myocardial infarction / impaired blood flow through the heart arteries  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"myocardialInfarction\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"myocardialInfarction\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>hepatitis / liver damage which can be  fatal in old age and when there are underlying complications  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"hepatitis\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"hepatitis\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>pyelonephritis / bacterial infection of the kidneys  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"pyelonephritis\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"pyelonephritis\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>renal calculi / kidney stones  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"renalCalculi\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"renalCalculi\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>malaria / acute infection by a protozoa of the genus Plasmodicum, which is transmitted by mosquitos  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"malaria\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"malaria\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>measles / pneumonia caused by measles viral infection  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"measles\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"measles\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>rubella / German measles / acute infection by the rubella virus, which is contagious  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"rubella\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"rubella\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>Epstein-Barr Disease / mononucleosis / infection by Epstein-Barr virus  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"epsteinBarrDisease\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"epsteinBarrDisease\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>mumps / infection by paramyxovirus  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"mumps\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"mumps\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>pneumonia / pneumonia = inflammation of the lungs  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"pneumonia\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"pneumonia\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>rheumatic fever / a streptococcal infection usually affecting joints with potential impact on the heart  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"rheumaticFever\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"rheumaticFever\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>cerebrovascular accident / (stroke) impairment of one or more brain blood vessels   \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"cerebrovascularAccident\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"cerebrovascularAccident\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>syphilis / infection by the spirochete treponema pallidum  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"syphilis\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"syphilis\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"<tr><td>tuberculosis / infection by tuberculosis mycobacterium  \n"  +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\"  \n"  +
"       value=\"tuberculosis\" />  \n"  +
"  </td><td>  \n"  +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"tuberculosis\" value=\"\" />  \n"  +
"  </td></tr>  \n"  +
"  \n"  +
"</table>  \n"  +
"  \n"  +
"<hr />  \n"  +
"Please check your data before submitting  \n"  +
"<input type=\"button\" value=\"Submit\" onClick=\"checkFields(this.form)\" />  \n"  +
"</form>  \n"  +
"  \n"  +
"</font>  \n"  +
"</body>  \n"  +
"</html>  \n"  +
"";
   out.println(str); 

}}
