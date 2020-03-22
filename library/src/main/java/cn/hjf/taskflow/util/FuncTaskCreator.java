package cn.hjf.taskflow.util;

import cn.hjf.taskflow.core.Task;

class FuncTaskCreator {

    public static Task create(Func func) {
        checkFunc(func);

        if (func instanceof Func0) {
            return FuncTaskCreator.create0((Func0) func);
        }
        if (func instanceof Func1) {
            return FuncTaskCreator.create1((Func1) func);
        }
        if (func instanceof Func2) {
            return FuncTaskCreator.create2((Func2) func);
        }
        if (func instanceof Func3) {
            return FuncTaskCreator.create3((Func3) func);
        }
        if (func instanceof Func4) {
            return FuncTaskCreator.create4((Func4) func);
        }
        if (func instanceof Func5) {
            return FuncTaskCreator.create5((Func5) func);
        }
        if (func instanceof Func6) {
            return FuncTaskCreator.create6((Func6) func);
        }
        if (func instanceof Func7) {
            return FuncTaskCreator.create7((Func7) func);
        }
        if (func instanceof Func8) {
            return FuncTaskCreator.create8((Func8) func);
        }
        if (func instanceof Func9) {
            return FuncTaskCreator.create9((Func9) func);
        }
        if (func instanceof Func10) {
            return FuncTaskCreator.create10((Func10) func);
        }
        if (func instanceof FuncN) {
            return FuncTaskCreator.createN((FuncN) func);
        }
        if (func instanceof FuncCreator1) {
            return FuncTaskCreator.createFuncCreator1((FuncCreator1) func);
        }
        if (func instanceof FuncCreator3) {
            return FuncTaskCreator.createFuncCreator3((FuncCreator3) func);
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


    private static Task createFuncCreator1(FuncCreator1 func) {
        return new FuncCreatorTask1(func);
    }

    private static Task createFuncCreator3(FuncCreator3 func) {
        return new FuncCreatorTask3(func);
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

