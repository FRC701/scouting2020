
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
    public static final String KEY_topPCellAuto = "topPCellAuto";
    public static final String KEY_bottomPCellAuto = "bottomPCellAuto";
    public static final String KEY_removeBallsAuto = "removeBallsAuto";
    public static final String KEY_crossLineAuto = "crossLineAuto";
    public static final String KEY_doesntMoveAuto = "doesntMoveAuto";
    public static final String KEY_intakeAuto = "intakeAuto";
    public static final String KEY_noShowAuto = "noShowAuto";

    //teleop
    public static final String KEY_NoShow = "NoShow";
    public static final String KEY_RobotDisabled = "RobotDisabled";
    public static final String KEY_RedCard = "RedCard";
    public static final String KEY_YellowCard = "YellowCard";
    public static final String KEY_Fouls = "Fouls";
    public static final String KEY_TechFouls = "TechFouls";
    public static final String KEY_Disqualified = "Disqualified";
    public static final String KEY_ClimbTime ="ClimbTime";

    private String compId;
    private int matchNum;
    private int teamNum;
    private int matchPos;
    private int noShow;
    private int hadAuto;
    private int redCard;
    private int yellowCard;
    private int foul;
    private int techFoul;
    private int disabled;

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
        noShow = 0;
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

    public int getNoShow(){
        return noShow;
    }
    public void setNoShow(int i){
        noShow = i;
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

    public int getRemoveBallsAuto () {return removeBallsAuto; }
    public void setRemoveBallsAuto (int i) { removeBallsAuto = i; }

    public int getCrossLineAuto () {return crossLineAuto; }
    public void setCrossLineAuto (int i) { crossLineAuto = i; }

    public int getDoesntMoveAuto () {return doesntMoveAuto; }
    public void setDoesntMoveAuto (int i) { doesntMoveAuto = i; }

    public int getIntakeAuto () {return intakeAuto; }
    public void setIntakeAuto (int i) { intakeAuto = i; }

    public int getNoShowAuto () {return noShowAuto; }
    public void setNoShowAuto (int i){ noShowAuto = i; }

}

