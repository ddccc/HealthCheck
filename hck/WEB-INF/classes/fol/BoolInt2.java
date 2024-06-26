// (C) OntoOO Inc 2004 Dec
package fol;

import java.util.*;

public class BoolInt2 extends Atom {
    Term leftTerm;
    Term rightTerm;
    BoolInt2(Symbol head, Vector args) {
	super(head, args);
	leftTerm = (Term) args.elementAt(0);
	rightTerm = (Term) args.elementAt(1);
    }
    public Term leftTerm() { return leftTerm; }
    public IntSymbol leftSymbol() { return (IntSymbol) leftTerm; }
    public Term rightTerm() { return rightTerm; }
    public IntSymbol rightSymbol() { return (IntSymbol) rightTerm; }
    // abstract public Atom eval();
    public boolean canEvaluate() { return 
	 ( leftTerm instanceof IntSymbol ) &&
         ( rightTerm instanceof IntSymbol );
    }
}







