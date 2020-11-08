package th.ac.su.cp.speedrecords.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "speeds")
public class Speed {

    @ColumnInfo(name = "num_sum")
    public final float sum;

    @ColumnInfo(name = "num_distance")
    public final float distance;

    @ColumnInfo(name = "num_duration")
    public final float duration;

    public Speed(float sum, float distance, float duration) {
        this.sum = sum;
        this.duration = duration;
        this.distance = distance;
    }
}