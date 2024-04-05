// (C) OntoOO Inc 2000
package misc;

import java.util.*;
import java.io.*;
import com.Common;

public class DB extends Properties implements Comparable {
  private boolean saved = true;
  private String fileName;
  public DB () { super(); }
  public DB (String fn) throws IOException { 
    fileName = fn;
    FileInputStream fis = new FileInputStream(fileName);
    load(fis);
    fis.close();
  }
  public void setFileName(String fn) { fileName = fn; }
  public void save(String source) throws IOException {
    if (saved) return;
    FileOutputStream fos = new FileOutputStream(fileName);
    store(fos, source);
    fos.close();
    saved = true;
  }
  protected void finalize() {
    if (!saved) try { save("DB-finalize"); } catch (IOException ignore) {}
  }

  public void removeProperty(String key) {
    saved = false;
    remove(key);
  }

  public void putProperty (String key, String value) {
    saved = false;
    setProperty(key, value);
  }

  public void extendProperty(String key, String value) {
    pushProperty(key, value, Common.normalizedDate());
  }

  public void pushProperty(String key, 
				  String value, 
				  String normalizedDate) {
    String episodeKey = key + "-episode";
    String pair = "|" + normalizedDate + "|" + value;
    String oldEpisode = getProperty(episodeKey);
    putProperty(episodeKey, 
		(null == oldEpisode ?
		 pair :
		 pair + oldEpisode));
  }

  public String getStream(String key) {
    return getProperty(key+"-episode");
  }

  public String getMostRecent(String key) {
    String stream = getStream(key);
    if ( null == stream ) return null; 
    StringTokenizer st = new StringTokenizer(stream, "|");
    String elem = ( st.hasMoreTokens() ? st.nextToken() : null );  
    if ( null == elem ) return null; 
    return ( st.hasMoreTokens() ? st.nextToken() : null );
  }

   public int compareTo(Object o2) {
	String acd = getProperty("accountCreationDate");
	if ( null == acd ) return 0;
	DB ss2 = this;
	try { ss2 = (DB) o2; }
	catch (ClassCastException ignore) { return 0; }
	String acd2 = ss2.getProperty("accountCreationDate");
	if ( null == acd2 ) return 0;
	return ( -acd.compareTo(acd2) );
   }
}

