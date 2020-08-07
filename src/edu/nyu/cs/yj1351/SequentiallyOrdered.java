package edu.nyu.cs.yj1351;

import java.util.ArrayList;

/**
 * interface that guarantee the consistency of objects that contain sequentially ordered lists of things
 */
public interface SequentiallyOrdered {
	
	public abstract OrderedThing getFirst();
	public abstract OrderedThing getLast();
	public abstract ArrayList<OrderedThing> getSequence();
}