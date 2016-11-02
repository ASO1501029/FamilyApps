package jp.ac.asojuku.st.FamilyApps;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class RouletteAdapter extends RecyclerView.Adapter<RouletteViewHolder> {
    private ArrayList<RouletteData> rouletteDataSet;
    private Activity activity;

    public RouletteAdapter(ArrayList<RouletteData> roulette, Activity activity) {
        this.activity = activity;
        this.rouletteDataSet = roulette;
    }


    public RouletteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        return new RouletteViewHolder(view);
    }

    public void onBindViewHolder(final RouletteViewHolder holder, final int listPosition) {
        holder.base.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("mailto:");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra(Intent.EXTRA_SUBJECT, "今日の晩御飯");
                intent.putExtra(Intent.EXTRA_TEXT, rouletteDataSet.get(listPosition).getComment());
                activity.startActivity(intent);
            }
        });
    }


public int getItemCount() {
    return rouletteDataSet.size();
}

}