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
                + PitData.KEY_Speed + " TEXT , "
                + PitData.KEY_ScoringMechanism + " TEXT , "
                + PitData.KEY_BallsDuringAuto + " TEXT , "
                + PitData.KEY_AutoYes + " INTEGER , "
                + PitData.KEY_AutoNo + " INTEGER , "
                + PitData.KEY_CrossLinePit + " INTEGER , "
                + PitData.KEY_IntakeBallsPit + " INTEGER , "
                + PitData.KEY_ScoreLowerPortPit + " INTEGER , "
                + PitData.KEY_ScoreOuterPortPit + " INTEGER , "
                + PitData.KEY_StageOnePit + " INTEGER , "
                + PitData.KEY_StageTwoPit + " INTEGER , "
                + PitData.KEY_StageThreePit + " INTEGER , "
                + PitData.KEY_BottomPortScore + " INTEGER , "
                + PitData.KEY_OuterPortScore + " INTEGER , "
                + PitData.KEY_InnerPortScore + " INTEGER , "
                + PitData.KEY_PositionPanel + " INTEGER , "
                + PitData.KEY_RotatePanel + " INTEGER , "
                + PitData.KEY_AssistClimbPit + " INTEGER , "
                + PitData.KEY_DuringClimbPark + " INTEGER , "
                + PitData.KEY_RobotClimbClimb + " INTEGER , "
                + PitData.KEY_DuringClimbAssist + " INTEGER , "
                + PitData.KEY_IntakePowerCellsYes + " INTEGER , "
                + PitData.KEY_IntakePowerCellsNo + " INTEGER , "
                + PitData.KEY_RobotDefenseYesPit + " INTEGER , "
                + PitData.KEY_RobotDefenseNoPit + " INTEGER , "
                + PitData.KEY_ScoreInnerPortPit + " INTEGER ) ";
    }

    public int insert (PitData pitData){
        int pitDataId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(PitData.KEY_TeamNum, pitData.getTeamNum());
        values.put(PitData.KEY_IntakeAndMech, pitData.getIntakeAndMech());
        values.put(PitData.KEY_DriveTrain, pitData.getDriveTrain());
        values.put(PitData.KEY_Lang, pitData.getLang());
        values.put(PitData.KEY_Speed, pitData.getSpeed());
        values.put(PitData.KEY_ScoringMechanism, pitData.getScoringMechanism());
        values.put(PitData.KEY_BallsDuringAuto, pitData.getBallsDuringAuto());
        values.put(PitData.KEY_Auto, pitData.getAuto());
        values.put(PitData.KEY_ScoreBottom, pitData.getScoreBottom());
        values.put(PitData.KEY_ScoreTop, pitData.getScoreTop());
        values.put(PitData.KEY_AutoYes, pitData.getAutoYes());
        values.put(PitData.KEY_AutoNo, pitData.getAutoNo());
        values.put(PitData.KEY_CrossLinePit, pitData.getCrossLinePit());
        values.put(PitData.KEY_IntakeBallsPit, pitData.getIntakeBallsPit());
        values.put(PitData.KEY_ScoreLowerPortPit, pitData.getScoreLowerPortPit());
        values.put(PitData.KEY_ScoreOuterPortPit, pitData.getScoreOuterPortPit());
        values.put(PitData.KEY_StageOnePit, pitData.getStageOnePit());
        values.put(PitData.KEY_StageTwoPit, pitData.getStageTwoPit());
        values.put(PitData.KEY_StageThreePit, pitData.getStageThreePit());
        values.put(PitData.KEY_BottomPortScore, pitData.getBottomPortScore());
        values.put(PitData.KEY_OuterPortScore, pitData.getOuterPortScore());
        values.put(PitData.KEY_InnerPortScore, pitData.getInnerPortScore());
        values.put(PitData.KEY_PositionPanel, pitData.getPositionPanel());
        values.put(PitData.KEY_RotatePanel, pitData.getRotatePanel());
        values.put(PitData.KEY_AssistClimbPit, pitData.getAssistClimbPit());
        values.put(PitData.KEY_DuringClimbPark, pitData.getDuringClimbPark());
        values.put(PitData.KEY_RobotClimbClimb, pitData.getRobotClimbClimb());
        values.put(PitData.KEY_DuringClimbAssist, pitData.getDuringClimbAssist());
        values.put(PitData.KEY_IntakePowerCellsYes, pitData.getIntakePowerCellsYes());
        values.put(PitData.KEY_IntakePowerCellsNo, pitData.getIntakePowerCellsNo());
        values.put(PitData.KEY_RobotDefenseYesPit, pitData.getRobotDefenseYesPit());
        values.put(PitData.KEY_RobotDefenseNoPit, pitData.getRobotDefenseNoPit());
        values.put(PitData.KEY_ScoreInnerPortPit, pitData.getScoreInnerPortPit());




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
        values.put(PitData.KEY_Speed, pitData.getSpeed());
        values.put(PitData.KEY_ScoringMechanism, pitData.getScoringMechanism());
        values.put(PitData.KEY_BallsDuringAuto, pitData.getBallsDuringAuto());
        values.put(PitData.KEY_Auto, pitData.getAuto());
        values.put(PitData.KEY_ScoreBottom, pitData.getScoreBottom());
        values.put(PitData.KEY_ScoreTop, pitData.getScoreTop());
        values.put(PitData.KEY_AutoNo, pitData.getAutoNo());
        values.put(PitData.KEY_AutoYes, pitData.getAutoYes());
        values.put(PitData.KEY_CrossLinePit, pitData.getCrossLinePit());
        values.put(PitData.KEY_IntakeBallsPit, pitData.getIntakeBallsPit());
        values.put(PitData.KEY_ScoreLowerPortPit, pitData.getScoreLowerPortPit());
        values.put(PitData.KEY_ScoreOuterPortPit, pitData.getScoreOuterPortPit());
        values.put(PitData.KEY_StageOnePit, pitData.getStageOnePit());
        values.put(PitData.KEY_StageTwoPit, pitData.getStageTwoPit());
        values.put(PitData.KEY_StageThreePit, pitData.getStageThreePit());
        values.put(PitData.KEY_BottomPortScore, pitData.getBottomPortScore());
        values.put(PitData.KEY_OuterPortScore, pitData.getOuterPortScore());
        values.put(PitData.KEY_InnerPortScore, pitData.getInnerPortScore());
        values.put(PitData.KEY_PositionPanel, pitData.getPositionPanel());
        values.put(PitData.KEY_RotatePanel, pitData.getRotatePanel());
        values.put(PitData.KEY_AssistClimbPit, pitData.getAssistClimbPit());
        values.put(PitData.KEY_DuringClimbPark, pitData.getDuringClimbPark());
        values.put(PitData.KEY_RobotClimbClimb, pitData.getRobotClimbClimb());
        values.put(PitData.KEY_DuringClimbAssist, pitData.getDuringClimbAssist());
        values.put(PitData.KEY_IntakePowerCellsYes, pitData.getIntakePowerCellsYes());
        values.put(PitData.KEY_IntakePowerCellsNo, pitData.getIntakePowerCellsNo());
        values.put(PitData.KEY_RobotDefenseYesPit, pitData.getRobotDefenseYesPit());
        values.put(PitData.KEY_RobotDefenseNoPit, pitData.getRobotDefenseNoPit());
        values.put(PitData.KEY_ScoreInnerPortPit, pitData.getScoreInnerPortPit());


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
                + ", PitData." + PitData.KEY_Speed
                + ", PitData." + PitData.KEY_ScoringMechanism
                + ", PitData." + PitData.KEY_BallsDuringAuto
                + ", PitData." + PitData.KEY_Auto
                + ", PitData." + PitData.KEY_ScoreBottom
                + ", PitData." + PitData.KEY_ScoreTop
                + ", PitData." + PitData.KEY_AutoNo
                + ", PitData." + PitData.KEY_AutoYes
                + ", PitData." + PitData.KEY_CrossLinePit
                + ", PitData." + PitData.KEY_IntakeBallsPit
                + ", PitData." + PitData.KEY_ScoreLowerPortPit
                + ", PitData." + PitData.KEY_ScoreOuterPortPit
                + ", PitData." + PitData.KEY_StageOnePit
                + ", PitData." + PitData.KEY_StageTwoPit
                + ", PitData." + PitData.KEY_StageThreePit
                + ", PitData." + PitData.KEY_BottomPortScore
                + ", PitData." + PitData.KEY_OuterPortScore
                + ", PitData." + PitData.KEY_InnerPortScore
                + ", PitData." + PitData.KEY_PositionPanel
                + ", PitData." + PitData.KEY_RotatePanel
                + ", PitData." + PitData.KEY_AssistClimbPit
                + ", PitData." + PitData.KEY_DuringClimbPark
                + ", PitData." + PitData.KEY_RobotClimbClimb
                + ", PitData." + PitData.KEY_DuringClimbAssist
                + ", PitData." + PitData.KEY_IntakePowerCellsYes
                + ", PitData." + PitData.KEY_IntakePowerCellsNo
                + ", PitData." + PitData.KEY_RobotDefenseYesPit
                + ", PitData." + PitData.KEY_RobotDefenseNoPit
                + ", PitData." + PitData.KEY_ScoreInnerPortPit


                + " FROM " + PitData.TABLE
                + " WHERE PitData." + PitData.KEY_TeamNum + " = " + teamNum;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            pitData.setAuto(cursor.getInt(cursor.getColumnIndex(PitData.KEY_Auto)));
            pitData.setIntakeAndMech(cursor.getString(cursor.getColumnIndex(PitData.KEY_IntakeAndMech)));
            pitData.setDriveTrain(cursor.getString(cursor.getColumnIndex(PitData.KEY_DriveTrain)));
            pitData.setLang(cursor.getString(cursor.getColumnIndex(PitData.KEY_Lang)));
            pitData.setSpeed(cursor.getString(cursor.getColumnIndex(PitData.KEY_Speed)));
            pitData.setScoringMechanism(cursor.getString(cursor.getColumnIndex(PitData.KEY_ScoringMechanism)));
            pitData.setBallsDuringAuto(cursor.getString(cursor.getColumnIndex(PitData.KEY_BallsDuringAuto)));
            pitData.setScoreBottom(cursor.getInt(cursor.getColumnIndex(PitData.KEY_ScoreBottom)));
            pitData.setScoreTop(cursor.getInt(cursor.getColumnIndex(PitData.KEY_ScoreTop)));
            pitData.setAutoNo(cursor.getInt(cursor.getColumnIndex(PitData.KEY_AutoNo)));
            pitData.setAutoYes(cursor.getInt(cursor.getColumnIndex(PitData.KEY_AutoYes)));
            pitData.setCrossLinePit(cursor.getInt(cursor.getColumnIndex(PitData.KEY_CrossLinePit)));
            pitData.setIntakeBallsPit(cursor.getInt(cursor.getColumnIndex(PitData.KEY_IntakeBallsPit)));
            pitData.setScoreLowerPortPit(cursor.getInt(cursor.getColumnIndex(PitData.KEY_ScoreLowerPortPit)));
            pitData.setScoreOuterPortPit(cursor.getInt(cursor.getColumnIndex(PitData.KEY_ScoreOuterPortPit)));
            pitData.setStageOnePit(cursor.getInt(cursor.getColumnIndex(PitData.KEY_StageOnePit)));
            pitData.setStageTwoPit(cursor.getInt(cursor.getColumnIndex(PitData.KEY_StageTwoPit)));
            pitData.setStageThreePit(cursor.getInt(cursor.getColumnIndex(PitData.KEY_StageThreePit)));
            pitData.setBottomPortScore(cursor.getInt(cursor.getColumnIndex(PitData.KEY_BottomPortScore)));
            pitData.setOuterPortScore(cursor.getInt(cursor.getColumnIndex(PitData.KEY_OuterPortScore)));
            pitData.setInnerPortScore(cursor.getInt(cursor.getColumnIndex(PitData.KEY_InnerPortScore)));
            pitData.setPositionPanel(cursor.getInt(cursor.getColumnIndex(PitData.KEY_PositionPanel)));
            pitData.setRotatePanel(cursor.getInt(cursor.getColumnIndex(PitData.KEY_RotatePanel)));
            pitData.setAssistClimbPit(cursor.getInt(cursor.getColumnIndex(PitData.KEY_AssistClimbPit)));
            pitData.setDuringClimbPark(cursor.getInt(cursor.getColumnIndex(PitData.KEY_DuringClimbPark)));
            pitData.setRobotClimbClimb(cursor.getInt(cursor.getColumnIndex(PitData.KEY_RobotClimbClimb)));
            pitData.setDuringClimbAssist(cursor.getInt(cursor.getColumnIndex(PitData.KEY_DuringClimbAssist)));
            pitData.setIntakePowerCellsYes(cursor.getInt(cursor.getColumnIndex(PitData.KEY_IntakePowerCellsYes)));
            pitData.setIntakePowerCellsNo(cursor.getInt(cursor.getColumnIndex(PitData.KEY_IntakePowerCellsNo)));
            pitData.setRobotDefenseYesPit(cursor.getInt(cursor.getColumnIndex(PitData.KEY_RobotDefenseYesPit)));
            pitData.setRobotDefenseNoPit(cursor.getInt(cursor.getColumnIndex(PitData.KEY_RobotDefenseNoPit)));
            pitData.setRobotDefenseNoPit(cursor.getInt(cursor.getColumnIndex(PitData.KEY_RobotDefenseNoPit)));
            pitData.setRobotDefenseNoPit(cursor.getInt(cursor.getColumnIndex(PitData.KEY_RobotDefenseNoPit)));
            pitData.setScoreInnerPortPit(cursor.getInt(cursor.getColumnIndex(PitData.KEY_ScoreInnerPortPit)));
        }
        cursor.close();
        DatabaseManager.getInstance().closeDatabase();
        return pitData;
    }
}
