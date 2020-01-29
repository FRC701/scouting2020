package com.vandenrobotics.saga.data.repo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.vandenrobotics.saga.data.DatabaseManager;
import com.vandenrobotics.saga.data.model.Competitions;
import com.vandenrobotics.saga.data.model.Stats;
import com.vandenrobotics.saga.data.model.Teams;

/**
 * Created by Programming701-A on 12/18/2017.
 */

public class StatsRepo {

    private Stats stats;

    private final String TAG = StatsRepo.class.getSimpleName();
    public StatsRepo(){
        stats = new Stats();
    }

    //Holds String to execute SQLite where the Stats Table is created and specified how it is made
    public static String createTable(){
        return "CREATE TABLE " + Stats.TABLE + "("
                + Stats.KEY_CompId + " TEXT not null , "
                + Stats.KEY_MatchNum + " INTEGER not null , "
                + Stats.KEY_TeamNum + " INTEGER not null , "
                //Makes sure the match position is between 1 and 6 for each tablet
                + Stats.KEY_MatchPosition + " INTEGER not null CHECK ( " + Stats.KEY_MatchPosition + " BETWEEN 1 AND 6 ), "
                + Stats.KEY_TopPCellAuto + " INTEGER , "
                + Stats.KEY_BottomPCellAuto + " INTEGER , "
                + Stats.KEY_CrossLineAuto + " INTEGER , "
                + Stats.KEY_DoesntMoveAuto + " INTEGER , "
                + Stats.KEY_IntakeAuto + " INTEGER , "
                + Stats.KEY_NoShowAuto + " INTEGER , "
                + Stats.KEY_TeleComments + " TEXT , "
                + Stats.KEY_TeleTopPC + " INTEGER , "
                + Stats.KEY_TeleBottomPC + " INTEGER , "
                + Stats.KEY_TeleRotation + " INTEGER , "
                + Stats.KEY_TelePosition + " INTEGER , "
                + Stats.KEY_TeleHangSuccess  + " INTEGER , "
                + Stats.KEY_TeleHangAttempt + " INTEGER , "
                + Stats.KEY_TeleHangNA + " INTEGER , "
                + Stats.KEY_TeleAssist + " INTEGER , "
                + Stats.KEY_TeleAssisted + " INTEGER , "
                + Stats.KEY_TeleDefenseNone + " INTEGER , "
                + Stats.KEY_TeleDefenseSome + " INTEGER , "
                + Stats.KEY_TeleDefenseAll + " INTEGER , "
                + Stats.KEY_TeleDefenseGood + " INTEGER , "
                + Stats.KEY_TeleDefenseBad + " INTEGER , "
                + Stats.KEY_TeleDefenseOk + " INTEGER , "
                + Stats.KEY_TeleDefenseNA + " INTEGER ,"
                + Stats.KEY_RobotDisabled + " INTEGER , "
                + Stats.KEY_RedCard + " INTEGER , "
                + Stats.KEY_YellowCard + " INTEGER , "
                + Stats.KEY_Fouls + " INTEGER , "
                + Stats.KEY_TechFouls + " INTEGER , "
                + Stats.KEY_ClimbSpeedFast + " INTEGER , "
                + Stats.KEY_ClimbSpeedMedium + " INTEGER , "
                + Stats.KEY_ClimbSpeedSlow + " INTEGER , "
                + Stats.KEY_ClimbSpeedNo + " INTEGER , "
                +
                //makes the CompId, MatchNum and MatchPos Primary Key so there needs
                //to be a unique combination of these attributes in each row in the Stats table
                "PRIMARY KEY ( '" + Stats.KEY_CompId
                + "' , '" + Stats.KEY_MatchNum
                + "' , '" + Stats.KEY_MatchPosition + "' ), "
                //makes sure CompId column exists in the Competitions Table
                + " FOREIGN KEY ( " + Stats.KEY_CompId + " ) REFERENCES " + Competitions.TABLE
                + " ( " + Competitions.KEY_CompId + " ), "
                //makes sure TeamNum column exists in the Team Table
                + " FOREIGN KEY ( " + Stats.KEY_TeamNum + " ) REFERENCES " + Teams.TABLE
                + " ( " + Teams.KEY_TeamNum + " ))";
    }

    //Holds String to execute SQLite where the Stats Index is created to specify that there
    //Is a unique combination of CompId, Match# and Team# in every row in the stats table
    public static String createIndex(){
        return "CREATE UNIQUE INDEX '" + Stats.INDEX + "' ON "
                + Stats.TABLE
                + " ( " + Stats.KEY_CompId
                + " , " + Stats.KEY_MatchNum
                + " , " + Stats.KEY_TeamNum + " )";
    }

    //inserts all values of a stats row object into the sql database
    public int insertAll(Stats stats){
        int statsId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Stats.KEY_CompId, stats.getCompId());
        values.put(Stats.KEY_MatchNum, stats.getMatchNum());
        values.put(Stats.KEY_TeamNum, stats.getTeamNum());
        values.put(Stats.KEY_MatchPosition, stats.getMatchPos());
        values.put(Stats.KEY_RobotDisabled, stats.getDisabled());
        values.put(Stats.KEY_RedCard, stats.getRedCard());
        values.put(Stats.KEY_YellowCard, stats.getYellowCard());
        values.put(Stats.KEY_Fouls, stats.getFoul());
        values.put(Stats.KEY_TechFouls, stats.getTechFoul());
        values.put(Stats.KEY_TopPCellAuto, stats.getTopPCellAuto());
        values.put(Stats.KEY_BottomPCellAuto, stats.getBottomPCellAuto());
        values.put(Stats.KEY_CrossLineAuto, stats.getCrossLineAuto());
        values.put(Stats.KEY_DoesntMoveAuto, stats.getDoesntMoveAuto());
        values.put(Stats.KEY_IntakeAuto, stats.getIntakeAuto());
        values.put(Stats.KEY_NoShowAuto, stats.getNoShowAuto());
        values.put(Stats.KEY_TeleComments, stats.getTeleComments());
        values.put(Stats.KEY_TeleTopPC, stats.getTeleTopPC());
        values.put(Stats.KEY_TeleBottomPC, stats.getTeleBottomPC());
        values.put(Stats.KEY_TeleRotation, stats.getTeleRotation());
        values.put(Stats.KEY_TelePosition, stats.getTelePosition());
        values.put(Stats.KEY_TeleHangSuccess, stats.getTeleHangSuccess());
        values.put(Stats.KEY_TeleHangAttempt, stats.getTeleHangAttempt());
        values.put(Stats.KEY_TeleHangNA, stats.getTeleHangNA());
        values.put(Stats.KEY_TeleAssist, stats.getTeleHangAssist());
        values.put(Stats.KEY_TeleAssisted, stats.getTeleHangAssisted());
        values.put(Stats.KEY_TeleDefenseNone, stats.getTeleDefenseNone());
        values.put(Stats.KEY_TeleDefenseSome, stats.getTeleDefenseSome());
        values.put(Stats.KEY_TeleDefenseAll, stats.getTeleDefenseAll());
        values.put(Stats.KEY_TeleDefenseGood, stats.getTeleDefenseGood());
        values.put(Stats.KEY_TeleDefenseBad, stats.getTeleDefenseBad());
        values.put(Stats.KEY_TeleDefenseOk, stats.getTeleDefenseOk());
        values.put(Stats.KEY_TeleDefenseNA, stats.getTeleDefenseNA());
        values.put(Stats.KEY_ClimbSpeedFast, stats.getClimbSpeedFast());
        values.put(Stats.KEY_ClimbSpeedMedium, stats.getClimbSpeedMedium());
        values.put(Stats.KEY_ClimbSpeedSlow, stats.getClimbSpeedSlow());
        values.put(Stats.KEY_ClimbSpeedNo, stats.getClimbSpeedNo());

        //check if there is a conflict. It should return -1 if there is a copy of the exact combination of the Primary Keys
        statsId=(int)db.insertWithOnConflict(Stats.TABLE, null, values, SQLiteDatabase.CONFLICT_IGNORE);

        DatabaseManager.getInstance().closeDatabase();
        //return to check conflict
        return statsId;
    }

    //updates the first part of the row with a new team
    public int updatePart(Stats stats){
        int statsId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Stats.KEY_TeamNum, stats.getTeamNum());

        //updates row with the same CompId, Match# and Match Position
        statsId = db.update(Stats.TABLE, values,Stats.KEY_CompId + " =  '" + stats.getCompId() + "' AND "
                + Stats.KEY_MatchNum + " = " + stats.getMatchNum() + " AND "
                + Stats.KEY_MatchPosition + " = " + stats.getMatchPos(), null);
        DatabaseManager.getInstance().closeDatabase();
        return statsId;
    }

    //deletes all rows in the stats table
    public void delete( ) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Stats.TABLE, null,null);
        DatabaseManager.getInstance().closeDatabase();
    }

    //deletes all rows in the stats table for the specified comp
    public void deleteForComp(String event) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Stats.TABLE, Stats.KEY_CompId + " =  '" + event + "'",null);
        DatabaseManager.getInstance().closeDatabase();
    }

    /*
    * All set functions save each part of a single row for each phase of the match
    * using the initial insert that adds the comp, match, team and match pos
    * used for saving data
    * */

    public void setAuto(Stats stats){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        Log.d("StatsRepo auto", "team id " + stats.getTeamNum());
        values.put(Stats.KEY_TopPCellAuto, stats.getTopPCellAuto());
        values.put(Stats.KEY_BottomPCellAuto, stats.getBottomPCellAuto());
        values.put(Stats.KEY_CrossLineAuto, stats.getCrossLineAuto());
        values.put(Stats.KEY_DoesntMoveAuto, stats.getDoesntMoveAuto());
        values.put(Stats.KEY_IntakeAuto, stats.getIntakeAuto());
        values.put(Stats.KEY_NoShowAuto, stats.getNoShowAuto());

        int row = db.update(Stats.TABLE, values, Stats.KEY_CompId + " =  '" + stats.getCompId() + "' AND "
                + Stats.KEY_MatchNum + " = " + stats.getMatchNum() + " AND "
                + Stats.KEY_TeamNum + " = " + stats.getTeamNum(),null);

        Log.d("Sarah", row + "");
        DatabaseManager.getInstance().closeDatabase();
    }

    //save the Tele Stats to the database for the current comp, match and team
    public void setTele(Stats stats) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        Log.d("StatsRepo", "Team id " + stats.getTeamNum());
        values.put(Stats.KEY_RobotDisabled, stats.getDisabled());
        values.put(Stats.KEY_RedCard, stats.getRedCard());
        values.put(Stats.KEY_YellowCard, stats.getYellowCard());
        values.put(Stats.KEY_Fouls, stats.getFoul());
        values.put(Stats.KEY_TechFouls, stats.getTechFoul());
        values.put(Stats.KEY_TeleComments, stats.getTeleComments());
        values.put(Stats.KEY_TeleTopPC, stats.getTeleTopPC());
        values.put(Stats.KEY_TeleBottomPC, stats.getTeleBottomPC());
        values.put(Stats.KEY_TeleRotation, stats.getTeleRotation());
        values.put(Stats.KEY_TelePosition, stats.getTelePosition());
        values.put(Stats.KEY_TeleHangSuccess, stats.getTeleHangSuccess());
        values.put(Stats.KEY_TeleHangAttempt, stats.getTeleHangAttempt());
        values.put(Stats.KEY_TeleHangNA, stats.getTeleHangNA());
        values.put(Stats.KEY_TeleAssist, stats.getTeleHangAssist());
        values.put(Stats.KEY_TeleAssisted, stats.getTeleHangAssisted());
        values.put(Stats.KEY_TeleDefenseNone, stats.getTeleDefenseNone());
        values.put(Stats.KEY_TeleDefenseSome, stats.getTeleDefenseSome());
        values.put(Stats.KEY_TeleDefenseAll, stats.getTeleDefenseAll());
        values.put(Stats.KEY_TeleDefenseGood, stats.getTeleDefenseGood());
        values.put(Stats.KEY_TeleDefenseBad, stats.getTeleDefenseBad());
        values.put(Stats.KEY_TeleDefenseOk, stats.getTeleDefenseOk());
        values.put(Stats.KEY_TeleDefenseNA, stats.getTeleDefenseNA());
        values.put(Stats.KEY_ClimbSpeedFast, stats.getClimbSpeedFast());
        values.put(Stats.KEY_ClimbSpeedMedium, stats.getClimbSpeedMedium());
        values.put(Stats.KEY_ClimbSpeedSlow, stats.getClimbSpeedSlow());
        values.put(Stats.KEY_ClimbSpeedNo, stats.getClimbSpeedNo());

        Log.d("StatsRepo", "updating table"+values.toString());
        try {
            db.update(Stats.TABLE, values, Stats.KEY_CompId + " =  \"" + stats.getCompId() + "\" AND "
                    + Stats.KEY_MatchNum + " = " + stats.getMatchNum() + " AND "
                    + Stats.KEY_TeamNum + " = " + stats.getTeamNum(), null);
        }catch(Exception e){
            Log.e("StatsRepo", "Exception updating database" + e.getMessage());

        }
        DatabaseManager.getInstance().closeDatabase();
    }

    /*
    * get functions gets their phase from part of the row with the current comp, match, and position
    * used for loading data
    * */

    //get the Auto stats from the row with the current comp, match and match position

    public Stats getAuto(String event, int match, int matchPos){
        Stats stats = new Stats();

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        //makes the selection query for the stats table to get the auto stats
        String selectQuery = " SELECT Stats." + Stats.KEY_TopPCellAuto
                + ", Stats." + Stats.KEY_BottomPCellAuto
                + ", Stats." + Stats.KEY_CrossLineAuto
                + ", Stats." + Stats.KEY_DoesntMoveAuto
                + ", Stats." + Stats.KEY_IntakeAuto
                + ", Stats." + Stats.KEY_NoShowAuto
                + " FROM " + Stats.TABLE
                + " WHERE Stats." + Stats.KEY_CompId + " = \"" + event + "\""
                + " AND Stats." + Stats.KEY_MatchNum + " = " + match
                + " AND Stats." + Stats.KEY_MatchPosition + " = " + matchPos;

        Log.d(TAG, selectQuery);
        //uses the selection query to get rows from the database one at a time
        Cursor cursor = db.rawQuery(selectQuery, null);
        //gets the first row that matches the specifications from the selection query
        if (cursor.moveToFirst()){
            stats.setTopPCellAuto(cursor.getInt(cursor.getColumnIndex(Stats.KEY_TopPCellAuto)));
            stats.setBottomPCellAuto(cursor.getInt(cursor.getColumnIndex(Stats.KEY_BottomPCellAuto)));
            stats.setCrossLineAuto(cursor.getInt(cursor.getColumnIndex(Stats.KEY_CrossLineAuto)));
            stats.setDoesntMoveAuto(cursor.getInt(cursor.getColumnIndex(Stats.KEY_DoesntMoveAuto)));
            stats.setIntakeAuto(cursor.getInt(cursor.getColumnIndex(Stats.KEY_IntakeAuto)));
            stats.setNoShowAuto(cursor.getInt(cursor.getColumnIndex(Stats.KEY_NoShowAuto)));
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();
        //returns a stats row object with the values from the database
        return stats;
    }
    //get the Tele stats from the row with the current comp, match and match position
    public Stats getTeleStats (String event, int match, int matchPos) {
        Stats stats = new Stats();

        //makes the selection query for the stats table to get the tele stats
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        String selectQuery = " SELECT Stats." + Stats.KEY_RobotDisabled
                + ", Stats." + Stats.KEY_RedCard
                + ", Stats." + Stats.KEY_YellowCard
                + ", Stats." + Stats.KEY_Fouls
                + ", Stats." + Stats.KEY_TechFouls
                + ", Stats." + Stats.KEY_TeleComments
                + ", Stats." + Stats.KEY_TeleTopPC
                + ", Stats." + Stats.KEY_TeleBottomPC
                + ", Stats." + Stats.KEY_TeleRotation
                + ", Stats." + Stats.KEY_TelePosition
                + ", Stats." + Stats.KEY_TeleHangSuccess
                + ", Stats." + Stats.KEY_TeleHangAttempt
                + ", Stats." + Stats.KEY_TeleHangNA
                + ", Stats." + Stats.KEY_TeleAssist
                + ", Stats." + Stats.KEY_TeleAssisted
                + ", Stats." + Stats.KEY_TeleDefenseNone
                + ", Stats." + Stats.KEY_TeleDefenseSome
                + ", Stats." + Stats.KEY_TeleDefenseAll
                + ", Stats." + Stats.KEY_TeleDefenseGood
                + ", Stats." + Stats.KEY_TeleDefenseBad
                + ", Stats." + Stats.KEY_TeleDefenseOk
                + ", Stats." + Stats.KEY_TeleDefenseNA
                + ", Stats." + Stats.KEY_ClimbSpeedFast
                + ", Stats." + Stats.KEY_ClimbSpeedMedium
                + ", Stats." + Stats.KEY_ClimbSpeedSlow
                + ", Stats." + Stats.KEY_ClimbSpeedNo

                + " FROM " + Stats.TABLE
                + " WHERE Stats." + Stats.KEY_CompId + " = \"" + event + "\""
                + " AND Stats." + Stats.KEY_MatchNum + " = " + match
                + " AND Stats." + Stats.KEY_MatchPosition + " = " + matchPos;

        Log.d(TAG, selectQuery);
        //uses the selection query to get rows from the database one at a time
        Cursor cursor = db.rawQuery(selectQuery, null);
        //gets the first row that matches the specifications from the selection query
        if (cursor.moveToFirst()){
            stats.setDisabled(cursor.getInt(cursor.getColumnIndex(Stats.KEY_RobotDisabled)));
            stats.setRedCard(cursor.getInt(cursor.getColumnIndex(Stats.KEY_RedCard)));
            stats.setYellowCard(cursor.getInt(cursor.getColumnIndex(Stats.KEY_YellowCard)));
            stats.setFoul(cursor.getInt(cursor.getColumnIndex(Stats.KEY_Fouls)));
            stats.setTechFoul(cursor.getInt(cursor.getColumnIndex(Stats.KEY_TechFouls)));
            stats.setTeleComments(cursor.getString(cursor.getColumnIndex(Stats.KEY_TeleComments)));
            stats.setTeleTopPC(cursor.getInt(cursor.getColumnIndex(Stats.KEY_TeleTopPC)));
            stats.setTeleBottomPC(cursor.getInt(cursor.getColumnIndex(Stats.KEY_TeleBottomPC)));
            stats.setTeleRotation(cursor.getInt(cursor.getColumnIndex(Stats.KEY_TeleRotation)));
            stats.setTelePosition(cursor.getInt(cursor.getColumnIndex(Stats.KEY_TelePosition)));
            stats.setTeleHangSuccess(cursor.getInt(cursor.getColumnIndex(Stats.KEY_TeleHangSuccess)));
            stats.setTeleHangAttempt(cursor.getInt(cursor.getColumnIndex(Stats.KEY_TeleHangAttempt)));
            stats.setTeleHangNA(cursor.getInt(cursor.getColumnIndex(Stats.KEY_TeleHangNA)));
            stats.setTeleHangAssist(cursor.getInt(cursor.getColumnIndex(Stats.KEY_TeleAssist)));
            stats.setTeleHangAssisted(cursor.getInt(cursor.getColumnIndex(Stats.KEY_TeleAssisted)));
            stats.setTeleDefenseNone(cursor.getInt(cursor.getColumnIndex(Stats.KEY_TeleDefenseNone)));
            stats.setTeleDefenseSome(cursor.getInt(cursor.getColumnIndex(Stats.KEY_TeleDefenseSome)));
            stats.setTeleDefenseAll(cursor.getInt(cursor.getColumnIndex(Stats.KEY_TeleDefenseAll)));
            stats.setTeleDefenseGood(cursor.getInt(cursor.getColumnIndex(Stats.KEY_TeleDefenseGood)));
            stats.setTeleDefenseBad(cursor.getInt(cursor.getColumnIndex(Stats.KEY_TeleDefenseBad)));
            stats.setTeleDefenseOk(cursor.getInt(cursor.getColumnIndex(Stats.KEY_TeleDefenseOk)));
            stats.setTeleDefenseNA(cursor.getInt(cursor.getColumnIndex(Stats.KEY_TeleDefenseNA)));
            stats.setClimbSpeedFast(cursor.getInt(cursor.getColumnIndex(Stats.KEY_ClimbSpeedFast)));
            stats.setClimbSpeedMedium(cursor.getInt(cursor.getColumnIndex(Stats.KEY_ClimbSpeedMedium)));
            stats.setClimbSpeedSlow(cursor.getInt(cursor.getColumnIndex(Stats.KEY_ClimbSpeedSlow)));
            stats.setClimbSpeedNo(cursor.getInt(cursor.getColumnIndex(Stats.KEY_ClimbSpeedNo)));
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();
        //returns a stats row object with the values from the database
        return stats;
    }
}
