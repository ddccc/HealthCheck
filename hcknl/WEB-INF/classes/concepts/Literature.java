// (C) OntoOO Inc 2000
package concepts;


public class Literature {

  private String keyLabel;
  private String name;

  public Literature(
	   String keyLabel,
	   String name
	   ) {
    this.keyLabel = keyLabel;
    this.name = name;
  } // end of Literature()

  public String getKeyLabel() { return keyLabel; }

} // end of Literature
