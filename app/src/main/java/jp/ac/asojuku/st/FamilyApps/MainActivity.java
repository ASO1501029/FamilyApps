package jp.ac.asojuku.st.FamilyApps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cardList);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llManager = new LinearLayoutManager(this);
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llManager);

        ArrayList<RouletteData> anbayasi = new ArrayList<RouletteData>();
        for (int i=0; i < MyData.commentArray.length; i++) {
            anbayasi.add(new RouletteData(
                    MyData.commentArray[i]
            ));
        }

        RecyclerView.Adapter adapter = new RouletteAdapter(anbayasi, this);
        recyclerView.setAdapter(adapter);
        recyclerView.smoothScrollToPosition(anbayasi.size() -1);
    }
}
