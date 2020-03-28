package cn.hjf.taskflow.util;

abstract class CompoundFuncBuilder {

    protected GraphBuilder mGraphBuilder;
    protected boolean mHaveEnd = false;

    public CompoundFuncBuilder(IFunc start) {
        checkStart(start);

        mGraphBuilder = new GraphBuilder();
        mGraphBuilder.addFunc(start);
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    protected void checkStart(IFunc start) {
        checkPre(start);
    }

    protected void checkEnd(IFunc end) {
        checkPre(end);
        checkNext(end);

        if (mHaveEnd) {
            throw new RuntimeException("addEnd can only be called once during one build process.");
        }
        mHaveEnd = true;
    }

    protected void checkNormal(IFunc func) {
        checkPre(func);
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    private void checkPre(IFunc func) {
        if (!func.getPreList().isEmpty()) {
            throw new IllegalArgumentException("func: " + func + " already have pre func. " + func.getPreList());
        }
    }

    private void checkNext(IFunc func) {
        if (!func.getNextList().isEmpty()) {
            throw new IllegalArgumentException("func: " + func + " already have next func. " + func.getNextList());
        }
    }
}
