package cn.hjf.taskflow.sample.test;

import android.util.Log;

import cn.hjf.taskflow.util2.Scope;
import cn.hjf.taskflow.util2.Variable;
import cn.hjf.taskflow.util2.VariableReceiver;

public class Util2Test {

    public void f1() {
        Scope scope = new Scope();
        Variable<String> idVariable = scope.declareVariable("id-");
        Variable<Integer> aVariable = scope.declareVariable(1);
        Variable<Vocab> vocabVariable = scope.invokeMethod(Util2Test::getVocab, idVariable, aVariable);
        Variable<OldExample> oldExampleVariable = scope.invokeMethod(Util2Test::getExample, vocabVariable);
        Variable<NewExample> newExampleVariable = scope.invokeMethod(Util2Test::transExample, oldExampleVariable);
        Variable<Favorite> favoriteVariable = scope.invokeMethod(Util2Test::getFavorite, vocabVariable);
        Variable<ViewData> viewDataVariable = scope.invokeMethod(Util2Test::mergeData, vocabVariable, newExampleVariable, favoriteVariable);
        viewDataVariable.read(new VariableReceiver<ViewData>() {
            @Override
            public void onValue(ViewData viewData) {
                Log.e("O_O", viewData.value);
            }

            @Override
            public void onError(Throwable throwable) {
                Log.e("O_O", throwable.getMessage());
            }
        });
    }

    public void f2() {
        Scope scope = new Scope();
        Variable<String> idVariable = scope.declareVariable("id-");
        Variable<Integer> aVariable = scope.declareVariable(2);
        Variable<Vocab> vocabVariable = scope.invokeMethod(Util2Test::getVocab, idVariable, aVariable);

        Variable<NewExample> newExampleVariable = getAndTransExample(scope, vocabVariable);

        Variable<Favorite> favoriteVariable = scope.invokeMethod(Util2Test::getFavorite, vocabVariable);
        Variable<ViewData> viewDataVariable = scope.invokeMethod(Util2Test::mergeData, vocabVariable, newExampleVariable, favoriteVariable);
        viewDataVariable.read(new VariableReceiver<ViewData>() {
            @Override
            public void onValue(ViewData viewData) {
                Log.e("O_O", viewData.value);
            }

            @Override
            public void onError(Throwable throwable) {
                Log.e("O_O", throwable.getMessage());
            }
        });
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    private static Variable<NewExample> getAndTransExample(Scope scope, Variable<Vocab> vocabVariable) {
        Variable<OldExample> oldExampleVariable = scope.invokeMethod(Util2Test::getExample, vocabVariable);
        Variable<NewExample> newExampleVariable = scope.invokeMethod(Util2Test::transExample, oldExampleVariable);
        return newExampleVariable;
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    private static Vocab getVocab(String v, int q) {
        return new Vocab("|vocab " + v + q);
    }

    private static OldExample getExample(Vocab v) {
        return new OldExample("|old example " + v.value);
    }

    private static NewExample transExample(OldExample v) {
        return new NewExample("|new example " + v.value);
    }

    private static Favorite getFavorite(Vocab v) {
        return new Favorite("|favorite " + v.value);
    }

    private static ViewData mergeData(Vocab v1, NewExample v2, Favorite v3) {
        return new ViewData("|view data " + v1.value + " " + v2.value + " " + v3.value);
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    private static class Vocab {
        String value;

        public Vocab(String value) {
            this.value = value;
        }
    }

    private static class OldExample {
        String value;

        public OldExample(String value) {
            this.value = value;
        }
    }

    private static class NewExample {
        String value;

        public NewExample(String value) {
            this.value = value;
        }
    }

    private static class Favorite {
        String value;

        public Favorite(String value) {
            this.value = value;
        }
    }

    private static class ViewData {
        String value;

        public ViewData(String value) {
            this.value = value;
        }
    }
}
