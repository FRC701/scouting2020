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
        topPCell = (float(team.Scores.avgTeleTopPC)/2.5)*2.0


        team.totalWS = str(round(float(team.totalWS)+(team.Scores.avgAutoTopPCell+rocketTopH+rocketMiddleC+rocketMiddleH+rocketBottomC+rocketBottomH+cargoShipC+cargoShipH), 2))
        imports.add_teamInfo(team)
        
        
#------------------------------------------------------------------------------
# calculate_pit_data function
#   - handles pit data and stores it to the teams
#------------------------------------------------------------------------------

#TODO change to incorperate sql
def calculate_pit_data():
    # for entry in PitEntry.entries:
    #     done = False
    #     for team in Team.team_list:
    #         if team.number == entry.team:
    #             assign_pit_entry_values(team, entry)
    done = True
        # if done == False:
        #     newTeam = Team(entry.team)
        #     print ("Added Team #: " + str(entry.team))
        #     assign_pit_entry_values(Team.team_list[len(Team.team_list)-1],entry)
        #
#------------------------------------------------------------------------------
# assign_pit_entry_values function
#   -- takes PitEntry values and puts them into a team
#   -- still needs error handling
#------------------------------------------------------------------------------
def assign_pit_entry_values(team, entry):
    
    team.PitInfo.answer1 = entry.answer1
    #team.PitInfo.answer2 = entry.answer2
    team.PitInfo.answer3 = entry.answer3
    team.PitInfo.answer4 = entry.answer4
    team.PitInfo.answer5 = entry.answer5
    team.PitInfo.answer6 = entry.answer6
    
    
#------------------------------------------------------------------------------
# get_rank functions
#   -- calculates rankings for avg, min, and max scores for each team
#------------------------------------------------------------------------------

def get_autoTopPCell_rank(sort="avg", rev=True):
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

def get_autoBottomPCell_rank(sort="avg", rev=True):
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

def get_teleTopPC_rank(sort="avg", rev=True):
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

def get_teleBottomPC_rank(sort="avg", rev=True):
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
    team2 = teams[1]
    team3 = teams[2]
    team4 = teams[3]
    team5 = teams[4]
    team6 = teams[5]

    # standard deviations
    Sigmas = [[],[]]


    totalRed = [float(team1.totalWS),float(team2.totalWS),float(team3.totalWS)]
    totalBlue = [float(team4.totalWS),float(team5.totalWS),float(team6.totalWS)]

    mur = (float(1)/3)*(sum(totalRed))
    mub = (float(1)/3)*(sum(totalBlue))

    for score in totalRed:
        Sigmas[0].append((score-mur)**2)
        print(Sigmas[0])
    for score in totalBlue:
        Sigmas[1].append((score-mub)**2)
        print(Sigmas[1])

    rst = math.sqrt(sum(Sigmas[0])/3.0)
    bst = math.sqrt(sum(Sigmas[1])/3.0)
    
    if mur > mub:
        #check zval and ntdri
        zval = (mur-mub)/math.sqrt((rst**2)+(bst**2)) if math.sqrt((rst**2)+(bst**2)) > 0 else 0
        perr = 1-stats.stats.special.ndtri(zval)
        perr = round(perr,4)

        zval2 = (mub-mur)/math.sqrt((rst**2)+(bst**2)) if math.sqrt((rst**2)+(bst**2)) > 0 else 0
        perr2 = 1-stats.stats.special.ndtri(zval2)
        perr2 = round(perr2, 4)
        return "Red Alliance: " + str(perr*100) + " blue: " +str(perr2)
    
    else:
        zval = (mub-mur)/math.sqrt((rst**2)+(bst**2)) if math.sqrt((rst**2)+(bst**2)) > 0 else 0
        perr = stats.stats.special.ndtri(zval)
        perr = round(perr, 4)
        
        zval2 = (mur-mub)/math.sqrt((rst**2)+(bst**2)) if math.sqrt((rst**2)+(bst**2)) > 0 else 0
        perr2 = stats.stats.special.ndtri(zval2)
        perr2 = round(perr2, 4)
        return "Blue Alliance: " + str(perr*100) + " red: " +str(perr2)
