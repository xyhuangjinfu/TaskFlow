package cn.hjf.taskflow.sample.test;

import android.util.Log;

import androidx.annotation.NonNull;

import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.util.Func1;
import cn.hjf.taskflow.util.Func3;
import cn.hjf.taskflow.util.FuncExecutor;
import cn.hjf.taskflow.util.FuncGraphBuilder;
import cn.hjf.taskflow.util.IFunc1;

public class FuncGraphTest {

    class Vocab {
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

    class Example {
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

    class Favorite {
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

    class ViewData {
        Vocab vocab;
        Example example;
        Favorite favorite;

        public ViewData(Vocab vocab, Example example, Favorite favorite) {
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

        Func1<Vocab, Example> getExample = new Func1<Vocab, Example>() {
            @NonNull
            @Override
            protected Example process(Vocab vocab) throws Exception {
                return new Example("example of " + vocab.content);
            }
        };

        Func1<Vocab, Favorite> getFavorite = new Func1<Vocab, Favorite>() {
            @NonNull
            @Override
            protected Favorite process(Vocab vocab) throws Exception {
                return new Favorite("favorite of " + vocab.content);
            }
        };

        Func3<Vocab, Example, Favorite, ViewData> mergeData = new Func3<Vocab, Example, Favorite, ViewData>() {
            @NonNull
            @Override
            protected ViewData process(Vocab vocab, Example example, Favorite favorite) throws Exception {
                return new ViewData(vocab, example, favorite);
            }
        };

        IFunc1<String, Vocab> f = (IFunc1<String, Vocab>) new FuncGraphBuilder()
                .joinTo(mergeData, getVocab, getExample, getFavorite)
                .joinTo(getExample, getVocab)
                .joinTo(getFavorite, getVocab)
                .create();

        FuncExecutor.execute(f, new Callback<ViewData>(){
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
}
