package cn.hjf.taskflow.util;

abstract class CompoundFuncBuilder {

    protected GraphBuilder mGraphBuilder;
    protected boolean mHaveEnd = false;

    public CompoundFuncBuilder(IFunc start) {
        mGraphBuilder = new GraphBuilder();
        mGraphBuilder.addFunc(start);
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    protected void checkEnd() {
        if (mHaveEnd) {
            throw new RuntimeException("addEnd can only be called once during one build process.");
        }
        mHaveEnd = true;
    }
}
