package cn.hjf.taskflow.sample.test;

import android.util.Log;

import androidx.annotation.NonNull;

import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.util.Func1;
import cn.hjf.taskflow.util.Func3;
import cn.hjf.taskflow.util.FuncExecutor;
import cn.hjf.taskflow.util.FuncGraphBuilder;
import cn.hjf.taskflow.util.IFunc1;

public class CompoundFuncTest {

    private class Vocab {
        String id;
        String content;

        public Vocab(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return "Vocab{" +
                    "id='" + id + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }
    }

    private class Example {
        String content;

        public Example(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "Example{" +
                    "content='" + content + '\'' +
                    '}';
        }
    }

    private class ExampleV2 {
        String content;

        public ExampleV2(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "ExampleV2{" +
                    "content='" + content + '\'' +
                    '}';
        }
    }

    private class Favorite {
        String content;

        public Favorite(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "Favorite{" +
                    "content='" + content + '\'' +
                    '}';
        }
    }

    private class ViewData {
        Vocab vocab;
        ExampleV2 example;
        Favorite favorite;

        public ViewData(Vocab vocab, ExampleV2 example, Favorite favorite) {
            this.vocab = vocab;
            this.example = example;
            this.favorite = favorite;
        }

        @Override
        public String toString() {
            return "ViewData{" +
                    "vocab=" + vocab +
                    ", example=" + example +
                    ", favorite=" + favorite +
                    '}';
        }
    }

    public void testData(final String vocabId) {
        Func1<String, Vocab> getVocab = new Func1<String, Vocab>() {
            @NonNull
            @Override
            protected Vocab process(String s) throws Exception {
                return new Vocab(s, "content of " + s);
            }
        };

        IFunc1<Vocab, ExampleV2> getExample = getExampleByVocab();

        Func1<Vocab, Favorite> getFavorite = new Func1<Vocab, Favorite>() {
            @NonNull
            @Override
            protected Favorite process(Vocab vocab) throws Exception {
                return new Favorite("favorite of " + vocab.content);
            }
        };

        Func3<Vocab, ExampleV2, Favorite, ViewData> mergeData = new Func3<Vocab, ExampleV2, Favorite, ViewData>() {
            @NonNull
            @Override
            protected ViewData process(Vocab vocab, ExampleV2 example, Favorite favorite) throws Exception {
                return new ViewData(vocab, example, favorite);
            }
        };

        IFunc1<String, ViewData> f = (IFunc1<String, ViewData>) new FuncGraphBuilder()
                .joinTo(mergeData, getVocab, getExample, getFavorite)
                .joinTo(getExample, getVocab)
                .joinTo(getFavorite, getVocab)
                .create();

        FuncExecutor.execute(f, new Callback<ViewData>() {
            @Override
            public void onComplete(ViewData o) {
                Log.e("O_O", "onComplete " + vocabId + " , " + o);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("O_O", "onError " + vocabId + " , " + e.getMessage());
            }
        }, vocabId);
    }

    private IFunc1<Vocab, ExampleV2> getExampleByVocab() {
        Func1<Vocab, Example> getExample = new Func1<Vocab, Example>() {
            @NonNull
            @Override
            protected Example process(Vocab vocab) throws Exception {
                return new Example("example of " + vocab.content);
            }
        };
        Func1<Example, ExampleV2> transExample = new Func1<Example, ExampleV2>() {
            @NonNull
            @Override
            protected ExampleV2 process(Example e) throws Exception {
                return new ExampleV2("examplev2 of " + e.content);
            }
        };

        IFunc1<Vocab, ExampleV2> f = (IFunc1<Vocab, ExampleV2>) new FuncGraphBuilder()
                .joinTo(transExample, getExample)
                .create();

        return f;
    }
}
