// (C) OntoOO Inc 2007 Apr
package actors;

public class MonitorCandidate  { 
    private Monitor monitor = null;
    private State upStreamState1 = null;
    private State upStreamState2 = null;
    private int interval = 10000000;

    public MonitorCandidate(Monitor m, State u, int i) {
	monitor = m; upStreamState1 = u; interval = i;
    }
    public MonitorCandidate(Monitor m, State u1, State u2, int i) {
	monitor = m; upStreamState1 = u1; upStreamState2 = u2; interval = i;
    }

    public Monitor getMonitor() { return monitor; }
    public State getUpStreamState1() { return upStreamState1; }
    public State getUpStreamState2() { return upStreamState2; }
    public int getInterval() { return interval; }

} // end MonitorCandidate
