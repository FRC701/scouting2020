
package com.vandenrobotics.saga.data.model;

/**
 * Created by Programming701-A on 12/13/2017.
 */

public class Stats {

    public static final String TABLE = "Stats";

    public static final String INDEX = "comp_match_team";

    public static final String KEY_CompId = "CompID";
    public static final String KEY_MatchNum = "MatchNumber";
    public static final String KEY_TeamNum = "TeamNumber";
    public static final String KEY_MatchPosition = "MatchPosition";

    //auto
    public static final String KEY_TopPCellAuto = "TopPCellAuto";
    public static final String KEY_BottomPCellAuto = "BottomPCellAuto";
    public static final String KEY_CrossLineAuto = "CrossLineAuto";
    public static final String KEY_DoesntMoveAuto = "DoesntMoveAuto";
    public static final String KEY_IntakeAuto = "IntakeAuto";
    public static final String KEY_NoShowAuto = "NoShowAuto";

    //teleop
    public static final String KEY_RobotDisabled = "RobotDisabled";
    public static final String KEY_RedCard = "RedCard";
    public static final String KEY_YellowCard = "YellowCard";
    public static final String KEY_Fouls = "Fouls";
    public static final String KEY_TechFouls = "TechFouls";
    public static final String KEY_Disqualified = "Disqualified";
    public static final String KEY_TeleComments = "TeleComments";
    public static final String KEY_TeleTopPC = "TeleTopPC";
    public static final String KEY_TeleBottomPC = "TeleBottomPC";
    public static final String KEY_TeleRotation = "TeleRotation";
    public static final String KEY_TelePosition = "TelePosition";
    public static final String KEY_TeleHangSuccess = "TeleHangSuccess";
    public static final String KEY_TeleHangAttempt = "TeleHangAttempt";
    public static final String KEY_TeleHangNA = "TeleHangNA";
    public static final String KEY_TeleAssist ="TeleAssist";
    public static final String KEY_TeleAssisted = "TeleAssisted";
    public static final String KEY_TeleDefenseNone = "TeleDefenseNone";
    public static final String KEY_TeleDefenseSome = "TeleDefenseSome";
    public static final String KEY_TeleDefenseAll = "TeleDefenseAll";
    public static final String KEY_TeleDefenseGood = "TeleDefenseGood";
    public static final String KEY_TeleDefenseBad = "TeleDefenseBad";
    public static final String KEY_TeleDefenseOk = "TeleDefenseOk";
    public static final String KEY_TeleDefenseNA = "TeleDefenseNA";
    public static final String KEY_ClimbSpeedFast = "ClimbSpeedFast";
    public static final String KEY_ClimbSpeedMedium = "ClimbSpeedMedium";
    public static final String KEY_ClimbSpeedSlow = "ClimbSpeedSlow";
    public static final String KEY_ClimbSpeedNo = "ClimbSpeedNo";


    private String compId;
    private int matchNum;
    private int teamNum;
    private int matchPos;
    private int hadAuto;
    private int redCard;
    private int yellowCard;
    private int foul;
    private int techFoul;
    private int disabled;
    private String teleComments;
    private int teleTopPC;
    private int teleBottomPC;
    private int teleRotation;
    private int telePosition;
    private int teleHangSuccess;
    private int teleHangAttempt;
    private int teleHangNA;
    private int teleAssist;
    private int teleAssisted;
    private int teleDefenseNone;
    private int teleDefenseSome;
    private int teleDefenseAll;
    private int teleDefenseGood;
    private int teleDefenseBad;
    private int teleDefenseOk;
    private int teleDefenseNA;
    private int climbSpeedFast;
    private int climbSpeedMedium;
    private int climbSpeedSlow;
    private int climbSpeedNo;

    //auto
    private int topPCellAuto;
    private int bottomPCellAuto;
    private int removeBallsAuto;
    private int crossLineAuto;
    private int doesntMoveAuto;
    private int intakeAuto;
    private int noShowAuto;

    public Stats(){
        compId = "None";
        matchNum = 0;
        teamNum = 0;
        matchPos = 0;
        hadAuto = 0;
        redCard = 0;
        yellowCard = 0;
        foul = 0;
        techFoul = 0;
        disabled = 0;
        topPCellAuto = 0;
        bottomPCellAuto = 0;
        removeBallsAuto = 0;
        crossLineAuto = 0;
        doesntMoveAuto = 0;
        intakeAuto = 0;
        noShowAuto = 0;
        teleTopPC = 0;
        teleBottomPC = 0;
        teleRotation = 0;
        telePosition = 0;
        teleHangSuccess = 0;
        teleHangAttempt = 0;
        teleHangNA = 0;
        teleAssist = 0;
        teleAssisted = 0;
        teleDefenseNone = 0;
        teleDefenseSome = 0;
        teleDefenseAll = 0;
        teleDefenseGood = 0;
        teleDefenseBad = 0;
        teleDefenseOk = 0;
        teleDefenseNA = 0;
        climbSpeedFast = 0;
        climbSpeedMedium = 0;
        climbSpeedSlow = 0;
        climbSpeedNo = 0;

    }

    public String getCompId(){
        return compId;
    }
    public void setCompId(String s){
        compId = s;
    }

    public int getMatchNum(){
        return matchNum;
    }
    public void setMatchNum(int i){
        matchNum = i;
    }

    public int getTeamNum(){
        return teamNum;
    }
    public void setTeamNum(int i){
        teamNum = i;
    }

    public int getMatchPos(){
        return matchPos;
    }
    public void setMatchPos(int i){
        matchPos = i;
    }

    public int getHadAuto(){
        return hadAuto;
    }
    public void setHadAuto(int i){
        hadAuto = i;
    }

    public int getRedCard(){
        return redCard;
    }
    public void setRedCard(int i){
        redCard = i;
    }

    public int getYellowCard(){
        return yellowCard;
    }
    public void setYellowCard(int i){
        yellowCard = i;
    }

    public int getDisabled(){
        return disabled;
    }
    public void setDisabled(int i){
        disabled = i;
    }

    public int getFoul(){
        return foul;
    }
    public void setFoul(int i){
        foul = i;
    }

    public int getTechFoul(){
        return techFoul;
    }
    public void setTechFoul(int i){
        techFoul = i;
    }

    public int getTopPCellAuto () { return topPCellAuto; }
    public void setTopPCellAuto (int i) { topPCellAuto = i; }

    public int getBottomPCellAuto () { return bottomPCellAuto; }
    public void setBottomPCellAuto (int i) { bottomPCellAuto = i; }

    public int getCrossLineAuto () {return crossLineAuto; }
    public void setCrossLineAuto (int i) { crossLineAuto = i; }

    public int getDoesntMoveAuto () {return doesntMoveAuto; }
    public void setDoesntMoveAuto (int i) { doesntMoveAuto = i; }

    public int getIntakeAuto () {return intakeAuto; }
    public void setIntakeAuto (int i) { intakeAuto = i; }

    public int getNoShowAuto () {return noShowAuto; }
    public void setNoShowAuto (int i){ noShowAuto = i; }

    public String getTeleComments () {return teleComments; }
    public void setTeleComments(String s){
        teleComments = s;
    }

    public int getTeleTopPC () {return teleTopPC; }
    public void setTeleTopPC (int i){ teleTopPC = i; }

    public int getTeleBottomPC () {return teleBottomPC; }
    public void setTeleBottomPC (int i){ teleBottomPC = i; }

    public int getTeleRotation () {return teleRotation; }
    public void setTeleRotation (int i){ teleRotation = i; }

    public int getTelePosition () {return telePosition; }
    public void setTelePosition (int i){ telePosition = i; }

    public int getTeleHangSuccess () {return teleHangSuccess; }
    public void setTeleHangSuccess (int i){ teleHangSuccess = i; }

    public int getTeleHangAttempt () {return teleHangAttempt; }
    public void setTeleHangAttempt (int i){teleHangAttempt = i; }

    public int getTeleHangNA () {return teleHangNA; }
    public void setTeleHangNA (int i){teleHangNA = i;}

    public int getTeleHangAssist () {return teleAssist; }
    public void setTeleHangAssist (int i){teleAssist = i; }

    public int getTeleHangAssisted () {return teleAssisted; }
    public void setTeleHangAssisted (int i){teleAssisted = i; }

    public int getTeleDefenseNone () {return teleDefenseNone; }
    public void setTeleDefenseNone (int i){teleDefenseNone = i; }

    public int getTeleDefenseSome () {return teleDefenseSome; }
    public void setTeleDefenseSome (int i){ teleDefenseSome = i; }

    public int getTeleDefenseAll () {return teleDefenseAll; }
    public void setTeleDefenseAll (int i){ teleDefenseAll = i; }

    public int getTeleDefenseGood () {return teleDefenseGood; }
    public void setTeleDefenseGood (int i){teleDefenseGood = i; }

    public int getTeleDefenseBad () {return teleDefenseBad; }
    public void setTeleDefenseBad (int i){teleDefenseBad = i; }

    public int getTeleDefenseOk () {return teleDefenseOk; }
    public void setTeleDefenseOk (int i){teleDefenseOk = i; }

    public int getTeleDefenseNA () {return teleDefenseNA; }
    public void setTeleDefenseNA (int i){teleDefenseNA = i; }

    public int getClimbSpeedFast () {return climbSpeedFast; }
    public void setClimbSpeedFast (int i){climbSpeedFast = i; }

    public int getClimbSpeedMedium () {return climbSpeedMedium; }
    public void setClimbSpeedMedium (int i){climbSpeedMedium = i; }

    public int getClimbSpeedSlow () {return climbSpeedSlow; }
    public void setClimbSpeedSlow (int i){climbSpeedSlow = i; }

    public int getClimbSpeedNo () {return climbSpeedNo; }
    public void setClimbSpeedNo (int i){climbSpeedNo = i; }

}

