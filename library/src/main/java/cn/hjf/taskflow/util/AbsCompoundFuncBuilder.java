package cn.hjf.taskflow.util;

abstract class AbsCompoundFuncBuilder {

    protected GraphBuilder mGraphBuilder;
    protected IFunc mStart;
    protected boolean mHaveEnd = false;

    public AbsCompoundFuncBuilder(IFunc start) {
        mStart = start;
        mGraphBuilder = new GraphBuilder();
        mGraphBuilder.addFunc(mStart);
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
