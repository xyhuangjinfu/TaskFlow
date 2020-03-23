package cn.hjf.taskflow.util;

import cn.hjf.taskflow.core.Task;

class TaskGenerator {

    public static Task create(Func func) {
        checkFunc(func);

        if (func instanceof Func0) {
            return create0((Func0) func);
        }
        if (func instanceof Func1) {
            return create1((Func1) func);
        }
        if (func instanceof Func2) {
            return create2((Func2) func);
        }
        if (func instanceof Func3) {
            return create3((Func3) func);
        }
        if (func instanceof Func4) {
            return create4((Func4) func);
        }
        if (func instanceof Func5) {
            return create5((Func5) func);
        }
        if (func instanceof Func6) {
            return create6((Func6) func);
        }
        if (func instanceof Func7) {
            return create7((Func7) func);
        }
        if (func instanceof Func8) {
            return create8((Func8) func);
        }
        if (func instanceof Func9) {
            return create9((Func9) func);
        }
        if (func instanceof Func10) {
            return create10((Func10) func);
        }
        if (func instanceof FuncN) {
            return createN((FuncN) func);
        }
        if (func instanceof FuncCreator0) {
            return createFuncCreator0((FuncCreator0) func);
        }
        if (func instanceof FuncCreator1) {
            return createFuncCreator1((FuncCreator1) func);
        }
        if (func instanceof FuncCreator2) {
            return createFuncCreator2((FuncCreator2) func);
        }
        if (func instanceof FuncCreator3) {
            return createFuncCreator3((FuncCreator3) func);
        }
        if (func instanceof FuncCreator4) {
            return createFuncCreator4((FuncCreator4) func);
        }
        if (func instanceof FuncCreator5) {
            return createFuncCreator5((FuncCreator5) func);
        }
        if (func instanceof FuncCreator6) {
            return createFuncCreator6((FuncCreator6) func);
        }
        if (func instanceof FuncCreator7) {
            return createFuncCreator7((FuncCreator7) func);
        }
        if (func instanceof FuncCreator8) {
            return createFuncCreator8((FuncCreator8) func);
        }
        if (func instanceof FuncCreator9) {
            return createFuncCreator9((FuncCreator9) func);
        }
        if (func instanceof FuncCreator10) {
            return createFuncCreator10((FuncCreator10) func);
        }
        if (func instanceof FuncCreatorN) {
            return createFuncCreatorN((FuncCreatorN) func);
        }

        throw new RuntimeException("unsupported func type : " + func.getClass().getName());
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    private static Task create0(Func0 func) {
        return new FuncTask0(func);
    }

    private static Task create1(Func1 func) {
        return new FuncTask1(func);
    }

    private static Task create2(Func2 func) {
        return new FuncTask2(func);
    }

    private static Task create3(Func3 func) {
        return new FuncTask3(func);
    }

    private static Task create4(Func4 func) {
        return new FuncTask4(func);
    }

    private static Task create5(Func5 func) {
        return new FuncTask5(func);
    }

    private static Task create6(Func6 func) {
        return new FuncTask6(func);
    }

    private static Task create7(Func7 func) {
        return new FuncTask7(func);
    }

    private static Task create8(Func8 func) {
        return new FuncTask8(func);
    }

    private static Task create9(Func9 func) {
        return new FuncTask9(func);
    }

    private static Task create10(Func10 func) {
        return new FuncTask10(func);
    }

    private static Task createN(FuncN func) {
        return new FuncTaskN(func);
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    private static Task createFuncCreator0(FuncCreator0 func) {
        return new CreateFuncTask0(func);
    }

    private static Task createFuncCreator1(FuncCreator1 func) {
        return new CreateFuncTask1(func);
    }

    private static Task createFuncCreator2(FuncCreator2 func) {
        return new CreateFuncTask2(func);
    }

    private static Task createFuncCreator3(FuncCreator3 func) {
        return new CreateFuncTask3(func);
    }

    private static Task createFuncCreator4(FuncCreator4 func) {
        return new CreateFuncTask4(func);
    }

    private static Task createFuncCreator5(FuncCreator5 func) {
        return new CreateFuncTask5(func);
    }

    private static Task createFuncCreator6(FuncCreator6 func) {
        return new CreateFuncTask6(func);
    }

    private static Task createFuncCreator7(FuncCreator7 func) {
        return new CreateFuncTask7(func);
    }

    private static Task createFuncCreator8(FuncCreator8 func) {
        return new CreateFuncTask8(func);
    }

    private static Task createFuncCreator9(FuncCreator9 func) {
        return new CreateFuncTask9(func);
    }

    private static Task createFuncCreator10(FuncCreator10 func) {
        return new CreateFuncTask10(func);
    }

    private static Task createFuncCreatorN(FuncCreatorN func) {
        return new CreateFuncTaskN(func);
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    private static void checkFunc(Func func) {
        if (func.isAttached()) {
            throw new IllegalArgumentException("func can not attach to more than one task");
        }
    }
}

