package cn.hjf.taskflow.util;

import java.util.Arrays;

final class CheckParamUtil {

    public static void checkParameterCount(String taskName, int paramCount, Object... params) {
        if (params.length != paramCount) {
            throw new RuntimeException("parameter count error for " + taskName + ", need " + paramCount + " parameters, but received " + params.length + ", " + Arrays.toString(params));
        }
    }
}
