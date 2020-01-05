package com.vandenrobotics.saga.data.repo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vandenrobotics.saga.data.DatabaseManager;
import com.vandenrobotics.saga.data.model.PitData;

import java.util.ArrayList;

/**
 * Created by Programming701-A on 1/17/2018.
 */

public class PitDataRepo {

    public static String createTable() {
        return "CREATE TABLE " + PitData.TABLE + " ( "
                + PitData.KEY_TeamNum + " INTEGER PRIMARY KEY , "
                + PitData.KEY_Auto + " INTEGER , "
                + PitData.KEY_ScoreBottom + " INTEGER , "
                + PitData.KEY_ScoreTop + " INTEGER , "
                + PitData.KEY_IntakeAndMech + " TEXT , "
                + PitData.KEY_DriveTrain + " TEXT , "
                + PitData.KEY_Lang + " TEXT , "
                + PitData.KEY_Comments + " TEXT , "
                + PitData.KEY_Speed + " TEXT , "
                + PitData.KEY_CoDriverExperience + " TEXT , "
                + PitData.KEY_DriverExperience + " TEXT , "
                + PitData.KEY_Climb + " TEXT ) ";
    }

    public int insert (PitData pitData){
        int pitDataId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(PitData.KEY_TeamNum, pitData.getTeamNum());
        values.put(PitData.KEY_IntakeAndMech, pitData.getIntakeAndMech());
        values.put(PitData.KEY_DriveTrain, pitData.getDriveTrain());
        values.put(PitData.KEY_Lang, pitData.getLang());
        values.put(PitData.KEY_Comments, pitData.getComments());
        values.put(PitData.KEY_Speed, pitData.getSpeed());
        values.put(PitData.KEY_DriverExperience, pitData.getDriverExperience());
        values.put(PitData.KEY_CoDriverExperience, pitData.getCoDriverExperience());
        values.put(PitData.KEY_Climb, pitData.getClimb());
        values.put(PitData.KEY_Auto, pitData.getAuto());
        values.put(PitData.KEY_ScoreBottom, pitData.getScoreBottom());
        values.put(PitData.KEY_ScoreTop, pitData.getScoreTop());
        values.put(PitData.KEY_CoDriverExperience, pitData.getCoDriverExperience());
        values.put(PitData.KEY_DriverExperience, pitData.getDriverExperience());
        values.put(PitData.KEY_Climb, pitData.getClimb());

        pitDataId = (int)db.insertWithOnConflict(PitData.TABLE, null, values, SQLiteDatabase.CONFLICT_IGNORE);
        DatabaseManager.getInstance().closeDatabase();
        return pitDataId;
    }
    public int update (PitData pitData){
        int pitDataId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(PitData.KEY_IntakeAndMech, pitData.getIntakeAndMech());
        values.put(PitData.KEY_DriveTrain, pitData.getDriveTrain());
        values.put(PitData.KEY_Lang, pitData.getLang());
        values.put(PitData.KEY_Comments, pitData.getComments());
        values.put(PitData.KEY_Speed, pitData.getSpeed());
        values.put(PitData.KEY_DriverExperience, pitData.getDriverExperience());
        values.put(PitData.KEY_CoDriverExperience, pitData.getCoDriverExperience());
        values.put(PitData.KEY_Climb, pitData.getClimb());
        values.put(PitData.KEY_Auto, pitData.getAuto());
        values.put(PitData.KEY_ScoreBottom, pitData.getScoreBottom());
        values.put(PitData.KEY_ScoreTop, pitData.getScoreTop());
        values.put(PitData.KEY_CoDriverExperience, pitData.getCoDriverExperience());
        values.put(PitData.KEY_DriverExperience, pitData.getDriverExperience());
        values.put(PitData.KEY_Climb, pitData.getClimb());

        pitDataId = (int)db.update(PitData.TABLE, values, PitData.KEY_TeamNum + " = " + pitData.getTeamNum(),null);
        DatabaseManager.getInstance().closeDatabase();
        return pitDataId;
    }
    public ArrayList<Integer> getTeams(){
        ArrayList<Integer> teams = new ArrayList<>();
        teams.add(0);
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        String selectQuery = " SELECT PitData." + PitData.KEY_TeamNum
                + " FROM " +PitData.TABLE;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                teams.add(cursor.getInt(cursor.getColumnIndex(PitData.KEY_TeamNum)));
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        DatabaseManager.getInstance().closeDatabase();
        return teams;
    }
    public PitData getTeamData(int teamNum){
        PitData pitData = new PitData(teamNum);

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        String selectQuery = " SELECT PitData." +PitData.KEY_TeamNum
                + ", PitData." + PitData.KEY_Auto
                + ", PitData." + PitData.KEY_IntakeAndMech
                + ", PitData." + PitData.KEY_DriveTrain
                + ", PitData." + PitData.KEY_Lang
                + ", PitData." + PitData.KEY_Comments
                + ", PitData." + PitData.KEY_Speed
                + ", PitData." + PitData.KEY_DriverExperience
                + ", PitData." + PitData.KEY_CoDriverExperience
                + ", PitData." + PitData.KEY_Climb
                + ", PitData." + PitData.KEY_Auto
                + ", PitData." + PitData.KEY_ScoreBottom
                + ", PitData." + PitData.KEY_ScoreTop
                + ", PitData." + PitData.KEY_CoDriverExperience
                + ", PitData." + PitData.KEY_DriverExperience
                + ", PitData." + PitData.KEY_Climb
                + " FROM " + PitData.TABLE
                + " WHERE PitData." + PitData.KEY_TeamNum + " = " + teamNum;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            pitData.setAuto(cursor.getInt(cursor.getColumnIndex(PitData.KEY_Auto)));
            pitData.setIntakeAndMech(cursor.getString(cursor.getColumnIndex(PitData.KEY_IntakeAndMech)));
            pitData.setDriveTrain(cursor.getString(cursor.getColumnIndex(PitData.KEY_DriveTrain)));
            pitData.setLang(cursor.getString(cursor.getColumnIndex(PitData.KEY_Lang)));
            pitData.setComments(cursor.getString(cursor.getColumnIndex(PitData.KEY_Comments)));
            pitData.setSpeed(cursor.getString(cursor.getColumnIndex(PitData.KEY_Speed)));
            pitData.setSpeed(cursor.getString(cursor.getColumnIndex(PitData.KEY_DriverExperience)));
            pitData.setSpeed(cursor.getString(cursor.getColumnIndex(PitData.KEY_CoDriverExperience)));
            pitData.setSpeed(cursor.getString(cursor.getColumnIndex(PitData.KEY_Climb)));
            pitData.setScoreBottom(cursor.getInt(cursor.getColumnIndex(PitData.KEY_ScoreBottom)));
            pitData.setScoreTop(cursor.getInt(cursor.getColumnIndex(PitData.KEY_ScoreTop)));
            pitData.setCoDriverExperience(cursor.getString(cursor.getColumnIndex(PitData.KEY_CoDriverExperience)));
            pitData.setDriverExperience(cursor.getString(cursor.getColumnIndex(PitData.KEY_DriverExperience)));
            pitData.setClimb(cursor.getString(cursor.getColumnIndex(PitData.KEY_Climb)));
        }
        cursor.close();
        DatabaseManager.getInstance().closeDatabase();
        return pitData;
    }
}
