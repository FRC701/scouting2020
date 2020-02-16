#------------------------------------------------------------------------------
# cteamdata module
#   -- contains the functions and classes for controlling the teamdata window
#------------------------------------------------------------------------------
from tkinter import *
from model.team import *

#------------------------------------------------------------------------------
# TeamDataController Class
#   -- contains information for setting and getting data and display values
#------------------------------------------------------------------------------
class TeamDataController():
    """Class that handles commands from the teamdata window."""

    # use these to index values to display, use the system: ("key", "term")
    # where key corresponds to a value in team and term labels that value
    dataLabelVals = [("numMatch", "Number of Matches: "),
                     ("offensiveWS", "Offensive Weighted Score: "),
                     ("totalWS", "Total Weighted Score: "),
                     ("negativeWS", "Negative Weighted Score: "),
                     ("pNoShow", "No Show Percentage: "),
                     
                     ("pAutoCrossLine", "Cross Line Percentage: "),
                     ("pAutoDoesntMove", "do not move in auto Percentage: "),
                     ("pAutoIntake", "the intake in auto Percentage: "),

                     ("avgAutoTopPCell", "The average top power cell in auto: "),
                     ("avgAutoBottomPCell", "The average bottom power cell in auto: "),
                     ("avgTeleBottomPC", "The average bottom power cell in tele: "),
                     ("avgTeleTopPC", "The average top power cell in tele: "),

                     ("pTeleRotation", "Completed rotation control: "),
                     ("pTelePosition", "Completed position control: "),
                     ("pTeleHangSucess", "Completed Hanging: "),
                     ("pTeleHangAttempt", "Attempted to hang: "),
                     ("pTeleHangNA", "Did not attempt to Hang: "),
                     ("pTeleAssist", "Helped another team hang: "),
                     ("pTeleAssisted", "Were Helped by another team to hang: "),
                     ("pTeleDefenseNone", "Does not play defense: "),
                     ("pTeleDefenseSome", "A moderate amount of defense: "),
                     ("pTeleDefenseAll", "They only do defense: "),
                     ("pTeleDefenseGood", "Good at Defense: "),
                     ("pTeleDefenseBad", "Bad at defense: "),
                     ("pTeleDefenseOk", "Not the best at defense but not the worst at it: "),
                     ("pTeleDefenseNA", "Does not do defense: "),
                     ("pTeleClimbSpeedFast", "Fast at climbing: "),
                     ("pTeleClimbSpeedMedium", "not too fast at climbing but not slow either: "),
                     ("pTeleClimbSpeedSlow", "Has a slow climb speed: "),
                     ("pTeleClimbSpeedNo", "Did not climb: "),

                     ("pFoul", "Matches Had Foul: "),
                     ("pTechFoul", "Matches Had Tech Foul: "),
                     ("pYellowCard", "Matches Had Yellow Card: "),

                     ("pRedCard", "Matches Had Red Card: "),
                     ("pDisabled", "Matches Where The Robot Was Disabled: ")]

    maxminLabelVals = [("maxAutoTopPCell", ": max amount of top power cells in auto: "),
                       ("minAutoTopPCell", ": min top power cells in auto"),
                       ("maxAutoBottomPCell", ": max bottom power cells in auto: "),
                       ("minAutoBottomPCell", ": min bottom power cells in auto"),
                       ("maxTeleTopPC", ": max top power cells in tele"),
                       ("minTeleTopPC", ": min top power cells in tele"),
                       ("maxTeleBottomPC", ": max bottom power cells in tele"),
                       ("minTeleBottomPC", ": min bottom power cells in tele")]
    
    pitDataStrings = [

    ]

    graphVals = [("avgAutoTopPCell", "Scores","autoTopPCell"),
                 ("avgAutoBottomPCell", "Scores","autoBottomPCell"),
                 ("avgTeleTopPC", "Scores","teleTopPC"),
                 ("avgTeleBottomPC", "Scores","teleBottomPC")]
    
    def __init__(self):
        self.teamNum = 0
        self.entry = None
        self.data = None
        self.image = None

    # gets the team # from self.entry and finds the corresponding team
    # returns true if the team was found and false if not
    def loadData(self):
        try:
            self.teamNum = int(self.entry.get())
        except:
            print("Team value not valid.")
            self.teamNum = 0
            
        for team in Team.team_list:
            if team.number == self.teamNum:
                self.data = team
                print ("Loading team...")
                return True
            
        print ("Team not found.")
        return False

    # gets the image file corresponding to self.teamNum and returns it
    # if team is not found: returns nopic.gif
    def get_PhotoImage(self):
        image_name = "Images/" + str(self.teamNum) + ".gif"
        try:
            open(image_name)
        except:
            self.image = PhotoImage(file="Images/nopic.gif")
            return self.image
        
        self.image = PhotoImage(file=image_name)
        return self.image

    def get_GraphData(self, graphType=None):
        index = None
        data = None
        try:
            graphName = self.dataLabelVals[int(graphType[0])][0]  
        except:
            graphName = None

        #find the index and attr name
        for x, y, z in self.graphVals:
            if x == graphName:
                index = y
                data = z
                break # do not continue to iterate through the list
        try:
            currentIndex = self.data.getAttr(index)
            return currentIndex.getAttr(data)
        except:
            print ("Cannot find data for that graph.")
            return None

    def get_GraphName(self, graphType=None):
        try:
            graphName = self.dataLabelVals[int(graphType[0])][0]  
        except:
            graphName = None

        return graphName

            






