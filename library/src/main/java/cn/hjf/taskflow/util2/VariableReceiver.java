package cn.hjf.taskflow.util2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface VariableReceiver<V> {

    void onValue(@Nullable V v);

    void onError(@NonNull Throwable throwable);
}
