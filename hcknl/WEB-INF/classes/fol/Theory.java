// (C) OntoOO Inc 2005 Jan
package fol;

import java.util.*;
import java.io.Serializable;

public class Theory implements Serializable {
    // fixed constants
    // fixed predicates
    // mapping in a domain in which things can be calculated

    private Vector assertions = new Vector(); // atoms
    private Vector axioms = new Vector();
    private Hashtable definitions = new Hashtable(); // iff / <->
    private Vector theorems = new Vector();

    private boolean traceb = false;

    // constructors
    public Theory() { traceb = true; }
    public Theory(boolean bool) { traceb = bool; }

    public Vector getAssertions() { return assertions; }
    public void addAssertion(Atom atom) { 
	// ignore false statements as well as those that can be calculated to be true
	if ( atom.canEvaluate() ) return; 
	assertions.addElement(atom); 
    }
    public Vector getAxioms() { return axioms; }
    public void addAxiom(Formula formula) { 
	Axiom axiom = new Axiom(formula);
	axioms.addElement(axiom); 
    }
    public Equivalence getDefinition(Symbol predicate) { 
	return (Equivalence) definitions.get(predicate); 
    }
    public void addDefinition(Universal formula) { // Universal with inside an Equivalence
	Formula body = formula.getBody();
	if ( body instanceof Universal ) { 
	    addDefinition((Universal) body);
	    return;
	}
	if ( !(body instanceof Equivalence) ) return; // ignore
	Equivalence eq = (Equivalence) body;
	Formula left = eq.getLeft();
	if ( !(left instanceof Atom) ) return; // ignore
	Atom leftAtom = (Atom) left;
	Symbol predicate = leftAtom.getPredicate();
	definitions.put(predicate, eq);
    }

    public Vector getTheorems() { return theorems; }
    public void addTheorem(Formula formula, ProofStep ps) { 
	Theorem theorem = new Theorem(formula, ps);
	theorems.addElement(theorem); 
    }
  
    /* prove should return:
       false: cannot be proven
       undecided, due to resource constraint or the like
       true with a proof
    */
    public ProofStep prove(Formula conjecture, int maxSteps) {
	if ( maxSteps < 0) 
	    return new ProofStep(conjecture, Symbol.UNKNOWN, "Reached Limit");
	if ( conjecture instanceof Atom ) {
	    Atom atomConjecture = (Atom) conjecture;
	    Atom evalOut = atomConjecture.eval();
	    if ( Symbol.UNKNOWN != evalOut )
		return new ProofStepAtom(atomConjecture, 
					 evalOut,
					 "Output of evaluation");
	    if ( null != assertions ) {
		Atom assertion = tryAssertions(atomConjecture, assertions);
		if ( null != assertion ) {
		    return new ProofStepAtom(atomConjecture, 
					     Symbol.TRUE, 
					     "Member of Assertions");
		}
	    } 
	    // check whether we can expand a definition
	    Symbol predicate = atomConjecture.getPredicate();
	    Equivalence eq = getDefinition(predicate);
	    if ( null != eq ) { // will expand this 
		Atom atomDef = (Atom) eq.getLeft();
		Formula target = eq.getRight();
		Vector argsDef = atomDef.getArgs(); // should be variables
		Vector argsConjecture = atomConjecture.getArgs();
		Vector substitutions = new Vector();
		int lng = argsConjecture.size();
		for ( int i = 0; i < lng; i++ ) {
		    Variable var = (Variable) argsDef.elementAt(i);
		    Term term = (Term) argsConjecture.elementAt(i);
		    Substitution subs = new Substitution(var, term);
		    substitutions.addElement(subs);
		}
		target = target.sublis(substitutions);
		ProofStep ps = prove(target, maxSteps - 1);
		return 
		    new ProofStepDefinition(atomConjecture,
					    ps.getResult(),
					    ps);
	    }
	    if ( traceb )
		System.out.println("/// Last resort: try resolution on: " +
				   atomConjecture.html());
	    ProofStep ps = resolve(new Negation(atomConjecture), maxSteps);
	    return new ProofStepResolve(atomConjecture, ps.getResult(), ps);
	}

	// conjecture is NOT an atom -- try splitting
	Formula conjecture2 = Formula.insurer(conjecture);
	if ( conjecture2 instanceof Conjunction ) 
	    return proveConjunction((Conjunction)conjecture2, maxSteps);
	// conjecture2 is an instance of something?
	ProofStep ps = instanceOfAssertions(conjecture2);
	if ( ps.getResult().equals(Symbol.TRUE) ) return ps;
	ps = instanceOfAxioms(conjecture2);
	if ( ps.getResult().equals(Symbol.TRUE) ) return ps;
	ps = instanceOfTheorems(conjecture2);
	if ( ps.getResult().equals(Symbol.TRUE) ) return ps;

	// last resort: try resolution
	Formula negConjecture = new Negation(conjecture2);

	ps = resolve(negConjecture, maxSteps);
	return new ProofStepResolve(conjecture, ps.getResult(), ps);

	/*
	System.out.println("Giving up prove: " + conjecture.html());

	return new ProofStep(conjecture, Symbol.UNKNOWN, "Default exit");
	*/
    }

    private Atom tryAssertions(Atom atomConjecture, Vector assertions) {
	Atom out = null;
	int lng = assertions.size();
	for ( int i = 0; i < lng; i++ ) {
	    Atom atomI = (Atom) assertions.elementAt(i);
	    if ( atomI.equals(atomConjecture) ) {
		out = atomI;
		break;
	    }
	}
	return out;
    }

    private ProofStep resolve(Formula negatedConjecture, int maxSteps) {
	// use here subsumption algorithm ??
	ClausedFormula negatedInput = new ClausedFormula(negatedConjecture);
	CG cg = new CG(true);
	cg.addClausedFormula(negatedInput);
	// add axioms
	int lng = axioms.size();
	for ( int i = 0; i < lng; i++ ) {
	    Axiom aI = (Axiom) axioms.elementAt(i);
	    cg.addClausedFormula(aI);
	}
	// add assertions
	lng = assertions.size();
	for ( int i = 0; i < lng; i++ ) {
	    Atom aI = (Atom) assertions.elementAt(i);
	    Vector vec = new Vector();
	    vec.addElement(aI);
	    PositiveClause pc = new PositiveClause(vec);
	    cg.addPosClause(pc, 0);
	}
	// add theorems
	// ++++

	// show the cg:
	if ( traceb )
	    System.out.println("cg: " + cg.html());

	// invoke tryProve:
	int resolveOut = cg.tryProve(maxSteps);
	/* -1 = cgLinks was empty
	   0 = empty clause found
	   1 = resource exhausted
	*/
	if ( traceb )
	    System.out.println("tryProve: " + resolveOut);
	// show the cg:
	if ( traceb )
	    System.out.println("cg: " + cg.html());

	if  ( 0 == resolveOut )
	    return new ProofStep(negatedConjecture, Symbol.TRUE, "Empty clause found");
	if  ( 1 == resolveOut )
	    return new ProofStep(negatedConjecture, Symbol.UNKNOWN, "Resource exhausted");
	// if  ( -1 == resolveOut )
	    return new ProofStep(negatedConjecture, Symbol.FALSE, "Links empty");

    } // end resolve(...)

    public ProofStep proveConjunction(Conjunction conjunction, int maxSteps) {
	Vector conjuncts = conjunction.getConjuncts();
	int lng = conjuncts.size();
	Vector proofSteps = new Vector();
	for ( int i = 0; i < lng; i++ ) {
	    Formula conI = (Formula) conjuncts.elementAt(i);
	    ProofStep psI = prove(conI, maxSteps);
	    Atom resultI = psI.getResult();
	    if ( !resultI.equals(Symbol.TRUE) ) return psI;
	    proofSteps.addElement(psI);
	}
	return new ProofStepAnd(conjunction, Symbol.TRUE, proofSteps);
    }

    public ProofStep instanceOfAssertions(Formula conjecture2) {
	int lng = assertions.size();
	boolean b;
	for ( int i = 0; i < lng; i++ ) {
	    Atom aI = (Atom) assertions.elementAt(i);
	    b = Formula.instance(conjecture2, aI);
	    if (b) return new ProofStep(conjecture2, Symbol.TRUE, "Instance of Assertion");
	}
	return new ProofStep(conjecture2, Symbol.UNKNOWN, "Undecided");
    }

    public ProofStep instanceOfAxioms(Formula conjecture2) {
	int lng = axioms.size();
	boolean b;
	for ( int i = 0; i < lng; i++ ) {
	    Axiom aI = (Axiom) axioms.elementAt(i);
	    Formula fI = aI.getFormula();
	    b = Formula.instance(conjecture2, fI);
	    if (b) return new ProofStep(conjecture2, Symbol.TRUE, "Instance of Axiom");
	}
	return new ProofStep(conjecture2, Symbol.UNKNOWN, "Undecided");
    }

    public ProofStep instanceOfTheorems(Formula conjecture2) {
	int lng = theorems.size();
	boolean b;
	for ( int i = 0; i < lng; i++ ) {
	    Theorem tI = (Theorem) axioms.elementAt(i);
	    Formula fI = tI.getFormula();
	    b = Formula.instance(conjecture2, fI);
	    if (b) return new ProofStep(conjecture2, Symbol.TRUE, "Instance of Theorem");
	}
	return new ProofStep(conjecture2, Symbol.UNKNOWN, "Undecided");
    }


    public CG setUpCGforConjecture(Formula conjecture) { // conjecture is in miniscope
	Formula negatedConjecture = new Negation(conjecture);
	ClausedFormula negatedInput = new ClausedFormula(negatedConjecture);
	CG cgx = new CG(true);
	cgx.addClausedFormula(negatedInput);
	// add axioms
	int lng = axioms.size();
	for ( int i = 0; i < lng; i++ ) {
	    Axiom aI = (Axiom) axioms.elementAt(i);
	    cgx.addClausedFormula(aI);
	}
	// add assertions
	lng = assertions.size();
	for ( int i = 0; i < lng; i++ ) {
	    Atom aI = (Atom) assertions.elementAt(i);
	    Vector vec = new Vector();
	    vec.addElement(aI);
	    PositiveClause pc = new PositiveClause(vec);
	    cgx.addPosClause(pc, 0);
	}
	// add theorems
	// ++++

	return cgx;
    } // end of setUpCGfor(Formula conjecture)

} // end Theory
