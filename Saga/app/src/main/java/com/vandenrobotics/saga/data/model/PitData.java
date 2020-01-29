package com.vandenrobotics.saga.data.model;

/**
 * Created by Programming701-A on 1/17/2018.
 */

public class PitData {

    //hey if i did this wrong i'm sorry
    //its okay aliza will save the day i never mess up

    public static final String TABLE = "PitData";
    public static final String KEY_TeamNum = "TeamNumber";
    // start here
    public static final String KEY_IntakeAndMech = "TypeOfIntakeAndMech";
    public static final String KEY_DriveTrain = "TypeOfDriveTrain";
    public static final String KEY_Speed = "AverageSpeed";
    public static final String KEY_Lang = "ProgrammingLanguage";
    public static final String KEY_ScoringMechanism = "ScoringMechanism";
    public static final String KEY_BallsDuringAuto = "BallsDuringAuto";
    public static final String KEY_AutoYes = "AutoAnswerYes";
    public static final String KEY_AutoNo = "AutoAnswerNo";
    public static final String KEY_CrossLinePit = "AutoCrossLinePit";
    public static final String KEY_IntakeBallsPit = "AutoIntakeBallsPit";
    public static final String KEY_ScoreLowerPortPit = "AutoScoreLower";
    public static final String KEY_ScoreOuterPortPit = "AutoScoreOuter";
    public static final String KEY_ScoreInnerPortPit = "AutoScoreInner";
    public static final String KEY_BottomPortScore = "ScoreBottomPort";
    public static final String KEY_OuterPortScore = "ScoreOuterPort";
    public static final String KEY_InnerPortScore = "ScoreInnerPort";
    public static final String KEY_PositionPanel = "PositionControlPanel";
    public static final String KEY_RotatePanel = "RotateControlPanel";
    public static final String KEY_AssistClimbPit = "PitAssistClimb";
    public static final String KEY_DuringClimbPark = "ParkRobot";
    public static final String KEY_RobotClimbClimb = "RobotClimb";
    public static final String KEY_DuringClimbAssist = "RobotAssistClimb";
    public static final String KEY_IntakePowerCellsYes = "PowerCellIntakeYesPit";
    public static final String KEY_IntakePowerCellsNo = "PowerCellIntakeNoPit";
    public static final String KEY_RobotDefenseYesPit = "DefenseRobotYesPit";
    public static final String KEY_RobotDefenseNoPit = "DefenseRobotNoPit";
    public static final String KEY_ScoreBottom = "ScoreBottom";
    public static final String KEY_ScoreTop = "ScoreTop";
    public static final String KEY_StageOnePit = "StageOnePit";
    public static final String KEY_StageTwoPit = "StageTwoPit";
    public static final String KEY_StageThreePit = "StageThreePit";
    //i did everything after here
    public static final String KEY_Auto = "Auto";



    private int teamNum;
    //start here
    private String intakeAndMech;
    private String driveTrain;
    private String speed;
    private String lang;
    private String climb;
    private String scoringMechanism;
    private String ballsDuringAuto;
    //and after here
    private int auto;
    private int autoNo;
    private int autoYes;
    private int crossLinePit;
    private int intakeBallsPit;
    private int scoreLowerPortPit;
    private int scoreOuterPortPit;
    private int scoreInnerPortPit;
    private int bottomPortScore;
    private int outerPortScore;
    private int innerPortScore;
    private int positionPanel;
    private int rotatePanel;
    private int assistClimbPit;
    private int duringClimbPark;
    private int robotClimbClimb;
    private int duringClimbAssist;
    private int intakePowerCellsYes;
    private int intakePowerCellsNo;
    private int robotDefenseYesPit;
    private int robotDefenseNoPit;
    private int scoreBottom;
    private int scoreTop;
    private int stageOnePit;
    private int stageTwoPit;
    private int stageThreePit;




    public PitData(int team){
        teamNum = team;
        intakeAndMech = "";
        driveTrain = "";
        lang = "";
        climb = "";
        scoringMechanism = "";
        ballsDuringAuto = "";
        auto = 0;
        autoNo = 0;
        autoYes = 0;
        crossLinePit = 0;
        intakeBallsPit = 0;
        scoreLowerPortPit = 0;
        scoreOuterPortPit = 0;
        scoreInnerPortPit = 0;
        bottomPortScore = 0;
        outerPortScore = 0;
        innerPortScore = 0;
        positionPanel = 0;
        rotatePanel = 0;
        assistClimbPit = 0;
        duringClimbPark = 0;
        robotClimbClimb = 0;
        duringClimbAssist = 0;
        intakePowerCellsYes = 0;
        intakePowerCellsNo = 0;
        robotDefenseYesPit = 0;
        robotDefenseNoPit = 0;
        scoreBottom = 0;
        scoreTop = 0;
        stageOnePit = 0;
        stageTwoPit = 0;
        stageThreePit = 0;

    }


    public int getTeamNum(){
        return teamNum;
    }
    public void setTeamNum(int s){
        teamNum = s;
    }

    public String getIntakeAndMech(){
        return intakeAndMech;
    }
    public void setIntakeAndMech(String s){
        intakeAndMech = s;
    }

    public String getDriveTrain(){
        return driveTrain;
    }
    public void setDriveTrain(String s){
        driveTrain = s;
    }

    public String getSpeed(){
        return speed;
    }
    public void setSpeed(String s){
        speed = s;
    }

    public String getLang(){
        return lang;
    }
    public void setLang(String s){
        lang = s;
    }

    public String getClimb(){
        return climb;
    }
    public void setClimb(String s){ climb = s; }

    public String getScoringMechanism(){
        return scoringMechanism;
    }
    public void setScoringMechanism(String s){ scoringMechanism = s; }

    public String getBallsDuringAuto(){
        return ballsDuringAuto;
    }
    public void setBallsDuringAuto(String s){ ballsDuringAuto = s; }

    public int getAuto(){return auto; }
    public void setAuto(int b) { auto = b; }

    public int getAutoYes() {return autoYes ; }
    public void setAutoYes(int b) { autoYes = b; }

    public int getAutoNo() {return autoNo ; }
    public void setAutoNo (int b) { autoNo = b; }

    public int getCrossLinePit() {return crossLinePit ; }
    public void setCrossLinePit (int b) {crossLinePit = b; }

    public int getIntakeBallsPit() {return intakeBallsPit ; }
    public void setIntakeBallsPit (int b) {intakeBallsPit = b; }

    public int getScoreLowerPortPit() {return scoreLowerPortPit ; }
    public void setScoreLowerPortPit (int b) {scoreLowerPortPit = b; }

    public int getScoreOuterPortPit() {return scoreOuterPortPit ; }
    public void setScoreOuterPortPit (int b) {scoreOuterPortPit = b; }

    public int getScoreInnerPortPit() {return scoreInnerPortPit ; }
    public void setScoreInnerPortPit (int b) {scoreInnerPortPit = b; }

    public int getBottomPortScore() {return bottomPortScore ; }
    public void setBottomPortScore (int b) {bottomPortScore = b; }

    public int getOuterPortScore() {return outerPortScore ; }
    public void setOuterPortScore (int b) {outerPortScore = b; }

    public int getInnerPortScore() {return innerPortScore ; }
    public void setInnerPortScore (int b) {innerPortScore = b; }

    public int getPositionPanel() {return positionPanel ; }
    public void setPositionPanel (int b) {positionPanel = b; }

    public int getRotatePanel() {return rotatePanel ; }
    public void setRotatePanel (int b) {rotatePanel = b; }

    public int getAssistClimbPit() {return assistClimbPit ; }
    public void setAssistClimbPit (int b) {assistClimbPit = b; }

    public int getDuringClimbPark() {return duringClimbPark ; }
    public void setDuringClimbPark (int b) {duringClimbPark = b;}

    public int getRobotClimbClimb() {return robotClimbClimb ; }
    public void setRobotClimbClimb (int b) {robotClimbClimb = b;}

    public int getDuringClimbAssist() {return duringClimbAssist ; }
    public void setDuringClimbAssist (int b) {duringClimbAssist = b; }

    public int getIntakePowerCellsYes() {return intakePowerCellsYes ; }
    public void setIntakePowerCellsYes (int b) {intakePowerCellsYes = b;}

    public int getIntakePowerCellsNo() {return intakePowerCellsNo ; }
    public void setIntakePowerCellsNo (int b) {intakePowerCellsNo = b; }

    public int getRobotDefenseYesPit() {return robotDefenseYesPit ; }
    public void setRobotDefenseYesPit (int b) {robotDefenseYesPit = b; }

    public int getRobotDefenseNoPit() {return robotDefenseNoPit ; }
    public void setRobotDefenseNoPit (int b) {robotDefenseNoPit = b; }

    public int getScoreBottom() {return scoreBottom ; }
    public void setScoreBottom (int b) {scoreBottom = b; }

    public int getScoreTop() {return scoreTop ; }
    public void setScoreTop (int b) {scoreTop = b; }

    public int getStageOnePit() {return stageOnePit ; }
    public void setStageOnePit (int b) {stageOnePit = b; }

    public int getStageTwoPit() {return stageTwoPit ; }
    public void setStageTwoPit (int b) {stageTwoPit = b; }

    public int getStageThreePit() {return stageThreePit ; }
    public void setStageThreePit (int b) {stageThreePit = b; }

}

