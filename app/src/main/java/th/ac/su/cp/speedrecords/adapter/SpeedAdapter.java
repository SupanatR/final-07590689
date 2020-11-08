package th.ac.su.cp.speedrecords.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import th.ac.su.cp.speedrecords.R;
import th.ac.su.cp.speedrecords.model.Speed;

public class SpeedAdapter extends RecyclerView.Adapter<SpeedAdapter.MyViewHolder> {

    private Context mContext;
    private Speed[] mSpeed;

    public SpeedAdapter(Context context, Speed[] speeds) {
        this.mContext = context;
        this.mSpeed = speeds;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_speed, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Speed speed = mSpeed[position];

        holder.sumNumTextView.setText((int) speed.sum);
        holder.distanceNumTextView.setText((int) speed.distance);
        holder.durationNumTextView.setText((int) speed.duration);

        //holder.singleTextView.setBackgroundColor(user.single ? Color.RED : Color.WHITE);

//        holder.genderImageView.setImageResource(
  //              user.gender == User.GENDER_MALE ? R.drawable.male : R.drawable.female
    //    );
    }

    @Override
    public int getItemCount() {
        return mSpeed.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView sumNumTextView;
        TextView distanceNumTextView;
        TextView durationNumTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.sumNumTextView = itemView.findViewById(R.id.text_speed);
            this.distanceNumTextView = itemView.findViewById(R.id.text_speed_cal);
            this.durationNumTextView = itemView.findViewById(R.id.text_speed_cal);
        }
    }
}