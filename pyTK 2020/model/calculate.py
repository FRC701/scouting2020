#------------------------------------------------------------------------------
# calculate module
#   -- functions for handling data input, output, and calculations
#------------------------------------------------------------------------------
import math
#from statlib import *

# from scipy import stats

from .team import TeamRankings
from . import imports
from .team import Team
from . import stat

# import model.stats
# import model.imports
# import model.team
#------------------------------------------------------------------------------
# calculate_data function
#   -- handles data and stores it to the teams
#------------------------------------------------------------------------------
def calculate_data():
    #adds stats values to team data
    stat.populate_teaminfo()

    # get primary offensive information about the team

    for team in Team.team_list:
        team.get_primary_details()
        topPCell = (float(team.Scores.avgTeleTopPC)*2)
        bottomPCell = (float(team.Scores.avgTeleBottomPC)*1)
        autoTopPCell = (float(team.Scores.avgAutoTopPCell)*4)
        autoBottomPCell = (float(team.Scores.avgAutoBottomPCell)*2)

        team.totalWS = str(round(float(team.totalWS)+(topPCell+bottomPCell+autoTopPCell+autoBottomPCell), 2))
        imports.add_teamInfo(team)
        
        
#------------------------------------------------------------------------------
# calculate_pit_data function
#   - handles pit data and stores it to the teams
#------------------------------------------------------------------------------

#TODO change to incorperate sql
def calculate_pit_data(row):
    TypeOfIntakeAndMech = 1
    TypeOfDriveTrain = 2
    ProgrammingLanguage = 3
    AverageSpeed = 4
    BallsDuringAuto = 5
    AutoAnswerYes = 6
    AutoAnswerNo = 7
    AutoCrossLinePit = 8
    AutoIntakeBallsPit = 9
    AutoScoreLower = 10
    AutoScoreOuter = 11
    AutoScoreInner = 12
    ScoreBottomPort = 13
    ScoreOuterPort = 14
    ScoreInnerPort = 15
    PositionControlPanel = 16
    RotateControlPanel = 17
    AssistClimb = 18
    ParkRobot = 19
    RobotClimb = 20
    PowerCellIntakeYes = 21
    PowerCellIntakeNo = 22
    DefenseRobotYes = 23
    DefenseRobotNo = 24

    for team in Team.team_list:
        if team.number == int(row[team]):
            team.PitInfo.typeOfIntakeAndMech = (row[TypeOfIntakeAndMech])
            team.PitInfo.typeOfDriveTrain = (row[TypeOfDriveTrain])
            team.PitInfo.programmingLanguage = (row[ProgrammingLanguage])
            team.PitInfo.averageSpeed = (row[AverageSpeed])
            team.PitInfo.ballsDuringAuto = (row[BallsDuringAuto])
            team.PitInfo.autoAnswerYes = (row[AutoAnswerYes])
            team.PitInfo.autoAnswerNo = (row[AutoAnswerNo])
            team.PitInfo.autoCrossLinePit = (row[AutoCrossLinePit])
            team.PitInfo.autoIntakeBallsPit = (row[AutoIntakeBallsPit])
            team.PitInfo.autoScoreLower = (row[AutoScoreLower])
            team.PitInfo.autoScoreOuter = (row[AutoScoreOuter])
            team.PitInfo.autoScoreInner = (row[AutoScoreInner])
            team.PitInfo.scoreBottomPort = (row[ScoreBottomPort])
            team.PitInfo.scoreOuterPort = (row[ScoreOuterPort])
            team.PitInfo.scoreInnerPort = (row[ScoreInnerPort])
            team.PitInfo.positionControlPanel = (row[PositionControlPanel])
            team.PitInfo.rotateControlPanel = (row[RotateControlPanel])
            team.PitInfo.assistClimb = (row[AssistClimb])
            team.PitInfo.parkRobot = (row[ParkRobot])
            team.PitInfo.robotClimb = (row[RobotClimb])
            team.PitInfo.powerCellIntakeYes = (row[PowerCellIntakeYes])
            team.PitInfo.powerCellIntakeNo = (row[PowerCellIntakeNo])
            team.PitInfo.defenseRobotYes = (row[DefenseRobotYes])
            team.PitInfo.defenseRobotNo = (row[DefenseRobotNo])
#------------------------------------------------------------------------------
# assign_pit_entry_values function
#   -- takes PitEntry values and puts them into a team
#   -- still needs error handling
#------------------------------------------------------------------------------
# def assign_pit_entry_values(team, entry):
#     team.PitInfo.typeOfIntakeAndMech = entry.typeOfIntakeAndMech
#
#
#------------------------------------------------------------------------------
# get_rank functions
#   -- calculates rankings for avg, min, and max scores for each team
#------------------------------------------------------------------------------

def get_auto_top_p_cell_rank(sort="avg", rev=True):
    TeamRankings.autoTopPCell_rank = []
    for team in Team.team_list:
        if sort == "avg":
            TeamRankings.autoTopPCell_rank.append([team.Scores.avgAutoTopPCell, team.number])
        elif sort == "max":
            TeamRankings.autoTopPCell_rank.append([team.Scores.maxAutoTopPCell, team.number])
        elif sort == "min":
            TeamRankings.autoTopPCell_rank.append([team.Scores.minAutoTopPCell, team.number])
    TeamRankings.autoTopPCell_rank.sort(reverse=rev)
    return TeamRankings.autoTopPCell_rank


def get_auto_bottom_p_cell_rank(sort="avg", rev=True):
    TeamRankings.autoBottomPCell_rank = []
    for team in Team.team_list:
        if sort == "avg":
            TeamRankings.autoBottomPCell_rank.append([team.Scores.avgAutoBottomPCell, team.number])
        elif sort == "max":
            TeamRankings.autoBottomPCell_rank.append([team.Scores.maxAutoBottomPCell, team.number])
        elif sort == "min":
            TeamRankings.autoBottomPCell_rank.append([team.Scores.minAutoBottomPCell, team.number])
    TeamRankings.autoBottomPCell_rank.sort(reverse=rev)
    return TeamRankings.autoBottomPCell_rank


def get_tele_top_p_cell_rank(sort="avg", rev=True):
    TeamRankings.teleTopPC_rank = []
    for team in Team.team_list:
        if sort == "avg":
            TeamRankings.teleTopPC_rank.append([team.Scores.avgTeleTopPC, team.number])
        elif sort == "max":
            TeamRankings.teleTopPC_rank.append([team.Scores.maxTeleTopPC, team.number])
        elif sort == "min":
            TeamRankings.teleTopPC_rank.append([team.Scores.minTeleTopPC, team.number])
    TeamRankings.teleTopPC_rank.sort(reverse=rev)
    return TeamRankings.teleTopPC_rank


def get_tele_bottom_p_cell_rank(sort="avg", rev=True):
    TeamRankings.teleBottomPC_rank = []
    for team in Team.team_list:
        if sort == "avg":
            TeamRankings.teleBottomPC_rank.append([team.Scores.avgTeleBottomPC, team.number])
        elif sort == "max":
            TeamRankings.teleBottomPC_rank.append([team.Scores.maxTeleBottomPC, team.number])
        elif sort == "min":
            TeamRankings.teleBottomPC_rank.append([team.Scores.minTeleBottomPC, team.number])
    TeamRankings.teleBottomPC_rank.sort(reverse=rev)
    return TeamRankings.teleBottomPC_rank


#------------------------------------------------------------------------------
# predict functions
#   -- calculates predicted alliance scores predicts match outcomes
#------------------------------------------------------------------------------

#TODO put function from calculate predictions here
def predict_scores(team1=None,team2=None,team3=None):
    #pOff1 = float(team1.pOff.rstrip("%"))/100
    #pOff2 = float(team2.pOff.rstrip("%"))/100
    #pOff3 = float(team3.pOff.rstrip("%"))/100
    #pDef1 = float(team1.pDef.rstrip("%"))/100
    #pDef2 = float(team2.pDef.rstrip("%"))/100
    #pDef3 = float(team3.pDef.rstrip("%"))/100
   
    try:
        offScore = (float(team1.offensiveWS)+float(team2.offensiveWS)+float(team3.offensiveWS))
        defScore = (float(team1.defensiveWS)+float(team2.defensiveWS)+float(team3.defensiveWS))
       
    except:
        offScore = 0
        defScore = 0

    expectedScores = [offScore, defScore]

    return expectedScores

def predict_outcome(teams=[]):
    
    team1 = teams[0]
    # team2 = teams[1]
    # team3 = teams[2]
    # team4 = teams[3]
    # team5 = teams[4]
    # team6 = teams[5]
    #
    # # standard deviations
    # Sigmas = [[],[]]
    #
    #
    # totalRed = [float(team1.totalWS),float(team2.totalWS),float(team3.totalWS)]
    # totalBlue = [float(team4.totalWS),float(team5.totalWS),float(team6.totalWS)]
    #
    # mur = (float(1)/3)*(sum(totalRed))
    # mub = (float(1)/3)*(sum(totalBlue))
    #
    # for score in totalRed:
    #     Sigmas[0].append((score-mur)**2)
    #     print(Sigmas[0])
    # for score in totalBlue:
    #     Sigmas[1].append((score-mub)**2)
    #     print(Sigmas[1])
    #
    # rst = math.sqrt(sum(Sigmas[0])/3.0)
    # bst = math.sqrt(sum(Sigmas[1])/3.0)
    #
    # if mur > mub:
    #     #check zval and ntdri
    #     zval = (mur-mub)/math.sqrt((rst**2)+(bst**2)) if math.sqrt((rst**2)+(bst**2)) > 0 else 0
    #     perr = 1-stats.stats.special.ndtri(zval)
    #     perr = round(perr,4)
    #
    #     zval2 = (mub-mur)/math.sqrt((rst**2)+(bst**2)) if math.sqrt((rst**2)+(bst**2)) > 0 else 0
    #     perr2 = 1-stats.stats.special.ndtri(zval2)
    #     perr2 = round(perr2, 4)
    #     return "Red Alliance: " + str(perr*100) + " blue: " +str(perr2)
    #
    # else:
    #     zval = (mub-mur)/math.sqrt((rst**2)+(bst**2)) if math.sqrt((rst**2)+(bst**2)) > 0 else 0
    #     perr = stats.stats.special.ndtri(zval)
    #     perr = round(perr, 4)
    #
    #     zval2 = (mur-mub)/math.sqrt((rst**2)+(bst**2)) if math.sqrt((rst**2)+(bst**2)) > 0 else 0
    #     perr2 = stats.stats.special.ndtri(zval2)
    #     perr2 = round(perr2, 4)
    #     return "Blue Alliance: " + str(perr*100) + " red: " +str(perr2)
