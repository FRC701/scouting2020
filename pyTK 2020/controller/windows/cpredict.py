#------------------------------------------------------------------------------
# cpredict module
#   -- contains data and information for controlling the predict window
#------------------------------------------------------------------------------
from tkinter import *

from model import team
from model import calculate

#------------------------------------------------------------------------------
# SearchController class
#   -- contains functions, lists, data, etc, for handling the search window
#------------------------------------------------------------------------------
class PredictController():
    """Class that handles commands from the search window."""

    allianceOptions = ["Custom",
                       "Alliance 1","Alliance 2",
                       "Alliance 3","Alliance 4",
                       "Alliance 5","Alliance 6",
                       "Alliance 7","Alliance 8"]
    
    predictIndex = [("offensiveWS","O-Scr"),
                    ("totalWS","T-Scr"),
                    
                    ("avgRocketTopC","RTC"),
                    ("avgRocketTopH","RTH"),
                    ("avgRocketMiddleC","RMC"),
                    ("avgRocketMiddleH","RMH"),

                    ("avgRocketBottomC","RBC"),
                    ("avgRocketBottomH","RBH"),
                    ("avgCargoShipC","CSC"),
                    ("avgCargoShipH","CSH"),
                    
                    ("negativeWS", "N-Scr"),
                    ("pFoul","Foul %")]
    
    def __init__(self):
        self.available = []
        for t in team.Team.team_list:
            self.available.append(str(t.number))

    def getInfo(self,teamVals=None,index=0):
        if int(teamVals[index][0].get()) != 0:
            for t in team.Team.team_list:
                if t.number == int(teamVals[index][0].get()):
                    for i in range(len(self.predictIndex)):
                        teamVals[index][i+1].set(str(t.getAttr(self.predictIndex[i][0])))
                    break
        else:
            for i in range(len(self.predictIndex)):
                teamVals[index][i+1].set("0")

    def getPrediction(self,team1,team2,team3):
        for t in team.Team.team_list:
            if t.number == int(team1.get()):
                team1 = t
                break
        for t in team.Team.team_list:
            if t.number == int(team2.get()):
                team2 = t
                break
        for t in team.Team.team_list:
            if t.number == int(team3.get()):
                team3 = t
                break

        return calculate.predict_scores(team1,team2,team3)

    def getComparison(self,teamNums=[]):
        teams = []
        for t in teamNums:
            for tm in team.Team.team_list:
                if int(t.get()) == tm.number:
                    teams.append(tm)

        return calculate.predict_outcome(teams)

    def loadAlliance(self,alliance=None):
        print (alliance)
        teams = [0,0,0]
        go = False
        i=0
        try:
            newData = open("alliances.txt","r")
            print ("Alliance File Opened")
            for line in newData:
                if line == alliance + "\n":
                    go = True
                    print ("FOUND")
                elif go and i<3:
                    teams[i]=line.replace("\n","")
                    i+=1
                    if i >= 3:
                        go = False
                        break
        except:
            pass
            print ("Error, could not open alliance file.")
        return teams
        
    def loadAllianceMatches(self,match=None, ally=None):
        print (match)
        teams = [0,0,0]
        go = False
        i=0
        j=4
        try:
            newData = open("matchlist.txt","r")
            print ("Match List File Openned")
            for line in newData:
                matchline = str(line).split(',')
                [s.strip('\n') for s in matchline]
                if matchline[0] == match:
                    go = True
                    print ("FOUND")
                    for x in range(0,3):
                        if go and ally==0:
                            if i<3:
                                teams[i]=matchline[i+1]
                                i+=1
                                if i >= 3:
                                    go = False
                                    break
                        elif go and ally==1:
                            if i<3:
                                teams[i]=matchline[j]
                                i+=1
                                j+=1
                                if i >= 3:
                                    go = False
                                    break
              
        except:
            pass
            print ("Error")
        teams = map(lambda each:each.strip("\n"), teams)
        return teams
    

    def saveAlliance(self,name="Custom Alliance",teams=[]):
        self.allianceOptions.append(name)

    def deleteAlliance(self,name="Custom Alliance"):
        for item in self.allianceOptions:
            if item == name:
                self.allianceOptions.remove(item)
