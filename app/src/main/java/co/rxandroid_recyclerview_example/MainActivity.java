package co.rxandroid_recyclerview_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
/**
 * Created by dharma kshetri(@dharma.kshetri@gmail.com) on 12/12/16.
 */
public class MainActivity extends AppCompatActivity {
    public final String TAG="RXANDROID";
    RecyclerView recyclerListView;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creating layout
        recyclerListView=(RecyclerView) findViewById(R.id.recylerview_list);
        recyclerListView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter= new MyAdapter(this);
        recyclerListView.setAdapter(myAdapter);
        // creating observales
        creatingObserable();
    }

    // method that added list of names

    public List<String> getNameList(){
        List<String> list= new ArrayList<>();
        list.add("Bob");
        list.add("Dave");
        list.add("Mike");
        list.add("John");
        list.add("Jannie");
        list.add("Ammy");
        return list;
    }

    // creating Obserables
    private void creatingObserable() {
        final Observable <List<String>> listObserable= Observable.just(getNameList());
        listObserable.subscribe(new Observer<List<String>>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted()");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError()",e);
            }

            @Override
            public void onNext(List<String> data) {
                myAdapter.setData(data);
            }
        });

    }
}
