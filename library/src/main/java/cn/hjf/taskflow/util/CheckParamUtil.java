package cn.hjf.taskflow.util;

import java.util.Arrays;

final class CheckParamUtil {

    public static void checkParameterCount(String taskName, int paramCount, Object... params) {
        if (params.length != paramCount) {
            throw new RuntimeException("parameter count error for " + taskName + ", need " + paramCount + " parameters, but received " + params.length + ", " + Arrays.toString(params));
        }
    }

    public static void checkParameterForIFunc0(String taskName, Object... params) {
        if (params.length == 0) {
            return;
        }
        if (params.length == 1 && params[0] == null) {
            return;
        }
        throw new RuntimeException("parameter count error for " + taskName + ", need 0 parameter or one null parameter, but received " + params.length + ", " + Arrays.toString(params));
    }
}
