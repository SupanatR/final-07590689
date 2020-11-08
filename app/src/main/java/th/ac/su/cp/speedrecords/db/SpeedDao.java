package th.ac.su.cp.speedrecords.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import th.ac.su.cp.speedrecords.model.Speed;

@Dao
public interface SpeedDao {

    @Query("SELECT * FROM speeds")
    Speed[] getAllSpeeds();

    @Query("SELECT * FROM speeds WHERE sum = :sum")
    Speed getUserById(int id);

    @Insert
    void addUser(Speed... speeds);

    @Delete
    void deleteUser(Speed speed);
}