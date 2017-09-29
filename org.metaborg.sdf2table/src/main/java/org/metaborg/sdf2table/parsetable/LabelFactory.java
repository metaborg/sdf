package org.metaborg.sdf2table.parsetable;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.Sets;

public class LabelFactory implements Serializable {

	private static final long serialVersionUID = -8515280863057691520L;

	private int nextLabel;
    private Set<Integer> labelPool;

    public LabelFactory(int initialLabel) {
        this.nextLabel = initialLabel;
        labelPool = null;
    }

    public int getNextLabel() {
        int result = nextLabel;
        
        if(labelPool != null) {
            if(labelPool.isEmpty()) {
                nextLabel++;
                return result;
            } else {
                Iterator<Integer> i = labelPool.iterator();
                result = i.next();
                labelPool.remove(result);
                return result;
            }
        }
        nextLabel++;
        return result;
    }
    
    public void releaseLabel(int l) {
        if(labelPool == null) {
            labelPool = Sets.newHashSet();
        }
        labelPool.add(l);
    }



}
