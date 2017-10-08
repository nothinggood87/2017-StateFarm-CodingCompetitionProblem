package sf.codingcomp.blocks.solution;

import sf.codingcomp.blocks.StorageBuildingBlock;

public class StorageBuildingBlockImpl<T> extends BuildingBlockImpl implements StorageBuildingBlock<T> {
T content;
    @Override
    public T getValue() {
        // TODO Auto-generated method stub
        return content;
    }

    @Override
    public void setValue(T value) {
        // TODO Auto-generated method stub
    	content=value;
    }

}
