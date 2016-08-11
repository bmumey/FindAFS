/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findafs;

/**
 *
 * @author bmumey
 */
import java.util.Arrays;
import java.util.ArrayList;
import java.util.TreeSet;

public class AFSNode implements Comparable<AFSNode> {

    int node;
    AFSNode parent;
    int[] supportingPaths;
    //ArrayList<PathSegment> supportingSegments;
    float support;
    AFSNode suffixlink;
    AFSNode[] child;
    

    public int compareTo(AFSNode other) {
        return Double.compare(other.support, support);
    }

    public boolean pathContains(int n) {
        if (node == n) {
            return true;
        } else if (parent == null) {
            return false;
        } else {
            return parent.pathContains(n);
        }
    }

    int depth() {
        if (parent == null) {
            return 1;
        } else {
            return 1 + parent.depth();
        }
    }
    
    ArrayList<Integer> getAnchorPath() {
        ArrayList<Integer> pap;
        if (parent == null) {
            pap = new ArrayList<Integer>();
        } else {
            pap = parent.getAnchorPath();

        }
        pap.add(node);
        return pap;
    }
}
