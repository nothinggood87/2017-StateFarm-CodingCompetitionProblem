package sf.codingcomp.blocks.solution;

import java.util.ArrayList;
import java.util.Iterator;

import sf.codingcomp.blocks.BuildingBlock;
import sf.codingcomp.blocks.CircularReferenceException;

public class BuildingBlockImpl implements BuildingBlock {
	BuildingBlock upper,lower;
    public Iterator<BuildingBlock> iterator() {
    	ArrayList<BuildingBlock> a = new ArrayList<BuildingBlock>();
    	BuildingBlock n = this;
    	while(n!=null) {
    		a.add(n);
    		n=n.findBlockOver();
    	}
        return a.iterator();
    }
    @Override
    public void stackOver(BuildingBlock b) {
    	upper = b;
    	if(b!=null&&b.findBlockOver()!=this) {
			b.stackUnder(this);
    		}
    	if(findBlockUnder()!=null&&findBlockUnder().findBlockUnder()!=null&&findBlockUnder().findBlockUnder().findBlockUnder()==this)
    	{
    		throw new CircularReferenceException("self chained iterate list");
    	}
    }

    @Override
    public void stackUnder(BuildingBlock b) {
    	if(b==null) {
    		lower=null;
    		return;
    	}
    	if(b.findBlockUnder()!=null) {
    		b.findBlockUnder().stackUnder(null);
    	}
    	lower = b;
    	if(b.findBlockUnder()!=this) {
			b.stackOver(this);
    		}
    	if(findBlockUnder()!=null&&findBlockUnder().findBlockUnder()!=null&&findBlockUnder().findBlockUnder().findBlockUnder()==this)
    	{
    		throw new CircularReferenceException("self chained iterate list");
    	}
    }

    @Override
    public BuildingBlock findBlockUnder() {
        // TODO Auto-generated method stub
        return upper;
    }

    @Override
    public BuildingBlock findBlockOver() {
        // TODO Auto-generated method stub
        return lower;
    }

}
